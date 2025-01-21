package com.project.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.*;

@Entity
@ApplicationScoped
@Table(name = "agent")
public class Agent extends PanacheEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(nullable = false)
    public String name;
    @Column(nullable = false)
    public int age;
    @Column(nullable = false)
    public String skill;
}
