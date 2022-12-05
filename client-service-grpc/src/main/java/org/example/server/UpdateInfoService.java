package org.example.server;

import com.sun.xml.internal.ws.util.StringUtils;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.example.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class UpdateInfoService {
    private static final Logger logger = Logger.getLogger(UpdateInfoService.class.getName());
    private Server server;
    private void start() throws IOException {
        int port = 50051;
        server = ServerBuilder.forPort(port).addService(new UpdateInfoServiceImpl()).build().start();

        logger.info("Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("Shutting down gRPC server");
                try {
                    server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    static class UpdateInfoServiceImpl extends UpdateInfoServiceGrpc.UpdateInfoServiceImplBase {
        public void update (UpdateInfoRequest req, StreamObserver<UpdateInfoResponse> responseObserver) {
            logger.info("Got request from client: " + req);
            if (req.getUserId() <= 0 ||
                    req.getFirstName() == null || "".equals(req.getFirstName()) ||
                    req.getEmail() == null || "".equals(req.getEmail()) ) {
                logger.info("Update failed");
                responseObserver.onError(io.grpc.Status.INTERNAL.withDescription("invalid input: all field are required not null").asException());
            }
            UpdateInfoResponse reply = UpdateInfoResponse.newBuilder()
                    .setUserId(req.getUserId())
                    .setIsSuccess(Status.SUCCESS)
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        final UpdateInfoService greetServer = new UpdateInfoService();
        greetServer.start();
        greetServer.server.awaitTermination();
    }
}
