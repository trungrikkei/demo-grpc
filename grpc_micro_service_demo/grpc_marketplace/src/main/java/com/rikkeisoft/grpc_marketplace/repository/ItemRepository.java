package com.rikkeisoft.grpc_marketplace.repository;

import com.rikkeisoft.grpc_marketplace.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
