package com.atheesh.app.ws.service.impl;

import com.atheesh.app.ws.entities.CompanyEntity;
import com.atheesh.app.ws.factory.DTOToEntityFactory;
import com.atheesh.app.ws.factory.EntityToDTOFactory;
import com.atheesh.app.ws.repositories.CompanyRepository;
import com.atheesh.app.ws.service.CompanyService;
import com.atheesh.app.ws.shared.dto.CompanyDTO;
import com.atheesh.app.ws.shared.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("companyService")
@Transactional(propagation= Propagation.REQUIRED)
public class CompanyServiceImpl implements CompanyService {

    private final
    CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        List<CompanyEntity> companyEntityList = companyRepository.findAll();
        List<CompanyDTO> companyDTOList = new ArrayList<>();

        for(CompanyEntity companyEntity : companyEntityList){
            companyDTOList.add(EntityToDTOFactory.company(companyEntity));
        }

        return companyDTOList;
    }

    @Override
    public CompanyDTO getCompanyById(Integer id) {
        Optional<CompanyEntity> companyEntityOptional = companyRepository.findById(id);

        if(companyEntityOptional.isPresent()){
            return EntityToDTOFactory.company(companyEntityOptional.get());
        }
        return null;
    }

    @Override
    public List<CompanyDTO> getCompaniesByStatus(Status status) {
        List<CompanyEntity> companyEntityList = companyRepository.findAllByStatusEquals(status);
        List<CompanyDTO> companyDTOList = new ArrayList<>();

        for(CompanyEntity companyEntity : companyEntityList){
            companyDTOList.add(EntityToDTOFactory.company(companyEntity));
        }
        return companyDTOList;
    }

    @Override
    public CompanyDTO save(CompanyDTO companyDTO) {
        companyDTO.setCreatedDate(new Date());
        companyDTO.setUpdatedDate(new Date());
        CompanyEntity companyEntity = companyRepository.save(DTOToEntityFactory.company(companyDTO));
        return EntityToDTOFactory.company(companyEntity);
    }

    @Override
    public boolean update(Integer id, CompanyDTO companyDTO) {
        int affectedRows = companyRepository.updateTheCompanyById(id,companyDTO.getName(),companyDTO.getPhoneNumber(),companyDTO.getWebsiteUrl(),
                new Date(),companyDTO.getStatus());
        return affectedRows > 0;
    }

    @Override
    public boolean delete(Integer id) {
        companyRepository.deleteById(id);
        return false;
    }




}
