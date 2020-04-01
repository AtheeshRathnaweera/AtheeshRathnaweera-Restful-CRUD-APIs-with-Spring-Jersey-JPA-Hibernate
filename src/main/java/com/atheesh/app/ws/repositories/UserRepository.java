package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.UserEntity;
import com.atheesh.app.ws.shared.enums.Status;
import com.atheesh.app.ws.shared.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update UserEntity userEntity set userEntity.firstName=:firstName,userEntity.lastName=:lastName," +
            "userEntity.email=:email,userEntity.phoneNumber=:phoneNumber,userEntity.nic=:nic,userEntity.status=:status where userEntity.id =:id")
    int updateTheRoleById(@Param("id") Integer id, @Param("firstName") String firstName,@Param("lastName") String lastName,
                          @Param("email") String email,@Param("phoneNumber") String phoneNumber,@Param("nic") String nic,
                          @Param("status") UserStatus status);


    List<UserEntity> getAllByStatus(UserStatus status);
}
