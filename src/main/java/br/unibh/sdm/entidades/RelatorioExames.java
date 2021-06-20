package br.unibh.sdm.entidades;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tb_relatorios")
public class RelatorioExames {

	@Id
	private String matricula;
	
	@NotBlank
	private String tipoExame;  
	

	@NotNull
	@Future
	private Date dataDoExame;


	public RelatorioExames() {
		super();
		
	}
	
	public RelatorioExames(String matricula, String tipoExame, Date dataDoExame) {
		super();
		this.matricula = matricula;
		this.tipoExame = tipoExame;
		this.dataDoExame = dataDoExame;
	}

	public String getTipoExame() {
		return tipoExame;
	}



	public void setTipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}


	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public Date getDataDoExame() {
		return dataDoExame;
	}

	public void setDataDoExame(Date dataDoExame) {
		this.dataDoExame = dataDoExame;
	}



	@Override
	public String toString() {
		return "RelatorioExames [matricula=" + matricula + ", tipoExame=" + tipoExame + ", dataDoExame=" + dataDoExame
				+ "]";
	}



	
}
