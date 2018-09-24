set projectLocation=C:\Program Files (x86)\Jenkins\workspace\MyFirstTestNGProject_GIT\MyFirstTestNGProject

cd %projectLocation%

java -cp "%projectLocation%\bin;%projectLocation%\lib\*" org.testng.TestNG testing.xml

pause
