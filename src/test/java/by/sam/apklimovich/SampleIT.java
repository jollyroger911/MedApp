package by.sam.apklimovich;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class SampleIT {

    @Test
    public void greetingTest() throws Exception {
        Person person = new Person();
        person.setName("Anton");
        Logger logger = LoggerFactory.getLogger(SampleIT.class);
        logger.info("Integration test");
        logger.debug("greetingTest method created ");
        ValidatableResponse response = null;
        RestAssured.baseURI = "http://localhost:8080/MedicineApp";
        given().urlEncodingEnabled(true).param("Anton").get("/hello").then().statusCode(200);
        response = given().contentType(ContentType.JSON).post("/formVal").then().statusCode(200);
        logger.info(response.toString());
    }
}
