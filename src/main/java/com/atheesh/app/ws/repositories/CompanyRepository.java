package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
}
