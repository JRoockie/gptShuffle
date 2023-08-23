package org.voetsky.openai.newTest.service;

import org.voetsky.openai.newTest.classes.FillDictionaryAct;
import org.voetsky.openai.newTest.classes.Machine;
import org.voetsky.openai.newTest.classes.ShuffleAct;
import org.voetsky.openai.newTest.classes.VocabAct;


import java.util.Scanner;

public class newMain {
    public static void main(String[] args) {

        Machine machine = new Machine();


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------------");
            System.out.println("Shuffle Prompt - 1" +
                    "\nFill vocab - 2" +
                    "\nUse vocab with start string - 3");
            System.out.println("--------------------------");

            String input = scanner.nextLine();
            if (input.equals("1")) {
                machine.setActivity(new ShuffleAct());
                machine.executeActivity();
            }
            if (input.equals("2")) {
                machine.setActivity(new FillDictionaryAct());
                machine.executeActivity();
            }

            if (input.equals("3")) {
                machine.setActivity(new VocabAct());
                machine.executeActivity();
            }
            if (input.equals("break")) {
                break;
            }
        }

    }
}
