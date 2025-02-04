package com.project.grpc;

import io.quarkus.grpc.MutinyService;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: agent.proto")
public interface AgentService extends MutinyService {

    io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.Agent> getAgentById(com.project.grpc.AgentProto.AgentRequest request);

    io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> createAgent(com.project.grpc.AgentProto.Agent request);

    io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> deleteAgent(com.project.grpc.AgentProto.AgentRequest request);

    io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> updateAgent(com.project.grpc.AgentProto.Agent request);

    io.smallrye.mutiny.Multi<com.project.grpc.AgentProto.Agent> getAllAgents(com.google.protobuf.Empty request);
}
