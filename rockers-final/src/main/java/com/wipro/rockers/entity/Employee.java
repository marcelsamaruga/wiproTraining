package com.wipro.rockers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Employee extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "wipro_id")
    private String wiproId;

    @Column(name = "mc_id")
    private String mcId;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWiproId() {
        return wiproId;
    }

    public void setWiproId(String wiproId) {
        this.wiproId = wiproId;
    }

    public String getMcId() {
        return mcId;
    }

    public void setMcId(String mcId) {
        this.mcId = mcId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
