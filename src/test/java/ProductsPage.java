import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class ProductsPage {
    private final String authToken;

    public ProductsPage(String authToken) {
        this.authToken = authToken;
    }

    public void getProductDetails() {
        given()
                .header("Authorization", "Bearer " + authToken)
                .when()
                .get("/auth/products")
                .then()
                .statusCode(200)
                .body("products[0].id", notNullValue())
                .body("products[0].title", notNullValue())
                .body("products[0].description", notNullValue())
                .body("products[0].price", notNullValue())
                .body("products[0].discountPercentage", notNullValue())
                .body("products[0].rating", notNullValue())
                .body("products[0].stock", notNullValue())
                .body("products[0].brand", notNullValue())
                .body("products[0].category", notNullValue())
                .body("products[0].thumbnail", notNullValue())
                .body("products[0].images", notNullValue())
                .body("products[0]", isA(Object.class));
    }

    public void getProductWithInvalidToken() {
        given()
                .header("Authorization", "Bearer invalid_token_here")
                .when()
                .get("/auth/products")
                .then()
                .statusCode(401) // Verifica o status code 401
                .body("name", equalTo("JsonWebTokenError"))
                .body("message", equalTo("Invalid/Expired Token!"));
    }

    public void addProduct() {
            String requestBodyJson = "{"
                    + "\"title\": \"Test Add Product\","
                    + "\"description\": \"Mega Discount, Impression of A...\","
                    + "\"price\": 13,"
                    + "\"discountPercentage\": 8.4,"
                    + "\"rating\": 4.26,"
                    + "\"stock\": 65,"
                    + "\"brand\": \"Impression of Acqua Di Gio\","
                    + "\"category\": \"fragrances\","
                    + "\"thumbnail\": \"https://i.dummyjson.com/data/products/11/thumbnail.jpg\""
                    + "}";

            given()
                    .header("Content-Type", "application/json")
                    .body(requestBodyJson)
                    .when()
                    .post("/products/add")
                    .then()
                    .statusCode(200)
                    .body("id", isA(Integer.class))
                    .body("title", isA(String.class))
                    .body("price", isA(Integer.class))
                    .body("stock", isA(Integer.class))
                    .body("rating", isA(Float.class))
                    .body("thumbnail", isA(String.class))
                    .body("description", isA(String.class))
                    .body("brand", isA(String.class))
                    .body("category", isA(String.class));
        }


    public void getAllProducts() {
        given()
                .header("Authorization", "Bearer " + authToken)
                .when()
                .get("/auth/products")
                .then()
                .statusCode(200)
                .body("products", isA(List.class))
                .body("products.size()", greaterThan(0));
    }

    public void getProductByIdInRange() {
        int productId = (int) (Math.random() * 30) + 1;

        Response response = given()
                .pathParam("productId", productId)
                .when()
                .get("/products/{productId}")
                .then()
                .statusCode(200)
                .extract()
                .response();
        response.then()
                .body("id", isA(Integer.class))
                .body("title", isA(String.class))
                .body("description", isA(String.class))
                .body("price", isA(Integer.class))
                .body("discountPercentage", isA(Float.class))
                .body("rating", isA(Float.class))
                .body("stock", isA(Integer.class))
                .body("brand", isA(String.class))
                .body("category", isA(String.class))
                .body("thumbnail", isA(String.class))
                .body("images", isA(List.class))
                .body("images.size()", greaterThan(0));
    }
}
