package steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import loginApi.LoginPage;
import org.junit.Before;
import pages.*;
import userApi.UserRegistered;
import utils.PlaywrightFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;



public class CheckOutSteps {


    private HomePage homePage;
    private ProductPage productPage;
    private CategoryPage categoryPage;
    private CheckoutPage checkoutPage;
    private OrderPaymentPage orderPaymentPage;
    private UserRegistered userRegistered;

    private String login;
    private String senha;
    private String email;

    /*public void beforeTests() {
        HomePage homePage = new HomePage(PlaywrightFactory.getPage());
        }
*/

    public CheckOutSteps() {
        var page = PlaywrightFactory.getPage();
        this.homePage = new HomePage(page);
        this.productPage = new ProductPage(page);
        this.categoryPage = new CategoryPage(page);
        this.checkoutPage = new CheckoutPage(page);
        this.orderPaymentPage = new OrderPaymentPage(page);
        this.userRegistered = new UserRegistered(page);
    }

    @Before
    public void setupUser() {
        // Gerar dados dinâmicos para evitar conflitos
        long timestamp = System.currentTimeMillis();
        login = "user" + timestamp;
        senha = "Senha@123";
        email = login + "@email.com";

        // Criar usuário via API
        UserRegistered user = new UserRegistered(login, senha, email, "Test", "User");
        LoginPage.registerUser(user);
    }

    @Given("que estou na página Home do site Advantage Online Shopping")
    public void queEstouNaPaginaHomeDoSiteAdvantageOnlineShopping() {
        homePage.homePageValidation();
    }

    @Given("que estou na página Home do site Advantage Online Shopping com login realizado {string}, {string}")
    public void queEstouNaPáginaHomeDoSiteAdvantageOnlineShoppingComLoginRealizado(String user, String password) {
        homePage.loginUserBtn();
        homePage.loginUserProccess(user, password);
    }

    @When("adiciono um produto ao carrinho de vendas")
    public void adicionarProdutoAoCarrinhoDeVendas() {
        categoryPage.speakerOption();
    }

    @When("seleciono um produto ao carrinho de vendas")
    public void selecionoUmProdutoAoCarrinhoDeVendas() {
        categoryPage.speakerOption();
    }

    @And("executo o processo de checkout")
    public void executoOProcessoDeCheckout() {
        productPage.setAddToCartBtn();
        productPage.setProductInCart();
        productPage.setCheckout();
    }

    @And("realizo o processo de checkout")
    public void realizoOProcessoDeCheckout() {
        productPage.setProductInCart();
        productPage.registerCheckoutBtn();
        checkoutPage.setNextBtn();
        orderPaymentPage.setSafePayUsernameField();
        orderPaymentPage.setMethodPaymentBtn();
        orderPaymentPage.setTrackingNumberLabel();
      //  orderPaymentPage.setPayNowBtn();
    }

    @And("realizo o checkout")
    public void realizoOCheckout() {
        productPage.setAddToCartBtn();
        productPage.setProductInCart();
        productPage.registerCheckoutBtn();
        checkoutPage.setNextBtn();
        orderPaymentPage.setMethodPaymentBtn();
        orderPaymentPage.setPayNowBtn();
    }

    @And("realizo cadastro do meu usuário com {string}, {string}, {string}, {string}, {string}")
    public void realizoOProcessoDeCheckout(String login, String senha, String email, String nome, String sobrenome) {
        // Salvar para uso posterior
        this.login = login;
        this.senha = senha;
        UserRegistered user = new UserRegistered(login, senha, email, nome, sobrenome);
        LoginPage.registerUser(user);
    }

    @And("inicio o processo de pagamento")
    public void inicioOProcessoDePagamento() {
        productPage.setAddToCartBtn();
        productPage.setProductInCart();
        productPage.setCheckout();
        orderPaymentPage.setNewUserBtn();
    }


    @Then("solicitação de cadastro e login são exibidas em tela")
    public void solicitaçãoDeCadastroELoginSaoExibidasEmTela() {
        checkoutPage.getNewUser();
        assertTrue(checkoutPage.getNewUser(), "O texto 'New user?' não está visível na tela!");
        checkoutPage.CreateAccountMessage();
        assertTrue(checkoutPage.CreateAccountMessage(), "O texto: 'Create your account' não está visível na tela!");
    }

    @Then("o pagamento é concluído")
    public void oPagamentoÉConcluído() {
        orderPaymentPage.setTrackingNumberLabel();
    }

    @Then("o pagamento é concluído e Ordem de pedido é gerada")
    public void oPagamentoÉConcluidoEOrdemDePedido() {
        orderPaymentPage.setTrackingNumberLabel();
        homePage.loginUserBtn();
        homePage.setMyAccountBtn();
        userRegistered.setDeleteUserBtn();
        userRegistered.confirmationDeleteUserBtn();
    }

    @And("realizo login com usuário gerado via api {string}, {string}")
    public void realizoLoginComUsuárioGeradoViaApi(String login, String senha) {
        homePage.loginUserBtn();
        homePage.loginUserProccess(login, senha);
    }
}












