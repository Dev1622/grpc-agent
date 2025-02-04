package com.project.grpc;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: agent.proto")
public class AgentServiceBean extends MutinyAgentServiceGrpc.AgentServiceImplBase implements BindableService, MutinyBean {

    private final AgentService delegate;

    AgentServiceBean(@GrpcService AgentService delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.Agent> getAgentById(com.project.grpc.AgentProto.AgentRequest request) {
        try {
            return delegate.getAgentById(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> createAgent(com.project.grpc.AgentProto.Agent request) {
        try {
            return delegate.createAgent(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> deleteAgent(com.project.grpc.AgentProto.AgentRequest request) {
        try {
            return delegate.deleteAgent(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> updateAgent(com.project.grpc.AgentProto.Agent request) {
        try {
            return delegate.updateAgent(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Multi<com.project.grpc.AgentProto.Agent> getAllAgents(com.google.protobuf.Empty request) {
        try {
            return delegate.getAllAgents(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
