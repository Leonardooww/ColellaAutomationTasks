import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Epic("API Tests")
@Feature("Posts API")
public class PostsApiTest {

    private static final String EXPECTED_TITLE = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
    private static final String EXPECTED_BODY = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }
    @Story("Validar todos os campos do retorno da API")
    @Test
    @Description("Verifica se todos os campos dos posts têm valores válidos")
    @Severity(SeverityLevel.BLOCKER)
    public void testAllPostsHaveValidFields() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .extract()
                .response();

        List<Map<String, Object>> posts = response.jsonPath().getList("");

        for (Map<String, Object> post : posts) {
            assertThat(post.get("userId"), instanceOf(Integer.class));
            assertThat((Integer) post.get("userId"), greaterThan(0));

            assertThat(post.get("id"), instanceOf(Integer.class));
            assertThat((Integer) post.get("id"), greaterThan(0));

            assertThat(post.get("title"), notNullValue());
            assertThat(post.get("title"), not(""));

            assertThat(post.get("body"), notNullValue());
            assertThat(post.get("body"), not(""));
        }
    }
    @Story("Verificar se o código de status da API é 200")
    @Test
    @Description("Verifica se a resposta da API retorna status 200")
    @Severity(SeverityLevel.CRITICAL)
    public void testStatusCodeIs200() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .statusCode(200);
    }

    @Story("Verificar se o userId do primeiro post é 1")
    @Test
    @Description("Verifica se o userId do primeiro post é 1")
    @Severity(SeverityLevel.NORMAL)
    public void testFirstPostUserIdIs1() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .body("[0].userId", equalTo(1));
    }

    @Story("Verificar se o id do primeiro post é 1")
    @Test
    @Description("Verifica se o id do primeiro post é 1")
    @Severity(SeverityLevel.NORMAL)
    public void testFirstPostIdIs1() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .body("[0].id", equalTo(1));
    }

    @Story("Verificar o título do primeiro post")
    @Test
    @Description("Verifica se o título do primeiro post é igual ao esperado")
    @Severity(SeverityLevel.NORMAL)
    public void testFirstPostTitle() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .body("[0].title", equalTo(EXPECTED_TITLE));
    }

    @Story("Verificar o corpo do primeiro post")
    @Test
    @Description("Verifica se o corpo do primeiro post é igual ao esperado")
    @Severity(SeverityLevel.NORMAL)
    public void testFirstPostBody() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .body("[0].body", equalTo(EXPECTED_BODY));
    }
}
