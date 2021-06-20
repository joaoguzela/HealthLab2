package br.unibh.sdm.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_agendamento")
public class AgendamentoExames {


	@Id
	private String matricula;
	
	@NotBlank
	private String nomeFuncionario; 
	
	@NotBlank
	private String tipoExame;  
	

	@NotNull
	@Future
	private Date dataDoExame;
	
	@NotBlank
	private String local;

	public AgendamentoExames() {
		super();
	}
	
	

	public AgendamentoExames(String matricula, String nomeFuncionario, String tipoExame,
			 Date dataDoExame, String local) {
		super();
		this.matricula = matricula;
		this.nomeFuncionario = nomeFuncionario;
		this.tipoExame = tipoExame;
		this.dataDoExame = dataDoExame;
		this.local = local;
	}



	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}

	public Date getDataDoExame() {
		return dataDoExame;
	}

	public void setDataDoExame(Date dataDoExame) {
		this.dataDoExame = dataDoExame;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "AgendamentoExames [matricula=" + matricula + ", nomeFuncionario=" + nomeFuncionario + ", tipoExame="
				+ tipoExame + ", dataDoExame=" + dataDoExame + ", local=" + local + "]";
	} 

	
	
	

	
}
