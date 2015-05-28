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

import java.util.List;

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

}
