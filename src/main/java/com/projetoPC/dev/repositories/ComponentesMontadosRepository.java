package com.projetoPC.dev.repositories;

import com.projetoPC.dev.models.ComponentesMontados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentesMontadosRepository extends JpaRepository<ComponentesMontados, Long> {

}
