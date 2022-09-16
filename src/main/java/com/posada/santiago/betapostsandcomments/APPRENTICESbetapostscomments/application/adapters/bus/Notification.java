package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.application.adapters.bus;

import com.google.gson.Gson;
import lombok.Setter;

import java.time.Instant;
@Setter
public class Notification {
    private  String type;
    private  String body;
    private Instant instant;

    public Notification(String type, String body) {
        this.type = type;
        this.body = body;
        this.instant = Instant.now();
    }
    private Notification(){
        this(null,null);
    }

    public String getType() {
        return type;
    }

    public String getBody() {
        return body;
    }

    public Instant getInstant() {
        return instant;
    }

    public Notification deserialize(String aSerialization) {
        return  new Gson().fromJson(aSerialization, Notification.class);
    }

    public String serialize() {
        return new Gson().toJson(this);
    }

    public static Notification from(String aNotification){
        return new Notification().deserialize(aNotification);
    }
}
