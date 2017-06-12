package com.example.sean.showpiecephotos.singletons;


public class TokenSingleton {
    private static final TokenSingleton ourInstance = new TokenSingleton();

    private String ACCESS_TOKEN;

    public static TokenSingleton getInstance() {
        return ourInstance;
    }

    public String getAccessToken() {
        return ACCESS_TOKEN;
    }

    public void setAccessToken(String token) {
        this.ACCESS_TOKEN = token;
    }

    private TokenSingleton() {
    }
}
