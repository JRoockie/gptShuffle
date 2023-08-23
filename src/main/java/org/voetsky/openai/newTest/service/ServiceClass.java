package org.voetsky.openai.newTest.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static org.voetsky.openai.newTest.classes.AbstractStaticVars.getSetFromDictionary;

public class ServiceClass {

    public static String input(String s) {
        System.out.println("--------------------------");
        System.out.printf("Write your %s\n",s);
        System.out.println("--------------------------");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.equals("break")){
            throw new RuntimeException();
        }
        return input;
    }

    public static String shuffle(String[] s) {

        List<String> wordList = new ArrayList<>(Arrays.asList(s)); // Преобразуем массив в список
        Collections.shuffle(wordList); // Перемешиваем список

        return String.join(", ", wordList);
    }

    public static String[] separate(String s){
        String[] strings = s.split("\\s*,\\s*");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].toLowerCase();
        }
        return strings;

    }

    public static void showInConsole(String s){
        System.out.println("--------------------------");
        System.out.println(s);
    }

    public static List<String> getListFromDictionary(){
        List<String> s = (List<String>) getSetFromDictionary();
        return s;
    }

    public static synchronized List<String> readDictionaryList() {

        String path = "src/main/resources/dictionary.txt";
        StringBuilder content = new StringBuilder();

        try (
                FileReader fileReader = new FileReader(path);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String result = content.toString();
        String[] array = ServiceClass.separate(result);

        return Arrays.asList(array);

    }



}
