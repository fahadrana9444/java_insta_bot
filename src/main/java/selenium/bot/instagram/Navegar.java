package selenium.bot.instagram;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Navegar {
	private static WebDriver driver;
	private static String usuarioAcesso;
	private static String senhaAcesso;
	private static String usuarioSeguir;
	private static String usuarioAleatorio;
	private static String hashtagSeguir;
	private static String hashtagAleatoria;

	private static void ColetarInformacoesLogin() {
		JFrame frame = new JFrame();
		JPanel tela = new JPanel(new BorderLayout(5, 5));
		JPanel rotulo = new JPanel(new GridLayout(0, 1, 2, 2));
		rotulo.add(new JLabel("Usuário do Instagram: ", SwingConstants.LEFT));
		rotulo.add(new JLabel("Senha do Instagram: ", SwingConstants.LEFT));
		rotulo.add(new JLabel("Usuários para seguir: ", SwingConstants.LEFT));
		rotulo.add(new JLabel("Hashtags para seguir:", SwingConstants.LEFT));
		tela.add(rotulo, BorderLayout.WEST);
		JPanel controle = new JPanel(new GridLayout(0, 1, 2, 2));
		JTextField campoUsuario = new JTextField();
		controle.add(campoUsuario);
		JPasswordField campoSenha = new JPasswordField();
		controle.add(campoSenha);
		JTextField campoUsuarioSeguir = new JTextField();
		controle.add(campoUsuarioSeguir);
		JTextField campoHashtagSeguir = new JTextField();
		controle.add(campoHashtagSeguir);
		tela.add(controle, BorderLayout.CENTER);
		JOptionPane.showMessageDialog(frame, tela, "Informações de acesso", JOptionPane.QUESTION_MESSAGE);
		usuarioAcesso = campoUsuario.getText();
		senhaAcesso = String.valueOf(campoSenha.getPassword());
		usuarioSeguir = String.valueOf(campoUsuarioSeguir.getText());
		hashtagSeguir = String.valueOf(campoHashtagSeguir.getText());
	}

	private static void RetornarErro(String mensagemErro) {
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

	private static WebDriver RealizarLogin() throws InterruptedException {
		File arquivoDriver = new File("C:/Autogram/driver.exe");
		File arquivoLog = new File("C:/Autogram/autogram.log");
		arquivoLog.mkdirs();
		System.setProperty("webdriver.gecko.driver", arquivoDriver.getAbsolutePath());
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, arquivoLog.getAbsolutePath());
		LoggingPreferences pref = new LoggingPreferences();
		pref.enable(LogType.BROWSER, Level.FINEST);
		pref.enable(LogType.CLIENT, Level.FINEST);
		pref.enable(LogType.DRIVER, Level.FINEST);
		pref.enable(LogType.PERFORMANCE, Level.FINEST);
		pref.enable(LogType.PROFILER, Level.FINEST);
		pref.enable(LogType.SERVER, Level.FINEST);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, pref);
		FirefoxOptions options = new FirefoxOptions(capabilities);
		options.setLogLevel(FirefoxDriverLogLevel.TRACE);
		WebDriver driver = new FirefoxDriver(options);
		String url = "https://www.instagram.com/accounts/login/?source=auth_switcher";
		String tituloReferencia = "Entrar • Instagram";
		String tituloNavegacao = "";
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to(url);
		tituloNavegacao = driver.getTitle();
		if (tituloNavegacao.contentEquals(tituloReferencia)) {
			System.out.println("Página do Instagram acessada com sucesso!");
			WebElement campoUsuario = driver.findElement(By.name("username"));
			campoUsuario.sendKeys(usuarioAcesso);
			Thread.sleep(700);
			WebElement campoSenha = driver.findElement(By.name("password"));
			campoSenha.sendKeys(senhaAcesso);
			WebElement botaoEntrar = driver.findElement(By.xpath("//*[text() = 'Entrar']"));
			Thread.sleep(700);
			botaoEntrar.click();
			WebElement botaoAgoraNao = driver.findElement(By.xpath("//*[text() = 'Agora não']"));
			Thread.sleep(2100);
			botaoAgoraNao.click();
			Thread.sleep(2100);
		}
		return driver;
	}

	private static void VoltarInicio(WebDriver driver) throws InterruptedException {
		String url = "https://www.instagram.com/";
		String tituloReferencia = "Instagram";
		String tituloNavegacao = "";
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to(url);
		tituloNavegacao = driver.getTitle();
		if (tituloNavegacao.contentEquals(tituloReferencia)) {
			System.out.println("Voltou à página inicial!");
		} else {
			RetornarErro("Não foi possível voltar à página inicial!");
			System.out.println("Não foi possível voltar à página inicial!");
		}
	}

	private static void SeguirUsuario(WebDriver driver) throws InterruptedException {
		String usuarios[] = usuarioSeguir.split(" ");
		for (int i = 0; i < usuarios.length; i++) {
			String usuario = usuarios[i];
			WebElement campoBusca = driver.findElement(By.xpath("//input[@placeholder='Busca']"));
			Thread.sleep(700);
			campoBusca.sendKeys("@" + usuario);
			Thread.sleep(2100);
			campoBusca.sendKeys(Keys.RETURN);
			Thread.sleep(2100);
			campoBusca.sendKeys(Keys.RETURN);
			Thread.sleep(2100);
			WebElement botaoSeguir = driver.findElement(By.xpath("//button[contains(.,'Seguir')]"));
			Thread.sleep(700);
			botaoSeguir.click();
			Thread.sleep(2100);
			VoltarInicio(driver);
		}
	}

	private static void SeguirUsuarioAleatorio(WebDriver driver) throws InterruptedException {

		Random aleatorio = new Random();
		String usuarios[] = usuarioSeguir.split(" ");
		int indiceAleatorio = aleatorio.nextInt(usuarios.length);
		String usuario = (usuarios[indiceAleatorio]);
		WebElement campoBusca = driver.findElement(By.xpath("//input[@placeholder='Busca']"));
		Thread.sleep(700);
		campoBusca.sendKeys("@" + usuario);
		Thread.sleep(2100);
		campoBusca.sendKeys(Keys.RETURN);
		Thread.sleep(2100);
		campoBusca.sendKeys(Keys.RETURN);
		Thread.sleep(2100);
		WebElement botaoSeguir = driver.findElement(By.xpath("//button[contains(.,'Seguir')]"));
		Thread.sleep(700);
		botaoSeguir.click();
		Thread.sleep(2100);
		VoltarInicio(driver);
	}

	private static void SeguirHashtag(WebDriver driver) throws InterruptedException {
		String hashtags[] = hashtagSeguir.split(" ");
		for (int i = 0; i < hashtags.length; i++) {
			String hashtag = hashtags[i];
			WebElement campoBusca = driver.findElement(By.xpath("//input[@placeholder='Busca']"));
			Thread.sleep(700);
			campoBusca.sendKeys("#" + hashtag);
			Thread.sleep(2100);
			campoBusca.sendKeys(Keys.RETURN);
			Thread.sleep(2100);
			campoBusca.sendKeys(Keys.RETURN);
			Thread.sleep(2100);
			WebElement botaoSeguir = driver.findElement(By.xpath("//button[contains(.,'Seguir')]"));
			Thread.sleep(700);
			botaoSeguir.click();
			Thread.sleep(2100);
			VoltarInicio(driver);
		}
	}

	private static void SeguirHashtagAleatoria(WebDriver driver) throws InterruptedException {
		Random aleatorio = new Random();
		String hashtags[] = hashtagSeguir.split(" ");
		int indiceAleatorio = aleatorio.nextInt(hashtags.length);
		String hashtag = (hashtags[indiceAleatorio]);
		WebElement campoBusca = driver.findElement(By.xpath("//input[@placeholder='Busca']"));
		Thread.sleep(700);
		campoBusca.sendKeys("#" + hashtag);
		Thread.sleep(2100);
		campoBusca.sendKeys(Keys.RETURN);
		Thread.sleep(2100);
		campoBusca.sendKeys(Keys.RETURN);
		Thread.sleep(2100);
		WebElement botaoSeguir = driver.findElement(By.xpath("//button[contains(.,'Seguir')]"));
		Thread.sleep(700);
		botaoSeguir.click();
		Thread.sleep(2100);
		VoltarInicio(driver);
	}

	public static void main(String[] args) throws InterruptedException {
//		usuarioAcesso = args[0];
//		senhaAcesso = args[1];
//		usuarioSeguir = args[2];
//		usuarioAleatorio = args[3];
//		hashtagSeguir = args[4];
//		hashtagAleatoria = args[5];
		ColetarInformacoesLogin();
		if ((usuarioAcesso.length() > 0) && (senhaAcesso.length() > 0)) {
			driver = RealizarLogin();
			if (usuarioSeguir.length() > 0) {

				if (usuarioAleatorio.length() == 0) {
					SeguirUsuarioAleatorio(driver);
				} else {
					SeguirUsuario(driver);
				}
			} else {
				RetornarErro("Sem usuário para seguir!");
			}
			if (hashtagSeguir.length() > 0) {
				if (hashtagAleatoria.length() > 0) {
					SeguirHashtagAleatoria(driver);
				} else {
					SeguirHashtag(driver);
				}
				VoltarInicio(driver);
			} else {
				RetornarErro("Sem usuário para seguir!");
			}
		} else {
			RetornarErro("Informações de acesso incompletas!");
		}

	}
}
