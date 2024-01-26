package com.dbproject.services;

import com.dbproject.Models.RestaurantModel;
import com.dbproject.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<RestaurantModel> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
