import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Carro{
	
	Scanner teclado = new Scanner(System.in);
	Random random = new Random();
	DecimalFormat formatado = new DecimalFormat("00");
	BancoDeDados Banco = new BancoDeDados();
	
	private String total;
	private String Imprimir;
	private int totMinut;
	private int totSegun;
	private int totMile;
	private int minutos1;
	private int segundos1;
	private int milesimos1;
	private String Dados1 = "00:00:00";
	private int minutos2;
	private int segundos2;
	private int milesimos2;
	private String Dados2 = "00:00:00";
	
	
	public void voltaUm() {
		setMinutos1(random.nextInt(2)+1);
		setSegundos1(random.nextInt(30)+1);
		setMilesimos1(random.nextInt(30)+1);
		setDados1(formatado.format(getMinutos1())+":"+formatado.format(getSegundos1())+":"+formatado.format(getMilesimos1()));
		setTotMinut(getMinutos1() + getMinutos2());
		setTotSegun(getSegundos1() + getSegundos2());
		setTotMile(getMilesimos1() + getMilesimos2());
		setTotal(formatado.format(getTotMinut())+":"+formatado.format(getTotSegun())+":"+formatado.format(getTotMile()));
		System.out.println("============RESULTADO==============");
		System.out.println("1ª Volta: "+getDados1()+"\n2ª Volta: "+getDados2()+"\nTempo Total: "+getTotal());
	}
	
	public void voltaDois() {
		setMinutos2(random.nextInt(2)+1);
		setSegundos2(random.nextInt(30)+1);
		setMilesimos2(random.nextInt(30)+1);
		setDados2(formatado.format(getMinutos2())+":"+formatado.format(getSegundos2())+":"+formatado.format(getMilesimos2()));
		setTotMinut(getMinutos1() + getMinutos2());
		setTotSegun(getSegundos1() + getSegundos2());
		setTotMile(getMilesimos1() + getMilesimos2());
		setTotal(formatado.format(getTotMinut())+":"+formatado.format(getTotSegun())+":"+formatado.format(getTotMile()));
		System.out.println("\n============RESULTADO==============");
		System.out.println("1ª Volta: "+getDados1()+"\n2ª Volta: "+getDados2()+"\nTempo Total: "+getTotal());
	}
	
	public void GuardarDados() {
		Banco.conectar();
		if(Banco.estaConectado() && getDados1() != "00:00:00" && getDados2() != "00:00:00") {
			Banco.inserirVoltas(getDados1(), getDados2(), getTotal());
			System.out.println("============BANCO DE DADOS==============");
			this.setImprimir("============BANCO DE DADOS==============\n\n1ª Volta: "+getDados1()+"\n2ª Volta: "+getDados2()+"\nTempo Total: "+getTotal()+"\n\nDados Guardados com Sucesso!!");
			System.out.println("Dados Guardados com Sucesso!!");
		}else {
			System.out.println("============BANCO DE DADOS==============");
			this.setImprimir("ERRO: Banco de Dados não está conectado ou os dados estão Incompletos.");
			System.out.println(getImprimir());
		}
	}
	
	public void MostrarDados() {
		Banco.conectar();
		Banco.listarVoltas();
		
	}

	public int getMinutos1() {
		return minutos1;
	}

	public void setMinutos1(int minutos1) {
		this.minutos1 = minutos1;
	}

	public int getSegundos1() {
		return segundos1;
	}

	public void setSegundos1(int segundos1) {
		this.segundos1 = segundos1;
	}

	public int getMinutos2() {
		return minutos2;
	}

	public void setMinutos2(int minutos2) {
		this.minutos2 = minutos2;
	}

	public int getSegundos2() {
		return segundos2;
	}

	public void setSegundos2(int segundos2) {
		this.segundos2 = segundos2;
	}

	public int getMilesimos1() {
		return milesimos1;
	}

	public void setMilesimos1(int milesimos1) {
		this.milesimos1 = milesimos1;
	}

	public int getMilesimos2() {
		return milesimos2;
	}

	public void setMilesimos2(int milesimos2) {
		this.milesimos2 = milesimos2;
	}

	public String getDados1() {
		return Dados1;
	}

	public void setDados1(String dados1) {
		Dados1 = dados1;
	}

	public String getDados2() {
		return Dados2;
	}

	public void setDados2(String dados2) {
		Dados2 = dados2;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public int getTotMinut() {
		return totMinut;
	}

	public void setTotMinut(int totMinut) {
		this.totMinut = totMinut;
	}

	public int getTotMile() {
		return totMile;
	}

	public void setTotMile(int totMile) {
		this.totMile = totMile;
	}

	public int getTotSegun() {
		return totSegun;
	}

	public void setTotSegun(int totSegun) {
		this.totSegun = totSegun;
	}

	public String getImprimir() {
		return Imprimir;
	}

	public void setImprimir(String imprimir) {
		Imprimir = imprimir;
	}
	
	
	
	
	
	
	
	
}