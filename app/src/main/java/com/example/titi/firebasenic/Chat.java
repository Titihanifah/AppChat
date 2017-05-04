package com.example.titi.firebasenic;

/**
 * Created by titih on 04/05/2017.
 */

public class Chat {

    String message;
    String name;

    public Chat() {

    }

    public Chat(String message, String name) {
        this.message = message;
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setText(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }
}
