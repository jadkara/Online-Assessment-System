package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
