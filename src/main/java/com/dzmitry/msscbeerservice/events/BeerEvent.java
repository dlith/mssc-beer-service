package com.dzmitry.msscbeerservice.events;

import com.dzmitry.msscbeerservice.web.model.BeerDto;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = 8098169146589759870L;

    private final BeerDto beerDto;
}
