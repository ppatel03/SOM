/**
 * 
 * Helper class containing utility method for computing  distance between the two vectors
 * 
 */
package som.helper;

import static som.constants.IGenericConstants.bestWordFileOptionForSituationDescription;
import static som.constants.IGenericConstants.bestWordFileOptionForSituationDescriptionAndMissionStatement;
import static som.constants.IGenericConstants.stemmedBestWordFileOptionForSituationDescriptionAndMissionStatement;
import static som.constants.IGenericConstants.stemmendBestWordFileOptionForSituationDescription;
import static som.constants.IVisualizationConstants.MIN_DIMENSION;
import static som.constants.IVisualizationConstants.MAX_DIMENSION;



import java.util.List;

import som.beans.VectorCoordinate;

public class GenericHelper {
	
	public static double computeEuclideanDistanceForCoordinates(List<Integer> coordinate1, List<Integer> coordinate2)
	{
		double squareDistance = 0;
		double squareRootDistance = 0;
		for (int i = 0; i < coordinate1.size(); i++)
		{
			squareDistance += coordinate1.get(i) * coordinate2.get(i);
		}
		squareRootDistance = Math.sqrt(squareDistance);
		return squareRootDistance;
	}
	
	/**
	 * 
	 * @param secondOption
	 * @return whether the menu selection matches the best words option
	 */
	public static boolean isBestWordsOptionSelected(int secondOption){
		return secondOption == bestWordFileOptionForSituationDescription ||
				secondOption == bestWordFileOptionForSituationDescriptionAndMissionStatement ||
				secondOption == stemmendBestWordFileOptionForSituationDescription ||
				secondOption == stemmedBestWordFileOptionForSituationDescriptionAndMissionStatement;
	}
	
	/**
	 * 
	 * @param secondOption
	 * @return whether the menu selection matches the stemmed best words option
	 */
	public static boolean isStemmedBestWordsSelected(int secondOption){
		return secondOption == stemmendBestWordFileOptionForSituationDescription ||
				secondOption == stemmedBestWordFileOptionForSituationDescriptionAndMissionStatement;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param dimensionList
	 * @return whether the point does not overlapp with one another
	 */
	public static boolean isDimensionCorrect(double x, double y, List<VectorCoordinate> dimensionList){
				
		boolean isDimensionCorrect = true;
		
		if(x <= MIN_DIMENSION || y<= MIN_DIMENSION || x >= MAX_DIMENSION || y >= MAX_DIMENSION){
			return false;
		}
		
		for(VectorCoordinate eachVectorCoordinate : dimensionList){
			if(eachVectorCoordinate.isOverlapping(x, y)){
				System.out.println(eachVectorCoordinate+ " is overalpping with x = "+x+" and y ="+y);
				isDimensionCorrect = false;
				break;
			}
		}
		
		return isDimensionCorrect;
	}

}
