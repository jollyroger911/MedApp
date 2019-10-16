Here we describe step-by-step instruction of making a simple servlet.
We need Tomcat and Maven installed on computer.
Download them and unzip to final directory.

1.  Install OpenJDK from Oracle site.
2.  Unzip Tomcat server and maven.
3.  Add JDK path to system variables using Advanced system settings/ Environment Variables/ System Variables
    Click Edit. If the PATH environment variable does not exist, click New.
    In the Edit System Variable (or New System Variable) window, specify the value of the PATH environment variable.
    So we created variable JAVA_HOME.
4.  Also do in cmd.exe run mvn -v to verify the Maven installation.
5.  The same we do for tomcat adding CATALINA_HOME (system variable contains path to place where tomcat was unzipped).
6.  Now we need to package our app, so we use standard phase, first clean the target folder, then press
    "package" and all the previous phases will run.
7.  At the end we get a .war file in "target" folder. We need it to deploy our app on server, so copy it to the
    directory where tomcat server is. Path: "webapps/file.war". After that we restart our server using .bat files
    in bin directory. App can be opened on http://localhost:8080/"project.artifactId"/"url-pattern"