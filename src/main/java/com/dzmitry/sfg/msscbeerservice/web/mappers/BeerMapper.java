package com.dzmitry.sfg.msscbeerservice.web.mappers;

import com.dzmitry.sfg.msscbeerservice.domain.Beer;
import com.dzmitry.sfg.brewery.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    BeerDto beerToBeerDtoWithInventory(Beer beer);
    Beer beerDtoToBeer(BeerDto dto);
}
