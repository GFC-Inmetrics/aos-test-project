package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {

    private final Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    private final String quantityAddBtn = "(e-sec-plus-minus div).nth(3)";
    private final String quantityDscBtn = "(e-sec-plus-minus div).nth(1)";
    private final String addToCartBtn = "button[name='save_to_cart']";
    private final String cartBtn = "#menuCart";
    private final String cartEmptyMsg = "[name='Your cart is empty']";
    private final String continueShoppingBtn = "button:has-text('CONTINUE SHOPPING')";
    private final String checkOutBtn = "#checkOutButton";


    public void setQuantityAddBtn() {
        page.click(quantityAddBtn);
    }
    public void setQuantityDscBtn() {
        page.click(quantityDscBtn);
    }
    public void setAddToCartBtn() {
        page.click(addToCartBtn);
    }
    public void setCheckout() {
        page.locator(addToCartBtn).waitFor(); // espera o botão estar disponível
        page.locator(addToCartBtn).click();
        page.locator(checkOutBtn).click();
    }

    public void registerCheckoutBtn(){
        page.click(checkOutBtn);
    }

    public void setProductInCart(){
        page.waitForSelector(cartBtn);
        page.locator(cartBtn).click();
        if (page.isVisible(cartEmptyMsg)) {
            page.click(continueShoppingBtn);
        }
    }
}
