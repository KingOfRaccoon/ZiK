package com.kingofraccoon.zik.users;

public class User {
    private String name;
    private int subunitNum;
    private String phone;
    private UserAccessLevel userAccessLevel;

    User(String name, int subunitNum, String phone, UserAccessLevel userAccessLevel) {
        this.name = name;
        this.subunitNum = subunitNum;
        this.phone = phone;
        this.userAccessLevel = userAccessLevel;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * @return Возвращает имя пользователя
     */
    public String getName(){
        return name;
    }

    public void setSubunitNum(int subunitNum) {
        this.subunitNum = subunitNum;
    }
    /**
     *
     * @return Возвращает номер подразделения пользователя
     */
    public int getSubunit() {
        return subunitNum;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     *
     * @return Возвращает номер телефона пользвателя
     */
    public String getPhone() {
        return phone;
    }

    public void setUserAccessLevel(UserAccessLevel userAccessLevel) {
        this.userAccessLevel = userAccessLevel;
    }
    public UserAccessLevel getUserAccessLevel() {
        return userAccessLevel;
    }
}
