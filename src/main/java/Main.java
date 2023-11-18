import java.time.LocalDateTime;
import java.util.HashMap;

import com.fintech.dao.ContaDAO;
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
        ValidadorUsuarioService usuarioValidadorService = new ValidadorUsuarioService();
        UsuarioService usuarioService = new UsuarioService();

        UsuarioDto david = new UsuarioDto(
                byteArray,
                "David",
                agora,
                "MASCULINO",
                "debarbinsso@gmail.com",
                "12345628"
        );
        Long idDavid = usuarioService.cadastrar(david);
        System.out.println(idDavid);

        Usuario usuarioDavid = usuarioService.buscarPorId(idDavid);
        System.out.println(usuarioDavid);


        HashMap<String, String> erros = new HashMap<String, String>();


        ValidadorContaService contaService = new ValidadorContaService();
        ValidadorInvestimentoService investimentoService = new ValidadorInvestimentoService();
        ValidadorReceitaService receitaService = new ValidadorReceitaService();
        ValidadorDespesaService despesaService = new ValidadorDespesaService();


        ContaDto contaDtoDavid = new ContaDto("Conta 1", 1000.0, usuarioDavid.getId());

        OracleDAOFactory daoFactory = new OracleDAOFactory();
        ContaDAO contaDAO = daoFactory.pegaContaDao();

        Long contaId = contaDAO.cadastrar(contaDtoDavid);
        Conta contaDavid = contaDAO.buscaPorId(contaId);
        System.out.println(contaDavid);


//		InvestimentoDto investimento = new
//				InvestimentoDto("APLICACAO", 1000.00,  50.0, contaDavid.getId(), true);
//		InvestimentoDto investimento2 =
//				new InvestimentoDto("APLICACAO", 1000.00, 100.0, contaDavid.getId(), true);
//
//		ReceitaDto salario = new ReceitaDto("Salario do mes", 1500.00, "Salario",   agora, contaDavid.getId());
//
//		DespesaDto fiap = new DespesaDto(, "mensalidade fiap", 690.00, "mensalidade", agora);


//}
    }
}