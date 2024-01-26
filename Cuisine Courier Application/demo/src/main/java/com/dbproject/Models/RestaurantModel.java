package com.dbproject.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.annotation.Documented;

@Entity
@Table(name="restaurants",schema="public")
@Data
@NoArgsConstructor

public class RestaurantModel {
    //data models handled by db
    @Id //look into auto generation
    @Column(name="rid",unique = true)
    private Integer id;

    @Column(name="rname",unique = true)
    private String name;

    @Column(name="rcity")
    private String city;

    @Column(name="rtype")
    private String type;

    @Column(name="rspeciality")
    private String speciality;




}
