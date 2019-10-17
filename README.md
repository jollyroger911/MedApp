Here we describe step-by-step instruction of making a simple servlet.
We need Tomcat and Maven installed on computer.
Download them and unzip to final directory.

1.  Download OpenJDk from ("https://jdk.java.net/13/") and unzip it to directory Java (path"C:\Program Files\Java").
2.  Add JDK path to system variables using "SearchWindows" print variables and choose "Edit environment variables".
    On "System Properties" window choose "Advanced" list and press button "Environment Variables". 
    On "Environment variables" tab we set JAVA_HOME variable for both system variables and user variables. 
    Press "New" and write "JAVA_HOME" to variable name and path ("C:\Program Files\Java\jdk-13") to variable value. Press Ok to close 
    all the windows. 
3.  Download Tomcat from "https://tomcat.apache.org/" and unzip to directory (path "D:\Tomcat"). Add Tomcat path to 
    system variables using "SearchWindows" print variables and choose "Edit environment variables".
    On "System Properties" window choose "Advanced" list and press button "Environment Variables". 
    Press "New" and write "CATALINA_HOME" to variable name and path ("D:\Tomcat\apache-tomcat-9.0.27") to variable value. Press Ok to close 
    all the windows.
4. Download Maven from "http://maven.apache.org/download.cgi" and unzip to directory (path "C:\Program Files\maven"). Add Maven path to 
   system variables using "SearchWindows" print variables and choose "Edit environment variables".
   On "System Properties" window choose "Advanced" list and press button "Environment Variables". 
   Press "New" and write "MAVEN_HOME" to variable name and path ("C:\Program Files\maven\apache-maven-3.6.2") to variable value. Press Ok to close 
   all the windows.
6.  Now we need to package our app, so we use standard phase, first on "Maven" tab 
    at the right upper corner press "clean" to clean the build and after press "package" and all the previous phases will run.
7.  At the end we get a .war file in "target" folder. We need it to deploy our app on server, so copy it to the
    directory where tomcat server is (path "D:\Tomcat\apache-tomcat-9.0.27\webapps"). 
    After that we start our server using .bat files (path: "D:\Tomcat\apache-tomcat-9.0.27\bin\startup").
    App can be opened using link "http://localhost:8080/"project.artifactId"/"url-pattern" ".