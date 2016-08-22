package com.test.hikari;

/**
 * Created by kotu on 8/19/16.
 */
public interface Formula {
    double calculate(int a);
    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
