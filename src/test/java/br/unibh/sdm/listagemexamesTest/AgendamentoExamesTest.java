package br.unibh.sdm.listagemexamesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.unibh.sdm.entidades.AgendamentoExames;
import br.unibh.sdm.repository.AgendamentoRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AgendamentoExamesTest {

	 private static Logger LOGGER = LoggerFactory.getLogger(AgendamentoExamesTest.class);
	 private SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
	    
		@Autowired
		private AgendamentoRepository repository;
		@Test
		
		public void testeCriacao() throws ParseException {
			LOGGER.info("Criando objetos...");
			AgendamentoExames c1 = new AgendamentoExames("000099", "joaog", "admissional",df.parse("01/08/2022"), "rua teste 223") ;
			repository.save(c1);
			LOGGER.info("Criando objetos...");
			AgendamentoExames c2 = new AgendamentoExames("0000991", "JOAOG2", "admissional",df.parse("01/08/2022"), "rua teste 223") ;
			repository.save(c2);
			
			LOGGER.info("Pesquisado todos");
			Iterable<AgendamentoExames> lista = repository.findAll();
			assertNotNull(lista.iterator());
			for (AgendamentoExames exameAgendado : lista) {
				LOGGER.info(exameAgendado.toString());
			}
			LOGGER.info("Pesquisado um objeto");
			List<AgendamentoExames> result = repository.findByMatricula("000099");
			assertEquals(result.size(), 1);
			assertEquals(result.get(0).getNomeFuncionario(), "joaog");
			LOGGER.info("Encontrado: {}", result.get(0));
			
			LOGGER.info("Pesquisado um objeto");
			List<AgendamentoExames> result2 = repository.findByNomeFuncionario("joaog");
			assertEquals(result2.size(), 1);
			assertEquals(result2.get(0).getMatricula(), "000099");
			LOGGER.info("Encontrado: {}", result2.get(0));
		}
		
		@Test	
		public void testeExclusao() throws ParseException {
			LOGGER.info("Excluindo objetos...");
			List<AgendamentoExames> result = repository.findByMatricula("000099");
			for (AgendamentoExames exameAgendado : result) {
				LOGGER.info("Excluindo Inss id = "+exameAgendado.getMatricula());
				repository.delete(exameAgendado);
			}
			
			result = repository.findByMatricula("000099");
			assertEquals(result.size(), 0);
			LOGGER.info("Exclusao feita com sucesso");
			}
		}

