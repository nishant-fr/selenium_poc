
# Java Selenium POC Setup Guide

## Prerequisites

### 1. **Install Java JDK**
- Install Java JDK and set up the `JAVA_HOME` environment variable.

### 2. **Install Maven**
- Install Maven and add the `bin` folder to the `PATH` environment variable.

### 3. **Install Required Maven Dependencies**
- Add the following dependencies to your `pom.xml` from the Maven Repository:
     - `selenium-java`
     - `cucumber-java`
     - `cucumber-junit`
     - `junit`
     - `extentreports`
     - `extentreports-cucumber7-adapter`
     - `webdrivermanager`
     - `slf4j-api`
     - `logback-classic`
     - `cucumber-picocontainer`
     - `jakarta.ws.rs-api`
     - `jakarta.json`
     - `assertj-core`
     - `json-unit-assertj`
     - `javafaker`

### 4. **Install IntelliJ Plugins**
- Install the following plugins in IntelliJ IDEA:
     - **Gherkin**
     - **Cucumber for Java**
     - **Docker**
     - **Lombok**

## Project Folder Structure

Project folder should be structured as follows:

```
src
├── main
│    └── java
│         └──├── Drivers       (WebDriver management)
│            ├── Pages         (Page Object)
│            └── Reports       (Extent Report configuration)
├── test
│    └── java
│         └──├── Runners       (Cucumber Test Runners)
│            └── Steps         (Step Definitions for Cucumber)
└── resources
     ├── features              (Cucumber feature files)
     └── config                (Configuration files like extent report, logger etc.)
```

## Maven Commands

### 1. **Resolve Dependencies**
To resolve the dependencies in your `pom.xml`, run the following command:

   ```bash
   mvn dependency:resolve
   ```

### 2. **Build Project**
After resolving the dependencies, run the following command to ensure the build passes successfully:

   ```bash
   mvn clean install -DskipTests=true
   ```

### 3. **Run Tests**
To execute the tests, run the following command:

   ```bash
   mvn test -DtestClassName=TestRunner
   ```


## Report Generation


### 1. **Extent Reports**
TODO - ADD path for extent report


### 2. **Native Cucumber HTML Reports**
TODO - Add path for generic cucumber report

TODO - Fix issues with LOGGER into the console
