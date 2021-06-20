package br.unibh.sdm.negocio;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.unibh.sdm.entidades.AgendamentoExames;
import br.unibh.sdm.repository.AgendamentoRepository;

@Service
public class AgendamentoServices {

	 private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	    
	    private final AgendamentoRepository agendamentoRepo;

	    public AgendamentoServices(AgendamentoRepository agendamentoRepository){
	        this.agendamentoRepo = agendamentoRepository;
	    }
	    
	    public List<AgendamentoExames> getExames(){
	        if(logger.isInfoEnabled()){
	            logger.info("Buscando todos os objetos");
	        }
	        Iterable<AgendamentoExames> lista = this.agendamentoRepo.findAll();
	        if (lista == null) {
	        	return new ArrayList<AgendamentoExames>();
	        }
	        return IteratorUtils.toList(lista.iterator());
	    }    

	    public AgendamentoExames getExamesByMatricula(String matricula){
	        if(logger.isInfoEnabled()){
	            logger.info("Buscando Exames com o funcionario {}",matricula);
	        }
	        Optional<AgendamentoExames> retorno = this.agendamentoRepo.findById(matricula);
	        if(!retorno.isPresent()){
	            throw new RuntimeException("Exames com a matricula "+matricula+" nao encontrado");
	        }
	        return retorno.get();
	    }
	    
	    public List<AgendamentoExames> getClienteByNome(String nome){
	    	if(logger.isInfoEnabled()){
	            logger.info("Buscando todos os objetos");
	        }
	        Iterable<AgendamentoExames> lista = this.agendamentoRepo.findByNomeFuncionario(nome);
	        if (lista == null) {
	        	return new ArrayList<AgendamentoExames>();
	        }
	        return IteratorUtils.toList(lista.iterator());
	    }
	    

		 public AgendamentoExames saveAgendamento(AgendamentoExames matricula) {
			 
			 if(logger.isInfoEnabled()) {
				 logger.info("Salvando exame do colaborador {}", matricula.toString());
			 }
			 return this.agendamentoRepo.save(matricula); 
		 }
	    
	    public void deleteExamePorColaborador(String matricula){
	        if(logger.isInfoEnabled()){
	            logger.info("Excluindo Exames do funcionario {}",matricula);
	        }
	        this.agendamentoRepo.deleteById(matricula);
	    }
}
