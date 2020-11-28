package com.kingofraccoon.zik.request;

import java.util.Date;

import com.kingofraccoon.zik.users.User;

import org.jetbrains.annotations.NotNull;

public class Request {
    private CargoStatus status;

    final private byte departurePoint;
    final private byte receptionPoint;

    final private User initiator;
    final private User creator;
    final User cargoSender;
    final User cargoRecipient;
    User driver;

    final private Date createTime;
    private Date arriveTime;

    private String reasonOfCanceling;
    private String commentOfCanceling;

    public Request(User initiator, User creator, User cargoSender, User cargoRecipient, byte departurePoint, byte receptionPoint) {
        this.departurePoint = departurePoint;
        this.receptionPoint = receptionPoint;

        this.initiator = initiator;
        this.creator = creator;
        this.cargoSender = cargoSender;
        this.cargoRecipient = cargoRecipient;

        createTime = new Date();

        status = CargoStatus.CREATED;
    }

    //Сеттеры лучше не использовать, т.к. статус отправки не учитывается

    public long getNumber() {
        return createTime.getTime();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public byte getDeparturePoint() {
        return departurePoint;
    }

    public byte getReceptionPoint() {
        return receptionPoint;
    }

    public CargoStatus getStatus() {
        return status;
    }

    public User getInitiator() {
        return initiator;
    }

    public User getCreator() {
        return creator;
    }

    public User getCargoSender() {
        return cargoSender;
    }

    public User getCargoRecipient() {
        return cargoRecipient;
    }

    public User getDriver() {
        return driver;
    }

    public void approve(User driver, @NotNull Date arriveTime) {
        this.driver = driver;
        status = CargoStatus.ACCEPTED;
        if (arriveTime.equals(createTime)) {
            this.arriveTime = new Date(createTime.getTime() + 600000);
        } else {
            this.arriveTime = arriveTime;
        }
    }

    public void accept() {
        status = CargoStatus.EXECUTING;
    }

    public void cancel(String reason, String comment) {
        status = CargoStatus.CANCELED;
        reasonOfCanceling = reason;
        commentOfCanceling = comment;
    }

    public void done() {
        status = CargoStatus.FINISHED;
    }
}
