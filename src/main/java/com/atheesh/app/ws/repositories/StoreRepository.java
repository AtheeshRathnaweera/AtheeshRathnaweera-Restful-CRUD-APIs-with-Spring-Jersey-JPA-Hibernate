package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.ItemEntity;
import com.atheesh.app.ws.entities.ShopEntity;
import com.atheesh.app.ws.entities.StoreEntity;
import com.atheesh.app.ws.shared.enums.Status;
import com.atheesh.app.ws.shared.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StoreRepository extends JpaRepository<StoreEntity, Integer> {

    List<StoreEntity> findStoreEntitiesByStatus(Status status);
    List<StoreEntity> findStoreEntitiesByShop(ShopEntity shopEntity);
    List<StoreEntity> findStoreEntitiesByItem(ItemEntity itemEntity);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update StoreEntity storeEntity set storeEntity.item=:newItem,storeEntity.shop=:newShop," +
            "storeEntity.amount=:newAmount,storeEntity.minLimit=:newLimit,storeEntity.status=:newStatus where storeEntity.id =:id")
    int updateTheStoreById(@Param("id") Integer id, @Param("newItem") ItemEntity newItem, @Param("newShop") ShopEntity newShop,
                          @Param("newAmount") Integer newAmount, @Param("newLimit") Integer newLimit,@Param("newStatus") Status newStatus);
}
