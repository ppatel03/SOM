package som.visualization;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import org.json.JSONArray;

import som.beans.SOMDimensionRelation;
import som.helper.DocumentVisualizationDetailsHelper;

//static imports
import static som.constants.IDWMFileConstants.dwmInfoMap;
import static som.constants.IVisualizationConstants.lamba;
import static som.constants.IVisualizationConstants.svgColorList;
import static som.constants.IVisualizationConstants.bmuCoordinatesList;


public  class DocumentPositionCalculator {
	
	public  void storeTraingularCoordinates(){		
		
		
		for(Map.Entry<Integer, PriorityQueue<SOMDimensionRelation>> entry : dwmInfoMap.entrySet()){
			int documentNumber = entry.getKey();
			PriorityQueue<SOMDimensionRelation> docQueue = entry.getValue();
			SOMDimensionRelation node1 =  docQueue.poll();
			SOMDimensionRelation node2 =  docQueue.poll();
			SOMDimensionRelation node3 =  docQueue.poll();
			SOMDimensionRelation node4 =  docQueue.poll();
			
			int node1X = node1.getxPosition();
			int node1Y = node1.getyPosition();
			double node1Distance = node1.getDistance();
			
			int node2X = node2.getxPosition();
			int node2Y = node2.getyPosition();
			double node2Distance = node2.getDistance();
			
			int node3X = node3.getxPosition();
			int node3Y = node3.getyPosition();
			double node3Distance = node3.getDistance();
			
			int node4X = node4.getxPosition();
			int node4Y = node4.getyPosition();
			double node4Distance = node4.getDistance();
			
			boolean isNode4Needed = false;
			//check if Node4 is needed
			if((node1X == node2X && node2X== node3X && node1X == node3X) ||
					(node1Y == node2Y && node2Y== node3Y && node1Y == node3Y)){
				isNode4Needed = true;
			}
			
			//calculating the relative force
			double force1= node1Distance/node2Distance;
			double force2= node1Distance/node3Distance;
			double force3 = (isNode4Needed) ? node1Distance/node4Distance : 0;
			
			//calculating the distance relation
			double force1X = (node1X == node2X)?0:(1/(node2X - node1X ));
			double force1Y = (node1Y == node2Y)?0:(1/(node2Y - node1Y ));
			
			double force2X = (node1X == node3X)?0:(1/(node3X - node1X ));			
			double force2Y = (node1Y == node3Y)?0:(1/(node3Y - node1Y ));
			
			double force3X = (node1X == node4X)?0:(1/(node4X - node1X ));
			double force3Y = (node1Y == node4Y)?0:(1/(node4Y - node1Y ));
			
			//calculating the final displacement Coordinate
			double bmuX = ((lamba*force1*force1X) + (lamba*force2*force2X) + (lamba*force3*force3X))+(node1X*100+50);
			double bmuY = ((lamba*force1*force1Y) + (lamba*force2*force2Y) + (lamba*force3*force3Y))+(node1Y*100+50);

			//selecting the random color for this document 
			int colorIndex = (int)(Math.random()*svgColorList.size());
			
			Map<String,Object> visualDocumentsMap = new HashMap<String,Object>();
			visualDocumentsMap.put("x_axis", bmuX);
			visualDocumentsMap.put("y_axis", bmuY);
			visualDocumentsMap.put("radius", 5);
			visualDocumentsMap.put("color", svgColorList.get(colorIndex));
			visualDocumentsMap.put("documentNumber", documentNumber);			
			Map<String,String> trainingDataFromSheetMap = DocumentVisualizationDetailsHelper.getSituationDescriptionFromExcelSheet(
					9, documentNumber);
			trainingDataFromSheetMap.put("organization_name", trainingDataFromSheetMap.get("organization_name"));
			trainingDataFromSheetMap.put("organization_website", trainingDataFromSheetMap.get("organization_website"));
			trainingDataFromSheetMap.put("social_sector", trainingDataFromSheetMap.get("social_sector"));
			trainingDataFromSheetMap.put("tech_sector", trainingDataFromSheetMap.get("tech_sector"));
			trainingDataFromSheetMap.put("situation_description", trainingDataFromSheetMap.get("situation_description"));
			trainingDataFromSheetMap.put("technical_scope", trainingDataFromSheetMap.get("technical_scope"));

			bmuCoordinatesList.put(visualDocumentsMap);
			//for debudgging
			System.out.print("Document Number :"+documentNumber);
			System.out.print(" bmuX:"+bmuX);
			System.out.println(" bmuY:"+bmuY);
		}
		
		System.out.println(bmuCoordinatesList);
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<String, Object>();
	    data.put( "name", "Mars" );
	    data.put( "age", 32 );
	    data.put( "city", "NY" );
	    
	    Map<String, Object> data2 = new HashMap<String, Object>();
	    data2.put( "name", "palebt" );
	    data2.put( "age", 21 );
	    data2.put( "city", "NY" );
	    
		System.out.println(DocumentVisualizationDetailsHelper.getSituationDescriptionFromExcelSheet(9, 0));


	    JSONArray list = new JSONArray();
	    list.put(data);
	    list.put(data2);

	    //System.out.printf( "JSON: %s", list ); 
	    
	   // System.out.println();
	    //DWMFileReader.readFromFileStatic();
	   // storeTraingularCoordinates();
	    
	    
	    
	}

}