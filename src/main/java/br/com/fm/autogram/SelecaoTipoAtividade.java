package br.com.fm.autogram;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SelecaoTipoAtividade extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public class BotaoSelecaoAtividade extends JFrame {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JRadioButton opcaoAleatoriamente, opcaoTodos;
		private JLabel rotulo;
		private ManipuladorSelecaoTipoAtividade manipulador;

		public BotaoSelecaoAtividade() {
			super("Selecionar tipo de atividade");
			setLayout(new FlowLayout());
			manipulador = new ManipuladorSelecaoTipoAtividade();

			rotulo = new JLabel("Como deseja seguir?");
			opcaoAleatoriamente = new JRadioButton("Aleatoriamente", false);
			opcaoTodos = new JRadioButton("Todos", false);

			add(rotulo);
			add(opcaoAleatoriamente);
			add(opcaoTodos);

			opcaoAleatoriamente.addItemListener(manipulador);
			opcaoTodos.addItemListener(manipulador);
		}

		private class ManipuladorSelecaoTipoAtividade implements ItemListener {

			public void itemStateChanged(ItemEvent event) {
				if (opcaoAleatoriamente.isSelected())
					JOptionPane.showMessageDialog(null, "Parabéns, você é o cara");
				if (opcaoTodos.isSelected())
					JOptionPane.showMessageDialog(null, "Sabe de nada, inocente!");
			}

		}

	}
}
