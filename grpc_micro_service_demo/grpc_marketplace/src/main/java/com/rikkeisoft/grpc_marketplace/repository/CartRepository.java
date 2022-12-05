package com.rikkeisoft.grpc_marketplace.repository;

import com.rikkeisoft.grpc_marketplace.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByItemIdAndUserId(Long itemId, Long userId);
}
