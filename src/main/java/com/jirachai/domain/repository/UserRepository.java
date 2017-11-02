package com.jirachai.domain.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jirachai.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findOneByEmail(String email);
//	Page<User> findByIdInOrderByUpdatedDesc(Collection id, Pageable pageable);
}
