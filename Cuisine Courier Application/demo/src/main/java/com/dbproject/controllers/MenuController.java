package com.dbproject.controllers;

import com.dbproject.Models.CartItem;

import com.dbproject.Models.MenuModel;

import com.dbproject.services.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Controller

public class MenuController {

    private final MenuService menuService;



    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    @GetMapping("/menu")
    public String showMenu(@RequestParam String foodType, Model model) {
        try {
            List<MenuModel> menuItems = menuService.getMenuItemsByType(foodType);
            model.addAttribute("menuItems", menuItems);
            model.addAttribute("foodType", foodType);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "menu";
    }



    private List<CartItem> cartItems = new ArrayList<>();


    @PostMapping("/addToCart")
    public String addToCart(@RequestParam String itemName, @RequestParam Double itemPrice) {
        try {
            CartItem cartItem = new CartItem();
            cartItem.setItemName(itemName);
            cartItem.setItemPrice(itemPrice);
            cartItems.add(cartItem);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        try {
            model.addAttribute("cartItems", cartItems);
            Double totalPrice = cartItems.stream().mapToDouble(CartItem::getItemPrice).sum();
            model.addAttribute("totalPrice", totalPrice);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "cart";
    }


    @PostMapping("/removeItem")
    public ResponseEntity<String> removeItem(@RequestParam int index) {
        try {
            if (index >= 0 && index < cartItems.size()) {
                // Remove the item from the cart
                cartItems.remove(index);
                return ResponseEntity.ok("Item removed successfully");
            } else {
                // Invalid index
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid index");
            }
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error removing item");
        }
    }



    @PostMapping("/clearCart")
    public String clearCart() {
        try {
            cartItems.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/dashboard";
    }


//    @PostMapping("/cart")

//    public ResponseEntity<String> removeItem(@RequestParam int index) {
//        try {
//            if (index >= 0 && index < cartItems.size()) {
//                cartItems.remove(index);
//                return ResponseEntity.ok("Item removed successfully");
//            } else {
//                return ResponseEntity.status(HttpStatus.OK).body("Invalid index");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error removing item");
//        }
    // The 'index' parameter is expected to be part of the request payload
//
//    public String removeItem(@RequestParam("index") int index) {
//        try {
//            // Call the cart service to remove the item
//           cartItems.remove(index);
//            return "Item removed from the cart successfully";
//        } catch (Exception e) {
//            return "Error removing item from cart: " + e.getMessage();
//        }
    }




