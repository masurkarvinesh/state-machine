package com.vim.statemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;

public class MyApp {

    @Autowired
    StateMachine<States, Events> stateMachine;

    void doSignals() {
        //StateMachine<States, Events> stateMachine = smBuilder.buildMachine();
        stateMachine.start();
        stateMachine.sendEvent(Events.EVENT1);
        stateMachine.sendEvent(Events.EVENT2);
    }
}
