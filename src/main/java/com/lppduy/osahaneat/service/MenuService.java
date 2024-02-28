package com.lppduy.osahaneat.service;

import org.springframework.web.multipart.MultipartFile;

public interface MenuService {
    boolean createMenu(
            MultipartFile file,
            String title,
            boolean isFreeship,
            String timeShip,
            double price,
            int cateId
    );
}
