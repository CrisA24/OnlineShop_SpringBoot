package com.example.OnlineShop.repository;

import com.example.OnlineShop.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdusRepository extends JpaRepository<Produs, Long> {
}
