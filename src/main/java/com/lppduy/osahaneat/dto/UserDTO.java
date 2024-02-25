package com.lppduy.osahaneat.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String username;
    private String passwod;
    private String fullname;
    private String createDate;
}
