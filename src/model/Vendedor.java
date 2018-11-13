package model;

public class Vendedor extends Pessoa {
	private String login;
	private int senha;
	
	
	public Vendedor() {
		super();
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public int getSenha() {
		return senha;
	}
	
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	
//	@Override
//	public void login() {
//	}
//
//	@Override
//	public int senha() {
//		return 0;
//	}
//
//	@Override
//	public String login(String login) {
//		this.login = login;
//		
//		return null;
//	}
//
//	@Override
//	public int senha(int senha) {
//		this.senha = senha;
//		return 0;
//	}


}
