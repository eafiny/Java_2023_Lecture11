package ru.muctr.PRELibrary.errorHandling;

import lombok.Data;

import java.util.*;

@Data
public class ServerError {
    private int status;
    private List<String> messages;
    private Date timestamp;

    public ServerError(int status, String... messages) {
        this.status = status;
        this.messages = new ArrayList<>(Arrays.asList(messages));
        this.timestamp = new Date();
    }

    public ServerError(int status, Collection<String> messages) {
        this.status = status;
        this.messages = new ArrayList<>(messages);
        this.timestamp = new Date();
    }
}