# Introduction

The process of designing web applications in such a way that which provides support for various countries and various languages and various currencies automatically without performing any change in the application, is called internationalization(I18N)

For example: 

If the request is coming from India then the response should be Indian people understandable form and if the request is coming from USA then the response should be in US people understandable form.

We can implement internationalization by using the following 3 classes 

1. Locale
2. NumberFormat
3. DateFormat

# Locale Class 

A locale object represents a geographic location(country) or language or both 

example : We can create a locale object to represent india 

We can create a locale object to represent English language

1. Locale class present in java.util package 
2. It is a final classs and it is the direct child class of object 
         