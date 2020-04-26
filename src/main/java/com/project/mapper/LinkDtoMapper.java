package com.project.mapper;


import com.project.models.Link;
import com.project.models.dtos.LinkDto;
import org.springframework.stereotype.Component;

@Component
public class LinkDtoMapper implements Mapper<Link, LinkDto> {


    @Override
    public LinkDto map(Link from) {
        return new LinkDto
                .Builder()
                .Id(from.getId())
                .CityA(from.getCityA())
                .CityB(from.getCityB())
                .StreetA(from.getStreetA())
                .StreetB(from.getStreetB())
                .ZipCodeA(from.getZipCodeA())
                .ZipCodeB(from.getZipCodeB())
                .Description(from.getDescription())
                .LinkLength(from.getLinkLength())
                .LinkName(from.getLinkName())
                .Operator(from.getOperator().getOperatorName())
                .SubscriptionFee(from.getSubscriptionFee())
                .Technology(from.getTechnology())//było getName
                .build();
    }

    @Override
    public Link revers(LinkDto to) {
        return null;
    }
}
