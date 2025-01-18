package com.example.rpc.server;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootApplication
public class RpcServerApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(RpcServerApplication.class, args);

        // Manually start the gRPC server
        Server grpcServer = ServerBuilder.forPort(9090)
                .addService(new RpcServiceImpl())
                .build();

        System.out.println("gRPC Server started on port 9090");

        grpcServer.start();
        grpcServer.awaitTermination();
    }
}
