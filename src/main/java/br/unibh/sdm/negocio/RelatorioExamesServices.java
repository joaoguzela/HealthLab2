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
import br.unibh.sdm.entidades.RelatorioExames;
import br.unibh.sdm.repository.RelatorioInicialRepository;

@Service
public class RelatorioExamesServices {
	 private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	    
	    private final RelatorioInicialRepository exameRepo;

	    public RelatorioExamesServices(RelatorioInicialRepository relatorioInicialRepository){
	        this.exameRepo = relatorioInicialRepository;
	    }
	    
	    public List<RelatorioExames> getExames(){
	        if(logger.isInfoEnabled()){
	            logger.info("Buscando todos os objetos");
	        }
	        Iterable<RelatorioExames> lista = this.exameRepo.findAll();
	        if (lista == null) {
	        	return new ArrayList<RelatorioExames>();
	        }
	        return IteratorUtils.toList(lista.iterator());
	    }    

	    public RelatorioExames getExamesByMatricula(String matricula){
	        if(logger.isInfoEnabled()){
	            logger.info("Buscando Exames com o funcionario {}",matricula);
	        }
	        Optional<RelatorioExames> retorno = this.exameRepo.findById(matricula);
	        if(!retorno.isPresent()){
	            throw new RuntimeException("Exames com a matricula "+matricula+" nao encontrado");
	        }
	        return retorno.get();
	    }
	    
	    public RelatorioExames saveRelatorio(RelatorioExames matricula) {
			 
			 if(logger.isInfoEnabled()) {
				 logger.info("Salvando exame do colaborador {}", matricula.toString());
			 }
			 return this.exameRepo.save(matricula); 
		 }
	    
	    
	    public void deleteExamePorColaborador(String matricula){
	        if(logger.isInfoEnabled()){
	            logger.info("Excluindo Exames do funcionario {}",matricula);
	        }
	        this.exameRepo.deleteById(matricula);
	    }

}
