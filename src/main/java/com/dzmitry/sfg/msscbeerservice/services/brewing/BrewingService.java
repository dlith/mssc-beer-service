package com.dzmitry.sfg.msscbeerservice.services.brewing;

import com.dzmitry.sfg.msscbeerservice.config.JmsConfig;
import com.dzmitry.sfg.msscbeerservice.domain.Beer;
import com.dzmitry.sfg.brewery.model.events.BrewBeerEvent;
import com.dzmitry.sfg.msscbeerservice.repository.BeerRepository;
import com.dzmitry.sfg.msscbeerservice.services.inventory.BeerInventoryService;
import com.dzmitry.sfg.msscbeerservice.web.mappers.BeerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {

    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000) // every 5 seconds
    public void checkForLowInventory(){
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer invQOH = beerInventoryService.getOnHandInventory(beer.getId());
            log.debug("Min On Hand is: " + beer.getMinOnHand());
            log.debug("Inventory is: " + invQOH);

            if(beer.getMinOnHand() >= invQOH) {
                BrewBeerEvent brewBeerEvent = new BrewBeerEvent(beerMapper.beerToBeerDto(beer));
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, brewBeerEvent);
            }
        });
    }
}
