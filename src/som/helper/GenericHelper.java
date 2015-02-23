/**
 * 
 * Helper class containing utility method for computing  distance between the two vectors
 * 
 */
package som.helper;

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

}
