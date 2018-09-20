package pkgUserRegForm_Delete;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyFirstTestNGFile {
	
	/*
	@Test(priority=2)
	public void fnHello() {
		System.out.println("Hello");
	}
	*/
	
	//-----------------------------
	//https://sqa.stackexchange.com/questions/15591/how-to-handle-multiple-columns-of-data-from-excel-using-apache-poi-for-selenium
	  
	public static HSSFWorkbook WBook = null;
	public static HSSFSheet WSheet= null;
	public static HSSFSheet Sheet;
	
    public static Object[][] LoginData;
    
    public static HSSFRow Row;
    public static HSSFCell cell;
    public static String FilePath = "C:\\Users\\Sharath.bannanje\\Desktop\\DatInput.xls";
    public static String SheetName1 = "Login";

    
    @DataProvider
	public static Object[][] getLoginData() throws Exception{
    	Sheet = DataSheet(FilePath, SheetName1);
    	int rowCount = Sheet.getLastRowNum();
    	//System.out.println(rowCount);
    	int colCount = Sheet.getRow(0).getLastCellNum();
        //System.out.println(colCount);

        LoginData = new Object[rowCount][colCount];
        
        /*
        String[] Headers = new String[colCount];
        for (int j=0;j<colCount;j++){
            Headers[j] = Sheet.getRow(0).getCell(j).getStringCellValue();
        }
        for(int a=0;a<colCount;a++){
            if(Headers[a].equals("Address")){
                //driver.findElement(By.id("lst-ib")).sendKeys(Sheet.getRow(1).getCell(a).getStringCellValue());
                break;
        }
        */

        for (int rCnt=1; rCnt<=rowCount;rCnt++){
            for (int cCnt=0; cCnt<colCount;cCnt++){
                LoginData[rCnt-1][cCnt] = getCellData(SheetName1, rCnt, cCnt);
                System.out.println(LoginData[rCnt-1][cCnt]);
            }
        }

        return LoginData;
    }
    
    //Create the Excel WorkBook Instance
	public static HSSFSheet DataSheet(String FilePath, String SheetName){
		File file = new File(FilePath);
		try {
	           FileInputStream fis = new FileInputStream(file);
	            WBook = new HSSFWorkbook(fis);
	            WSheet = WBook.getSheet(SheetName);         
	        } catch (Exception e) {         
	            e.printStackTrace();
	        }
	        return WSheet;      
	    }      
		
	public static String getCellData(String Sheet, int row, int col){
        try {

            int index = WBook.getSheetIndex(Sheet);

            WSheet = WBook.getSheetAt(index);	
            Row = WSheet.getRow(row);
            if (Row == null)
            return "";

            cell = Row.getCell(col);
            if (cell == null)
            return "";
            
            return cell.getStringCellValue();    
            //return WSheet.getCell(row,col).getContent();
           
            /*
            switch (cell.getCellType())
            {
            case  Cell.CELL_TYPE_STRING:
            return cell.getStringCellValue();               

            case  Cell.CELL_TYPE_BOOLEAN:
            return String.valueOf(cell.getBooleanCellValue());          

            case  Cell.CELL_TYPE_BLANK:
            return "";      

            case  Cell.CELL_TYPE_ERROR:
            return cell.getStringCellValue();           

            case  Cell.CELL_TYPE_NUMERIC:
            return String.valueOf(cell.getNumericCellValue());          

            default:
            return "Cell not found";        

            }
            */
            //return "123-AAA";     
        }
            catch (Exception e) {
            e.printStackTrace();
            return "row " + row + " or column " + col+ " does not exist in xls";
            }

    }	    
	
	@Test(dataProvider="getLoginData")
	
	public void TC01_Verify_Login_Data(String User, String Pass, String Nme){
	    System.out.println(User + Pass);    
		
	 }
	
		    
		    
		    
		    
		    
	  
	  /*
	  public void readExcel(String strFilepath, String strFileName, String SheetName){
		  File myFile  = new File(strFilepath + "\\" + strFileName);
		  FileInputStream inputStream = new FileInputStream(myFile);
		  Workbook myWorkBook = null;
		  
		  String fileExtensionName = strFileName.substring(strFileName.indexOf("."));
		  
		  if(fileExtensionName.equals(".xlsx")){
			  myWorkBook = new XSSFWorkbook(inputStream);
			
		  }else if(fileExtensionName.equals(".xls")){
			  myWorkBook = new HSSFWorkbook(inputStream);
		  }
		  
		  Row row = sheet.getRow(0);
		  
		  //int rowCount = myWorkBook.getLastRowNum() - myWorkBook.getFirstRowNum();
		
		  
		  for (int i = 0; i < rowCount+1; i++) {

		        Row row = myWorkBook.getRow(i);

		        //Create a loop to print cell values in a row
		        for (int j = 0; j < row.getLastCellNum(); j++) {
		            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
		        }

		        System.out.println();
		  inputStream.close();
	  }
	  */

}
