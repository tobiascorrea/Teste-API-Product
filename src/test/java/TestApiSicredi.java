import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestApiSicredi {

    @BeforeEach
    public void setUp() {
        authPage = new AuthPage();
        String username = System.getenv("API_USERNAME");
        String password = System.getenv("API_PASSWORD");
        authPage.login(username, password);
        productsPage = new ProductsPage(authPage.getAuthToken());
    }

    private static AuthPage authPage;
    private static ProductsPage productsPage;

    @Test
    public void CheckApiStatus() {

        authPage.checkApiStatus();
    }

    @Test
    public void SearchUserForAuthentication() {

        authPage.searchUsersForAuthentication();
    }

    @Test
    public void TestLoginAndValidateResponse() throws JsonProcessingException {
        String username = System.getenv("API_USERNAME");
        String password = System.getenv("API_PASSWORD");
        authPage.login(username, password);
    }

    @Test
    public void TestInvalidCredentials() {

        authPage.testInvalidCredentials();
    }

    @Test
    public void TestGetProducts() throws JsonProcessingException {
        String username = System.getenv("API_USERNAME");
        String password = System.getenv("API_PASSWORD");
        authPage.login(username, password);
        assertNotNull(authPage.getAuthToken());
        productsPage.getProductDetails();
    }

    @Test
    public void TestGetProductInvalidToken() {

        productsPage.getProductWithInvalidToken();
    }

    @Test
    public void TestAddProduct() {

        productsPage.addProduct();
    }

    @Test
    public void TestGetAllProducts() {

        productsPage.getAllProducts();
    }

    @Test
    public void TestGetProductByIdInRange() {

        productsPage.getProductByIdInRange();
    }
}
