package cadastros;

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
	
	

}
