package com.project.models.dtos;

public class LinkDto {

    private String linkName;
    private String zipCodeA;
    private String zipCodeB;
    private String cityA;
    private String cityB;
    private String streetA;
    private String streetB;
    private int subscriptionFee;
    private int linkLength;
    private String description;
    private String technology;
    private String operator;

    public LinkDto() {
    }

    private LinkDto(Builder b) {
        this.operator = b.operator;
        this.technology = b.technology;
        this.description = b.description;
        this.linkLength = b.linkLength;
        this.subscriptionFee = b.subscriptionFee;
        this.streetA = b.streetA;
        this.streetB = b.streetB;
        this.cityA = b.cityA;
        this.cityB = b.cityB;
        this.zipCodeA = b.zipCodeA;
        this.zipCodeB = b.zipCodeB;
        this.linkName = b.linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public void setZipCodeA(String zipCodeA) {
        this.zipCodeA = zipCodeA;
    }

    public void setZipCodeB(String zipCodeB) {
        this.zipCodeB = zipCodeB;
    }

    public void setCityA(String cityA) {
        this.cityA = cityA;
    }

    public void setCityB(String cityB) {
        this.cityB = cityB;
    }

    public void setStreetA(String streetA) {
        this.streetA = streetA;
    }

    public void setStreetB(String streetB) {
        this.streetB = streetB;
    }

    public void setSubscriptionFee(int subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public void setLinkLength(int linkLength) {
        this.linkLength = linkLength;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLinkName() {
        return linkName;
    }

    public String getZipCodeA() {
        return zipCodeA;
    }

    public String getZipCodeB() {
        return zipCodeB;
    }

    public String getCityA() {
        return cityA;
    }

    public String getCityB() {
        return cityB;
    }

    public String getStreetA() {
        return streetA;
    }

    public String getStreetB() {
        return streetB;
    }

    public int getSubscriptionFee() {
        return subscriptionFee;
    }

    public int getLinkLength() {
        return linkLength;
    }

    public String getDescription() {
        return description;
    }

    public String getTechnology() {
        return technology;
    }

    public String getOperator() {
        return operator;
    }

    public static class Builder {

        private String linkName;
        private String zipCodeA;
        private String zipCodeB;
        private String cityA;
        private String cityB;
        private String streetA;
        private String streetB;
        private int subscriptionFee;
        private int linkLength;
        private String description;
        private String technology;
        private String operator;

        public Builder() {
        }


        public Builder LinkName(String linkName) {
            this.linkName = linkName;
            return this;
        }

        public Builder ZipCodeA(String zipCodeA) {
            this.zipCodeA = zipCodeA;
            return this;
        }

        public Builder ZipCodeB(String zipCodeB) {
            this.zipCodeB = zipCodeB;
            return this;
        }

        public Builder CityA(String cityA) {
            this.cityA = cityA;
            return this;
        }

        public Builder CityB(String cityB) {
            this.cityB = cityB;
            return this;
        }

        public Builder StreetA(String streetA) {
            this.streetA = streetA;
            return this;
        }

        public Builder StreetB(String streetB) {
            this.streetB = streetB;
            return this;
        }

        public Builder SubscriptionFee(int subscriptionFee) {
            this.subscriptionFee = subscriptionFee;
            return this;
        }

        public Builder LinkLength(int linkLength) {
            this.linkLength = linkLength;
            return this;
        }

        public Builder Description(String description) {
            this.description = description;
            return this;
        }

        public Builder Technology(String technology) {
            this.technology = technology;
            return this;
        }

        public Builder Operator(String operator) {
            this.operator = operator;
            return this;
        }

        public LinkDto build() {
            return new LinkDto(this);
        }
    }
}
