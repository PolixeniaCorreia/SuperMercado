package model;

public class Produto {
	private int idVenda;
	private int codigoProduto;
	private String nome;
	private String descriçao;
	private int quantidade;
	
	public Produto() {
	
	}
	
	public Produto(int idVenda, int codigoProduto, String nome, String descriçao, int quantidade) {
		super();
		this.idVenda = idVenda;
		this.codigoProduto = codigoProduto;
		this.nome = nome;
		this.descriçao = descriçao;
		this.quantidade = quantidade;
	}
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public int getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescriçao() {
		return descriçao;
	}
	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
