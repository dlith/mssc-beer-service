package com.dzmitry.sfg.msscbeerservice.jsonTest;

import com.dzmitry.sfg.brewery.model.BeerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
public class BeerDtoJsonTest extends BaseTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();
        String jsonString = objectMapper.writeValueAsString(beerDto);
        System.out.println(jsonString);
    }

//    @Test
//    void testDeserialize() throws JsonProcessingException {
//        String json = "{\"id\":\"fb373b64-9088-48b0-8810-be5a6d40ae99\",\"version\":null,\"createdDate\":\"2022-10-29T16:41:47+0200\",\"lastModifiedDate\":\"2022-10-29T16:41:47+0200\",\"beerName\":\"BeerName\",\"beerStyle\":\"ALE\",\"upc\":12312312312,\"price\":\"12.99\",\"quantityOnHand\":null}\n";
//        BeerDto dto = objectMapper.readValue(json, BeerDto.class);
//        System.out.println(dto);
//    }
}
