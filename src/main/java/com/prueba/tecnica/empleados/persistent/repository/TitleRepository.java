package com.prueba.tecnica.empleados.persistent.repository;

import com.prueba.tecnica.empleados.persistent.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<TitleEntity, Long> {

    boolean existsByTitleIgnoreCase(String title);
}
