package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.CompanyEntity;
import com.atheesh.app.ws.entities.ShopEntity;
import com.atheesh.app.ws.entities.UserEntity;
import com.atheesh.app.ws.shared.enums.Status;
import com.atheesh.app.ws.shared.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShopRepository extends JpaRepository<ShopEntity, Integer> {

    List<ShopEntity> findShopEntitiesByStatus(Status status);
    List<ShopEntity> findShopEntitiesByManager(UserEntity manager);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update ShopEntity shopEntity set shopEntity.name=:newName," +
            "shopEntity.email=:newEmail,shopEntity.phoneNumber=:newPhoneNumber,shopEntity.district=:newDistrict,shopEntity.town=:newTown," +
            "shopEntity.address=:newAddress,shopEntity.company=:newCompany,shopEntity.manager=:newManager,shopEntity.status=:newStatus where shopEntity.id =:id")
    int updateTheShopById(@Param("id") Integer id, @Param("newName") String newName, @Param("newEmail") String newEmail,
                          @Param("newPhoneNumber") String newPhoneNumber, @Param("newDistrict") String newDistrict,
                          @Param("newTown") String newTown, @Param("newAddress") String newAddress, @Param("newCompany") CompanyEntity newCompany,@Param("newManager") UserEntity newManager,
                          @Param("newStatus") Status newStatus);
}
