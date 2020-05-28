package com.bit.security.domain;

import lombok.Data;

@Data
public class Auth {

    private int authCode;
    private String roleType;

    @Override
    public String toString() {
        return "Auth [authCode=" + authCode + ", roleType=" + roleType + "]";
    }

}