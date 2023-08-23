package org.voetsky.openai.newTest.classes;

import org.voetsky.openai.newTest.service.Activity;
import org.voetsky.openai.newTest.service.ServiceClass;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FillDictionaryAct extends AbstractStaticVars implements Activity {
    @Override
    public void doActivity() {



        beautifulMessage();
        setInput(ServiceClass.input("dictionary words"));
        setSeparated(ServiceClass.separate(getInput()));
        setSetForFill(writeForFill(getSeparated()));


            setSeparated(ServiceClass.separate(readDictionary()));

            setSetFromDictionary(writeDictionaryInSet(getSeparated()));
            setSetForFill(ListAndDictionarySet(getSetFromDictionary(), getSetForFill()));
            setSetFromDictionary(writeDictionary(getSetForFill()));

    }

    private Set<String> writeDictionaryInSet(String[] strings) {

        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < strings.length; i++) {
            stringSet.add(strings[i]);
        }
        return stringSet;

    }

    private Set<String> ListAndDictionarySet(Set<String> dic, Set<String> forFill) {

        Set<String> combinedSet = new HashSet<>(dic);
        combinedSet.addAll(forFill);
        return combinedSet;

    }

    public void beautifulMessage() {

        System.out.println("\nНапиши слова через запятую для заполнения в словарь");

    }

    public synchronized String readDictionary() {

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
        return content.toString();
    }


    public Set<String> writeForFill(String[] strings){
        return new HashSet<>(Arrays.asList(strings));
    }

    public synchronized Set<String> writeDictionary(Set<String> strings){

        String path = "src/main/resources/dictionary.txt";

        try (
                FileWriter writer = new FileWriter(path)
        ) {
            for (String str : strings) {
                writer.write(str + ", "); // Записываем строку
            }
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return strings;
    }
}
