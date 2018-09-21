
set projectLocation=C:\Users\Sharath.bannanje\workspace_testng\MyFirstTestNGProject
 
cd %projectLocation%
 
set classpath=%projectLocation%\bin;C:\Users\Sharath.bannanje\.p2\pool\plugins\*
 
java org.testng.TestNG %projectLocation%\testng.xml
 
pause