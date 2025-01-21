
package com.project.interceptor;

import io.grpc.*;
import io.quarkus.grpc.GlobalInterceptor;
import jakarta.inject.Singleton;

@Singleton
@GlobalInterceptor
public class AuthInterceptor implements ServerInterceptor{
    private static final Metadata.Key<String> AUTHORIZATION_KEY =
            Metadata.Key.of("Authorization",Metadata.ASCII_STRING_MARSHALLER);
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {

        String authHeader = headers.get(AUTHORIZATION_KEY);

        if(authHeader == null || !authHeader.equals(USERNAME + ":" + PASSWORD)){
            call.close(Status.UNAUTHENTICATED.withDescription("Invalid credentials"), headers);
            return new ServerCall.Listener<ReqT>() {};
        }
        return next.startCall(call,headers);
    }

}