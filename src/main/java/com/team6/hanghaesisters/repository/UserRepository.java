package com.team6.hanghaesisters.repository;

import com.team6.hanghaesisters.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
