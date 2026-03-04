To run the test cases you need to add the profile at the end.
Obs: the availiable profiles are added in the POM

Ex:
mvn clean test -p qa-local

Afte you run and have allure installed you can go to target/allure-results and run the command allure serve
then you should see a report builded and opened at you browser
