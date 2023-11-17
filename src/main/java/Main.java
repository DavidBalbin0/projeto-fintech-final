import java.time.LocalDateTime;
import java.util.HashMap;

import com.fintech.dao.OracleDAOFactory;
import com.fintech.dao.UsuarioDAO;
import com.fintech.db.FlywayConfig;
import com.fintech.dto.*;
import com.fintech.model.Conta;
import com.fintech.model.Investimento;
import com.fintech.model.Receita;
import com.fintech.model.Usuario;
import com.fintech.service.*;
import com.fintech.teste.Sexo;


public class Main {

	public static void main(String[] args) {

		FlywayConfig.configureAndMigrate();

		LocalDateTime agora = LocalDateTime.now();
		byte[] byteArray = new byte[]{0x12, 0x34, 0x56, 0x78, 0x70};
		UsuarioService usuarioService = new UsuarioService();

		UsuarioDto david = new UsuarioDto(
				byteArray,
				"Davids",
				agora,
				"MASCULINO",
				"debarbdindo@gmail.com",
				"12345628"
		);
		System.out.println("teste");
		Long idDavid = usuarioService.cadastrar(david);
		System.out.println(idDavid);
		Usuario usuarioDavid = usuarioService.buscarPorId(idDavid);
		System.out.println(usuarioDavid);



		//		HashMap<String,String> erros = new HashMap<String,String>();
//
//		ValidadorUsuarioService usuarioService = new ValidadorUsuarioService();
//		ValidadorContaService contaService = new ValidadorContaService();
//		ValidadorInvestimentoService investimentoService = new ValidadorInvestimentoService();
//		ValidadorReceitaService receitaService = new ValidadorReceitaService();
//		ValidadorDespesaService despesaService = new ValidadorDespesaService();
//

//

//
//		Usuario davidUser = new Usuario(
//				byteArray,
//				"David",
//				agora,
//				Sexo.MASCULINO,
//				"debarbino@gmail.com",
//				"12345678"
//		);
//
//		ContaDto contaDtoDavid = new ContaDto("Conta 1", 1000.0, 1L);
//
//		Conta contaDavid = new Conta("Conta 1", 1000.0,1L);
//
//		InvestimentoDto investimento = new
//				InvestimentoDto("APLICACAO", 1000.00,  50.0, contaDavid.getId(), true);
//		InvestimentoDto investimento2 =
//				new InvestimentoDto("APLICACAO", 1000.00, 100.0, contaDavid.getId(), true);
//
//		ReceitaDto salario = new ReceitaDto("Salario do mes", 1500.00, "Salario",   agora, contaDavid.getId());
//
//		DespesaDto fiap = new DespesaDto(contaDavid.getId(), "mensalidade fiap", 690.00, "mensalidade", agora);
//
//		usuarioService.validar(david, erros);
//		contaService.validar(contaDtoDavid, erros);
//		investimentoService.validar(investimento, erros);
//		investimentoService.validar(investimento2, erros);
//		receitaService.validar(salario, erros);
//		despesaService.validar(fiap, erros);
//
//		System.out.println(erros);
//		System.out.println(contaDavid);

//		OracleDAOFactory factory = new OracleDAOFactory();
//		UsuarioDAO usuarioDAO = factory.getUsuarioDAO();






//}
	}}