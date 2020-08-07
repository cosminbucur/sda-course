package com.bucur.exceptions;

import com.bucur.enums.ConsentType;

public class InputException extends RuntimeException {
    public InputException(ConsentType consentType) {
        super("Unknown consent type" + consentType);
    }
}
