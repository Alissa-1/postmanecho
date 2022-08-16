
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class testV2 {
    @Test
    void testPostQuantityOfBooks() {
        // Given - When - Then
// Предусловия
        File file = new File("./src/test/resources/myJson.json");
        given()
                .baseUri("https://postman-echo.com")
                .header("Content-Type", "application/json")
                .body(file) // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .body("data.store.book", hasSize(4))
        ;
    }
}
