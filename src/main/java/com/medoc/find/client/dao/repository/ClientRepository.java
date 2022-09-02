package com.medoc.find.client.dao.repository;

import com.medoc.find.client.dao.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("select c from ClientEntity c")
    List<ClientEntity> getAllFromQuery();

    @Query("SELECT c FROM ClientEntity c WHERE c.id = :id")
    ClientEntity getById(@Param(value = "id") Long id);
    @Modifying
    @Query("DELETE from ClientEntity  WHERE id = :id")
    int deleteFromId(@Param(value = "id") Long id);

    @Query("SELECT c FROM ClientEntity c")
    List<ClientEntity> getAllClient();
}
