package com.example.strongteambackendassignment.entity;


import javax.persistence.*;

@Entity
public class Roles {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Roles_Enum roles_enum;

    public Roles() {
    }

    public Roles(int id, Roles_Enum roles_enum) {
        this.id = id;
        this.roles_enum = roles_enum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Roles_Enum getRoles_enum() {
        return roles_enum;
    }

    public void setRoles_enum(Roles_Enum roles_enum) {
        this.roles_enum = roles_enum;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", roles_enum=" + roles_enum +
                '}';
    }
}

