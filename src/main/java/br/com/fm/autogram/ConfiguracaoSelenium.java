package br.com.fm.autogram;

import java.io.File;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ConfiguracaoSelenium {
	static WebDriver driver;
	
	static void ConfigurarDriver() {
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
		options.addArguments("--headless");
		driver = new FirefoxDriver(options);
	}
}
