package com.example.rpc.server;

import org.springframework.stereotype.Service;

import com.example.rpc.Request;
import com.example.rpc.Response;
import com.example.rpc.RpcServiceGrpc;

import io.grpc.stub.StreamObserver;

@Service
public class RpcServiceImpl extends RpcServiceGrpc.RpcServiceImplBase {
    @Override
    public void sendRequest(Request request, StreamObserver<Response> responseObserver) {
        String clientMessage = request.getMessage();
        String serverMessage = "Hello: " + clientMessage + "" + " from Server.";

        // Construct the response message
        Response response = Response.newBuilder().setMessage(serverMessage).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
