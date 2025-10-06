package loginApi;

import io.restassured.response.Response;
import userApi.UserRegistered;

import static io.restassured.RestAssured.given;
import static java.util.concurrent.CompletableFuture.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.anyOf;



public class LoginPage {

    public static void registerUser(UserRegistered user) {
        String jsonBody = String.format("""
            {
              "accountType": "USER",
              "address": "%s",
              "allowOffersPromotion": %s,
              "aobUser": %s,
              "cityName": "%s",
              "country": "%s",
              "email": "%s",
              "firstName": "%s",
              "lastName": "%s",
              "loginName": "%s",
              "password": "%s",
              "phoneNumber": "%s",
              "stateProvince": "%s",
              "zipcode": "%s"
            }
            """,
                user.address,
                user.allowOffersPromotion,
                user.aobUser,
                user.cityName,
                user.country,
                user.email,
                user.firstName,
                user.lastName,
                user.loginName,
                user.password,
                user.phoneNumber,
                user.stateProvince,
                user.zipcode
        );

        Response response = given()
                .baseUri("https://www.advantageonlineshopping.com")
                .basePath("/accountservice/accountrest/api/v1/register")
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .post()
                .then()
                .statusCode(anyOf(equalTo(200), equalTo(201))) // depende da resposta da API
                .log().all()
                .extract().response();

        System.out.println("Resposta da criação de usuário: " + response.asString());
    }
}
