package com.revature.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.User;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Integer> {
	
	
	public User findByUsername(String username);
	
	@Query("select chips from players where player_id= ?1")
	public int findBalanceId(int id);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update players set chips = chips+?2 where player_id=?1")
	public void depositChipsById(int id, int deposit);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update players set chips = chips-?2 where player_id=?1")
	public void withdrawChipsById(int id, int withdraw);

}
