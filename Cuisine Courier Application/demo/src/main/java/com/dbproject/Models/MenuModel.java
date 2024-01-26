package com.dbproject.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.annotation.Documented;

@Entity
@Table(name="menu",schema="public")
@Data
@NoArgsConstructor

public class MenuModel {
    //data models handled by db
    @Id //look into auto generation
    @Column(name="itemid",unique = true)
    private Integer itemid;

    @Column(name="itemname")
    private String itemname;

    @Column(name="itemseller")
    private String itemseller;

    @Column(name="iteminfo")
    private String iteminfo;

    @Column(name="itemtype")
    private String itemtype;

    @Column(name="itemprice")
    private Double itemprice;



}
