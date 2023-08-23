package org.voetsky.openai.newTest.classes;

import org.voetsky.openai.newTest.service.Activity;
import org.voetsky.openai.newTest.service.ServiceClass;

public class ShuffleAct extends AbstractStaticVars implements Activity {

    @Override
    public void doActivity() {

        while (true) {
            try {

                setInput(ServiceClass.input("prompt"));
                addStartString(getInput());
                setSeparated(separate(getInput()));
                setText(ServiceClass.shuffle(getSeparated()));
                ServiceClass.showInConsole(getStartString() + getText());

            } catch (RuntimeException e) {
                System.out.println("--------------------------");
                break;
            }
        }

    }

    public String[] separate(String s) {

        String[] parts = s.split(":\\s*", 2);
        return ServiceClass.separate(parts[1]);

    }

    public void addStartString(String s) {

        String[] parts = s.split(":\\s*", 2);
        setStartString(parts[0] + ": ");

    }


}
