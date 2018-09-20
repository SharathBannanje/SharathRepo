package myfirsttestpackeage;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.testng.annotations.DataProvider;

public class clsExcelDataExtract {
	//https://sqa.stackexchange.com/questions/15591/how-to-handle-multiple-columns-of-data-from-excel-using-apache-poi-for-selenium
	  
	public static HSSFWorkbook WBook = null;
	public static HSSFSheet Sheet= null;
	
    public static Object[][] dataObj;
    
    public static HSSFRow Row;
    public static HSSFCell cell;
    public static String SheetName = "Login";
	public static String FilePath = "C:\\Users\\Sharath.bannanje\\Desktop\\DatInput.xls";
    
	@DataProvider
	public static Object[][] getData() throws Exception{
    	dataObj = null;
    	try{
    		File file = new File(FilePath);
            FileInputStream fis = new FileInputStream(file);
            WBook = new HSSFWorkbook(fis);
            Sheet = WBook.getSheet(SheetName);            
    	        
        	int rowCount = Sheet.getLastRowNum();
        	//System.out.println("Rows" + rowCount);
        	int colCount = Sheet.getRow(0).getLastCellNum();
            //System.out.println("Columns" + colCount);
        
        	dataObj = new Object[rowCount][colCount];
            
            for (int rCnt=1; rCnt<=rowCount;rCnt++){
                for (int cCnt=0; cCnt<colCount;cCnt++){
                	dataObj[rCnt-1][cCnt] = getCellData(Sheet, rCnt, cCnt);
                    //System.out.println(dataObj[rCnt-1][cCnt]);
                }
            }          
            WBook.close();
            fis.close();
       
    	}catch (Exception e) {         
            e.printStackTrace();
        }
        return dataObj;
    }
    
		
	public static String getCellData(HSSFSheet Sheet, int row, int col){
	try{
		Row = Sheet.getRow(row);
    	
        if (Row == null)
        return "";

        cell = Row.getCell(col);
        if (cell == null)
        return "";

        CellType type =  cell.getCellTypeEnum();
        
        
        if (type == CellType.STRING) {
           return cell.getRichStringCellValue().toString();
        } else if (type == CellType.NUMERIC) {
            return String.valueOf((int)cell.getNumericCellValue());
        } else if (type == CellType.BOOLEAN) {
           return String.valueOf(cell.getBooleanCellValue());
        } else if (type == CellType.ERROR) {
        	return cell.getStringCellValue();  
        } else if (type == CellType.BLANK) {
        	return "";
        } else {
        	return "";
        }
        
     
           
        }catch (Exception e) {
        	e.printStackTrace();
        	return "row " + row + " or column " + col+ " does not exist in xls";
        }
    }	    
	
	
		    
		    
		    

}
