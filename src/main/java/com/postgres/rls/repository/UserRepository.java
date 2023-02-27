package com.postgres.rls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgres.rls.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}
