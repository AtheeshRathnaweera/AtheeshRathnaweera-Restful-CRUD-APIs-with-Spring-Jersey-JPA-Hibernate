package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.CompanyEntity;
import com.atheesh.app.ws.shared.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update CompanyEntity companyEntity set companyEntity.name=:newName,companyEntity.phoneNumber=:newPhone,companyEntity.websiteUrl=:newWebsiteUrl,companyEntity.updatedDate=:nowDate,companyEntity.status=:newStatus where companyEntity.id =:id")
    int updateTheCompanyById(@Param("id") int id, @Param("newName") String newName,@Param("newPhone") String newPhone,@Param("newWebsiteUrl") String newWebsiteUrl,
                          @Param("nowDate") Date updatedDate,@Param("newStatus") Status status);

    List<CompanyEntity> findAllByStatusEquals(Status status);
}
