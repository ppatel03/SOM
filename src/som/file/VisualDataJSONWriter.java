package som.file;

import java.io.PrintWriter;


//static import
import static som.constants.IVisualizationConstants.VISUAL_JSON_JS_FILE;
import static som.constants.IVisualizationConstants.bmuCoordinatesJSONArray;


public class VisualDataJSONWriter implements IFileWritable {

	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub
		try{
			PrintWriter pw = new PrintWriter(VISUAL_JSON_JS_FILE);
			pw.print("var jsonCircles  = "+bmuCoordinatesJSONArray+";");
			pw.close();
		}
		catch(Exception e){
			System.out.println("class : VisualDataJSONWriter & method : writeToFileException while writing to JSON File"+e);
		}
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
