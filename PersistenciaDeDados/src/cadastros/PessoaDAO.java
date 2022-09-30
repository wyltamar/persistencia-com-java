package cadastros;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends DAO {
	
	public void incluirPessoa(Pessoa pessoa) throws Exception {
		
		String sql ="INSERT INTO pessoa VALUES(?,?,?)";
		
		conectar();
		statement = connection.prepareStatement(sql);
		statement.setInt(1, pessoa.getIdPessoa());
		statement.setString(2, pessoa.getNomePessoa());
		statement.setString(3, pessoa.getEmail());
		statement.execute();
		statement.close();
		closeConnection();
	}
	
	public void atualizarPessoa(Pessoa pessoa) throws Exception {
		
		String sql = "UPDATE pessoa SET nomePessoa = ?, email = ? where idPessoa = ?";
		
		conectar();
		statement = connection.prepareStatement(sql);
		statement.setString(1, pessoa.getNomePessoa());
		statement.setString(2, pessoa.getEmail());
		statement.setInt(3, pessoa.getIdPessoa());
		statement.execute();
		statement.close();
		closeConnection();
	}
	
	public void excluirPessoa(Pessoa pessoa)throws Exception {
		
		String sql = "DELETE FROM pessoa WHERE idPessoa = ?";
		
		conectar();
		statement = connection.prepareStatement(sql);
		statement.setInt(1, pessoa.getIdPessoa());
		statement.execute();
		statement.close();
		closeConnection();
	}
	
	public Pessoa buscarPessoaPorId(int idPessoa) throws Exception {
		
		String sql = "SELECT * FROM pessoa WHERE idPessoa = ?";
		
		conectar();
		statement = connection.prepareStatement(sql);
		statement.setInt(1, idPessoa);
		resultSet = statement.executeQuery();
		
		
		Pessoa pessoa = new Pessoa();
		
		if(resultSet.next()) {
			
			pessoa.setIdPessoa(resultSet.getInt(1));
			pessoa.setNomePessoa(resultSet.getString(2));
			pessoa.setEmail(resultSet.getString(3));
		}
		else {
			System.out.println("Não existe pessoa com o id " + idPessoa + " em nossa base de dados.");
		}
		
		closeConnection();
		
		return pessoa;
		
	}
	
	public List<Pessoa> buscarPessoas()throws Exception{
		
		String sql = "SELECT * FROM pessoa";
		
		conectar();
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();
		
		
		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		while(resultSet.next()) {
			
			Pessoa pessoa = new Pessoa();
			pessoa.setIdPessoa(resultSet.getInt(1));
			pessoa.setNomePessoa(resultSet.getString(2));
			pessoa.setEmail(resultSet.getString(3));
			
			listaPessoas.add(pessoa);
		}
		
		if(!listaPessoas.isEmpty()) {
			
			return listaPessoas;
		}else {
			System.out.println("Não existe pessoas cadastradas em nossa base de dados.");
			return null;
		}
		
	}
	
	

}
