package com.project.mapper;

import com.project.models.Link;
import com.project.models.Operator;
import com.project.models.dtos.OperatorDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OperatorDtoMapper implements Mapper<Operator, OperatorDto> {

    @Override
    public OperatorDto map(Operator from) {
        List<String> links = from.getLinks()
                .stream()
                .map(LinksToString.INSTANCE)
                .collect(Collectors.toList());

        return new OperatorDto(from.getOperatorName(), links);
    }

    @Override
    public Operator revers(OperatorDto to) {
        return null;
    }

    ;private enum LinksToString implements Function<Link, String> {
        INSTANCE;

        @Override
        public String apply(Link link) {
            return link.getLinkName();
        }
    }
}
