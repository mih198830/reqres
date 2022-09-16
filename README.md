# This is the Project with API Autotests for 'Reqres' website
Click [here](https://reqres.in/) to take a look at the website!

## Technology Stack used in the project:

<p align="center">
<a href="https://www.java.com/"><img src="src/test/resources/images/logo/Java.svg" width="50" height="50"  alt="Java" title="Java"/></a>
<a href="https://gradle.org/"><img src="src/test/resources/images/logo/Gradle.svg" width="50" height="50"  alt="Gradle" title="Gradle"/></a>
<a href="https://junit.org/junit5/"><img src="src/test/resources/images/logo/Junit5.svg" width="50" height="50"  alt="JUnit 5" title="JUnit 5"/></a>
<a href="https://selenide.org/"><img src="src/test/resources/images/logo/Selenide.svg" width="50" height="50"  alt="Selenide" title="Selenide"/></a>
<a href="https://gradle.org/"><img src="src/test/resources/images/logo/rest-assured-logo.svg" width="50" height="50"  alt="Gradle" title="RestAssured"/></a>
<a href="https://www.jenkins.io/"><img src="src/test/resources/images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins" title="Jenkins"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="src/test/resources/images/logo/Allure.svg" width="50" height="50"  alt="Allure" title="Allure"/></a>


## What is special about this project:

- RestAssured library
- Specifications
- Lombok models

## To run tests locally use:

```
gradle clean test 
```
![2022-09-10_22h13_24](https://user-images.githubusercontent.com/61227126/189496385-c0802b15-cbdf-4bac-a3f9-6872fee0dcdb.png)


## Jenkins job
Jenkins is an automation server which lets us run tests

Click <a target="_blank" href="https://jenkins.autotests.cloud/job/ReqresWebSite/">here</a> to see the job for Reqres

![](../../Pictures/Screenpresso/2022-09-16_11h42_36.png)

## Allure report
Allure Framework is a flexible test report tool that shows a concise representation of what have been tested in a neat web report form

Click <a target="_blank" href="https://jenkins.autotests.cloud/job/ReqresWebSite/2/allure//#">here</a> to see the report of the tests

Here are test suites and graphs:
![2022-08-28_20h40_38](https://user-images.githubusercontent.com/61227126/187084951-a0e45809-fb9c-4921-83d8-2142ac2701cd.png)

![2022-08-28_20h41_07](https://user-images.githubusercontent.com/61227126/187084975-c4f7c914-72e8-44d8-b286-b116adbc2273.png)
