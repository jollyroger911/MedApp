package by.sam.apklimovich;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class IntegrationTest {

    @Test
    public void ITest() throws ClientProtocolException, IOException {


        // RestAssured.baseURI = "http://localhost:8080/MedicineApp/login";
        // given().urlEncodingEnabled(true).params("user").
//        assertTrue(
//                this.restTemplate
//                        .getForObject("http://localhost:" + "8080" + "/employees", Employees.class)
//                        .getEmployeeList().size() == 3);
        //  given().urlEncodingEnabled(true).param("admin").get("login").then().statusCode(500);
        // RestAssured.baseURI = "http://localhost:8080/MedicineApp/chat";
        //  given().urlEncodingEnabled(true).
        //get("http://localhost:8080/MedicineApp/login").
        // then().assertThat()
        // .statusCode(200).and().contentType("text/html;charset=UTF-8");
        given().get("http://localhost:8080/MedicineApp/login").then().assertThat().statusCode(200);

//
        //PersonDto persons1 = new PersonDto();
        //  persons1.setName("Anton");
//        Logger logger = LoggerFactory.getLogger(SampleIT.class);
//        logger.info("Integration test");              String name = RandomStringUtils.randomAlphabetic(8);
////        HttpUriRequest request = new HttpGet("http://localhost:8080/MedicineApp/" + name);
////        HttpResponse response = HttpClientBuilder.create().build().execute(request);
////        response.getStatusLine().getStatusCode().
////                response.getStatusLine().getStatusCode(),equals(HttpStatus.SC_NOT_FOUND));
////        );
//        logger.debug("greetingTest method created ");
//        ValidatableResponse response = null;
//        RestAssured.baseURI = "http://localhost:8080/MedicineApp";
//        given().urlEncodingEnabled(true).param("Anton").get("/hello").then().statusCode(200);
//        response = given().contentType(ContentType.JSON).post("/formVal").then().statusCode(200);
//        logger.info(response.toString());
    }
}
