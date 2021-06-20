package br.unibh.sdm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.unibh.sdm.entidades.AgendamentoExames;




public interface AgendamentoRepository extends CrudRepository<AgendamentoExames, String> {

		List<AgendamentoExames> findByMatricula(String matricula);
		
		List<AgendamentoExames> findByNomeFuncionario(String nomeFuncionario);
	
}

