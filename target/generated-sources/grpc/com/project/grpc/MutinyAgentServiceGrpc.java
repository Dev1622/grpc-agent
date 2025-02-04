package com.project.grpc;

import static com.project.grpc.AgentServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: agent.proto")
public final class MutinyAgentServiceGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinyAgentServiceGrpc() {
    }

    public static MutinyAgentServiceStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinyAgentServiceStub(channel);
    }

    public static class MutinyAgentServiceStub extends io.grpc.stub.AbstractStub<MutinyAgentServiceStub> implements io.quarkus.grpc.MutinyStub {

        private AgentServiceGrpc.AgentServiceStub delegateStub;

        private MutinyAgentServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = AgentServiceGrpc.newStub(channel);
        }

        private MutinyAgentServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = AgentServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinyAgentServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinyAgentServiceStub(channel, callOptions);
        }

        public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.Agent> getAgentById(com.project.grpc.AgentProto.AgentRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::getAgentById);
        }

        public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> createAgent(com.project.grpc.AgentProto.Agent request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::createAgent);
        }

        public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> deleteAgent(com.project.grpc.AgentProto.AgentRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::deleteAgent);
        }

        public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> updateAgent(com.project.grpc.AgentProto.Agent request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::updateAgent);
        }

        public io.smallrye.mutiny.Multi<com.project.grpc.AgentProto.Agent> getAllAgents(com.google.protobuf.Empty request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToMany(request, delegateStub::getAllAgents);
        }
    }

    public static abstract class AgentServiceImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public AgentServiceImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.Agent> getAgentById(com.project.grpc.AgentProto.AgentRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> createAgent(com.project.grpc.AgentProto.Agent request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> deleteAgent(com.project.grpc.AgentProto.AgentRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<com.project.grpc.AgentProto.AgentResponse> updateAgent(com.project.grpc.AgentProto.Agent request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Multi<com.project.grpc.AgentProto.Agent> getAllAgents(com.google.protobuf.Empty request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(com.project.grpc.AgentServiceGrpc.getGetAllAgentsMethod(), asyncServerStreamingCall(new MethodHandlers<com.google.protobuf.Empty, com.project.grpc.AgentProto.Agent>(this, METHODID_GET_ALL_AGENTS, compression))).addMethod(com.project.grpc.AgentServiceGrpc.getGetAgentByIdMethod(), asyncUnaryCall(new MethodHandlers<com.project.grpc.AgentProto.AgentRequest, com.project.grpc.AgentProto.Agent>(this, METHODID_GET_AGENT_BY_ID, compression))).addMethod(com.project.grpc.AgentServiceGrpc.getCreateAgentMethod(), asyncUnaryCall(new MethodHandlers<com.project.grpc.AgentProto.Agent, com.project.grpc.AgentProto.AgentResponse>(this, METHODID_CREATE_AGENT, compression))).addMethod(com.project.grpc.AgentServiceGrpc.getDeleteAgentMethod(), asyncUnaryCall(new MethodHandlers<com.project.grpc.AgentProto.AgentRequest, com.project.grpc.AgentProto.AgentResponse>(this, METHODID_DELETE_AGENT, compression))).addMethod(com.project.grpc.AgentServiceGrpc.getUpdateAgentMethod(), asyncUnaryCall(new MethodHandlers<com.project.grpc.AgentProto.Agent, com.project.grpc.AgentProto.AgentResponse>(this, METHODID_UPDATE_AGENT, compression))).build();
        }
    }

    private static final int METHODID_GET_ALL_AGENTS = 0;

    private static final int METHODID_GET_AGENT_BY_ID = 1;

    private static final int METHODID_CREATE_AGENT = 2;

    private static final int METHODID_DELETE_AGENT = 3;

    private static final int METHODID_UPDATE_AGENT = 4;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>, io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final AgentServiceImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(AgentServiceImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                case METHODID_GET_ALL_AGENTS:
                    io.quarkus.grpc.stubs.ServerCalls.oneToMany((com.google.protobuf.Empty) request, (io.grpc.stub.StreamObserver<com.project.grpc.AgentProto.Agent>) responseObserver, compression, serviceImpl::getAllAgents);
                    break;
                case METHODID_GET_AGENT_BY_ID:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.project.grpc.AgentProto.AgentRequest) request, (io.grpc.stub.StreamObserver<com.project.grpc.AgentProto.Agent>) responseObserver, compression, serviceImpl::getAgentById);
                    break;
                case METHODID_CREATE_AGENT:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.project.grpc.AgentProto.Agent) request, (io.grpc.stub.StreamObserver<com.project.grpc.AgentProto.AgentResponse>) responseObserver, compression, serviceImpl::createAgent);
                    break;
                case METHODID_DELETE_AGENT:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.project.grpc.AgentProto.AgentRequest) request, (io.grpc.stub.StreamObserver<com.project.grpc.AgentProto.AgentResponse>) responseObserver, compression, serviceImpl::deleteAgent);
                    break;
                case METHODID_UPDATE_AGENT:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.project.grpc.AgentProto.Agent) request, (io.grpc.stub.StreamObserver<com.project.grpc.AgentProto.AgentResponse>) responseObserver, compression, serviceImpl::updateAgent);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }
}
