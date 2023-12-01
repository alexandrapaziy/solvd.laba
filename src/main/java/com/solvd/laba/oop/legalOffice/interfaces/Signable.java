package com.solvd.laba.oop.legalOffice.interfaces;

import com.solvd.laba.oop.legalOffice.Client;

@FunctionalInterface
public interface Signable {
    void sign(Client client);
}
