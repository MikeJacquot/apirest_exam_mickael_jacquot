package com.humanbooster.apirest_exam_mickael_jacquot.model;


public class ErrorValidation {

    private String input;
    private String error;

    public ErrorValidation(String input, String error) {
        this.input = input;
        this.error = error;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
