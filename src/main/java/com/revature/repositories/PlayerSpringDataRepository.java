package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Player;

@Repository
public interface PlayerSpringDataRepository extends JpaRepository<Player, Integer>{
	

}