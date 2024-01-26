package com.dbproject.repository;

import com.dbproject.Models.Credentials;
import com.dbproject.Models.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantModel,Integer> {
    List<RestaurantModel> findAll();
}
