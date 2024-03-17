package com.lcwsankalp.recilance4j.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwsankalp.recilance4j.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

	List<Menu> findByCategory(String category);

}
