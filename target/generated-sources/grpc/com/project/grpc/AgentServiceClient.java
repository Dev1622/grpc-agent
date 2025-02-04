package com.project.grpc;

import java.util.function.BiFunction;
import io.quarkus.grpc.MutinyClient;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: agent.proto")
public class AgentServiceClient implements AgentService, MutinyClient<MutinyAgentServiceGrpc.MutinyAgentServiceStub> {

    private final MutinyAgentServiceGrpc.MutinyAgentServiceStub stub;

    public AgentServiceClient(String name, io.grpc.Channel channel, BiFunction<String, MutinyAgentServiceGrpc.MutinyAgentServiceStub, MutinyAgentServiceGrpc.MutinyAgentServiceStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinyAgentServiceGrpc.newMutinyStub(channel));
    }

    private AgentServiceClient(MutinyAgentServiceGrpc.MutinyAgentServiceStub stub) {
        this.stub = stub;
    }

    public AgentServiceClient newInstanceWithStub(MutinyAgentServiceGrpc.MutinyAgentServiceStub stub) {
        return new AgentServiceClient(stub);
    }

    @Override
    public MutinyAgentServiceGrpc.MutinyAgentServiceStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.Agent> getAgentById(com.project.grpc.AgentProto.AgentRequest request) {
        return stub.getAgentById(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> createAgent(com.project.grpc.AgentProto.Agent request) {
        return stub.createAgent(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> deleteAgent(com.project.grpc.AgentProto.AgentRequest request) {
        return stub.deleteAgent(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> updateAgent(com.project.grpc.AgentProto.Agent request) {
        return stub.updateAgent(request);
    }

    @Override
    public io.smallrye.mutiny.Multi<com.project.grpc.AgentProto.Agent> getAllAgents(com.google.protobuf.Empty request) {
        return stub.getAllAgents(request);
    }
}
