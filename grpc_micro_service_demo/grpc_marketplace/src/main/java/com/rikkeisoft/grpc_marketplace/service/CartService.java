package com.rikkeisoft.grpc_marketplace.service;

import com.rikkeisoft.grpc_marketplace.repository.CartRepository;
import com.rikkeisoft.grpc_marketplace.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartService {
    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;


}
