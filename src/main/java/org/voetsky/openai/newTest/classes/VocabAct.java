package org.voetsky.openai.newTest.classes;

import org.voetsky.openai.newTest.service.Activity;
import org.voetsky.openai.newTest.service.ServiceClass;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static org.voetsky.openai.newTest.service.ServiceClass.readDictionaryList;

public class VocabAct extends AbstractStaticVars implements Activity {
    @Override
    public void doActivity() {

        Scanner s = new Scanner(System.in);
        while (true) {
            try {
                setStartString(ServiceClass.input("start string"));
            }catch (Exception e){
                break;
            }

            System.out.println("How much words to use?");
            setWordsCount(s.nextInt());
            s.nextLine();

            while (true) {

                try {
                    setSetForFill(getWords(readDictionaryList(), getWordsCount()));
                    setText(ServiceClass.shuffle(makeArrayForShuffle(getSetForFill())));
                    ServiceClass.showInConsole(getStartString() + getText());

                    System.err.println("Повторить ? 1 - да");


                    if (!s.nextLine().equals("1")) {
                        break;
                    }

                } catch (RuntimeException e) {
                    System.out.println("--------------------------");
                    break;
                }
            }
        }

    }

    public Set<String> getWords(List<String> s, int i) {
        Set<String> res = new HashSet<>();
        for (int j = 0; j < i; j++) {
            res.add(s.get(ThreadLocalRandom.current().nextInt(s.size())));
        }
        return res;
    }

    public String[] makeArrayForShuffle(Set<String> s) {
        String[] array = s.toArray(new String[0]);
        return array;
    }


}
