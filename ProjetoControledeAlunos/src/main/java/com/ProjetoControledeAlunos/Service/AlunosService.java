package com.ProjetoControledeAlunos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoControledeAlunos.Repository.AlunosRepository;
import com.ProjetoControledeAlunos.entities.AlunosEntities;

@Service
public class AlunosService {
	private final AlunosRepository alunosRepository;
	
	@Autowired
	public AlunosService(AlunosRepository alunosRepository) {
		this.alunosRepository = alunosRepository;
	}

	public List<AlunosEntities> buscaTodosAlunos() {
		return alunosRepository.findAll();
	}

	public AlunosEntities buscaAlunosId(long id) {
		Optional<AlunosEntities> Alunos = alunosRepository.findById(id);
		return Alunos.orElse(null);
	}

	
	public AlunosEntities salvaAlunos(AlunosEntities alunos) {
		return alunosRepository.save(alunos);
	}

	public AlunosEntities alterarAlunos(long id, AlunosEntities alterarAlunos) {
		Optional<AlunosEntities> existeAlunos = alunosRepository.findById(id);
		if (existeAlunos.isPresent()) {
			alterarAlunos.setIdAluno(null);
			return alunosRepository.save(alterarAlunos);

		}
		return null;
	}
	public boolean apagarAlunos(long id) {
		Optional<AlunosEntities> existeAlunos = alunosRepository.findById(id);
		if (existeAlunos.isPresent() ) {
			alunosRepository.deleteById(id);
			return true;
		}
		return false;
	}
}