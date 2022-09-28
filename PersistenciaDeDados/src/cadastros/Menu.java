package cadastros;

public class Menu {

	public static void main(String[] args) throws Exception {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		try {
			
			//Cadastrando pessoas no banco de dados
			
			//Passando os dados da pessoa pelo m�todo construtor
			Pessoa pessoa1 = new Pessoa(1, "Wyltamar Douglas","wyltamar@hotmail.com");
			
			//Chamando o m�todo incluirPessoa da classe PessoaDAO
			pessoaDAO.incluirPessoa(pessoa1);
			
			//Passando os dados da pessoa atrav�s dos m�todos setters(acessores) da classe   
			Pessoa pessoa2 = new Pessoa();
			pessoa2.setIdPessoa(2);
			pessoa2.setNomePessoa("Pedro Lucas");
			pessoa2.setEmail("pedrooluucas@gmail.com");
			
			pessoaDAO.incluirPessoa(pessoa2);
			
		} catch (Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
	}

}
