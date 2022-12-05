package org.example.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.example.ClientInput;
import org.example.HelloServiceGrpc;
import org.example.ServiceOutput;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class GreetServer {
    private static final Logger logger = Logger.getLogger(GreetServer.class.getName());
    private Server server;
    private void start() throws IOException {
        int port = 50051;
        server = ServerBuilder.forPort(port).addService(new GreeterImpl()).build().start();

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
    static class GreeterImpl extends HelloServiceGrpc.HelloServiceImplBase {
        public void hello(ClientInput req, StreamObserver<ServiceOutput> responseObserver) {
            logger.info("Got request from client: " + req);
            ServiceOutput reply = ServiceOutput.newBuilder().setMessage(
                    "Server says " + "\"" + req.getGreeting() + " " + req.getName() + "\""
            ).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        final GreetServer greetServer = new GreetServer();
        greetServer.start();
        greetServer.server.awaitTermination();
    }
}
