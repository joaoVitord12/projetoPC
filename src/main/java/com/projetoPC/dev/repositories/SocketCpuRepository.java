package com.projetoPC.dev.repositories;

import com.projetoPC.dev.models.SocketCPU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocketCpuRepository extends JpaRepository<SocketCPU, Long> {
}
