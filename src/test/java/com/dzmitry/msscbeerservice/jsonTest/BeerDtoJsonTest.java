package com.dzmitry.msscbeerservice.jsonTest;

import com.dzmitry.msscbeerservice.domain.Beer;
import com.dzmitry.msscbeerservice.web.model.BeerDto;
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

    @Test
    void testDeserialize() throws JsonProcessingException {
        String json = "{\"id\":\"8ae5607c-f154-4c16-931f-b4cc39585837\",\"version\":null,\"createdDate\":\"2022-10-29T07:34:22.7825952+02:00\",\"lastModifiedDate\":\"2022-10-29T07:34:22.7835954+02:00\",\"beerName\":\"BeerName\",\"beerStyle\":\"ALE\",\"upc\":12312312312,\"price\":12.99,\"quantityOnHand\":null}\n";
        BeerDto dto = objectMapper.readValue(json, BeerDto.class);
        System.out.println(dto);
    }
}
