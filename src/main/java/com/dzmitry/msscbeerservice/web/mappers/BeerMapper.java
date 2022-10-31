package com.dzmitry.msscbeerservice.web.mappers;

import com.dzmitry.msscbeerservice.domain.Beer;
import com.dzmitry.msscbeerservice.web.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    default Beer beerDtoToBeer(BeerDto dto) {
        return null;
    }
}
