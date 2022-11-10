package com.dzmitry.sfg.brewery.model.events;

import com.dzmitry.sfg.brewery.model.BeerDto;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {

    private static final long serialVersionUID = 8098169146589759870L;

    private BeerDto beerDto;
}
