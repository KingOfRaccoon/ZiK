package com.kingofraccoon.zik.request;

import java.util.Date;

import com.kingofraccoon.zik.place.Place;
import com.kingofraccoon.zik.transport.NoDriverException;
import com.kingofraccoon.zik.transport.Transport;
import com.kingofraccoon.zik.users.User;

import org.jetbrains.annotations.NotNull;

public class Request {
    private CargoStatus status;
    private int serviceCode;
    private String cargoInfo;

    final private Place placeOfDeparture;
    final private Place placeOfReceipt;

    private User initiator;
    private User creator;
    User cargoSender;
    User cargoRecipient;
    Transport transport;

    private Date createTime;
    private Date arriveTime;

    private String reasonOfCanceling;
    private String commentOnCanceling;
    private String subdivision;

    public Request(Place placeOfDeparture, Place placeOfReceipt, int serviceCode,
                   User initiator, User creator, User cargoSender, User cargoRecipient) {
        this.serviceCode = serviceCode;
        this.cargoInfo = "";

        this.placeOfDeparture = placeOfDeparture;
        this.placeOfReceipt = placeOfReceipt;

        this.initiator = initiator;
        this.creator = creator;
        this.cargoSender = cargoSender;
        this.cargoRecipient = cargoRecipient;

        createTime = new Date();

        status = CargoStatus.CREATED;
    }
    public Request(Place placeOfDeparture, Place placeOfReception, int serviceCode,
                   User initiator, User creator, User cargoSender,
                   User cargoRecipient, String cargoInfo) {
        this(placeOfDeparture, placeOfReception, serviceCode, initiator,
                creator, cargoSender, cargoRecipient);
        this.cargoInfo = cargoInfo;
    }

    public Request(Place placeOfDeparture, Place placeOfReception, int serviceCode, User creator,
                   User cargoSender, User cargoRecipient) {
        this(placeOfDeparture, placeOfReception, serviceCode,
                creator, creator, cargoSender, cargoRecipient);
    }

    public Request(Place placeOfDeparture, Place placeOfReception, int serviceCode,
                   User creator, User cargoSender, User cargoRecipient, String cargoInfo) {
        this(placeOfDeparture, placeOfReception, serviceCode,
                creator, cargoSender, cargoRecipient);
        this.cargoInfo = cargoInfo;
    }
    public Request(Place placeSend, Place placeGet){
        this.placeOfDeparture = placeSend;
        this.placeOfReceipt = placeGet;

        status = CargoStatus.CREATED;
    }

    //Сеттеры лучше не использовать, т.к. статус отправки не учитывается

    public long getNumber() {
        return createTime.getTime();
    }

    public void setServiceCode(int serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getCargoInfo() {
        return cargoInfo;
    }

    public void setCargoInfo(String cargoInfo) {
        this.cargoInfo = cargoInfo;
    }

    public int getServiceCode() {
        return serviceCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public Place getPlaceOfDeparture() {
        return placeOfDeparture;
    }

    public Place getPlaceOfReceipt() {
        return placeOfReceipt;
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

    public Transport getTransport() {
        return transport;
    }

    public String getReasonOfCanceling() {
        return reasonOfCanceling;
    }

    public String getCommentOnCanceling() {
        return commentOnCanceling;
    }


    public void approve(Transport transport, @NotNull Date arriveTime) throws NoDriverException {
        /*Нужно либо здесь сделать проверку на наличие водителя, либо выше.
        Сейчас пока что здесь, должен быть водитель, иначе будет вызываться NoDriverException
         */
        if(!transport.hasDriver()){
            throw new NoDriverException("Нет водителя в машине, заявка не может быть обработана");
        }
        this.transport = transport;
        status = CargoStatus.ACCEPTED;
        if (createTime.equals(arriveTime)) {
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
        commentOnCanceling = comment;
    }

    public void done() {
        status = CargoStatus.FINISHED;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }
}
