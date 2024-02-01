package com.ProjetoControledeAlunos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoControledeAlunos.entities.AlunosEntities;

public interface AlunosRepository extends JpaRepository<AlunosEntities, Long> {
	
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}	
