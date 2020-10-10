package model;

public class Carro {
	
	private int id;
	private String nome;
	private String marca;
	private String anoModelo;
	private String dataVenda;
	
	public Carro(int id, String nome, String marca, String anoModelo, String dataVenda) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.anoModelo = anoModelo;
		this.dataVenda = dataVenda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", nome=" + nome + ", marca=" + marca + ", anoModelo=" + anoModelo + ", dataVenda="
				+ dataVenda + "]";
	}
	
}
