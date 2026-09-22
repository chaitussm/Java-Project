package com.advanced.internationalization;

import java.text.DateFormat;
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

public class dateFormatClassDemo {

    public static void printDateFormat() {
        DateFormat dateFormat = DateFormat.getDateInstance();
        System.out.println(dateFormat.format(new Date()));
    }

    public static void printTimeFormat() {
        DateFormat timeFormat = DateFormat.getTimeInstance();
        System.out.println(timeFormat.format(new Date()));
    }

    public static void printDateTimeFormat() {
        DateFormat dateTimeFormat = DateFormat.getDateTimeInstance();
        System.out.println(dateTimeFormat.format(new Date()));
    }

    public static void printdaysFormat() {
        DateFormat daysFormat = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(daysFormat.format(new Date()));
    }

    public static void printVariousFormsOfdateFormat() {
        DateFormat fullDateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Full form: " + fullDateFormat.format(new Date()));

        DateFormat longDateFormat = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println("Long form: " + longDateFormat.format(new Date()));

        DateFormat mediumDateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println("Medium form: " + mediumDateFormat.format(new Date()));

        DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("Short form: " + shortDateFormat.format(new Date()));
    }

    public static void converStringToJavaDateForm(String dateString) {
        try {
            ParseOutcome outcome = parseDateDynamically(dateString);
            System.out.println("Converted date: " + outcome.date());
            System.out.println("Matched using: " + outcome.matchedUsing());
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
    }

    public static void converLocaleToStringForm(Date date) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        String dateString = dateFormat.format(date);
        System.out.println("Converted string: " + dateString);
    }

    /** Tries ISO, locale DateFormats, and common patterns until one matches the full string. */
    private static ParseOutcome parseDateDynamically(String dateString) throws ParseException {
        if (dateString == null || dateString.trim().isEmpty()) {
            throw new ParseException("Date string is empty", 0);
        }
        String text = dateString.trim();

        ParseOutcome fromTime = tryJavaTimeParsers(text);
        if (fromTime != null) {
            return fromTime;
        }

        Set<Locale> locales = new LinkedHashSet<>();
        locales.add(Locale.getDefault());
        locales.add(Locale.US);
        locales.add(Locale.UK);
        locales.add(Locale.FRANCE);
        locales.add(Locale.GERMANY);

        int[] dateStyles = {
                DateFormat.SHORT,
                DateFormat.MEDIUM,
                DateFormat.LONG,
                DateFormat.FULL
        };

        for (Locale locale : locales) {
            for (int style : dateStyles) {
                ParseOutcome r = tryDateFormat(
                        DateFormat.getDateInstance(style, locale),
                        text,
                        "DateFormat.getDateInstance(" + styleName(style) + ", " + locale + ")");
                if (r != null) {
                    return r;
                }
            }
            ParseOutcome dateTime = tryDateFormat(
                    DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locale),
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
            return new ParseOutcome(toDate(ld), "java.time LocalDate");
        } catch (DateTimeParseException ignored) {
            // try next
        }
        try {
            LocalDateTime ldt = LocalDateTime.parse(text, formatter);
            return new ParseOutcome(toDate(ldt), "java.time LocalDateTime");
        } catch (DateTimeParseException ignored) {
            // try next
        }
        try {
            ZonedDateTime zdt = ZonedDateTime.parse(text, formatter);
            return new ParseOutcome(Date.from(zdt.toInstant()), "java.time ZonedDateTime");
        } catch (DateTimeParseException ignored) {
            return null;
        }
    }

    private static ParseOutcome tryDateFormat(DateFormat format, String text, String description) {
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
            case DateFormat.SHORT -> "SHORT";
            case DateFormat.MEDIUM -> "MEDIUM";
            case DateFormat.LONG -> "LONG";
            case DateFormat.FULL -> "FULL";
            default -> String.valueOf(style);
        };
    }

    private static final class ParseOutcome {
        private final Date date;
        private final String matchedUsing;

        ParseOutcome(Date date, String matchedUsing) {
            this.date = date;
            this.matchedUsing = matchedUsing;
        }

        Date date() {
            return date;
        }

        String matchedUsing() {
            return matchedUsing;
        }
    }

    public static void main(String[] args) {
        printDateFormat();
        printTimeFormat();
        printDateTimeFormat();
        printdaysFormat();
        printVariousFormsOfdateFormat();
        converStringToJavaDateForm("2024-06-15");
        converStringToJavaDateForm("15/06/2024");
        converStringToJavaDateForm("June 15, 2024");
        converLocaleToStringForm(new Date());
    }
}