package by.sam.apklimovich;

import io.restassured.RestAssured;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static io.restassured.RestAssured.when;

public class SampleIT {

    @Test
    public void greetingTest() throws Exception {
        Logger logger = LoggerFactory.getLogger(SampleIT.class);
        logger.info("Integration test");
        logger.debug("greetingTest method created ");
        RestAssured ra = new RestAssured();
        try{
            logger.info("in try test 1 ");
            when().get("http://localhost:8080/MedicineApp/hello").then().assertThat().equals("Hello world.");
            logger.info("in try test 2");
        }
        finally {

        }
    }
}
