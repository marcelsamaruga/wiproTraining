package com.wipro.rockers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class Team extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @OneToMany(mappedBy = "team")
    private List<Employee> listEmployee;

    public List<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
