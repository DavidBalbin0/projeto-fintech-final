import java.sql.Timestamp;

import com.fintech.model.Conta;
import com.fintech.model.Receita;
import com.fintech.model.Usuario;

public class Main {

	public static void main(String[] args) {
		
		Usuario david = new Usuario(
				"foto", 
				"David", 
				new Timestamp(System.currentTimeMillis()), 
				"masculino", 
				"debarbino@gmail.com", 
				"12345678"
				);
		
		Conta contaDavid = new Conta("Conta 1", 0.0, david.getId());
		
		Receita salario = new Receita("Salario do mes", "Salario", new Timestamp(System.currentTimeMillis()), contaDavid.getId());
		
		System.out.println(david);

	}
	

}
