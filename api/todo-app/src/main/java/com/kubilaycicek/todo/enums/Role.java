package com.kubilaycicek.todo.enums;

public enum Role {

    USER(0), ADMIN(1);

    private int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() { return value; }
}
