package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.LocatorOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

public class CheckoutPage {

    private final Page page;
    public CheckoutPage(Page page) {
        this.page = page;
    }


    public void setNextBtn () {
        //page.locator("#next_btn:not([disabled])").click();
        page.locator("#next_btn:enabled").first().click();

    }

    public boolean getNewUser() {
        page.locator("text=New user?").waitFor();
        return page.getByText("New user?").isVisible();
    }

    public boolean CreateAccountMessage () {
        return page.getByText("Create your account to track your order").isVisible();
    }

    public void loginDuringCheckout(String username, String password) {
        page.fill("input[name='usernameInOrderPayment']", username);
        page.fill("input[name='passwordInOrderPayment']", password);
        page.click("#login_btnundefined");
        page.waitForSelector("text=Order Payment");
    }





}
