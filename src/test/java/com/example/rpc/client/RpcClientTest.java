package com.example.rpc.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.rpc.Request;
import com.example.rpc.Response;
import com.example.rpc.RpcServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

@SpringBootTest
public class RpcClientTest {

    private static Server server;

    @BeforeAll
    public static void startServer() throws Exception {
        // Start the gRPC server
        server = ServerBuilder.forPort(9090)
                .addService(new com.example.rpc.server.RpcServiceImpl())
                .build()
                .start();
        System.out.println("Test gRPC server started on port 9090");
    }

    @Test
    public void testRpcCommunication() {
        // Create the gRPC client channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        RpcServiceGrpc.RpcServiceBlockingStub stub = RpcServiceGrpc.newBlockingStub(channel);

        // Create and send the request
        Request request = Request.newBuilder().setMessage("Hello Server!").build();
        Response response = stub.sendRequest(request);

        // Validate the response
        assertEquals("Hello from Server: Hello Server!", response.getMessage());

        channel.shutdown();
    }
}
