package org.afrivera.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorDetail {

    private Date date_time;
    private String message;
    private int code;
    private Object data;

    public ErrorDetail(String message, int code, Object data) {
        this.date_time = new Date();
        this.message = message;
        this.code = code;
        this.data = data;
    }
}
