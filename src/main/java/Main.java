import java.time.LocalDateTime;
import java.util.HashMap;

import com.fintech.dao.*;
import com.fintech.db.FlywayConfig;
import com.fintech.dto.*;
import com.fintech.model.*;
import com.fintech.service.*;


public class Main {

    public static void main(String[] args) {

        FlywayConfig.configureAndMigrate();

//        LocalDateTime agora = LocalDateTime.now();
//        ValidadorUsuarioService usuarioValidadorService = new ValidadorUsuarioService();
//        UsuarioService usuarioService = new UsuarioService();
//
//        UsuarioDto david = new UsuarioDto(
//                "David",
//                agora,
//                "MASCULINO",
//                "debarbddsaddddssssdsdsssdsdsdsdssidsno@gmail.com",
//                "123456d28"
//        );
//        Long idDavid = usuarioService.cadastrar(david);
//        System.out.println(idDavid);
//
//        Usuario usuarioDavid = usuarioService.buscarPorId(idDavid);
//        System.out.println(usuarioDavid);
//
//
//        HashMap<String, String> erros = new HashMap<String, String>();
//
//
//        ValidadorContaService contaService = new ValidadorContaService();
////        ValidadorObjetivoService objetivoService = new ValidadorObjetivoService();
//        ValidadorReceitaService receitaService = new ValidadorReceitaService();
//        ValidadorDespesaService despesaService = new ValidadorDespesaService();
//
//
//        ContaDto contaDtoDavid = new ContaDto("Conta 1", 1000.0, usuarioDavid.getId());
//
//        OracleDAOFactory daoFactory = new OracleDAOFactory();
//        ContaDAO contaDAO = daoFactory.pegaContaDao();
//
//        Long contaId = contaDAO.cadastrar(contaDtoDavid);
//        Conta contaDavid = contaDAO.buscaPorId(contaId);
//        System.out.println(contaDavid);
//
//
//		ObjetivoDto objetivoDto = new
//                ObjetivoDto("APLICACAO", 1000.00,  50.0,  true, contaDavid.getId());
//
//        ObjetivoDAO objetivoDAO = daoFactory.pegaObjetivoDao();
//        Long objetivoId = objetivoDAO.cadastrarObjetivo(objetivoDto);
//        Objetivo objetivo = objetivoDAO.buscaPorId(objetivoId);
//        System.out.println(objetivo);
//
//
//		ObjetivoDto objetivoDto2 = new ObjetivoDto("APLICACAO", 1000.00, 100.0,true,  contaDavid.getId());
//        Long objetivoId2 = objetivoDAO.cadastrarObjetivo(objetivoDto2);
//        Objetivo objetivo2 = objetivoDAO.buscaPorId(objetivoId2);
//        System.out.println(objetivo2);

//		ReceitaDto salario = new ReceitaDto("Salario do mes", 1500.00, "Salario",   agora, contaDavid.getId());
//        ReceitaDAO receitaDAO = daoFactory.pegaReceitaDao();
//
//
//        Long receitaId = receitaDAO.cadastra(salario);
//        Receita receita = receitaDAO.buscaPorId(receitaId);
//        System.out.println(receita);
//
//
//        DespesaDto fiap = new DespesaDto("mensalidade fiap", 690.00, "mensalidade", agora,  contaId);
//        DespesaDAO despesaDAO = daoFactory.pegaDespesaDao();
//        Long fiapId = despesaDAO.cadastra(fiap);
//        Despesa despesa = despesaDAO.buscaPorId(fiapId);
//        System.out.println(despesa);

    }
}