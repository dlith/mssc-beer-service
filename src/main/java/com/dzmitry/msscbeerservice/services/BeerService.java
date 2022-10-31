package com.dzmitry.msscbeerservice.services;

import com.dzmitry.msscbeerservice.web.model.BeerDto;
import com.dzmitry.msscbeerservice.web.model.BeerPagedList;
import com.dzmitry.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);

    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
