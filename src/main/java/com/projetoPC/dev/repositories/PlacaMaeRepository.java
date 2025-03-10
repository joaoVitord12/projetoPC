package com.projetoPC.dev.repositories;

import com.projetoPC.dev.models.PlacaMae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacaMaeRepository extends JpaRepository<PlacaMae, Long> {
}
