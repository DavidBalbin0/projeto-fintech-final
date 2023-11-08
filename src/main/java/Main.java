import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.fintech.dto.UsuarioDto;
import com.fintech.model.Conta;
import com.fintech.model.Investimento;
import com.fintech.model.Receita;
import com.fintech.model.Usuario;
import com.fintech.service.ValidadorService;


public class Main {

	public static void main(String[] args) {
		LocalDateTime agora = LocalDateTime.now();

		byte[] byteArray = new byte[]{0x12, 0x34, 0x56, 0x78, 0x70};

		Usuario david = new Usuario(
				byteArray,
				"David",
				agora,
				"masculino",
				"debarbino@gmail.com",
				"12345678"
				);

		Conta contaDavid = new Conta("Conta 1", 1000.0, david.getId());

		Investimento investimento = new
				Investimento("APLICACAO", 1000.00, contaDavid, 100.0, true);
		Investimento investimento2 =
				new Investimento("APLICACAO", 1000.00, contaDavid, 100.0, true);


		Receita salario = new Receita("Salario do mes", "Salario", agora, contaDavid.getId());

		System.out.println(david);
		System.out.println(contaDavid);




//}
	}}