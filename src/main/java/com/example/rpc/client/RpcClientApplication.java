package com.example.rpc.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.rpc.Request;
import com.example.rpc.Response;
import com.example.rpc.RpcServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@SpringBootApplication
public class RpcClientApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(RpcClientApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Establish the gRPC channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

        // Create the blocking stub (synchronous)
        RpcServiceGrpc.RpcServiceBlockingStub stub = RpcServiceGrpc.newBlockingStub(channel);

        // Create a request
        Request request = Request.newBuilder().setMessage("Hello From Client!").build();

        // Send the request and get the response
        Response response = stub.sendRequest(request);

        // Print the response
        System.out.println("Response from server: " + response.getMessage());

        // Shutdown the channel
        channel.shutdown();
    }
}