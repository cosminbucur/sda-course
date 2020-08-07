package com.bucur.exceptions;

import com.bucur.enums.ConsentType;

public class DemoException {

    public static void main(String[] args) {
        int x = 2;
        ConsentType consentType = ConsentType.ACCEPTED;
        if (x == 2) {
            throw new InputException(consentType);
        }
    }
}
