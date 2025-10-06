package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.*;

public class PlaywrightFactory {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;


    public static Page getPage() {
        if (page == null) {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            context = browser.newContext();
            page = context.newPage();
            page.navigate("https://advantageonlineshopping.com/");
        }
        return page;
    }
    public static void close() {
        if (playwright != null) {
            playwright.close();
            playwright = null;
            browser = null;
            context = null;
            page = null;
        }
    }
}






