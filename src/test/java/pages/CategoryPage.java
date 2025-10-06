package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CategoryPage {

    private final Page page;

    public CategoryPage(Page page) {
        this.page = page;
    }


    public void speakerOption() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("SpeakersCategory").setExact(true)).click();
        Locator speakerOptionIBtn = page.getByText("Bose Soundlink Bluetooth Speaker III");
        speakerOptionIBtn.waitFor();
        speakerOptionIBtn.scrollIntoViewIfNeeded();
        speakerOptionIBtn.click();
    }


}
