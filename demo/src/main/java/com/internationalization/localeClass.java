package com.internationalization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Locale.FilteringMode;
import java.util.Locale.LanguageRange;

/**
 * Demonstrates {@link Locale} constructors, constants, static factories,
 * instance accessors, display names, BCP 47 tags, extensions, and
 * {@link Locale.Builder} / filter / lookup APIs.
 */
public class localeClass {

    private static final String SEP = "------------------------------------------------------------";

    public static void main(String[] args) {
        System.out.println("=== Locale class demonstration (localeClass.java) ===\n");

        demonstrateConstants();
        demonstrateConstructors();
        demonstrateStaticFactories();
        demonstrateGettersAndDisplay();
        demonstrateIsoAndLanguageTag();
        demonstrateExtensionsAndBuilder();
        demonstrateDefaultLocale();
        demonstrateAvailableAndIsoLists();
        demonstrateCloneEqualsHash();
        demonstrateFilterAndLookup();

        System.out.println("\n=== End of demonstration ===");
    }

    private static void demonstrateConstants() {
        section("Predefined constants (Locale.US, Locale.GERMANY, …)");
        System.out.println("Locale.US           = " + Locale.US);
        System.out.println("Locale.UK           = " + Locale.UK);
        System.out.println("Locale.GERMANY      = " + Locale.GERMANY);
        System.out.println("Locale.FRANCE       = " + Locale.FRANCE);
        System.out.println("Locale.ENGLISH      = " + Locale.ENGLISH);
        System.out.println("Locale.CHINESE      = " + Locale.CHINESE);
        System.out.println("Locale.SIMPLIFIED_CHINESE = " + Locale.SIMPLIFIED_CHINESE);
        System.out.println("Locale.ROOT         = " + Locale.ROOT);
    }

    private static void demonstrateConstructors() {
        section("Constructors: Locale(language), Locale(language, country), Locale(language, country, variant)");
        Locale byLanguage = new Locale("en");
        Locale byLangCountry = new Locale("en", "US");
        Locale byLangCountryVariant = new Locale("en", "US", "POSIX");
        System.out.println("new Locale(\"en\")              -> " + byLanguage);
        System.out.println("new Locale(\"en\", \"US\")        -> " + byLangCountry);
        System.out.println("new Locale(\"en\", \"US\", \"POSIX\") -> " + byLangCountryVariant);
    }

    private static void demonstrateStaticFactories() {
        section("Static factories: Locale.of(...) and Locale.forLanguageTag(...)");
        Locale ofLang = Locale.of("hi");
        Locale ofLangRegion = Locale.of("hi", "IN");
        Locale ofLangRegionVariant = Locale.of("hi", "IN", "POSIX");
        System.out.println("Locale.of(\"hi\")           -> " + ofLang);
        System.out.println("Locale.of(\"hi\", \"IN\")     -> " + ofLangRegion);
        System.out.println("Locale.of(\"hi\", \"IN\", \"POSIX\") -> " + ofLangRegionVariant);

        String tag = "zh-Hans-CN";
        Locale fromTag = Locale.forLanguageTag(tag);
        System.out.println("Locale.forLanguageTag(\"" + tag + "\") -> " + fromTag);
        System.out.println("Locale.caseFoldLanguageTag(\"EN-us\") -> " + Locale.caseFoldLanguageTag("EN-us"));
    }

    private static void demonstrateGettersAndDisplay() {
        section("Instance getters and getDisplay* (UI labels for users)");
        Locale india = Locale.of("hi", "IN");
        System.out.println("getLanguage()  = " + india.getLanguage());
        System.out.println("getCountry()   = " + india.getCountry());
        System.out.println("getVariant()   = " + india.getVariant());
        System.out.println("getScript()    = " + india.getScript());
        System.out.println("toString()     = " + india.toString());
        System.out.println("toLanguageTag()= " + india.toLanguageTag());

        System.out.println("getDisplayLanguage()       = " + india.getDisplayLanguage());
        System.out.println("getDisplayCountry()        = " + india.getDisplayCountry());
        System.out.println("getDisplayName()           = " + india.getDisplayName());
        System.out.println("getDisplayLanguage(Locale.US) = " + india.getDisplayLanguage(Locale.US));
        System.out.println("getDisplayCountry(Locale.US)  = " + india.getDisplayCountry(Locale.US));
        System.out.println("getDisplayName(Locale.US)       = " + india.getDisplayName(Locale.US));
    }

    private static void demonstrateIsoAndLanguageTag() {
        section("ISO-639 / ISO-3166 helpers (getISO3Language, getISO3Country)");
        Locale us = Locale.US;
        try {
            System.out.println("US getISO3Language() = " + us.getISO3Language());
            System.out.println("US getISO3Country()  = " + us.getISO3Country());
        } catch (Exception e) {
            System.out.println("ISO3 lookup failed: " + e);
        }
    }

    private static void demonstrateExtensionsAndBuilder() {
        section("Locale.Builder and BCP 47 extensions");
        Locale built = new Locale.Builder()
                .setLanguage("en")
                .setRegion("GB")
                .setScript("Latn")
                .setUnicodeLocaleKeyword("nu", "latn")
                .build();
        System.out.println("Builder result: " + built);
        System.out.println("hasExtensions() = " + built.hasExtensions());
        System.out.println("getUnicodeLocaleType(\"nu\") = " + built.getUnicodeLocaleType("nu"));
        System.out.println("getUnicodeLocaleKeys() = " + built.getUnicodeLocaleKeys());
        System.out.println("getUnicodeLocaleAttributes() = " + built.getUnicodeLocaleAttributes());
        System.out.println("getExtensionKeys() = " + built.getExtensionKeys());
        System.out.println("stripExtensions() = " + built.stripExtensions());

        Locale cleared = new Locale.Builder().setLocale(built).clearExtensions().build();
        System.out.println("clearExtensions() -> " + cleared);
    }

    private static void demonstrateDefaultLocale() {
        section("Default locale: getDefault / setDefault (JVM-wide, restored after demo)");
        Locale originalDefault = Locale.getDefault();
        Locale originalDisplay = Locale.getDefault(Locale.Category.DISPLAY);
        Locale originalFormat = Locale.getDefault(Locale.Category.FORMAT);
        System.out.println("getDefault()                    = " + originalDefault);
        System.out.println("getDefault(Locale.Category.DISPLAY) = " + originalDisplay);
        System.out.println("getDefault(Locale.Category.FORMAT)  = " + originalFormat);

        Locale.setDefault(Locale.of("fr", "FR"));
        System.out.println("After setDefault(fr_FR), getDefault() = " + Locale.getDefault());

        Locale.setDefault(Locale.Category.FORMAT, Locale.US);
        System.out.println("After setDefault(FORMAT, US), FORMAT = " + Locale.getDefault(Locale.Category.FORMAT));

        Locale.setDefault(originalDefault);
        Locale.setDefault(Locale.Category.DISPLAY, originalDisplay);
        Locale.setDefault(Locale.Category.FORMAT, originalFormat);
        System.out.println("Restored JVM default locale to " + Locale.getDefault());
    }

    private static void demonstrateAvailableAndIsoLists() {
        section("getAvailableLocales / availableLocales / getISOCountries / getISOLanguages");
        Locale[] all = Locale.getAvailableLocales();
        System.out.println("getAvailableLocales().length = " + all.length);
        System.out.println("First 5 available locales: " + Arrays.toString(Arrays.copyOf(all, Math.min(5, all.length))));

        long streamCount = Locale.availableLocales().count();
        System.out.println("availableLocales().count()   = " + streamCount);

        String[] countries = Locale.getISOCountries();
        System.out.println("getISOCountries().length     = " + countries.length);
        System.out.println("Sample ISO country codes: " + Arrays.toString(Arrays.copyOf(countries, 5)));

        String[] languages = Locale.getISOLanguages();
        System.out.println("getISOLanguages().length     = " + languages.length);
        System.out.println("Sample ISO language codes: " + Arrays.toString(Arrays.copyOf(languages, 5)));

        System.out.println("getISOCountries(IsoCountryCode.PART1_ALPHA2).size sample = "
                + Locale.getISOCountries(Locale.IsoCountryCode.PART1_ALPHA2).stream().limit(5).toList());
    }

    private static void demonstrateCloneEqualsHash() {
        section("clone(), equals(), hashCode()");
        Locale a = Locale.of("en", "US");
        Locale b = Locale.of("en", "US");
        Locale c = (Locale) a.clone();
        System.out.println("a.equals(b) = " + a.equals(b));
        System.out.println("a.equals(c) = " + a.equals(c));
        System.out.println("a.hashCode() = " + a.hashCode() + ", b.hashCode() = " + b.hashCode());
        System.out.println("clone() produces equal locale: " + a.equals(c));
    }

    private static void demonstrateFilterAndLookup() {
        section("LanguageRange filter / lookup (HTTP Accept-Language style)");
        List<LanguageRange> ranges = LanguageRange.parse("en-US;q=0.9, en;q=0.8, fr;q=0.5");
        List<Locale> candidates = Arrays.asList(Locale.GERMANY, Locale.US, Locale.FRANCE, Locale.UK);
        List<Locale> matched = Locale.filter(ranges, candidates);
        System.out.println("filter(ranges, locales) -> " + matched);

        List<Locale> matchedExtended = Locale.filter(ranges, candidates, FilteringMode.EXTENDED_FILTERING);
        System.out.println("filter(..., EXTENDED_FILTERING) -> " + matchedExtended);

        List<String> tags = Arrays.asList("de-DE", "en-GB", "es-ES");
        List<String> filteredTags = Locale.filterTags(ranges, tags);
        System.out.println("filterTags(ranges, tags) -> " + filteredTags);

        Locale best = Locale.lookup(ranges, candidates);
        System.out.println("lookup(ranges, locales) -> " + best);

        String bestTag = Locale.lookupTag(ranges, tags);
        System.out.println("lookupTag(ranges, tags) -> " + bestTag);
    }

    private static void section(String title) {
        System.out.println();
        System.out.println(SEP);
        System.out.println(title);
        System.out.println(SEP);
    }
}
