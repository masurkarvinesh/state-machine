package com.vim.statemachine;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;

import java.util.EnumSet;

public class MachineBuilder {

    public StateMachine<States, Events> buildMachine() throws Exception {
        StateMachineBuilder.Builder<States, Events> builder = StateMachineBuilder.builder();

        configureInitialState(builder);

        configureStateOne(builder);

        //configureStateTwo(builder);

        return builder.build();
    }

    private void configureInitialState(StateMachineBuilder.Builder<States, Events> builder) throws Exception {
        builder.configureStates()
                .withStates()
                .initial(States.STATE1)
                .states(EnumSet.allOf(States.class));
    }

    private void configureStateOne(StateMachineBuilder.Builder<States, Events> builder) throws Exception {
        builder.configureTransitions()
                .withExternal()
                .source(States.STATE1).target(States.STATE2)
                .event(Events.EVENT1)
                .action(new EventOneAction())

                .and()

                .withExternal()
                .source(States.STATE2).target(States.STATE1)
                .event(Events.EVENT2)
                .action(new EventTwoAction());
    }

    private void configureStateTwo(StateMachineBuilder.Builder<States, Events> builder) throws Exception {
        builder.configureTransitions()
                .withExternal()
                .source(States.STATE2).target(States.STATE1)
                .event(Events.EVENT2)
                .action(new EventTwoAction())

                .and()

                .withExternal()
                .source(States.STATE1).target(States.STATE2)
                .event(Events.EVENT1)
                .action(new EventOneAction());
    }
}
