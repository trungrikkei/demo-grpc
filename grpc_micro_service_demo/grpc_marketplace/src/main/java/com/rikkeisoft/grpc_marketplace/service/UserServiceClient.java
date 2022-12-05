package com.rikkeisoft.grpc_marketplace.service;

import com.rikkeisoft.user.*;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class UserServiceClient {
    @GrpcClient("UserService")
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    public String getUsername(Long userId) {
        UserDetailRequest request = UserDetailRequest.newBuilder()
                .setUserId(userId)
                .build();
        try {
            UserInfo userInfo = userServiceBlockingStub.getDetailUser(request);
            return userInfo.getUsername();
        } catch (Exception e) {
            return null;
        }
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
