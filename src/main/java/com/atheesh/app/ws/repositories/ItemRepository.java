package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
}
