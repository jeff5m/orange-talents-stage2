package com.orangetalents.challenge.repository;

import com.orangetalents.challenge.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
