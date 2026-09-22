package com.advanced.internationalization;

import java.util.Locale;

public class localeClassDemo  {

    // Prints the default locale's country and language codes, as well as their display names.
    public static void printDefaultLocale() {
        Locale defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale.getCountry()+"---" + defaultLocale.getLanguage());
        System.out.println(defaultLocale.getDisplayCountry()+"---" + defaultLocale.getDisplayLanguage());
    }

    // Prints the default locale's country and its languages
    public static void printCountryAndLanguages() {
        Locale defaultLocale = new Locale("telugu" , "IN");
        Locale.setDefault(defaultLocale);
        System.out.println(defaultLocale.getDefault().getDisplayCountry()+"---" + defaultLocale.getDefault().getDisplayLanguage());
        System.out.println(defaultLocale.getLanguage());
    }

    //prints the languages 
    public static void printLanguages() {
        Locale defaultLocale = Locale.getDefault();
        String[] languages = Locale.getISOLanguages();
        for (String language : languages) {
            System.out.println(language);
        }
    }

    //prints countries
    public static void printCountries() {
        Locale defaultLocale = Locale.getDefault();
        String[] countries = Locale.getISOCountries();
        for (String country : countries) {
            System.out.println(country);
        }
    }

    //prints currencies 
    public static void printCurrencies() {
        Locale defaultLocale = Locale.getDefault();
        java.util.Currency currency = java.util.Currency.getInstance(defaultLocale);
        System.out.println(currency.getCurrencyCode()+"---" + currency.getDisplayName());
    }
    


    public static void main(String[] args) {
        printDefaultLocale();
        printCountryAndLanguages();
        printLanguages();
        //printCountries();
        printCurrencies();

    }

    
}
