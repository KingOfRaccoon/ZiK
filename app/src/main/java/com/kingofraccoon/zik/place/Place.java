package com.kingofraccoon.zik.place;

public class Place {
    private String PRP;
    private String gates;
    private String building;
    public Place(String PRP, String gates, String building) {
        this.PRP = PRP;
        this.gates = gates;
        this.building = building;
    }

    public void setPRP(String PRP) {
        this.PRP = PRP;
    }

    public String getPRP() {
        return PRP;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getBuilding() {
        return building;
    }

    public String getGates() {
        return gates;
    }

    public void setGates(String gates) {
        this.gates = gates;
    }
}
