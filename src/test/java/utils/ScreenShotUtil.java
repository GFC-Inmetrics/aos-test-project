package utils;

import com.microsoft.playwright.Page;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenShotUtil {

    public static void captureScreenshot(String scenarioName) {
        try {
            Page page = PlaywrightFactory.getPage();

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";

            // Força o caminho para "target/evidencias" a partir da raiz do projeto
            String projectRoot = System.getProperty("user.dir");
            Path evidenceDir = Paths.get(projectRoot, "target", "evidencias");

            Files.createDirectories(evidenceDir); // Cria diretórios, se não existirem

            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(evidenceDir.resolve(fileName))
                    .setFullPage(true));

            System.out.println(" Screenshot salvo: " + evidenceDir.resolve(fileName));

        } catch (Exception e) {
            System.out.println(" Erro ao capturar screenshot: " + e.getMessage());
        }
    }
}