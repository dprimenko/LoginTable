package com.example.logintable.controllers;

import java.util.regex.Pattern;

/**
 * Created by usuario on 5/10/16.
 */


/*
* Class...
* */
public class LoginTable_Controller {

    public static final int OK = 0;
    public static final int PASSWORD_DIGIT = 1;
    public static final int PASSWORD_CASE = 2;
    public static final int PASSWORD_LENGTH = 3;

    public int validateCredentials(String user, String password) {

        if (!(password.matches("[0-9]"))) {
            return PASSWORD_DIGIT;
        }
        if (!((password.matches("[a-z]")) && (password.matches("[A-Z]")))) {
            return PASSWORD_CASE;
        }

        if (!(password.length() >= 8)) {
            return PASSWORD_LENGTH;
        }
        return OK;
    }
}
