package com.atheesh.app.ws.service.impl;

import com.atheesh.app.ws.service.OfferService;
import com.atheesh.app.ws.shared.dto.OfferDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("offerService")
@Transactional(propagation= Propagation.REQUIRED)
public class OfferServiceImpl implements OfferService {

    @Override
    public List<OfferDTO> getAllIOffers() {
        return null;
    }

    @Override
    public OfferDTO getOfferById(Integer id) {
        return null;
    }

    @Override
    public OfferDTO save(OfferDTO offerDTO) {
        return null;
    }

    @Override
    public boolean update(Integer id, OfferDTO offerDTO) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
