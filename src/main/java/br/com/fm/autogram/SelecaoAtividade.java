package br.com.fm.autogram;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SelecaoAtividade extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	static void InformarUsuario() throws InterruptedException {
		JFrame frame = new JFrame();
		JPanel tela = new JPanel(new BorderLayout(5, 5));
		JPanel rotulo = new JPanel(new GridLayout(0, 1, 2, 2));
		rotulo.add(new JLabel("Usuário para seguir: ", SwingConstants.LEFT));
		tela.add(rotulo, BorderLayout.WEST);
		JPanel controle = new JPanel(new GridLayout(0, 1, 2, 2));
		JTextField campoUsuario = new JTextField();
		controle.add(campoUsuario);
		tela.add(controle, BorderLayout.CENTER);
		JOptionPane.showMessageDialog(frame, tela, "Informações para seguir usuário", JOptionPane.QUESTION_MESSAGE);
		String usuarioSeguir = campoUsuario.getText();
		
		if ((usuarioSeguir.length() > 0)){
			Acesso.RealizarAcesso();
		} else {
			RetornoErro.RetornarErro("Informações de atividade incompletas!");
		}
	}
	
	static void InformarHashtag() throws InterruptedException {
		JFrame frame = new JFrame();
		JPanel tela = new JPanel(new BorderLayout(5, 5));
		JPanel rotulo = new JPanel(new GridLayout(0, 1, 2, 2));
		rotulo.add(new JLabel("Hashtag para seguir: ", SwingConstants.LEFT));
		tela.add(rotulo, BorderLayout.WEST);
		JPanel controle = new JPanel(new GridLayout(0, 1, 2, 2));
		JTextField campoHashtag = new JTextField();
		controle.add(campoHashtag);
		tela.add(controle, BorderLayout.CENTER);
		JOptionPane.showMessageDialog(frame, tela, "Informações para seguir hashtag", JOptionPane.QUESTION_MESSAGE);
		String hashtagSeguir = campoHashtag.getText();
		
		if ((hashtagSeguir.length() > 0)){
			Acesso.RealizarAcesso();
		} else {
			RetornoErro.RetornarErro("Informações de atividade incompletas!");
		}
	}

}
