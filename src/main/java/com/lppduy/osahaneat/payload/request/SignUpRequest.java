package com.lppduy.osahaneat.payload.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpRequest {

    private String fullname;
    private String email;
    private String password;
    private int roleId;
}
