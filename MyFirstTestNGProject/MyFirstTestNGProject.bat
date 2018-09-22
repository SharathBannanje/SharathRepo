
set projectLocation=D:\GitRepoProjects\MyFirstTestNGProject
 
cd %projectLocation%

D: 

java -cp "%projectLocation%\bin;%projectLocation%\lib\*" org.testng.TestNG testing.xml

pause