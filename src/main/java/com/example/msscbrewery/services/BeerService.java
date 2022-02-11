package com.example.msscbrewery.services;

import java.util.UUID;

import com.example.msscbrewery.web.model.BeerDto;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto savedBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
