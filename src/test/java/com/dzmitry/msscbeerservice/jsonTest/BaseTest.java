package com.dzmitry.msscbeerservice.jsonTest;

import com.dzmitry.msscbeerservice.domain.Beer;
import com.dzmitry.msscbeerservice.web.model.BeerDto;
import com.dzmitry.msscbeerservice.web.model.BeerStyleEnum;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import static com.dzmitry.msscbeerservice.bootstrap.BeerLoader.BEER_1_UPC;

public class BaseTest {

    BeerDto getDto(){
        return BeerDto.builder()
                .beerName("BeerName")
                .beerStyle(BeerStyleEnum.ALE)
                .id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .price(new BigDecimal("12.99"))
                .upc(BEER_1_UPC)
                .build();
    }
}
