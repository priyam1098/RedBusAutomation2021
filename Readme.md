###Automation Testing framework 
[Testing Website URL](https://www.redbus.in/)
***
[Github Repositories URL](https://github.com/priyam1098/RedBusAutomation2021.git)



###Tools Used in testing:
- Eclipse IDE
- JAVA
- TestNG
- MAVEN
- Github
- Jenkins
- Docker

***

###Packages Description:
* **src/main/java -utils**
    * DateAndTimeHelper
    * DatePicker
            
#POM STRUCTURE
  
* **pages(com.redbus.pages)** (Contains Locators and methods to perform actions)

    * HomeFunctionalityPage
    * InfoSectionPage
    * ModifySearchLocationPage
    * OpenGloballySitesBookingPage
    * PartnerWwebsitesPage
    * rPoolSectionPage
    * SearchBusPage
    * SignInPage
    * TravellerBusHiringPage
   

* **Tests(com.redbus.tests)**
    * BaseTest.java(Contains Browser configurations, extent reports,Screenshots functionality, headless configurations,logger)
    * AirportBusHiringTest.java
    * BusAllOperatorsTest.java
    * CareersTest.java
    * CheckOffersTest.java
    * ContactUsTest.java
    * CustomerHelpSection.java
    * InfoSectionTest.java
    * LocalBusHiringTest.java
    * ManageBookingChangeTravelDateTest.java
    * ManageBookingShowMyTicketTest.java
    * MangaingBookingCancelTicketTest.java
    * ModifySearchBusLocationTest.java
    * NavigateBusOperatorRegistrationTest.java
    * OutstaionBusHiringTest.java
    * RedbusGloballyBookingSitesTest.java
    * RedbusPartnerwebsitesTest.java
    * rPoolSectionTest.java
    * SearchBusTest.java
    * SigInTest.java
    * NavigateBusOperatorRegistrationTest.java


	

* **utilities**
* ExcelDataReader.java(Read excel data )
* CommonUtils.java(Execution required or not)



###Folders  
* **Drivers** (Contains Drivers)
    * chromedriver.exe
    * geckodriver.exe
    * msedgedriver.exc

* **Resources**
    * ExcelData.xlsx(Taking Excel file which contains Test data )
    * Conf.properties file(contains url , path of all drivers, headless, docker, browser options)
    * log4j.properties

**Reports**
	* report.html
	* ScreenShots

**Refrenced library**
	*Screenshots jar (for screen shots)

**Dependencies in POM
       -Selenium
       -Test NG
       -Extent Reports
       -Log4j
       -POI XML    

***
###Steps to Run (on CMD):
- **Step:1**
  Open terminal 
- **Step:2**
  Now type Command  Run.bat(if docker=true all will be excecute in docker)
***

###Steps to Run(on eclipse):
- **Step:1**
  Open eclipse 
- **Step:2**
  Run as testNG (if docker= true in conf then it will run in docker )
  
  
###Steps to Run(on jenkins)
- **Step:1**
   Start genkins server go to project
- **Step:2**
   Click on build now 
	

  