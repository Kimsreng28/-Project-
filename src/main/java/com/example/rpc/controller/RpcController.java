package com.example.rpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rpc.Request;
import com.example.rpc.Response;
import com.example.rpc.RpcServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Controller
public class RpcController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/send-request")
    public String sendRequest(@RequestParam String message, Model model) {
        System.out.println("Received message: " + message);

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        RpcServiceGrpc.RpcServiceBlockingStub stub = RpcServiceGrpc.newBlockingStub(channel);
        Request request = Request.newBuilder().setMessage(message).build();
        Response response = stub.sendRequest(request);

        model.addAttribute("response", response.getMessage());

        return "response";
    }

}
