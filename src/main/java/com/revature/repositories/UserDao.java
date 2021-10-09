package com.revature.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Player;

@Repository
@Transactional
public interface UserDao extends JpaRepository<Player, Integer> {
	
	public Optional<Player> findByUsername(String username);

}
