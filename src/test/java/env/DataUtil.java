package env;

import java.util.HashMap;

public class DataUtil {

	public static HashMap <String,String>getData(Xls_Reader xls, String testDataRow){
		String sheetName="Data";
		// reads data for only testCaseName
		
		int testStartRowNum=1;
		while(!xls.getCellData(sheetName,1, testStartRowNum).equals(testDataRow)){
			testStartRowNum++;
		}
		System.out.println("Test starts from row - "+ testStartRowNum);
		int colStartRowNum=1;
		int dataStartRowNum=testStartRowNum;

		int cols=0;
		while(!xls.getCellData(sheetName, cols, colStartRowNum).equals("")){
			cols++;
		}
		System.out.println("Total cols are  - "+cols );
		
		/****************************************************************************************/
		
	
		HashMap<String,String> table=null;
		
			table = new HashMap<String,String>();
			for(int cNum=0;cNum<cols;cNum++){
				String key=xls.getCellData(sheetName,cNum,colStartRowNum);
				String value= xls.getCellData(sheetName, cNum, dataStartRowNum);
				table.put(key, value);
				
			}
			
		
		return table;
	}

}