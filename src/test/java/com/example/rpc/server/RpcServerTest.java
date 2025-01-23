package com.example.rpc.server;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.rpc.Request;
import com.example.rpc.Response;

import io.grpc.stub.StreamObserver;

public class RpcServerTest {

    @Test
    public void testRpcService() {
        // Mock a request
        Request request = Request.newBuilder().setMessage("Test Message").build();

        // Create a response observer
        StreamObserver<Response> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(Response response) {
                // Validate the server's response
                assertEquals("Hello from Server: Test Message", response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                fail("RPC failed: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                // Test complete
            }
        };

        // Call the service implementation
        RpcServiceImpl service = new RpcServiceImpl();
        service.sendRequest(request, responseObserver);

        // Add some waiting time to let the server process the request (if necessary)
        try {
            Thread.sleep(1000); // Give server time to respond
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
