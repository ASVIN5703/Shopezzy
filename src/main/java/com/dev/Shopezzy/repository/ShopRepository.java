package com.dev.Shopezzy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.Shopezzy.model.ShopModel;

@Repository
public interface ShopRepository extends JpaRepository<ShopModel, Long>{

}
