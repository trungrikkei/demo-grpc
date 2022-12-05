package org.example.client;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.example.ClientInput;
import org.example.HelloServiceGrpc;
import org.example.ServiceOutput;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GreetClient {
    private static final Logger logger = Logger.getLogger(GreetClient.class.getName());
    private final HelloServiceGrpc.HelloServiceBlockingStub blockingStub;

    public GreetClient(Channel channel) {
        blockingStub = HelloServiceGrpc.newBlockingStub(channel);
    }
    public void makeGreeting(String greeting, String username) {
        logger.info("Sending greeting to server: " + greeting + " for name: " + username);
        ClientInput request = ClientInput.newBuilder().setName(username).setGreeting(greeting).build();
        logger.info("Sending to server: " + request);
        ServiceOutput response;
        try {
            response = blockingStub.hello(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Got following from the server: " + response.getMessage());
    }

    public static void main(String[] args) throws Exception {
        String greeting = "rikkei";
        String username = "trung";
        String serverAddress = "localhost:50051";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(serverAddress)
                .usePlaintext()
                .build();
        try {
            GreetClient client = new GreetClient(channel);
            client.makeGreeting(greeting, username);
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
