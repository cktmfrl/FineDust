package com.example.finedust.model;

import com.example.finedust.model.dust_material.Body;
import com.example.finedust.model.dust_material.Header;

public class Response {

    @Override
    public String toString() {
        return "Response{" +
                "body=" + body +
                ", header=" + header +
                '}';
    }

    @com.squareup.moshi.Json(name = "body")
    private Body body;
    @com.squareup.moshi.Json(name = "header")
    private Header header;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

}