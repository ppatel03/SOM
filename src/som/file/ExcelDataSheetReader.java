/**
 * 
 * This Class contains methods which will reads the excel sheet and accordingly store the input colukn data 
 * 
 */
package som.file;

//static import
import static som.constants.IGenericConstants.REVISED_INPUT_SHEET_NAME;
import static som.constants.IGenericConstants.sheetMapper;
import static som.constants.IGenericConstants.MAX_NO_OF_ROWS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import som.beans.VectorData;


public class ExcelDataSheetReader implements IFileWritable{
	private StringBuffer combinedWords = new StringBuffer("");
	
	
	public StringBuffer getCombinedWords() {
		return combinedWords;
	}


	public void setCombinedWords(StringBuffer combinedWords) {
		this.combinedWords = combinedWords;
	}


	/**
	 * 
	 * @param option
	 * @return
	 */
	public List<VectorData> getInputDataSheet(int option){
	
		List<VectorData> vectorDataList = new ArrayList<VectorData>();
		createVectorDataList(vectorDataList, option);
		return vectorDataList;
	}

	
	/**
	 * 
	 * @param vectorDataList
	 * @param option
	 */
	private void createVectorDataList(List<VectorData> vectorDataList, int option){
		List<Byte> columnList = sheetMapper.get(option);
		System.out.println("Selected Column Numbers are "+ columnList);
		populateValuesIntoListFromFileAndAdditToWordDictionary(vectorDataList, columnList);
	}

	/**
	 * 
	 * @param cell
	 * @return
	 */
	private String getCellValue(Cell cell){
		String cellValue = "";
		if(cell != null){
			switch(cell.getCellType()) {
			case Cell.CELL_TYPE_BOOLEAN:
				cellValue = cell.getBooleanCellValue()+"";

				break;
			case Cell.CELL_TYPE_NUMERIC:        	
				cellValue = cell.getNumericCellValue() + "";
				break;
			case Cell.CELL_TYPE_STRING:
				cellValue = cell.getStringCellValue() + "";
				break;
			}
		}
		return cellValue;
	}

	
	

	/**
	 * get VectorData Class object
	 * @param columnList
	 * @param row
	 * @return
	 */
	private VectorData getPopulatedVectorData(List<Byte> columnList, Row row){
		VectorData vectorData = new VectorData();
		
		//necessary values to ne inputter
		Cell cellTitle = row.getCell(17);
		String cellValueTitle = getCellValue(cellTitle);
		vectorData.setProjectTitleForBLParser(cellValueTitle);
		
		Cell cellDesc = row.getCell(18);
		String cellValueDesc = getCellValue(cellDesc);
		vectorData.setSituationDescriptionForBLParser(cellValueDesc);
		
		for(byte pos : columnList){
			
			Cell cell = row.getCell(pos);
			String cellValue = getCellValue(cell);
			
			
			
			if(cellValue != "" && cellValue != null){				
				
				combinedWords.append(cellValue).append(" ");

				
				if(pos == 0){
					vectorData.setOrganizatioName(cellValue);
				}
				else if(pos == 1){
					vectorData.setOrganizationType(cellValue);
				}
				else if(pos == 2){
					vectorData.setOrganization(cellValue);
				}
				else if(pos == 3){
					vectorData.setFocusArea(cellValue);
				}
				else if(pos == 4){
					vectorData.setOrganizationWebsite(cellValue);
				}				
				else if(pos == 5){
					vectorData.setMissionStatement(cellValue);
				}
				else if(pos == 6){
					vectorData.setSizeOfOrganization(cellValue);
				}				
				else if(pos == 7){
					vectorData.setOrientationReach(cellValue);
				}				
				else if(pos == 8){
					vectorData.setGeographicalScope(cellValue);
				}
				else if(pos == 9){
					vectorData.setTargetAudience(cellValue);
				}
				else if(pos == 10){
					vectorData.setCity(cellValue);
				}				
				else if(pos == 11){
					vectorData.setState(cellValue);
				}
				else if(pos == 12){
					vectorData.setCountry(cellValue);
				}
				else if(pos == 13){
					vectorData.setRealOrganization(cellValue);
				}
				else if(pos == 14){
					vectorData.setSocialSector(cellValue);
				}
				else if(pos == 15){
					vectorData.setTechSector(cellValue);
				}
				else if(pos == 16){
					vectorData.setNeeder(cellValue);
				}				
				else if(pos == 17){
					vectorData.setProjectTitle(cellValue);
				}
				else if(pos == 18){
					vectorData.setSituationDescription(cellValue);
				}				
				else if(pos == 19){
					vectorData.setOnsite(cellValue);
				}				
				else if(pos == 20){
					vectorData.setTechnicalScope(cellValue);
				}				
				else if(pos == 21){
					vectorData.setSkillsNeeded(cellValue);
				}
				else if(pos == 22){
					vectorData.setPortalRelationship(cellValue);
				}
				else if(pos == 23){
					vectorData.setEstimatedProjectHours(cellValue);
				}
				else if(pos == 24){
					vectorData.setProjectOverView(cellValue);
				}
				
				
			}
		}
		
		return vectorData;
	}
	
	/**
	 * 
	 * @param vectorDataList
	 * @param columnList
	 */
	private void populateValuesIntoListFromFileAndAdditToWordDictionary(List<VectorData> vectorDataList,
			List<Byte> columnList){
		XSSFWorkbook workbook = null;
		try {

			FileInputStream file = new FileInputStream(new File(REVISED_INPUT_SHEET_NAME));

			//Get the workbook instance for XLS file 
			workbook = new XSSFWorkbook(file);

			//Get first sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);


			//Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();

			int rowCount = 0;
			
			while(rowIterator.hasNext() && rowCount < MAX_NO_OF_ROWS) {
				
				Row row = rowIterator.next(); 
				if(row.getRowNum() == 0){
					continue;
				}
				
				VectorData vectorData = getPopulatedVectorData(columnList, row);
				vectorDataList.add(vectorData);
				rowCount++;
				
			}
			
			
			file.close();
			workbook.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			
		}
	}



	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void readFromFile() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void readFromFile(String fileName) {
		// TODO Auto-generated method stub
		
	}
}
