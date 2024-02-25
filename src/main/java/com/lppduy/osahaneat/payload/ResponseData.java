package com.lppduy.osahaneat.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData {
    private int status = 200;
    private String desc;
    private Object data;
}
