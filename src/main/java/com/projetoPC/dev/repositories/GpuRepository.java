package com.projetoPC.dev.repositories;

import com.projetoPC.dev.models.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpuRepository extends JpaRepository<Gpu, Long> {
    Gpu findByNome(String nome);
}
