package com.atheesh.app.ws.repositories;

import com.atheesh.app.ws.entities.RoleEntity;
import com.atheesh.app.ws.entities.UserEntity;
import com.atheesh.app.ws.entities.UserRoleEntity;
import com.atheesh.app.ws.shared.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer> {

    List<UserRoleEntity> findUserRoleEntitiesByUser(UserEntity user);
    List<UserRoleEntity> findUserRoleEntitiesByRole(RoleEntity role);
    UserRoleEntity findUserRoleEntityByUserEqualsAndRoleEquals(UserEntity userEntity,RoleEntity roleEntity);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update UserRoleEntity userRoleEntity set userRoleEntity.role=:newRole,userRoleEntity.user=:newUser where userRoleEntity.id =:id")
    int updateTheUserRoleById(@Param("id") Integer id, @Param("newRole") RoleEntity newRole, @Param("newUser") UserEntity newUser);
}
