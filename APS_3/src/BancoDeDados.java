import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Statement;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BancoDeDados {
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	Document document = new Document();
	
	//CONECTA NO BANCO
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
	//VERIFICA SE ESTÁ CONECTADO
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		}else {
			return false;
		}
	}
	//GERAR RELATORIO EM PDF DOS DADOS
	public void listarVoltas() {
		try {
			PdfWriter.getInstance(document, new FileOutputStream("documento.pdf"));
			document.open();
			String query = "SELECT * FROM voltas";
			this.resultset = this.statement.executeQuery(query);
			document.add(new Paragraph("==============================RELATORIO=================================="));
			while(this.resultset.next()) {
				document.add(new Paragraph("=========="+this.resultset.getString("idVoltas")+"ª Corrida "+"=========="+"\nTempo da 1ª Volta: "
							+this.resultset.getString("Voltas1") +"\nTempo da 2ª Volta: "+ this.resultset.getString("Voltas2")+"\nTempo Total das Voltas: "
							+this.resultset.getString("TotVoltas")));
			}
		} catch (SQLException e) {
			System.out.println("Banco está Desconectado");
		} catch (FileNotFoundException e) {
			System.out.println("Error: "+e);
		} catch (DocumentException e) {
			System.out.println("Error: "+e);
		} finally {
			document.close();
		}
		
	}
	//INSERIR DADOS NO BANCO	
	public void inserirVoltas(String volta1, String volta2, String TotVolt) {
		try {
			String query = "INSERT INTO voltas(Voltas1, Voltas2, TotVoltas) values('"+volta1+"','"+volta2+"','"+TotVolt+"');";
			this.statement.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}

}
