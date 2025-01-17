package main.java.com.example.rpc.client;

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
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        RpcServiceGrpc.RpcServiceBlockingStub stub = RpcServiceGrpc.newBlockingStub(channel);
        Request request = Request.newBuilder().setMessage("Hello Server!").build();
        Response response = stub.sendRequest(request);
        System.out.println("Response from server: " + response.getMessage());
        channel.shutdown();
    }
}