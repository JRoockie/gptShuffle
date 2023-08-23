package org.voetsky.openai.newTest.classes;

import java.util.Set;

public class AbstractStaticVars {
    public static String getStartString() {
        return startString;
    }

    public static void setStartString(String startString) {
        AbstractStaticVars.startString = startString + " ";
    }

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        AbstractStaticVars.text = text;
    }

    public static String[] getSeparated() {
        return separated;
    }

    public static void setSeparated(String[] separated) {
        AbstractStaticVars.separated = separated;
    }


    public static String getInput() {
        return input;
    }

    public static void setInput(String input) {
        AbstractStaticVars.input = input;
    }

    private static String startString;
    private static String text;
    private static String[] separated;
    private static String input;
    private static Set<String> setForFill;
    private static Set<String> setFromDictionary;


    public static void setWordsCount(int wordsCount) {
        AbstractStaticVars.wordsCount = wordsCount;
    }

    public static int getWordsCount() {
        return wordsCount;
    }
    private static int wordsCount= 10;



    public static Set<String> getSetFromDictionary() {
        return setFromDictionary;
    }

    public static void setSetFromDictionary(Set<String> setFromDictionary) {
        AbstractStaticVars.setFromDictionary = setFromDictionary;
    }

    public static Set<String> getSetForFill() {
        return setForFill;
    }

    public static void setSetForFill(Set<String> setForFill) {
        AbstractStaticVars.setForFill = setForFill;
    }
}
