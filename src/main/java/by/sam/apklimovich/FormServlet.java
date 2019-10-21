package by.sam.apklimovich;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//@WebServlet(name = "by.sam.apklimovich.FormServlet", urlPatterns = "/calculateServlet")
public class FormServlet extends HttpServlet {
    public String getGreeting() {
        return "Hello world.";
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // https://www.oracle.com/technetwork/java/servlet-142430.html
        PrintWriter out = resp.getWriter();
        out.println(this.getGreeting());
        out.close();
    }

    /*
    <build>
        <finalName>${project.artifactId}</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.6.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.0</version>
                <configuration>
                    <server>myserver</server>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.0</version>
                <configuration>
                    <url>http://localhost:8080/manager</url>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-failsafe-plugin</artifactId>
                <version>2.17</version>
                <executions>
                    <execution>
                        <id>integration-tests</id>
                        <goals>
                            <goal>integration-test</goal>
                            <goal>verify</goal>
                        </goals>
                        <configuration>
                            <includes>
                                <include>**//*.java</include>
                            </includes>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>





    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");

        try {
            double bmi = calculateBMI(
                    Double.parseDouble(weight),
                    Double.parseDouble(height));
            writer.println("<h2>Hello from HelloServlet</h2>");
            request.setAttribute("bmi", bmi);
            response.setHeader("Test", "Success");
            response.setHeader("BMI", String.valueOf(bmi));

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    }

    private Double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
    }*/
}

