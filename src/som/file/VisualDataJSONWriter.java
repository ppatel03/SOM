package som.file;

import java.io.PrintWriter;

//static import
import static som.constants.IVisualizationConstants.VISUAL_JSON_JS_FILE;
import static som.constants.IVisualizationConstants.bmuCoordinatesList;


public class VisualDataJSONWriter implements IFileWritable {

	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub
		try{
			PrintWriter pw = new PrintWriter(VISUAL_JSON_JS_FILE);
			pw.print("var jsonCircles  = "+bmuCoordinatesList+";");
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

}
