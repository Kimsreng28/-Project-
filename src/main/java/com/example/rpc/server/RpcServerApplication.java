package main.java.com.example.rpc.server;

import java.io.IOException;

import org.springframework.boot.SpringApplication;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class RpcServerApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(RpcServerApplication.class, args);
        Server server = ServerBuilder.forPort(9090).addService(new RpcServiceImpl()).build();
        System.out.println("gRPC Server started on port 9090");
        server.start();
        server.awaitTermination();
    }
}
