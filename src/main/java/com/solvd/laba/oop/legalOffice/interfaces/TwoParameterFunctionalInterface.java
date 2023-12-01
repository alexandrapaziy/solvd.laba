package com.solvd.laba.oop.legalOffice.interfaces;

@FunctionalInterface
public interface TwoParameterFunctionalInterface<T, U> {
    void performAction(T parameter1, U parameter2);
}

