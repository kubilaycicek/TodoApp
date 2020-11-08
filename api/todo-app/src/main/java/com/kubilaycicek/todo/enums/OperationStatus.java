package com.kubilaycicek.todo.enums;

public enum OperationStatus {
    SUCCESS(true), UN_SUCCESS(false);

    boolean value;

    OperationStatus(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return this.value;
    }
}
