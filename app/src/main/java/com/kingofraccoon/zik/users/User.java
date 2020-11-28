package com.kingofraccoon.zik.users;

public interface User {
    /**
     *
     * @return Возвращает имя пользователя
     */
    String getName();

    /**
     *
     * @return Возвращает номер подразделения пользователя
     */
    int getSubunit();

    /**
     *
     * @return Возвращает номер телефона пользвателя
     */
    String getPhone();
}
