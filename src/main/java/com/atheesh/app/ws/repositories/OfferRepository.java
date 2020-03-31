package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<OfferEntity, Integer> {
}
