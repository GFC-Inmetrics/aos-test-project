package userApi;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class UserRegistered {

    private UserRegistered userRegistered;

    private Page page;

    public UserRegistered(Page page) {
        this.page = page;
    }

    private final String deleteUserBtn = "button:has-text('Delete Account')";

    public void setDeleteUserBtn() {
        page.locator(deleteUserBtn).click();
    }




    public void confirmationDeleteUserBtn() {
        page.getByText("YES").click();
    }

    public String accountType = "USER";
    public String address;
    public boolean allowOffersPromotion = true;
    public boolean aobUser = true;
    public String cityName;
    public String country = "AUSTRALIA_AU";
    public String email;
    public String firstName;
    public String lastName;
    public String loginName;
    public String password;
    public String phoneNumber;
    public String stateProvince;
    public String zipcode;

    // Construtor
    public UserRegistered(String loginName, String password, String email, String firstName, String lastName) {
        this.loginName = loginName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = "123 Test St";
        this.cityName = "Test City";
        this.phoneNumber = "999999999";
        this.stateProvince = "Test State";
        this.zipcode = "000000";
    }
}