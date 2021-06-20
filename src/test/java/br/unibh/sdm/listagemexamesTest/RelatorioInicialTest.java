package br.unibh.sdm.listagemexamesTest;

import static org.junit.Assert.assertNotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.unibh.sdm.entidades.RelatorioExames;
import br.unibh.sdm.repository.RelatorioInicialRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RelatorioInicialTest {

	private static Logger LOGGER = LoggerFactory.getLogger(AgendamentoExamesTest.class);
	private SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
    
	@Autowired
	private RelatorioInicialRepository repository;
	@Test
	public void testeCriacao() throws ParseException {
		
		LOGGER.info("Criando objetos...");
		RelatorioExames c1 = new RelatorioExames("0000993", "admissional",df.parse("01/08/2022")) ;
		repository.save(c1);
		
		LOGGER.info("Pesquisado todos");
		Iterable<RelatorioExames> lista = repository.findAll();
		assertNotNull(lista.iterator());
		for (RelatorioExames exameAgendado : lista) {
			LOGGER.info(exameAgendado.toString());
		}
		}
	@Test
	public void testeExclusao() throws ParseException {
		LOGGER.info("Excluindo objetos...");
					 
		repository.deleteById("0000993");
			
		
		assertNotNull(repository.findById("0000993")); //Devolve Opitional.Empty()
			LOGGER.info("Exclusao feita com sucesso");
			}
		
}

