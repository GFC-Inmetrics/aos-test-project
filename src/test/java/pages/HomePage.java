package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {

    private final Page page;

    private final String speakerCategoryBtn = "page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName('SpeakersCategory').setExact(true))";
    private final String headphonesCategoryBtn = "page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName('HeadphonesCategory').setExact(true))";
    private final String laptopsCategoryBtn = "page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName('LaptopsCategory').setExact(true))";
    private final String miceCategoryBtn = "page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName('MiceCategory').setExact(true))";
    private final String usernameField = "input[name='username']";
    private final String passwordField = "input[name='password']";
    private final String loginBtn = "button:has-text('SIGN IN')";
    private final String OurProductsBtn = "button:has-text('OUR PRODUCTS')";
    private final String myAccountBtn = "button:has-text('My account')";


    public HomePage(Page page) {
        this.page = page;
    }

    public void homePageValidation(){
        page.isVisible(OurProductsBtn);
    }

    public void loginUserBtn() {
    page.locator("#menuUserSVGPath").click();
    }

    /*public void setMyAccountBtn(){
    page.locator(myAccountBtn).click();
    }     */

    public void setMyAccountBtn() {
        page.getByText("My account").nth(1).click();
    }

    public void loginUserProccess (String username, String password) {
        page.locator(usernameField).fill(username);
        page.locator(passwordField).fill(password);
        page.locator(loginBtn).click();
    }





    public void tabletOption() {

    }

    public void headphonesOption() {
        page.click(headphonesCategoryBtn);
    }

    public void laptopsOption() {
        page.click(laptopsCategoryBtn);
    }

    public void miceOption() {
        page.click(miceCategoryBtn);
    }

}

