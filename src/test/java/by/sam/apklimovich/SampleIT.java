package by.sam.apklimovich;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SampleIT {

    @Test
    public void greetingTest() throws Exception {
        Persons1 person = new Persons1();
        person.setName("Anton");
//        Logger logger = LoggerFactory.getLogger(SampleIT.class);
//        logger.info("Integration test");
//        logger.debug("greetingTest method created ");
//        ValidatableResponse response = null;
//        RestAssured.baseURI = "http://localhost:8080/MedicineApp";
//        given().urlEncodingEnabled(true).param("Anton").get("/hello").then().statusCode(200);
//        response = given().contentType(ContentType.JSON).post("/formVal").then().statusCode(200);
//        logger.info(response.toString());
    }
}
