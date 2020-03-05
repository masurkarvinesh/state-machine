package com.vim.statemachine;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class Config extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
                .withStates()
                .initial(States.STATE2)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        //configureStateOne(transitions);
        //configureStateTwo(transitions);
    }

    private void configureStateOne(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions
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

    private void configureStateTwo(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions
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
