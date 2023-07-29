package com.java.Desafio.aula3.repository;

import com.java.Desafio.aula3.entities.Pecas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PecasRepository extends JpaRepository<Pecas, Long> {




    @Query("select p from Pecas p where p.ativo = true")
    List<Pecas> buscarTodosSemParam();
}


