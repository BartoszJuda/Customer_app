package com.project.models.dtos;

import java.util.ArrayList;
import java.util.List;

public class OperatorDto {

    private String operatorName;
    private List<String> links = new ArrayList<>();

    public OperatorDto(String operatorName, List<String> links) {
        this.operatorName = operatorName;
        this.links = links;
    }

    public OperatorDto() {
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }
}
