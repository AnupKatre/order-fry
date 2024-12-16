package com.of.rms.ordermanagement.repository;


import com.of.rms.ordermanagement.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}

