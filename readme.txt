Important Points:

1. All test data required is placed in "configuration.properties" file which is available in src/main/java/com.amazon.qa.configuration
2. Path for browser is provided by TestBase.java class inside com.amazon.qa.base package.
3.This script is capable to execute in Chrome and Firefox Browser.
4.Please execute this program from testng.xml

***************************Working of Program**********************************************************************
1.Open browser
2.Open https://www.amazon.in website.
3.Get All the search dropdown list from All Categories
4.Select Books Option form All Categories
5.Enter Search text as "data"
6.Select first test result from the bunch of test results .
7.Capture all the details about the book.

************************************About project and Structure********************************************************

1.src/main/java : contains all main functions PACKAGES,Class and Functions

com.amazon.qa.base: This package contains class files for browser launch and configuration
TestBase.java:This class contains function to launch browser,configuration details and quit browser

com.amazon.qa.configuration: This package contatins configuration details
configuration.properties:This file contains all the properties/data to Determines browser,URL, data accordingly.

com.amazon.qa.driver:This Package contains test runner file

com.amazon.qa.pages: This Package contains class according to Website pages
AmazonHomePage: Contains all element related to HAmazonHomePage and Methods to perform action on homePage.
BooksContentPage: Contains elements related to BooksContent page and methods to perform action on pagePage.

com.amazon.qa.testdata:Contains TestData

com.amazon.qa.utilities:this package contains some utilities required to run program
TestUtilities: Contains PAGE_LOAD_TIMEOUT and IMPLICIT_WAIT details

2.src/main/resource:Contains TestRunDetails.properties file, browser exe files

3.src/test/java: contains classes to test amazon website

AmazonHomePageTest: Contains funtion to test AmazonHomePage
BooksContentPageTest: Contains funtion to test BooksContent page.
