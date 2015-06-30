package som.adapter;

//static imports
import static som.constants.IGenericConstants.inputValuesMap;
import static som.constants.IGenericConstants.INPUT_VECTOR_GENERATION_OPTION;

import som.helper.MenuDrivenVectorGenerator;

public class Struts2Adapter {

	public static String getInputVectorFileGenerationStatus( int secondOption){
		return MenuDrivenVectorGenerator.createInputVectorFilesForStruts2(inputValuesMap, INPUT_VECTOR_GENERATION_OPTION
				, secondOption);
	}
}
