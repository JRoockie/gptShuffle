package org.voetsky.openai.newTest.classes;

import org.voetsky.openai.newTest.service.Activity;

public class Machine {

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    Activity activity;

    public void executeActivity(){
        activity.doActivity();
    }

}
