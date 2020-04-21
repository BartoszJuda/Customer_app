package com.project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 20)
    private String linkName;

    @NotNull
    @Size(max= 7)
    @Column(name = "zip_code_A")
    private String zipCodeA;

    @NotNull
    @Size(max= 7)
    @Column(name = "zip_code_B")
    private String zipCodeB;

    @NotNull
    @Size(max= 30)
    @Column(name = "city_A")
    private String cityA;

    @NotNull
    @Size(max= 30)
    @Column(name = "city_B")
    private String cityB;

    @NotNull
    @Size(max= 45)
    @Column(name = "street_A")
    private String streetA;

    @NotNull
    @Size(max= 45)
    @Column(name = "street_B")
    private String streetB;

    @NotNull
    private int subscriptionFee;

    @NotNull
    private int linkLength;

    @NotNull
    @Size(max= 500)
    private String description;

    @Column(length = 10)
    private String technology;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "operator_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Operator operator;

    public Link(@NotNull @Size(max = 20) String linkName, @NotNull @Size(max = 7) String zipCodeA, @NotNull @Size(max = 7) String zipCodeB, @NotNull @Size(max = 30) String cityA, @NotNull @Size(max = 30) String cityB, @NotNull @Size(max = 45) String streetA, @NotNull @Size(max = 45) String streetB, @NotNull int subscriptionFee, @NotNull int linkLength, @NotNull @Size(max = 500) String description, String technology, Operator operator) {
        this.linkName = linkName;
        this.zipCodeA = zipCodeA;
        this.zipCodeB = zipCodeB;
        this.cityA = cityA;
        this.cityB = cityB;
        this.streetA = streetA;
        this.streetB = streetB;
        this.subscriptionFee = subscriptionFee;
        this.linkLength = linkLength;
        this.description = description;
        this.technology = technology;
        this.operator = operator;
    }

    public Link() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getZipCodeA() {
        return zipCodeA;
    }

    public void setZipCodeA(String zipCodeA) {
        this.zipCodeA = zipCodeA;
    }

    public String getZipCodeB() {
        return zipCodeB;
    }

    public void setZipCodeB(String zipCodeB) {
        this.zipCodeB = zipCodeB;
    }

    public String getCityA() {
        return cityA;
    }

    public void setCityA(String cityA) {
        this.cityA = cityA;
    }

    public String getCityB() {
        return cityB;
    }

    public void setCityB(String cityB) {
        this.cityB = cityB;
    }

    public String getStreetA() {
        return streetA;
    }

    public void setStreetA(String streetA) {
        this.streetA = streetA;
    }

    public String getStreetB() {
        return streetB;
    }

    public void setStreetB(String streetB) {
        this.streetB = streetB;
    }

    public int getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setSubscriptionFee(int subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public int getLinkLength() {
        return linkLength;
    }

    public void setLinkLength(int linkLength) {
        this.linkLength = linkLength;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", linkName='" + linkName + '\'' +
                ", zipCodeA='" + zipCodeA + '\'' +
                ", zipCodeB='" + zipCodeB + '\'' +
                ", cityA='" + cityA + '\'' +
                ", cityB='" + cityB + '\'' +
                ", streetA='" + streetA + '\'' +
                ", streetB='" + streetB + '\'' +
                ", subscriptionFee=" + subscriptionFee +
                ", linkLength=" + linkLength +
                ", description='" + description + '\'' +
                ", technology='" + technology + '\'' +
                ", operator=" + operator +
                '}';
    }
}
