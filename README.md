Java Selenium POC

-	Install Java JDK and add JAVA_HOME env variable
-	Install Maven and add bin folder it to PATH env variable
-	Install following dependencies from Maven Repository
     o	selenium-java
     o	cucumber-java
     o	cucumber-junit
     o	junit
     o	extentreports
     o	webdrivermanager
     o	slf4j-api
     o	logback-classic
-	Install following Plugins on IntelliJ
     o	Gherkin
     o	Cucumber for Java
     o	Docker
     o	Lombok


Setup Project folder as following :

src
├── main
│    └── java
│         └── com.example.automation
│              ├── utils         (Utility classes)
│              ├── drivers       (WebDriver management)
│              └── reports       (Extent Report configuration)
├── test
├── java
│    └── com.example.automation
│         ├── stepdefinitions (Step Definitions for Cucumber)
│         └── runners         (Cucumber Test Runners)
└── resources
├── features        (Cucumber feature files)
└── config          (Configuration files like properties)

Run following command to resolve dependencies in pom.xml
mvn dependency:resolve
then run following to make sure build passes successfully
mvn clean install -DskipTests=true


