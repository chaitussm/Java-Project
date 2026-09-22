package com.advanced.internationalization.classes;

import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Demonstrates {@link java.text.DateFormat} factory methods, style constants,
 * format/parse, calendar/time-zone/lenient settings, and {@link SimpleDateFormat}.
 */
public class DateFormat {

    private static final String SEP = "------------------------------------------------------------";
    private static final Date SAMPLE = new Date(125, Calendar.AUGUST, 15, 14, 30, 0); // 2025-08-15 14:30:00

    public static void main(String[] args) throws ParseException {
        System.out.println("=== DateFormat demonstration (DateFormat.java) ===\n");

        demonstrateStyleConstants();
        demonstrateFactoryMethods();
        demonstrateFormatAndParse();
        demonstrateTimeZoneAndCalendar();
        demonstrateLenientAndNumberFormat();
        demonstrateSimpleDateFormatConstructors();
        demonstrateFieldConstants();
        demonstrateCloneEqualsHash();
        demonstrateAvailableLocales();

        System.out.println("\n=== End of demonstration ===");
    }

    private static void demonstrateStyleConstants() {
        section("Style constants: FULL, LONG, MEDIUM, SHORT, DEFAULT");
        System.out.println("FULL=" + java.text.DateFormat.FULL + " LONG=" + java.text.DateFormat.LONG
                + " MEDIUM=" + java.text.DateFormat.MEDIUM + " SHORT=" + java.text.DateFormat.SHORT
                + " DEFAULT=" + java.text.DateFormat.DEFAULT);
    }

    private static void demonstrateFactoryMethods() {
        section("getDateInstance / getTimeInstance / getDateTimeInstance / getInstance");
        Locale us = Locale.US;
        Locale india = Locale.of("hi", "IN");

        System.out.println("getDateInstance(SHORT, US)     = "
                + java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT, us).format(SAMPLE));
        System.out.println("getDateInstance(LONG, IN)    = "
                + java.text.DateFormat.getDateInstance(java.text.DateFormat.LONG, india).format(SAMPLE));
        System.out.println("getTimeInstance(MEDIUM, US)    = "
                + java.text.DateFormat.getTimeInstance(java.text.DateFormat.MEDIUM, us).format(SAMPLE));
        System.out.println("getDateTimeInstance(SHORT, FULL, US) = "
                + java.text.DateFormat.getDateTimeInstance(java.text.DateFormat.SHORT, java.text.DateFormat.FULL, us)
                        .format(SAMPLE));
        System.out.println("getInstance() default        = "
                + java.text.DateFormat.getInstance().format(SAMPLE));
        System.out.println("getDateInstance() no-arg     = "
                + java.text.DateFormat.getDateInstance().format(SAMPLE));
        System.out.println("getTimeInstance() no-arg     = "
                + java.text.DateFormat.getTimeInstance().format(SAMPLE));
    }

    private static void demonstrateFormatAndParse() throws ParseException {
        section("format(Date) and parse(String)");
        java.text.DateFormat df = java.text.DateFormat.getDateTimeInstance(
                java.text.DateFormat.MEDIUM, java.text.DateFormat.MEDIUM, Locale.US);
        String text = df.format(SAMPLE);
        System.out.println("format(SAMPLE) = " + text);

        Date parsed = df.parse(text);
        System.out.println("parse(formatted) = " + parsed);

        ParsePosition pos = new ParsePosition(0);
        Date fromPos = df.parse(text, pos);
        System.out.println("parse with ParsePosition index=" + pos.getIndex() + " -> " + fromPos);

        StringBuffer buf = new StringBuffer();
        FieldPosition fp = new FieldPosition(java.text.DateFormat.YEAR_FIELD);
        df.format(SAMPLE, buf, fp);
        System.out.println("format to StringBuffer = " + buf);
    }

    private static void demonstrateTimeZoneAndCalendar() {
        section("setTimeZone / getTimeZone / setCalendar / getCalendar");
        java.text.DateFormat df = java.text.DateFormat.getDateTimeInstance(
                java.text.DateFormat.FULL, java.text.DateFormat.FULL, Locale.US);
        TimeZone utc = TimeZone.getTimeZone("UTC");
        df.setTimeZone(utc);
        System.out.println("getTimeZone() = " + df.getTimeZone().getID());
        System.out.println("format in UTC = " + df.format(SAMPLE));

        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(SAMPLE);
        df.setCalendar(cal);
        System.out.println("getCalendar().getTime() = " + df.getCalendar().getTime());
    }

    private static void demonstrateLenientAndNumberFormat() {
        section("setLenient / isLenient and embedded NumberFormat");
        java.text.DateFormat df = java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT, Locale.US);
        df.setLenient(false);
        System.out.println("isLenient() = " + df.isLenient());
        java.text.NumberFormat nf = df.getNumberFormat();
        System.out.println("getNumberFormat() = " + (nf != null ? nf.getClass().getSimpleName() : "null"));
        if (nf != null) {
            java.text.NumberFormat custom = java.text.NumberFormat.getIntegerInstance(Locale.US);
            df.setNumberFormat(custom);
            System.out.println("setNumberFormat(integer) applied");
        }
    }

    private static void demonstrateSimpleDateFormatConstructors() {
        section("SimpleDateFormat constructors and applyPattern");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        System.out.println("new SimpleDateFormat(pattern, locale) -> " + sdf.format(SAMPLE));
        System.out.println("toPattern() = " + sdf.toPattern());

        SimpleDateFormat defaultCtor = new SimpleDateFormat();
        defaultCtor.applyPattern("dd/MM/yyyy");
        System.out.println("applyPattern(dd/MM/yyyy) -> " + defaultCtor.format(SAMPLE));

        DateFormatSymbols symbols = DateFormatSymbols.getInstance(Locale.FRANCE);
        SimpleDateFormat localized = new SimpleDateFormat("EEEE d MMMM yyyy", symbols);
        System.out.println("with DateFormatSymbols FR -> " + localized.format(SAMPLE));
        localized.applyLocalizedPattern("dd/MM/yyyy HH:mm");
        System.out.println("applyLocalizedPattern -> " + localized.format(SAMPLE));
    }

    private static void demonstrateFieldConstants() {
        section("DateFormat field constants (for FieldPosition)");
        System.out.println("ERA_FIELD=" + java.text.DateFormat.ERA_FIELD
                + " YEAR_FIELD=" + java.text.DateFormat.YEAR_FIELD
                + " MONTH_FIELD=" + java.text.DateFormat.MONTH_FIELD
                + " DATE_FIELD=" + java.text.DateFormat.DATE_FIELD);
        System.out.println("HOUR_OF_DAY0_FIELD=" + java.text.DateFormat.HOUR_OF_DAY0_FIELD
                + " MINUTE_FIELD=" + java.text.DateFormat.MINUTE_FIELD
                + " TIMEZONE_FIELD=" + java.text.DateFormat.TIMEZONE_FIELD);
    }

    private static void demonstrateCloneEqualsHash() {
        section("clone(), equals(), hashCode()");
        java.text.DateFormat a = java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT, Locale.US);
        java.text.DateFormat b = (java.text.DateFormat) a.clone();
        System.out.println("clone type = " + b.getClass().getSimpleName());
        System.out.println("equals = " + a.equals(b));
        System.out.println("hashCode a=" + a.hashCode() + " b=" + b.hashCode());
    }

    private static void demonstrateAvailableLocales() {
        section("DateFormat.getAvailableLocales()");
        Locale[] locales = java.text.DateFormat.getAvailableLocales();
        System.out.println("available locale count = " + locales.length);
        System.out.println("sample: " + locales[0] + ", " + locales[1]);
    }

    private static void section(String title) {
        System.out.println();
        System.out.println(SEP);
        System.out.println(title);
        System.out.println(SEP);
    }
}
