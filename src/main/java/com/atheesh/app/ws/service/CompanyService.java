package com.atheesh.app.ws.service;

import com.atheesh.app.ws.shared.dto.CompanyDTO;
import com.atheesh.app.ws.shared.enums.Status;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> getAllCompanies();
    CompanyDTO getCompanyById(Integer id);
    List<CompanyDTO> getCompaniesByStatus(Status status);
    CompanyDTO save(CompanyDTO companyDTO);
    boolean update(Integer id, CompanyDTO companyDTO);
    boolean delete(Integer id);


}
