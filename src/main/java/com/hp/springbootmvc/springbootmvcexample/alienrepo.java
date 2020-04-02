package com.hp.springbootmvc.springbootmvcexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface alienrepo extends JpaRepository<alien,Integer>
{

    @Query("from alien where alien_name= :name")
    List<alien> findByalien_name(@Param("name") String alien_name);
}
