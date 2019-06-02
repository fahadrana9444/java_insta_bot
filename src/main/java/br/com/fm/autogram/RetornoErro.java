package br.com.fm.autogram;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RetornoErro {
	static void RetornarErro(String mensagemErro) {
		JFrame frame = new JFrame();
		JPanel tela = new JPanel(new BorderLayout(5, 5));
		JPanel rotulo = new JPanel(new GridLayout(0, 1, 2, 2));
		rotulo.add(new JLabel("Erro de execução", SwingConstants.CENTER));
		rotulo.add(new JLabel("--- " + mensagemErro + " ---", SwingConstants.CENTER));
		tela.add(rotulo, BorderLayout.WEST);
		JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
		tela.add(controls, BorderLayout.CENTER);
		JOptionPane.showMessageDialog(frame, tela, "Atenção ! ! !", JOptionPane.QUESTION_MESSAGE);
	}
}
