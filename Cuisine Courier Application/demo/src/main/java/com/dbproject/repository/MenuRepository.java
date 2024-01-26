package com.dbproject.repository;

//import com.dbproject.Models.Credentials;
//import com.dbproject.Models.RestaurantModel;
import com.dbproject.Models.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuRepository extends JpaRepository<MenuModel,Integer> {

    List<MenuModel> findByItemtype(String type);}
