package com.dbproject.services;

import com.dbproject.Models.MenuModel;
import com.dbproject.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<MenuModel> getMenuItemsByType(String itemType) {
        log.info("getting item type {}",itemType);//increase code maintainability n debugging
        return menuRepository.findByItemtype(itemType);
    }

    public MenuModel getMenuItemById(Integer itemId) {
        Optional<MenuModel> optionalMenuItem = menuRepository.findById(itemId);
        return optionalMenuItem.orElse(null);
    }
}
