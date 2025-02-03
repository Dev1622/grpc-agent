package com.project.grpc;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import com.project.entity.Agent;
import org.jboss.logging.Logger;
import java.util.List;

@GrpcService
public class AgentServiceImpl implements AgentService {

    @Inject
    Logger log;

    @Override
    @Transactional
    @Blocking
    public Multi<AgentProto.Agent> getAllAgents(Empty request){
        log.info("Fetching all agents!");

        List<Agent> agentList = Agent.listAll();

        if(agentList.isEmpty()){
            log.error("No agent found!");
            throw new StatusRuntimeException(Status.NOT_FOUND.withDescription("No agent found!"));
        }

        return Multi.createFrom().items(Agent.<Agent>streamAll())
                .map(agent -> AgentProto.Agent.newBuilder()
                        .setId(agent.id)
                        .setName(agent.name)
                        .setAge(agent.age)
                        .setSkill(agent.skill)
                        .build())
                .onFailure().transform(e -> {
                    log.error("Error occurred while fetching agents!");
                    throw new StatusRuntimeException(Status.INTERNAL.withDescription("An Internal error occurred while fetching agents!"));
                });

    }

    @Override
    @Transactional
    @Blocking
    public Uni<AgentProto.Agent> getAgentById(AgentProto.AgentRequest request) {
        log.info("Fetching agent with id : " + request.getId());
        return Uni.createFrom().item(() -> {
            Agent agent = Agent.findById(request.getId());
            if(agent == null){
                log.error("Agent not found");
                throw new StatusRuntimeException(Status.NOT_FOUND.withDescription("Agent not found with the given id : " + request.getId()));
            }
            return agent;
        }).map(agent -> AgentProto.Agent.newBuilder()
                        .setId(request.getId())
                        .setName(agent.name)
                        .setAge(agent.age)
                        .setSkill(agent.skill)
                        .build())
                
                .onFailure().invoke(e -> {
                    if(!(e instanceof StatusRuntimeException)){
                    log.error("Error occurred while fetching agent!");
                    throw new StatusRuntimeException(Status.INTERNAL.withDescription("Error occurred while fetching Agent!"));
                }
                });
    }

    @Override
    @Transactional
    @Blocking
    public Uni<AgentProto.AgentResponse> createAgent(AgentProto.Agent request) {
        log.info("Creating new agent!");
        return Uni.createFrom().item(() -> Agent.find("name=?1 and age=?2 and skill=?3", request.getName(), request.getAge(), request.getSkill())
                        .firstResult())
                .onItem().ifNotNull().failWith(()-> new StatusRuntimeException(Status.ALREADY_EXISTS.withDescription("Agent already exist")))
                .onItem().ifNull().continueWith(() -> {
                    Agent agent = new Agent();
                    agent.name = request.getName();
                    agent.age = request.getAge();
                    agent.skill = request.getSkill();

                    if(request.getName().isEmpty() || request.getAge() <= 0 || request.getSkill().isEmpty()){
                        log.error("Invalid arguments!");
                        throw new StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Please enter valid input for fields"));
                    }

                    agent.persistAndFlush();
                    return agent;
                })
                .replaceWith(AgentProto.AgentResponse.newBuilder()
                        .setMessage("Agent created successfully!")
                        .build())
                .onFailure().invoke(e -> {
                    if(!(e instanceof StatusRuntimeException)) {
                        log.error("Error occurred while creating agent!");
                        throw new StatusRuntimeException(Status.INTERNAL.withDescription("Error occurred while creating agent!"));
                    }
                });
    }

    @Override
    @Transactional
    @Blocking
    public Uni<AgentProto.AgentResponse> deleteAgent(AgentProto.AgentRequest request) {
        log.info("Deleting agent with id : " + request.getId());
        return Uni.createFrom().item(() ->{
            boolean deleted = Agent.deleteById(request.getId());
            if(!deleted){
                log.error("No agent found with the given id");
                throw new StatusRuntimeException(Status.NOT_FOUND.withDescription("Agent not found with the given id : " + request.getId()));
            }else{
                return AgentProto.AgentResponse.newBuilder()
                        .setMessage("Agent deleted successfully!")
                        .build();
            }
        })
                .onFailure().invoke(e -> {
                    if(!(e instanceof StatusRuntimeException)){
                    log.error("Error occurred while deleting Agent!");
                    throw new StatusRuntimeException(Status.INTERNAL.withDescription("Error occurred while deleting Agent!"));
                }
                });
    }

    @Override
    @Transactional
    @Blocking
    public Uni<AgentProto.AgentResponse> updateAgent(AgentProto.Agent request) {
        log.info("Updating the agent with id : " + request.getId());
        return Uni.createFrom().item(() -> {
            Agent agent = Agent.findById(request.getId());
            if (agent == null) {
                log.error("No agent found with the given id");
                throw new StatusRuntimeException(Status.NOT_FOUND.withDescription("No Agent found with the give id : " + request.getId()));
            }
                agent.name = request.getName();
                agent.age = request.getAge();
                agent.skill = request.getSkill();

                if(request.getName().isEmpty() || request.getAge() <= 0 || request.getSkill().isEmpty()){
                    log.error("Update agent information is null");
                    throw new StatusRuntimeException(Status.INVALID_ARGUMENT.withDescription("Update Agent Information Cannot be null!"));
                }

                agent.persistAndFlush();
                return AgentProto.AgentResponse.newBuilder()
                        .setMessage("Agent updated successfully!")
                        .build();

        })
                .onFailure().invoke(e -> {
                    if(!(e instanceof StatusRuntimeException)) {
                        log.error("Error occurred while updating agent!");
                        throw new StatusRuntimeException(Status.INTERNAL.withDescription("Error occurred while updating agent!"));
                    }
                });
    }
}