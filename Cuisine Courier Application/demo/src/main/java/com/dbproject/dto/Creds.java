package com.dbproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Creds{
    private String email;
    private String username;
    private String password;

}
