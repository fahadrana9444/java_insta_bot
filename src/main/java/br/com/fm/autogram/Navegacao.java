package br.com.fm.autogram;

public class Navegacao {

	public static void main(String[] args) throws InterruptedException {

		Acesso.ColetarInformacoesAcesso();
		Acesso.RealizarAcesso();
		Atividade.SeguirUsuario("test");
	}
}