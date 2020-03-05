package com.vim.statemachine;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

public class EventOneAction implements Action<States, Events> {

    @Override
    public void execute(StateContext<States, Events> context) {
        System.out.println("Executing Action for Event ONE ..................................1111");
    }
}
