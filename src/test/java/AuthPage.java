import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AuthPage {
    private String authToken;
    private ObjectMapper objectMapper;

    public AuthPage() {
        RestAssured.baseURI = "https://dummyjson.com";
        objectMapper = new ObjectMapper();
    }

    public void login(String username, String password) {
        String requestBody = "{\n" +
                "    \"username\": \"" + username + "\",\n" +
                "    \"password\": \"" + password + "\"\n" +
                "}";

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Model apiResponse = response.as(Model.class);
        authToken = apiResponse.getToken();
    }


    public String getAuthToken() {
        return authToken;
    }

    public void checkApiStatus() {
    }

    public void searchUsersForAuthentication() {
    }

    public void testInvalidCredentials() {
    }
}
