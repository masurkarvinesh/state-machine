package com.vim.statemachine;

import org.junit.jupiter.api.Test;
import org.springframework.statemachine.StateMachine;

class MachineBuilderFeatureTest {

    private MachineBuilder smBuilder = new MachineBuilder();

    @Test
    public void testStateMachine() throws Exception {
        StateMachine<States, Events> stateMachine = smBuilder.buildMachine();
        stateMachine.start();
        stateMachine.sendEvent(Events.EVENT1);
        stateMachine.sendEvent(Events.EVENT2);
    }
}
