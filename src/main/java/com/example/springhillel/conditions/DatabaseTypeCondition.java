package com.example.springhillel.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DatabaseTypeCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
        String enabledType = System.getProperty("mySql");
        return enabledType != null && enabledType.equalsIgnoreCase("true");
    }
}