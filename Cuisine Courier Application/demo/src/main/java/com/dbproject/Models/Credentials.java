package com.dbproject.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.annotation.Documented;

@Entity
@Table(name="credentials",schema="public")
@Data
@NoArgsConstructor

public class Credentials {
    //data models handled by db
    @Id //look into auto generation
    @Column(name="username",unique = true)
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email",unique = true)
    private String email;



}
