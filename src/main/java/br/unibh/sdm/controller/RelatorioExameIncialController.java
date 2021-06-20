package br.unibh.sdm.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import br.unibh.sdm.entidades.RelatorioExames;
import br.unibh.sdm.negocio.RelatorioExamesServices;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "relatoriosexames")

public class RelatorioExameIncialController {
	 
	private final RelatorioExamesServices relatorioService;

	    public RelatorioExameIncialController(RelatorioExamesServices relatorioService){
	        this.relatorioService=relatorioService;
	    }

	    @GetMapping(value = "")
	    public List<RelatorioExames> getClientes(){
	        return relatorioService.getExames();
	    }
	    
	    @GetMapping(value="{matricula}")
	    public RelatorioExames getExamesByMatricula(@PathVariable String matricula) throws Exception{
	        if(!ObjectUtils.isEmpty(matricula)){
	           return relatorioService.getExamesByMatricula(matricula);
	        }
	        throw new Exception("Exames do colaborador com a matricula "+matricula+" nao encontrados");
	    }
	    
	  
	    @ResponseStatus(HttpStatus.CREATED)
	    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public RelatorioExames createRelatorio(@RequestBody @NotNull RelatorioExames relatorio) throws Exception {
	         return relatorioService.saveRelatorio(relatorio);
	    }
	    
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    @DeleteMapping(value = "{matricula}")
	    public boolean updateCliente(@PathVariable String matricula) throws Exception {
	    	relatorioService.deleteExamePorColaborador(matricula);
	         return true;
	    }
}
