package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.ItemEntity;
import com.atheesh.app.ws.entities.ShopEntity;
import com.atheesh.app.ws.entities.StoreEntity;
import com.atheesh.app.ws.shared.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StoreRepository extends JpaRepository<StoreEntity, Integer> {

    List<StoreEntity> findAllByStatus(Status status);
    List<StoreEntity> findAllByShop_Id(Integer shopId);
    List<StoreEntity> findAllByItem_Id(Integer itemId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update StoreEntity storeEntity set storeEntity.item=:newItem,storeEntity.shop=:newShop," +
            "storeEntity.amount=:newAmount,storeEntity.minLimit=:newLimit,storeEntity.unitQuantity=:unitQuantity,storeEntity.unitSymbol=:unitSymbol,storeEntity.unitPrice=:newPrice,storeEntity.priceSymbol=:priceSymbol,storeEntity.status=:newStatus where storeEntity.id =:id")
    int updateTheStoreById(@Param("id") Integer id, @Param("newItem") ItemEntity newItem, @Param("newShop") ShopEntity newShop,
                          @Param("newAmount") Integer newAmount, @Param("newLimit") Integer newLimit,@Param("unitQuantity") Integer unitQuantity,
                          @Param("unitSymbol") String unitSymbol,@Param("newPrice") Float newPrice,@Param("priceSymbol") String priceSymbol,@Param("newStatus") Status newStatus);
}
