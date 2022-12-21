package com.team6.hanghaesisters.entity;

import lombok.Getter;

@Getter
public enum UserRole {
    USER(Authority.USER);  // 사용자 권한

    private final String authority;

    UserRole(String authority) {
        this.authority = authority;
    }

    public static class Authority {
        public static final String USER = "ROLE_USER";
    }
}