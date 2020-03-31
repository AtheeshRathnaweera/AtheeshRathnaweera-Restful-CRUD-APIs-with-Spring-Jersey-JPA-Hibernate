package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.OfferDTO;

import java.util.List;

public interface OfferService {

    List<OfferDTO> getAllIOffers();
    OfferDTO getOfferById(Integer id);
    OfferDTO save(OfferDTO offerDTO);
    boolean update(Integer id, OfferDTO offerDTO);
    boolean delete(Integer id);
}
