package com.example.finedust.model;

public class FineDust {
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "CurrentDust{" +
                "response=" + response +
                '}';
    }
}