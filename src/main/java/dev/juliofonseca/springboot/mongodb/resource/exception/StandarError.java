package dev.juliofonseca.springboot.mongodb.resource.exception;

import java.io.Serializable;

public class StandarError implements Serializable {

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandarError(Long timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
