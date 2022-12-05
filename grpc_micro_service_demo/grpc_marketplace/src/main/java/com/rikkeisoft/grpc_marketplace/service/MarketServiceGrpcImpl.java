package com.rikkeisoft.grpc_marketplace.service;

import com.rikkeisoft.grpc_marketplace.entity.Cart;
import com.rikkeisoft.grpc_marketplace.entity.Item;
import com.rikkeisoft.grpc_marketplace.repository.CartRepository;
import com.rikkeisoft.grpc_marketplace.repository.ItemRepository;
import com.rikkeisoft.marketplace.*;
import com.rikkeisoft.user.UpdateUserOutput;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MarketServiceGrpcImpl extends MarketplaceServiceGrpc.MarketplaceServiceImplBase {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CartRepository cartRepository;
    private static final Logger logger = Logger.getLogger(MarketServiceGrpcImpl.class.getName());
    public void updateItemInfo(ItemInfo req, StreamObserver<UpdateItemOutput> responseObserver) {
        logger.info("Got request from client: " + req);
        if (req.getItemId() <= 0
                || "".equals(req.getItemName())
                || "".equals(req.getItemCost())
                || "".equals(req.getDescription())) {
            logger.info("Update failed");
            responseObserver.onError(io.grpc.Status.DATA_LOSS.withDescription("invalid input: all field are required not null").asException());
        }

        Item item = itemRepository.findById(req.getItemId()).orElse(null);
        if (item == null) {
            logger.info("user not exist");
            responseObserver.onError(io.grpc.Status.NOT_FOUND.withDescription("Item not exist").asException());
        } else {
            item.setItemName(req.getItemName());
            item.setItemCost(req.getItemCost());
            item.setDescription(item.getDescription());
            itemRepository.save(item);

            UpdateItemOutput reply = UpdateItemOutput.newBuilder()
                    .setItemId(req.getItemId())
                    .setStatus(Status.SUCCESS)
                    .setMessage("Update success")
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

    public void getDetailItem(ItemDetailRequest req, StreamObserver<ItemInfo> responseObserver) {
        logger.info("Got request from client: " + req);
        if (req.getItemId() <= 0) {
            logger.info("Update failed");
            responseObserver.onError(io.grpc.Status.DATA_LOSS.withDescription("invalid input: all field are required not null").asException());
        }

        Item item = itemRepository.findById(req.getItemId()).orElse(null);
        if (item == null) {
            logger.info("user not exist");
            responseObserver.onError(io.grpc.Status.NOT_FOUND.withDescription("Item not exist").asException());
        } else {

            ItemInfo reply = ItemInfo.newBuilder()
                    .setItemId(item.getId())
                    .setItemName(item.getItemName())
                    .setItemCost(item.getItemCost())
                    .setDescription(item.getDescription())
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

    public void updateInfoCart(CartInfo req, StreamObserver<UpdateCartInfoOutput> responseObserver) {
        logger.info("Got request from client: " + req);
        if (req.getItemId() <= 0
                || req.getQuantity() < 0
                || req.getUserId() <= 0
                || "".equals(req.getUsername())) {
            logger.info("Update failed");
            responseObserver.onError(io.grpc.Status.DATA_LOSS.withDescription("invalid input: all field are required not null").asException());
        }

        Cart cart = cartRepository.findByItemIdAndUserId(req.getItemId(), req.getUserId());
        if (cart == null) {
            logger.info("cart not exist");
            responseObserver.onError(io.grpc.Status.NOT_FOUND.withDescription("cart not exist").asException());
        } else {
            if (req.getQuantity() == 0) {
                cartRepository.delete(cart);
            } else {
                cart.setQuantity(req.getQuantity());
            }

            UpdateCartInfoOutput reply = UpdateCartInfoOutput.newBuilder()
                    .setUserId(req.getUserId())
                    .setStatus(Status.SUCCESS)
                    .setMessage("Update success")
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
