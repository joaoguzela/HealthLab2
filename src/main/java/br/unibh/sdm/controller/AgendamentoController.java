package br.unibh.sdm.controller;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.unibh.sdm.entidades.AgendamentoExames;
import br.unibh.sdm.entidades.RelatorioExames;
import br.unibh.sdm.negocio.AgendamentoServices;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "agendamentoexames")
public class AgendamentoController {

	 private final AgendamentoServices agendamentoServices;

	    public AgendamentoController(AgendamentoServices agendamentoServices){
	        this.agendamentoServices=agendamentoServices;
	    }
	 
	    @ResponseStatus(HttpStatus.CREATED)
	    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public AgendamentoExames createRelatorio(@RequestBody @NotNull AgendamentoExames agendamento) throws Exception {
	         return agendamentoServices.saveAgendamento(agendamento);
	    }
	    
	    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	    public AgendamentoExames updateExames(@PathVariable String id, 
	    		@RequestBody @NotNull AgendamentoExames matricula) throws Exception {
	         return agendamentoServices.saveAgendamento(matricula);
	    }
	
}
