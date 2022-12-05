package org.example.client;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.example.*;
import org.example.server.UpdateInfoService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateInfoClient {
    private static final Logger logger = Logger.getLogger(UpdateInfoClient.class.getName());
    private final UpdateInfoServiceGrpc.UpdateInfoServiceBlockingStub blockingStub;

    public UpdateInfoClient(Channel channel) {
        blockingStub = UpdateInfoServiceGrpc.newBlockingStub(channel);
    }
    public void updateInfo(UpdateInfoRequest request) {
        logger.info("Sending greeting to server: ");
        logger.info("Sending to server: " + request);
        UpdateInfoResponse response;
        try {
            response = blockingStub.update(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Got following from the server: ");
        logger.info("userId:" + response.getUserId() +"\n" + "status:" + response.getIsSuccess());
    }

    public static void main(String[] args) throws Exception {
//        UpdateInfoRequest.Address address1 = UpdateInfoRequest.Address.newBuilder().setStreet("Phạm Hùng").setCity("Hà Nội").build();
//        UpdateInfoRequest.Address address2 = UpdateInfoRequest.Address.newBuilder().setStreet("Mễ Trì").setCity("Hà Nội").build();
        UpdateInfoRequest request = UpdateInfoRequest.newBuilder()
                .setUserId(1)
                .setFirstName("Trung Rikkeisoft")
                .setEmail("trungth@rikkeisoft.com")
                .setPhone("0123456789")
//                .setAddress(0, address1)
//                .setAddress(1, address2)
                .build();
        String serverAddress = "localhost:50051";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(serverAddress)
                .usePlaintext()
                .build();
        try {
            UpdateInfoClient client = new UpdateInfoClient(channel);
            client.updateInfo(request);
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
