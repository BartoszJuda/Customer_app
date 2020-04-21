package com.project.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Operator {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NotNull
    @Size(max = 200)
    private String operatorName;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "operator", cascade = CascadeType.ALL)
    private Set<Link> links = new HashSet<>();

    public Operator(@NotNull @Size(max = 200) String operatorName, Set<Link> links) {
        this.operatorName = operatorName;
        this.links = links;
    }

    public Operator() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Set<Link> getLinks() {
        return links;
    }

    public void setLinks(Set<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "Id=" + Id +
                ", operatorName='" + operatorName + '\'' +
                ", links=" + links +
                '}';
    }
}
