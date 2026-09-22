package com.advanced.internationalization;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Tries multiple locale styles, ISO / java.time formatters, and common patterns
 * until a date string is fully parsed.
 */
public final class DynamicDateParser {

    private DynamicDateParser() {
    }

    public record ParseOutcome(Date date, String matchedUsing) {
    }

    public static ParseOutcome parse(String dateString) throws ParseException {
        return parse(dateString, Locale.getDefault());
    }

    public static ParseOutcome parse(String dateString, Locale primaryLocale) throws ParseException {
        if (dateString == null || dateString.isBlank()) {
            throw new ParseException("Date string is empty", 0);
        }
        String text = dateString.trim();

        ParseOutcome fromTime = tryJavaTimeParsers(text);
        if (fromTime != null) {
            return fromTime;
        }

        Set<Locale> locales = new LinkedHashSet<>();
        locales.add(primaryLocale);
        locales.add(Locale.getDefault());
        locales.add(Locale.US);
        locales.add(Locale.UK);
        locales.add(Locale.FRANCE);
        locales.add(Locale.GERMANY);

        int[] dateStyles = {
                java.text.DateFormat.SHORT,
                java.text.DateFormat.MEDIUM,
                java.text.DateFormat.LONG,
                java.text.DateFormat.FULL
        };

        for (Locale locale : locales) {
            for (int style : dateStyles) {
                ParseOutcome r = tryDateFormat(
                        java.text.DateFormat.getDateInstance(style, locale),
                        text,
                        "DateFormat.getDateInstance(" + styleName(style) + ", " + locale + ")");
                if (r != null) {
                    return r;
                }
            }
            ParseOutcome dateTime = tryDateFormat(
                    java.text.DateFormat.getDateTimeInstance(
                            java.text.DateFormat.SHORT, java.text.DateFormat.SHORT, locale),
                    text,
                    "DateFormat.getDateTimeInstance(SHORT, SHORT, " + locale + ")");
            if (dateTime != null) {
                return dateTime;
            }
        }

        for (String pattern : commonPatterns()) {
            for (Locale locale : locales) {
                ParseOutcome r = trySimpleDateFormat(text, pattern, locale);
                if (r != null) {
                    return r;
                }
            }
        }

        throw new ParseException("Unrecognized date format: \"" + text + "\"", 0);
    }

    private static ParseOutcome tryJavaTimeParsers(String text) {
        List<DateTimeFormatter> formatters = List.of(
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME,
                DateTimeFormatter.ISO_OFFSET_DATE_TIME,
                DateTimeFormatter.ISO_ZONED_DATE_TIME,
                DateTimeFormatter.ofPattern("dd/MM/yyyy"),
                DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                DateTimeFormatter.ofPattern("MM/dd/yyyy"),
                DateTimeFormatter.ofPattern("yyyy/MM/dd"),
                DateTimeFormatter.ofPattern("dd MMM yyyy").withLocale(Locale.ENGLISH),
                DateTimeFormatter.ofPattern("MMM dd, yyyy").withLocale(Locale.ENGLISH),
                DateTimeFormatter.ofPattern("MMMM d, yyyy").withLocale(Locale.ENGLISH));

        for (DateTimeFormatter formatter : formatters) {
            ParseOutcome r = tryParseWithFormatter(text, formatter);
            if (r != null) {
                return r;
            }
        }
        return null;
    }

    private static ParseOutcome tryParseWithFormatter(String text, DateTimeFormatter formatter) {
        try {
            LocalDate ld = LocalDate.parse(text, formatter);
            return new ParseOutcome(toDate(ld), "java.time LocalDate " + formatter);
        } catch (DateTimeParseException ignored) {
            // continue
        }
        try {
            LocalDateTime ldt = LocalDateTime.parse(text, formatter);
            return new ParseOutcome(toDate(ldt), "java.time LocalDateTime " + formatter);
        } catch (DateTimeParseException ignored) {
            // continue
        }
        try {
            ZonedDateTime zdt = ZonedDateTime.parse(text, formatter);
            return new ParseOutcome(Date.from(zdt.toInstant()), "java.time ZonedDateTime " + formatter);
        } catch (DateTimeParseException ignored) {
            return null;
        }
    }

    private static ParseOutcome tryDateFormat(java.text.DateFormat format, String text, String description) {
        format.setLenient(false);
        ParsePosition pos = new ParsePosition(0);
        Date parsed = format.parse(text, pos);
        if (parsed != null && pos.getIndex() == text.length() && pos.getErrorIndex() == -1) {
            return new ParseOutcome(parsed, description);
        }
        return null;
    }

    private static ParseOutcome trySimpleDateFormat(String text, String pattern, Locale locale) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
        sdf.setLenient(false);
        ParsePosition pos = new ParsePosition(0);
        Date parsed = sdf.parse(text, pos);
        if (parsed != null && pos.getIndex() == text.length() && pos.getErrorIndex() == -1) {
            return new ParseOutcome(parsed, "SimpleDateFormat(\"" + pattern + "\", " + locale + ")");
        }
        return null;
    }

    private static List<String> commonPatterns() {
        List<String> patterns = new ArrayList<>();
        patterns.add("yyyy-MM-dd");
        patterns.add("yyyy-MM-dd HH:mm:ss");
        patterns.add("dd/MM/yyyy");
        patterns.add("MM/dd/yyyy");
        patterns.add("dd-MM-yyyy");
        patterns.add("MM-dd-yyyy");
        patterns.add("yyyy/MM/dd");
        patterns.add("dd.MM.yyyy");
        patterns.add("EEE, MMM dd, yyyy");
        patterns.add("MMMM d, yyyy");
        return patterns;
    }

    private static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    private static String styleName(int style) {
        return switch (style) {
            case java.text.DateFormat.SHORT -> "SHORT";
            case java.text.DateFormat.MEDIUM -> "MEDIUM";
            case java.text.DateFormat.LONG -> "LONG";
            case java.text.DateFormat.FULL -> "FULL";
            default -> String.valueOf(style);
        };
    }
}
