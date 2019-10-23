package by.sam.apklimovich;

import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import sun.jvm.hotspot.HelloWorld;

import java.io.IOException;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class SampleIT {
    @Autowired
    private WebApplicationContext context;
/*
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;
*/
    @Test
    public void greetingTest() throws Exception {
        Logger logger = LoggerFactory.getLogger(SampleIT.class);
        logger.info("Hello world string output");
        logger.debug("Hello world ffff");
       // System.out.println("Hello ");
      //  this.mockMvc.perform((RequestBuilder) get("http://localhost:8080/MedicineApp/hello")).andDo(print()).andExpect(status().isOk())
      //          .andExpect(content().string(containsString("Hello world.")));

       // RestAssuredMockMvc.webAppContextSetup();
       // Response response = RestAssured.get("/MedicineApp/hello");
       // String str = response.getStatusLine(context,);
       // String str = get("MedicineApp/hello").toString();

        //try{
       //     RestAssuredMockMvc.given().when().
                    //get("MedicineApp/hello").
                  //  then().statusCode(200).body(equals("Hello world."));
       // }
      //  finally {

     //   }
     //  when(). request("GET", "/hello").then().expect(str);

        // get("/hello").then().assertThat()
         //       .body( , ("Hello world.".trim()));
      //  given()
      //          .standaloneSetup(webApplicationContext)
        //System.out.println("IntegrationTest");
//        when().
//                get("/MedicineApp/hello", "Hello world.").
//                then().
//                statusCode(200).
//                body("lotto.lottoId".trim(), equalTo("Hello world."),
//                        "lotto.winners.winnerId", hasItems(23, 54));


    }


}
