package tim.QAWorks.com.qa.works.com.page;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class shareDriver extends EventFiringWebDriver {

	private static WebDriver REAL_DRIVER;
	private static Thread CLOSE_THREAD = new Thread() {
		@Override
		public void run() {
			REAL_DRIVER.quit();
		}
	};

	static {
		REAL_DRIVER = new FirefoxDriver();
		REAL_DRIVER.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		REAL_DRIVER.manage().window().maximize();
		Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
	}

	public shareDriver() {
		super(REAL_DRIVER);

	}

	@Override
	public void close() {
		if (Thread.currentThread() != CLOSE_THREAD) {
			throw new UnsupportedOperationException(
					"You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
		}
		super.close();
	}
}
