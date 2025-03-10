package com.projetoPC.dev.repositories;

import com.projetoPC.dev.models.MemoriaRam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoriaRamRepository extends JpaRepository<MemoriaRam, Long> {
}
