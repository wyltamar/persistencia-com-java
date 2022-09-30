package cadastros;

import java.util.List;

public class Menu {

	public static void main(String[] args) throws Exception {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		try {
			
			//Cadastrando pessoas no banco de dados
			
			//Passando os dados da pessoa pelo método construtor
			/*
			Pessoa pessoa1 = new Pessoa(1, "Wyltamar Douglas","wyltamar@hotmail.com");
			
			//Chamando o método incluirPessoa da classe PessoaDAO
			pessoaDAO.incluirPessoa(pessoa1);
			
			//Passando os dados da pessoa através dos métodos setters(acessores) da classe   
			Pessoa pessoa2 = new Pessoa();
			pessoa2.setIdPessoa(2);
			pessoa2.setNomePessoa("Pedro Lucas");
			pessoa2.setEmail("pedrooluucas@gmail.com");
			
			pessoaDAO.incluirPessoa(pessoa2);
			*/
			
			//Atualização de pessoa no banco de dados
		/*	Pessoa pessoaAtualizar = new Pessoa();
			pessoaAtualizar = pessoaDAO.buscarPessoaPorId(1);
			
			if(pessoaAtualizar != null) {
				
				pessoaAtualizar.setNomePessoa("Maria");
				pessoaAtualizar.setEmail("maria@gmail.com");
				pessoaDAO.atualizarPessoa(pessoaAtualizar);
			}
			
			List<Pessoa> listPessoas = pessoaDAO.buscarPessoas();
			
			for (Pessoa pessoa : listPessoas) {
				System.out.println(pessoa);
			}*/
			
			//Exclusão
			
			Pessoa pessoaExcluir = new Pessoa();
			pessoaExcluir = pessoaDAO.buscarPessoaPorId(1);
			
			if(pessoaExcluir != null) {
				pessoaDAO.excluirPessoa(pessoaExcluir);
				System.out.println("Registro excluido com sucesso");
			}
			
			List<Pessoa> listPessoas = pessoaDAO.buscarPessoas();
			
			for (Pessoa pessoa : listPessoas) {
				System.out.println(pessoa);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " +e.getMessage());
		}
	}

}
