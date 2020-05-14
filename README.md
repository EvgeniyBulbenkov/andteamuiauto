#### **Test automation Project**

This project contains 2 modules: AndersetTeam (andtm) and Yandex (yandex).
To produce tests, checkout project from git:


`git checkout https://github.com/EvgeniyBulbenkov/andteamuiauto.git `

then run maven goal 

`mvn clean test` - this will run in browser in headless mode

or

`mvn clean -Denv=local test` - this will open visible browser instance

after that, to see test results, run

`mvn allure:serve` - this will start up server and open browser page with Allure report.

By default, thr above steps produce **Yndex Pages tests**. To pass **Andersen Team Tests** 
you should:
 - be connected to the Andersen Internal Network (over VPN).
 - in  src/test/resources/creds.properties type your Login and Password
  
