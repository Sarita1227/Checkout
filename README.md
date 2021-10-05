# Getting Started

Please follow below instruction to copy the project and running on your local machine for testing purpose

### Tools And Environment
1. Eclipse IDE for Enterprise Java Developers 
2. Java version: 1.8.0_231, vendor: Oracle Corporation
3. Maven home: apache-maven-3.6.3
4. Enable cucumber-java plugin in Eclipse
5. GitHub
6. Required driver versions (ChromeDriver 93.0.4577.63)
7. Required browsers (Version 93.0.4577.63 )
8. Mac OS


This test was done on MAC on chrome browser but if you are running this code in windows then please download the chromedriver.exe file for windows and replace the file present in Chromedriver folder placed inside the project<br />
File can be dowloaded from the below link <br />
https://chromedriver.storage.googleapis.com/index.html?path=93.0.4577.63/


Make sure your Chromedriver.exe file is compatible with your chrome version


### Framework Design Approach
Selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web.

Page Factory is an inbuilt Page Object Model concept for Selenium WebDriver but it is very optimized.Here we follow the concept of separation of Page Object Repository and Test Methods.

Additionally, with the help of PageFactory class, we use annotations @FindBy to find WebElement. We use initElements method to initialize web elements.

For UI Tests : Selenium-cucumber-Maven with PageFactory Design Pattern.



Steps to run the tests
--------------
Please make sure to have all the tools and libraries mentioned in the "Tools And Environment" section.

Step-1: Clone the repository from 

Step-2: Use the following maven commands to run the tests.

```bash
"mvn test" for execution
```
or

```bash
mvn test -Dcucumber.options="--tags @Checkout" to run the tests
```
or


Feature File >>>> Step Definition File >>>> Main File

For example: Feature file is created for Automation demo in which scenario is written in gherkin language.
This feature file calls step definition file through glue code.
Then step definition file calls main page file in which all methods are defined.

### Cucumber Test Reports

 
##### UI Test Results


##### Sarita Dash
##### 05Oct 2021
