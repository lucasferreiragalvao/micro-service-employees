package edu.unifacef.employee.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {

    EMPLOYEE_NOT_FOUND("employee.not.found"),
    EMPLOYEE_ALREADY_EXISTS("employee.already.exists");

    private String key;
}