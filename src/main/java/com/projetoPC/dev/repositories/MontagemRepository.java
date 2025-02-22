package com.projetoPC.dev.repositories;

import com.projetoPC.dev.models.Montagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MontagemRepository extends JpaRepository<Montagem, Long> {
}
