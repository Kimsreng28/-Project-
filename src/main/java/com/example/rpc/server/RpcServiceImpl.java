package main.java.com.example.rpc.server;

import com.example.rpc.Request;
import com.example.rpc.Response;
import com.example.rpc.RpcServiceGrpc;

import io.grpc.stub.StreamObserver;

public class RpcServiceImpl extends RpcServiceGrpc.RpcServiceImplBase {
    @Override
    public void sendRequest(Request request, StreamObserver<Response> responseObserver) {
        System.out.println("Received request: " + request.getMessage());
        Response response = Response.newBuilder().setMessage("Hello from Server: " + request.getMessage()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
