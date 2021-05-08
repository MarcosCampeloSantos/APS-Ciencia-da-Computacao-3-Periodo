import java.sql.Connection;
import java.sql.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BancoDeDados {
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/aps";
		String usuario = "root";
		String senha = "";
		
		try {
			this.connection = (Connection) DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro "+e.getMessage());
		}
		
	}
	
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void listarVoltas() {
		try {
			String query = "SELECT * FROM voltas";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				System.out.println("=========="+this.resultset.getString("idVoltas")+"ª Corrida "+"=========="+"\nTempo da 1ª Volta: "+this.resultset.getString("Voltas1") +"\nTempo da 2ª Volta: "+ this.resultset.getString("Voltas2")+"\nTempo Total das Voltas: "+this.resultset.getString("TotVoltas"));
			}
		} catch (SQLException e) {
			System.out.println("Banco está Desconectado");
		}
		
	}
	
	public void inserirVoltas(String volta1, String volta2, String TotVolt) {
		try {
			String query = "INSERT INTO voltas(Voltas1, Voltas2, TotVoltas) values('"+volta1+"','"+volta2+"','"+TotVolt+"');";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}

}
