package com.projetoPC.dev.repositories;

import com.projetoPC.dev.models.Componentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentesRepository extends JpaRepository<Componentes, Long> {
}
