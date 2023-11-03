import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.fintech.dto.UsuarioDto;
import com.fintech.model.Conta;
import com.fintech.model.Receita;
import com.fintech.model.Usuario;
import com.fintech.service.ValidadorService;
import com.fintech.validacao.ValidadorException;

public class Main {

	public static void main(String[] args) {
		LocalDateTime agora = LocalDateTime.now();
		
//		Usuario david = new Usuario(
//				"foto", 
//				"David", 
//				agora, 
//				"masculino", 
//				"debarbino@gmail.com", 
//				"12345678"
//				);
//		
//		Conta contaDavid = new Conta("Conta 1", 0.0, david.getId());
//		
//		Receita salario = new Receita("Salario do mes", "Salario", agora, contaDavid.getId());
//		
//		System.out.println(david);
		
		UsuarioDto usuarioDto = new UsuarioDto("foto", 
				"", 
				agora, 
				"masculino", 
				"debarbinogmail.com", 
				"12345678");
		
		ValidadorService validadorService = new ValidadorService();
		HashMap<String, String> erros = new HashMap<String, String>();
		
		validadorService.validate(usuarioDto, erros);
		if(!erros.isEmpty()){
			System.out.println(erros);
		}else {
			System.out.println("UsuarioDto criado!");
		}
		
	
	}
	

}
