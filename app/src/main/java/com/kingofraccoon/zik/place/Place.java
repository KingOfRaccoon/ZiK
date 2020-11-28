package com.kingofraccoon.zik.place;

public class Place {
    private byte PRP;
    private int gates;
    private int building;
    public Place(byte PRP, int gates, int building) {
        this.PRP = PRP;
        this.gates = gates;
        this.building = building;
    }

    public void setPRP(byte PRP) {
        this.PRP = PRP;
    }

    public byte getPRP() {
        return PRP;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public int getBuilding() {
        return building;
    }

    public int getGates() {
        return gates;
    }

    public void setGates(int gates) {
        this.gates = gates;
    }
}
