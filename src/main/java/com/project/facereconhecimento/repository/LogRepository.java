package com.project.facereconhecimento.repository;

import com.project.facereconhecimento.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log,Long> {
}
