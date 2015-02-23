/**
 * 
 * Bean Class to store all data related to single excel sheet column to be represented as the vector
 * 
 */

package som.beans;

import java.util.List;



public class VectorData {
	private String organizatioName	;
	private String organizationType	;
	private String organization ;
	private String focusArea	;
	private String organizationWebsite	;
	private String missionStatement	;
	private String sizeOfOrganization	;
	private String orientationReach	;
	private String geographicalScope	;	
	private String targetAudience;	
	private String city	;
	private String state;	
	private String Country	;
	private String realOrganization	;
	private String socialSector	;
	private String techSector;	
	private String needer;	
	private String projectTitle	;
	private String situationDescription	;
	private String projectOverView	;
	private String projectTitleForBLParser	;
	private String situationDescriptionForBLParser	;
	private String onsite;	
	private String technicalScope	;
	private String skillsNeeded	;
	private String portalRelationship	;
	private String estimatedProjectHours ;
	private List<Integer> vector;
	private List<Byte> vectorByte;
	private StringBuffer vectorString;
	
	public String getOrganizatioName() {
		return organizatioName;
	}
	public void setOrganizatioName(String organizatioName) {
		this.organizatioName = organizatioName;
	}
	public String getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getFocusArea() {
		return focusArea;
	}
	public void setFocusArea(String focusArea) {
		this.focusArea = focusArea;
	}
	public String getOrganizationWebsite() {
		return organizationWebsite;
	}
	public void setOrganizationWebsite(String organizationWebsite) {
		this.organizationWebsite = organizationWebsite;
	}
	public String getMissionStatement() {
		return missionStatement;
	}
	public void setMissionStatement(String missionStatement) {
		this.missionStatement = missionStatement;
	}
	public String getSizeOfOrganization() {
		return sizeOfOrganization;
	}
	public void setSizeOfOrganization(String sizeOfOrganization) {
		this.sizeOfOrganization = sizeOfOrganization;
	}
	public String getOrientationReach() {
		return orientationReach;
	}
	public void setOrientationReach(String orientationReach) {
		this.orientationReach = orientationReach;
	}
	public String getGeographicalScope() {
		return geographicalScope;
	}
	public void setGeographicalScope(String geographicalScope) {
		this.geographicalScope = geographicalScope;
	}
	public String getTargetAudience() {
		return targetAudience;
	}
	public void setTargetAudience(String targetAudience) {
		this.targetAudience = targetAudience;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getRealOrganization() {
		return realOrganization;
	}
	public void setRealOrganization(String realOrganization) {
		this.realOrganization = realOrganization;
	}
	public String getSocialSector() {
		return socialSector;
	}
	public void setSocialSector(String socialSector) {
		this.socialSector = socialSector;
	}
	public String getTechSector() {
		return techSector;
	}
	public void setTechSector(String techSector) {
		this.techSector = techSector;
	}
	public String getNeeder() {
		return needer;
	}
	public void setNeeder(String needer) {
		this.needer = needer;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getSituationDescription() {
		return situationDescription;
	}
	public void setSituationDescription(String situationDescription) {
		this.situationDescription = situationDescription;
	}
	public String getOnsite() {
		return onsite;
	}
	public void setOnsite(String onsite) {
		this.onsite = onsite;
	}
	public String getTechnicalScope() {
		return technicalScope;
	}
	public void setTechnicalScope(String technicalScope) {
		this.technicalScope = technicalScope;
	}
	public String getSkillsNeeded() {
		return skillsNeeded;
	}
	public void setSkillsNeeded(String skillsNeeded) {
		this.skillsNeeded = skillsNeeded;
	}
	public String getPortalRelationship() {
		return portalRelationship;
	}
	public void setPortalRelationship(String portalRelationship) {
		this.portalRelationship = portalRelationship;
	}
	public String getEstimatedProjectHours() {
		return estimatedProjectHours;
	}
	public void setEstimatedProjectHours(String estimatedProjectHours) {
		this.estimatedProjectHours = estimatedProjectHours;
	}
	public List<Integer> getVector() {
		return vector;
	}
	public void setVector(List<Integer> vector) {
		this.vector = vector;
	}
	@Override
	public String toString() {
		return " "
				+ (organizatioName != null ? organizatioName + " " : "")
				+ (organizationType != null ?  organizationType + " " : "")
				+ (organization != null ?  organization + " "	: "")
				+ (focusArea != null ?  focusArea + " " : "")
				+ (organizationWebsite != null ?  organizationWebsite + " " : "")
				+ (missionStatement != null ? missionStatement + " " : "")
				+ (sizeOfOrganization != null ?  sizeOfOrganization + " " : "")
				+ (orientationReach != null ?  orientationReach + " " : "")
				+ (geographicalScope != null ?  geographicalScope + " " : "")
				+ (targetAudience != null ?  targetAudience	+ ", " : "")
				+ (city != null ?  city + " " : "")
				+ (state != null ? state + " " : "")
				+ (Country != null ?  Country + " " : "")
				+ (realOrganization != null ? realOrganization + " " : "")
				+ (socialSector != null ? socialSector + " "						: "")
				+ (techSector != null ?  techSector + " " : "")
				+ (needer != null ?  needer + " " : "")
				+ (projectTitle != null ? projectTitle + " "	: "")
				+ (situationDescription != null ? situationDescription + " " : "")
				+ (projectOverView != null ? projectOverView + " " : "")
				+ (onsite != null ?  onsite + " " : "")
				+ (technicalScope != null ?  technicalScope		+ " " : "")
				+ (skillsNeeded != null ?  skillsNeeded + " ": "")
				+ (portalRelationship != null ?portalRelationship + " " : "")
				+ (estimatedProjectHours != null ?  estimatedProjectHours + " " : "")
				+ (vector != null ?  vector : "") ;
	}
	public StringBuffer getVectorString() {
		return vectorString;
	}
	public void setVectorString(StringBuffer vectorString) {
		this.vectorString = vectorString;
	}
	public List<Byte> getVectorByte() {
		return vectorByte;
	}
	public void setVectorByte(List<Byte> vectorByte) {
		this.vectorByte = vectorByte;
	}
	public String getProjectTitleForBLParser() {
		return projectTitleForBLParser;
	}
	public void setProjectTitleForBLParser(String projectTitleForBLParser) {
		this.projectTitleForBLParser = projectTitleForBLParser;
	}
	public String getSituationDescriptionForBLParser() {
		return situationDescriptionForBLParser;
	}
	public void setSituationDescriptionForBLParser(
			String situationDescriptionForBLParser) {
		this.situationDescriptionForBLParser = situationDescriptionForBLParser;
	}
	/**
	 * @return the projectOverView
	 */
	public String getProjectOverView() {
		return projectOverView;
	}
	/**
	 * @param projectOverView the projectOverView to set
	 */
	public void setProjectOverView(String projectOverView) {
		this.projectOverView = projectOverView;
	}
	
	
}
