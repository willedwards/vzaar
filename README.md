Vzaar video upload example

Requires Java 7, maven 3.x


To build
1) git clone this repo

2) download the API from

https://code.google.com/p/vzaar/downloads/detail?name=vzaar-java-api-2.0.zip

extract the lib/vzaar-java-api.jar to the pom.xml level of this project.

3) install this jar locally into your ~/.m2/repository via

>mvn install:install-file -Dfile=lib/vzaar-java-api.jar -DgroupId=com.vzaar -DartifactId=api -Dversion=2.0 -Dpackaging=jar

>mvn clean install

To run

>java -jar target/console-uploadexample-0.0.1.jar [arguments]

