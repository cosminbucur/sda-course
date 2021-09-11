package com.sda.advanced.exceptions;

import com.sda.advanced.enums.ConsentType;

public class InputException extends RuntimeException {
    public InputException(ConsentType consentType) {
        super("Unknown consent type" + consentType);
    }
}
