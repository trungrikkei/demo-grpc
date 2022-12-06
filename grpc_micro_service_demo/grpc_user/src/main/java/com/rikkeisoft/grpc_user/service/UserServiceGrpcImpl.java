package com.rikkeisoft.grpc_user.service;

import com.rikkeisoft.grpc_user.entity.User;
import com.rikkeisoft.grpc_user.repository.UserRepository;
import com.rikkeisoft.user.*;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

@AllArgsConstructor
@NoArgsConstructor
@GrpcService
public class UserServiceGrpcImpl extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = Logger.getLogger(UserServiceGrpcImpl.class.getName());
    public void updateUserInfo (UserInfo req, StreamObserver<UpdateUserOutput> responseObserver) {
        logger.info("Got request from client: " + req);
        if (req.getUserId() <= 0
                || "".equals(req.getName())
                || "".equals(req.getEmail())
                || "".equals(req.getPhone())) {
            logger.info("Update failed");
            responseObserver.onError(io.grpc.Status.DATA_LOSS.withDescription("invalid input: all field are required not null").asException());
        }

        User user = userRepository.findById(req.getUserId()).orElse(null);
        if (user == null) {
            logger.info("user not exist");
            responseObserver.onError(io.grpc.Status.NOT_FOUND.withDescription("User not exist").asException());
        } else {
            user.setName(req.getName());
            user.setPhone(req.getPhone());
            user.setEmail(req.getEmail());
            userRepository.save(user);

            UpdateUserOutput reply = UpdateUserOutput.newBuilder()
                    .setUserId(req.getUserId())
                    .setStatus(Status.SUCCESS)
                    .setMessage("Update success")
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

    public void getDetailUser(UserDetailRequest req, StreamObserver<UserInfo> responseObserver) {
        logger.info("Got request from client: " + req);
        if (req.getUserId() <= 0) {
            logger.info("Update failed");
            responseObserver.onError(io.grpc.Status.DATA_LOSS.withDescription("invalid input: all field are required not null").asException());
        }

        User user = userRepository.findById(req.getUserId()).orElse(null);
        if (user == null) {
            logger.info("user not exist");
            responseObserver.onError(io.grpc.Status.NOT_FOUND.withDescription("User not exist").asException());
        } else {
            UserInfo reply = UserInfo.newBuilder()
                    .setUserId(user.getId())
                    .setEmail(user.getEmail())
                    .setName(user.getName())
                    .setUsername(user.getUsername())
                    .setPhone(user.getPhone())
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
