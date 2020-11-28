package com.kingofraccoon.zik.transport;

import com.kingofraccoon.zik.users.User;

public class Transport {
    private int number;
    private User driver;

    public Transport(int number) {
        this.number = number;
    }

    public Transport(int number, User driver) {
        this(number);
        this.driver = driver;
    }

    public int getNumber() {
        return number;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public boolean hasDriver() {
        if(driver != null) {
            return true;
        }
        return false;
    }
}
