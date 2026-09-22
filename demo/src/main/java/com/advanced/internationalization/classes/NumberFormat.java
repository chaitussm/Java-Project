package com.advanced.internationalization.classes;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Currency;
import java.util.Locale;

/**
 * Demonstrates {@link java.text.NumberFormat} factory methods, formatting/parsing,
 * digit/currency/grouping settings, and {@link DecimalFormat} constructors.
 */
public class NumberFormat {

    private static final String SEP = "------------------------------------------------------------";
    private static final double SAMPLE = 1234567.891;

    public static void main(String[] args) throws ParseException {
        System.out.println("=== NumberFormat demonstration (NumberFormat.java) ===\n");

        demonstrateFactoryMethods();
        demonstrateFormatAndParse();
        demonstrateConfiguration();
        demonstrateCurrencyAndPercent();
        demonstrateCompactNumbers();
        demonstrateDecimalFormatConstructors();
        demonstrateCloneEqualsHash();
        demonstrateAvailableLocales();

        System.out.println("\n=== End of demonstration ===");
    }

    private static void demonstrateFactoryMethods() {
        section("Static factories: getInstance / getNumberInstance / getIntegerInstance / …");
        Locale us = Locale.US;
        Locale india = Locale.of("hi", "IN");

        System.out.println("getInstance()        = "
                + java.text.NumberFormat.getInstance().getClass().getSimpleName());
        System.out.println("getNumberInstance(US)= "
                + java.text.NumberFormat.getNumberInstance(us).format(SAMPLE));
        System.out.println("getIntegerInstance(IN)= "
                + java.text.NumberFormat.getIntegerInstance(india).format(SAMPLE));
        System.out.println("getCurrencyInstance(DE)= "
                + java.text.NumberFormat.getCurrencyInstance(Locale.GERMANY).format(SAMPLE));
        System.out.println("getPercentInstance(US)= "
                + java.text.NumberFormat.getPercentInstance(us).format(0.75));
    }

    private static void demonstrateFormatAndParse() throws ParseException {
        section("format(double/long) and parse(String)");
        java.text.NumberFormat nf = java.text.NumberFormat.getNumberInstance(Locale.US);
        String formatted = nf.format(SAMPLE);
        long asLong = 9876543210L;
        System.out.println("format(double) = " + formatted);
        System.out.println("format(long)   = " + nf.format(asLong));

        Number parsed = nf.parse("1,234.56");
        System.out.println("parse(\"1,234.56\") = " + parsed);

        ParsePosition pos = new ParsePosition(0);
        Number partial = nf.parse("1,234.56 trailing", pos);
        System.out.println("parse with ParsePosition index=" + pos.getIndex() + " -> " + partial);

        StringBuffer buf = new StringBuffer();
        FieldPosition fp = new FieldPosition(java.text.NumberFormat.FRACTION_FIELD);
        nf.format(SAMPLE, buf, fp);
        System.out.println("format to StringBuffer = " + buf + " (fraction field begin=" + fp.getBeginIndex() + ")");
        System.out.println("INTEGER_FIELD constant = " + java.text.NumberFormat.INTEGER_FIELD
                + ", FRACTION_FIELD = " + java.text.NumberFormat.FRACTION_FIELD);
    }

    private static void demonstrateConfiguration() {
        section("Digit limits, grouping, rounding, parseIntegerOnly");
        java.text.NumberFormat nf = java.text.NumberFormat.getNumberInstance(Locale.US);
        nf.setGroupingUsed(true);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        nf.setMaximumIntegerDigits(8);
        nf.setMinimumIntegerDigits(1);
        nf.setRoundingMode(RoundingMode.HALF_UP);
        nf.setParseIntegerOnly(false);

        System.out.println("isGroupingUsed() = " + nf.isGroupingUsed());
        System.out.println("getMaximumFractionDigits() = " + nf.getMaximumFractionDigits());
        System.out.println("getMinimumFractionDigits() = " + nf.getMinimumFractionDigits());
        System.out.println("getRoundingMode() = " + nf.getRoundingMode());
        System.out.println("formatted = " + nf.format(SAMPLE));

        nf.setParseIntegerOnly(true);
        System.out.println("isParseIntegerOnly() = " + nf.isParseIntegerOnly());
    }

    private static void demonstrateCurrencyAndPercent() {
        section("setCurrency / getCurrency");
        java.text.NumberFormat currency = java.text.NumberFormat.getCurrencyInstance(Locale.US);
        Currency usd = Currency.getInstance("USD");
        currency.setCurrency(usd);
        System.out.println("getCurrency() = " + currency.getCurrency());
        System.out.println("format currency = " + currency.format(99.5));
    }

    private static void demonstrateCompactNumbers() {
        section("getCompactNumberInstance (Java 12+)");
        java.text.NumberFormat compact = java.text.NumberFormat.getCompactNumberInstance(
                Locale.US, java.text.NumberFormat.Style.SHORT);
        System.out.println("compact SHORT US: " + compact.format(1500));
        java.text.NumberFormat compactLong = java.text.NumberFormat.getCompactNumberInstance(
                Locale.US, java.text.NumberFormat.Style.LONG);
        System.out.println("compact LONG US:  " + compactLong.format(1500));
    }

    private static void demonstrateDecimalFormatConstructors() {
        section("DecimalFormat constructors (concrete NumberFormat)");
        DecimalFormat pattern = new DecimalFormat("#,##0.00");
        System.out.println("new DecimalFormat(\"#,##0.00\") -> " + pattern.format(SAMPLE));

        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(Locale.FRANCE);
        DecimalFormat withSymbols = new DecimalFormat("#,##0.00", symbols);
        System.out.println("DecimalFormat with FR symbols -> " + withSymbols.format(SAMPLE));
        System.out.println("grouping size = " + withSymbols.getGroupingSize());
        withSymbols.setGroupingSize(3);
        withSymbols.setPositivePrefix("+");
        System.out.println("after setPositivePrefix(+) -> " + withSymbols.format(SAMPLE));
    }

    private static void demonstrateCloneEqualsHash() {
        section("clone(), equals(), hashCode()");
        java.text.NumberFormat a = java.text.NumberFormat.getNumberInstance(Locale.US);
        java.text.NumberFormat b = (java.text.NumberFormat) a.clone();
        System.out.println("clone class = " + b.getClass().getSimpleName());
        System.out.println("equals after clone = " + a.equals(b));
        System.out.println("hashCode a=" + a.hashCode() + " b=" + b.hashCode());
    }

    private static void demonstrateAvailableLocales() {
        section("NumberFormat.getAvailableLocales()");
        Locale[] locales = java.text.NumberFormat.getAvailableLocales();
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
