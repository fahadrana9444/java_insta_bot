package br.com.fm.autogram;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Acesso {
	
	static String usuarioAcesso;
	static String senhaAcesso;
	
	static void ColetarInformacoesAcesso() throws InterruptedException {
		JFrame frame = new JFrame();
		JPanel tela = new JPanel(new BorderLayout(5, 5));
		JPanel rotulo = new JPanel(new GridLayout(0, 1, 2, 2));
		rotulo.add(new JLabel("Usuário do Instagram: ", SwingConstants.LEFT));
		rotulo.add(new JLabel("Senha do Instagram: ", SwingConstants.LEFT));
		tela.add(rotulo, BorderLayout.WEST);
		JPanel controle = new JPanel(new GridLayout(0, 1, 2, 2));
		JTextField campoUsuario = new JTextField();
		controle.add(campoUsuario);
		JPasswordField campoSenha = new JPasswordField();
		controle.add(campoSenha);
		tela.add(controle, BorderLayout.CENTER);
		JOptionPane.showMessageDialog(frame, tela, "Informações de acesso", JOptionPane.QUESTION_MESSAGE);
		usuarioAcesso = campoUsuario.getText();
		senhaAcesso = String.valueOf(campoSenha.getPassword());
		
	}
	
	static void RealizarAcesso() throws InterruptedException {
		ConfiguracaoSelenium.ConfigurarDriver();
		String url = "https://www.instagram.com/accounts/login/?source=auth_switcher";
		String tituloReferencia = "Entrar • Instagram";
		String tituloNavegacao = "";
		ConfiguracaoSelenium.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		ConfiguracaoSelenium.driver.navigate().to(url);
		tituloNavegacao = ConfiguracaoSelenium.driver.getTitle();
		if (tituloNavegacao.contentEquals(tituloReferencia)) {
			System.out.println("Página do Instagram acessada com sucesso!");
			WebElement campoUsuario = ConfiguracaoSelenium.driver.findElement(By.name("username"));
			campoUsuario.sendKeys(usuarioAcesso);
			Thread.sleep(1400);
			WebElement campoSenha = ConfiguracaoSelenium.driver.findElement(By.name("password"));
			campoSenha.sendKeys(senhaAcesso);
			WebElement botaoEntrar = ConfiguracaoSelenium.driver.findElement(By.xpath("//*[text() = 'Entrar']"));
			Thread.sleep(1400);
			botaoEntrar.click();
			WebElement botaoAgoraNao = ConfiguracaoSelenium.driver.findElement(By.xpath("//*[text() = 'Agora não']"));
			Thread.sleep(3300);
			botaoAgoraNao.click();
			Thread.sleep(3300);
		}
	}
}
