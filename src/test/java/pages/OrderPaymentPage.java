package pages;

import com.microsoft.playwright.Page;

public class OrderPaymentPage {

    private final Page page;

    public OrderPaymentPage(Page page) {
        this.page = page;
    }

    private final String methodPaymentBtn = "[name='safepay']";
    private final String payNowBtn = "#pay_now_btn_SAFEPAY";
    private final String trackingNumberLabel = "#trackingNumberLabel";
    private final String newUserBtn = "#registration_btn";
    private final String safePayUsernameField = "[name='safepay_username']";
    private final String safePayPasswordField = "[name='safepay_password']";

    public void setPayNowBtn(){
        page.locator(payNowBtn).click();
    }

    public void setMethodPaymentBtn() {
        page.locator(methodPaymentBtn).click();
    }
    public void setNewUserBtn(){ page.locator(newUserBtn).click(); }

    public boolean setTrackingNumberLabel(){
        page.locator(trackingNumberLabel).waitFor();
        return page.getByTestId("#trackingNumberLabel").isVisible();
    }

    public void setSafePayUsernameField(){
            page.locator(safePayUsernameField).fill("teste");
            page.locator(safePayPasswordField).fill("Teste@123");
            page.locator(payNowBtn).click();
        }
    }





