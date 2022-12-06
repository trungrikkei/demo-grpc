package com.rikkeisoft.grpc_marketplace.service;

import com.rikkeisoft.user.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class UserServiceClient {
    @GrpcClient("grpc-devproblems-service")
    UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    @GrpcClient("grpc-devproblems-service")
    UserServiceGrpc.UserServiceStub userServiceStub;

    public String getUsername(Long userId) {
        UserDetailRequest request = UserDetailRequest.newBuilder()
                .setUserId(userId)
                .build();

        UserInfo userInfo = userServiceBlockingStub.getDetailUser(request);
        return userInfo.getUsername();
    }

    public boolean upDateUser() {
        UserInfo userInfo = UserInfo.newBuilder()
                .setUserId(1)
                .setName("trung")
                .setEmail("trungth@rikkeisoft.com")
                .setPhone("0987655331")
                .build();
        try {
            UpdateUserOutput response = userServiceBlockingStub.updateUserInfo(userInfo);
            return response.getStatus().equals(Status.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
