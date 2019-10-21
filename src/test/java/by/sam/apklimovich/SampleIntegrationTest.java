package by.sam.apklimovich;

import jdk.jfr.Category;

import org.junit.Test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import sun.net.www.URLConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;



public class SampleIntegrationTest {
    @Test
/*
    public void sampleIntegrationTest(){
        System.out.println("IntegrationTest");
    }*/

    public void sampleIntegrationTest() throws IOException {
        System.out.println("IntegrationTest");
        CloseableHttpClient httpClient = HttpClients.createDefault();

        try {
            HttpGet request = new HttpGet("http://localhost:8080/MedicineApp/calculateServlet");
            //request.addHeader();
            CloseableHttpResponse response = httpClient.execute(request);
            try {
                System.out.println(response.getProtocolVersion());
                System.out.println(response.getStatusLine().getStatusCode());
                System.out.println(response.getStatusLine().getReasonPhrase());
                System.out.println(response.getStatusLine().toString());

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    System.out.println(result);
                    //System.out.println(result.charAt(13));
                 //   assertEquals('H', result.charAt(0));
                   // assertEquals("Hello world.\n", result.toString());
                    //assertSame("Hello world.\n", result);

                }
            } finally {

            }
        } finally {

        }

       // String url = "http://localhost:8080/MedicineApp/calculateServlet";
        //URLConnection connection = (URLConnection) new URL(url).openConnection();
        /*try(InputStream response = connection.getInputStream();
            Scanner scaner = new Scanner(response)){
            String responseBody = scaner.nextLine();
            assertEquals("Hello world", responseBody);
        }*/
    }


}
