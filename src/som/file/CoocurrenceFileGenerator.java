package som.file;

import static som.constants.IGenericConstants.REVISED_INPUT_SHEET_NAME;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CoocurrenceFileGenerator implements IFileWritable{



	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub


	}


	public void createVectorDimensionAndWriteIntoFile(String[] words){
		try{
			PrintWriter pw = new PrintWriter("bestwords.txt");
			pw.println(words[0]+","+words[1]);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void readFromFile() {
		BufferedReader br = null;
		String line = "";
		try{
			// TODO Auto-generated method stub
			br = new BufferedReader(new FileReader("output_cooccurrOfmergedSitDescOnly.csv"));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] words = line.split(",");

				createVectorDimensionAndWriteIntoFile(words);

			}
		}
		catch(Exception e ){
			e.printStackTrace();
		}

	}

	/**
	 *  main function used for testing
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoocurrenceFileGenerator cf = new CoocurrenceFileGenerator();
		cf.readFromFile();
	}



}
