package com.solvd.laba.oop.legalOffice.interfaces;

@FunctionalInterface
public interface SingleParameterFunctionalInterface<T> {
    void performAction(T parameter);
}