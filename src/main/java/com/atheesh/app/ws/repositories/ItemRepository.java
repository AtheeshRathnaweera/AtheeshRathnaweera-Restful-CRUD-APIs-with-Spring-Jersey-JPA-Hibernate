package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.ItemEntity;
import com.atheesh.app.ws.shared.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update ItemEntity itemEntity set itemEntity.name=:newName,itemEntity.imageUrl=:newImage,itemEntity.status=:newStatus,itemEntity.updatedDate=:nowDate where itemEntity.id =:id")
    int updateTheItemById(@Param("id") int id, @Param("newName") String newName, @Param("newImage") String newImage, @Param("newStatus") Status status,
                          @Param("nowDate")Date updatedDate);

    List<ItemEntity> findItemEntityByStatusEquals(Status status);
}
