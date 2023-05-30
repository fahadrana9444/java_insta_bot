package br.com.fm.autogram;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Navegacao {

	private static void VoltarInicio() throws InterruptedException {
		String url = "https://www.instagram.com/";
		// Goto Url
		String tituloReferencia = "Instagram";
		String tituloNavegacao = "";
		ConfiguracaoSelenium.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		ConfiguracaoSelenium.driver.navigate().to(url);
		tituloNavegacao = ConfiguracaoSelenium.driver.getTitle();
		if (tituloNavegacao.contentEquals(tituloReferencia)) {
			System.out.println("Voltou à página inicial!");
		} else {
			RetornoErro.RetornarErro("Não foi possível voltar à página inicial!");
			System.out.println("Não foi possível voltar à página inicial!");
		}
	}

// running error
	
	static void SeguirUsuario(String usuarioSeguir) throws InterruptedException {
		String usuarios[] = usuarioSeguir.split(" ");
		for (int i = 0; i < usuarios.length; i++) {
			String usuario = usuarios[i];
			WebElement campoBusca = ConfiguracaoSelenium.driver.findElement(By.xpath("//input[@placeholder='Busca']"));
			Thread.sleep(1400);
			campoBusca.sendKeys("@" + usuario);
			Thread.sleep(3300);
			campoBusca.sendKeys(Keys.RETURN);
			Thread.sleep(3300);
			campoBusca.sendKeys(Keys.RETURN);
			Thread.sleep(3300);
			WebElement botaoSeguir = ConfiguracaoSelenium.driver.findElement(By.xpath("//button[contains(.,'Seguir')]"));
			Thread.sleep(1400);
			botaoSeguir.click();
			Thread.sleep(3300);
			VoltarInicio();
		}


	}

	static void SeguirUsuarioAleatorio(String usuarioSeguir) throws InterruptedException {

		Random aleatorio = new Random();
		String usuarios[] = usuarioSeguir.split(" ");
		int indiceAleatorio = aleatorio.nextInt(usuarios.length);
		String usuario = (usuarios[indiceAleatorio]);
		WebElement campoBusca = ConfiguracaoSelenium.driver.findElement(By.xpath("//input[@placeholder='Busca']"));
		Thread.sleep(1400);
		campoBusca.sendKeys("@" + usuario);
		Thread.sleep(3300);
		campoBusca.sendKeys(Keys.RETURN);
		Thread.sleep(3300);
		campoBusca.sendKeys(Keys.RETURN);
		Thread.sleep(3300);
		WebElement botaoSeguir = ConfiguracaoSelenium.driver.findElement(By.xpath("//button[contains(.,'Seguir')]"));
		Thread.sleep(1400);
		botaoSeguir.click();
		Thread.sleep(3300);
		VoltarInicio();
	}
	
	static void SeguirUsuarioURL(String usuarioSeguir) throws InterruptedException {
		String usuarios[] = usuarioSeguir.split(" ");
		for (int i = 0; i < usuarios.length; i++) {
			String usuario = usuarios[i];
			String url = "https://www.instagram.com/"+usuario;
			ConfiguracaoSelenium.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			ConfiguracaoSelenium.driver.navigate().to(url);
			Thread.sleep(3300);
			WebElement botaoSeguir = ConfiguracaoSelenium.driver.findElement(By.xpath("//button[contains(.,'Seguir')]"));
			Thread.sleep(1400);
			botaoSeguir.click();
			Thread.sleep(3300);
			System.out.println("Seguiu o usuário: "+usuario+"!");
			Thread.sleep(1400);
			VoltarInicio();
		}
	}

	static void SeguirHashtag(String hashtagSeguir) throws InterruptedException {
		String hashtags[] = hashtagSeguir.split(" ");
		for (int i = 0; i < hashtags.length; i++) {
			String hashtag = hashtags[i];
			WebElement campoBusca = ConfiguracaoSelenium.driver.findElement(By.xpath("//input[@placeholder='Busca']"));
			Thread.sleep(1400);
			campoBusca.sendKeys("#" + hashtag);
			Thread.sleep(3300);
			campoBusca.sendKeys(Keys.RETURN);
			Thread.sleep(3300);
			campoBusca.sendKeys(Keys.RETURN);
			Thread.sleep(3300);
			WebElement botaoSeguir = ConfiguracaoSelenium.driver.findElement(By.xpath("//button[contains(.,'Seguir')]"));
			Thread.sleep(1400);
			botaoSeguir.click();
			Thread.sleep(3300);
			VoltarInicio();
		}
	}

	static void SeguirHashtagAleatoria(String hashtagSeguir) throws InterruptedException {
		Random aleatorio = new Random();
		String hashtags[] = hashtagSeguir.split(" ");
		int indiceAleatorio = aleatorio.nextInt(hashtags.length);
		String hashtag = (hashtags[indiceAleatorio]);
		WebElement campoBusca = ConfiguracaoSelenium.driver.findElement(By.xpath("//input[@placeholder='Busca']"));
		Thread.sleep(1400);
		campoBusca.sendKeys("#" + hashtag);
		Thread.sleep(3300);
		campoBusca.sendKeys(Keys.RETURN);
		Thread.sleep(3300);
		campoBusca.sendKeys(Keys.RETURN);
		Thread.sleep(3300);
		WebElement botaoSeguir = ConfiguracaoSelenium.driver.findElement(By.xpath("//button[contains(.,'Seguir')]"));
		Thread.sleep(1400);
		botaoSeguir.click();
		Thread.sleep(3300);
		VoltarInicio();
	}

}
