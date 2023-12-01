package com.solvd.laba.oop.legalOffice.interfaces;

@FunctionalInterface
public interface ThreeParameterFunctionalInterface<T, U, V> {
    void performAction(T parameter1, U parameter2, V parameter3);
}
