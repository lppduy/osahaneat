package com.lppduy.osahaneat.service;

import com.lppduy.osahaneat.payload.request.OrderRequest;

public interface OrderService {
    boolean insertOrder(OrderRequest orderRequest);
}
