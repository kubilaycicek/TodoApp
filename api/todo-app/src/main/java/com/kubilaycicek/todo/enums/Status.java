package com.kubilaycicek.todo.enums;

public enum Status {
    TODO(0), DOING(1), TEST(2), CLOSED(3);

    private int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue(int value) {
        return this.value;
    }
}
