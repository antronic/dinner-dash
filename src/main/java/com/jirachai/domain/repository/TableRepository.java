package com.jirachai.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jirachai.domain.entity.Table;

@Repository
public interface TableRepository extends JpaRepository<Table, Integer>{

//	User findOneByEmail(String email);
//	Page<User> findByIdInOrderByUpdatedDesc(Collection id, Pageable pageable);
}
