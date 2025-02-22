package com.projetoPC.dev.repositories;

import com.projetoPC.dev.models.Fonte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonteRepository extends JpaRepository<Fonte, Long> {
}
