package br.com.fm.autogram;

public class Atividade {

	public static void main(String[] args) throws InterruptedException {

		Acesso.ColetarInformacoesAcesso();
		Acesso.RealizarAcesso(Acesso.usuarioAcesso, Acesso.senhaAcesso);
		Navegacao.SeguirUsuario("lmiguelmp");
	}
}
