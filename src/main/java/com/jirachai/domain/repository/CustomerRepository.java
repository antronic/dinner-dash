package com.jirachai.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jirachai.domain.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

//	User findOneByEmail(String email);
//	Page<User> findByIdInOrderByUpdatedDesc(Collection id, Pageable pageable);
}
