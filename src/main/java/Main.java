import java.time.LocalDateTime;

import com.fintech.model.Conta;
import com.fintech.model.Receita;
import com.fintech.model.Usuario;

public class Main {

	public static void main(String[] args) {
		LocalDateTime agora = LocalDateTime.now();
		
		Usuario david = new Usuario(
				"foto", 
				"David", 
				agora, 
				"masculino", 
				"debarbino@gmail.com", 
				"12345678"
				);
		
		Conta contaDavid = new Conta("Conta 1", 0.0, david.getId());
		
		Receita salario = new Receita("Salario do mes", "Salario", agora, contaDavid.getId());
		
		System.out.println(david);

	}
	

}
