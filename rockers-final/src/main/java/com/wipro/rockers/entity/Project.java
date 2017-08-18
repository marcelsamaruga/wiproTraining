package com.wipro.rockers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class Project extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "project")
    private List<Team> listTeam;

    public List<Team> getListTeam() {
        return listTeam;
    }

    public void setListTeam(List<Team> listTeam) {
        this.listTeam = listTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", id='" + super.id + '\'' +
                '}';
    }
}
