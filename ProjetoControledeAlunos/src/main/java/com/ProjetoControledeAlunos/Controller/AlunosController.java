package com.ProjetoControledeAlunos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoControledeAlunos.Service.AlunosService;
import com.ProjetoControledeAlunos.entities.AlunosEntities;

@RestController
@RequestMapping("/Alunos")
public class AlunosController {
	private final AlunosService AlunosService;

	@Autowired
	public AlunosController(AlunosService alunosService) {
		this.AlunosService = alunosService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<AlunosEntities> buscaAlunosControlId(@PathVariable long id) {
		AlunosEntities alunos = AlunosService.buscaAlunosId(id);
		if (alunos != null)
			return ResponseEntity.ok(alunos);
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<AlunosEntities>> buscaTodosAlunosControl() {
		List<AlunosEntities> Alunos = AlunosService.buscaTodosAlunos();
		return ResponseEntity.ok(Alunos);
	}

	@PostMapping("/")
	public ResponseEntity<AlunosEntities> salvaAlunoControl(@RequestBody AlunosEntities alunos) {
		AlunosEntities salvaAlunos = AlunosService.salvaAlunos(alunos);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAlunos);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AlunosEntities> alteraAlunosControl(@PathVariable long id, @RequestBody AlunosEntities alunos) {
		AlunosEntities alteraAlunos = AlunosService.alterarAlunos(id, alunos);
		if (alteraAlunos != null) {
			return ResponseEntity.ok(alunos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaAlunosControl(@PathVariable long id) {
		boolean apagar = AlunosService.apagarAlunos(id);
		if (apagar) {
			return ResponseEntity.ok().body("a Alunos foi excluida com sucesso");
		} else {
			return ResponseEntity.notFound().build();

		}
	}
}
