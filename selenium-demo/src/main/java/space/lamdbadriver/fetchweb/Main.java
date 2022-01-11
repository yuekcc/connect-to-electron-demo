package space.lamdbadriver.fetchweb;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    static String getChromeBinaryPath() throws IOException {
        return Files.readString(Path.of("path.txt")).trim();
    }

    public static void main(String[] args) {
        try {
            var chromeOptions = new ChromeOptions();
            chromeOptions.setBinary(getChromeBinaryPath());
            chromeOptions.addArguments("--disable-gpu", "--no-sandbox");

            var cap = new DesiredCapabilities();
            cap.setCapability("goog:chromeOptions", chromeOptions);
            cap.setBrowserName("chrome");

            var driver = new RemoteWebDriver(new URL("http://localhost:9515"), cap);
            driver.get("https://www.baidu.com");
            System.out.println("page title: " + driver.getTitle());

            var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Files.write(Path.of("screenshot.png"), screenshot);


            driver.quit();
        } catch (Exception e) {
            System.out.println("SYSTEM ERROR: " + e);
        }
    }
}
