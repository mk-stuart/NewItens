package br.com.newitens.vo;

public class NiFeatureVO {
	
	private long featureId;        
	private long fatherFeatureId;        
	private String description;
	
	public NiFeatureVO(){
		featureId = 0;
		fatherFeatureId = 0;
		description = new String();
	}
	
	public NiFeatureVO(long featureId, long fatherFeatureId, String description){
		this.featureId = featureId;
		this.fatherFeatureId = fatherFeatureId;
		this.description = description;
	}

	public long getFeatureId() {
		return featureId;
	}

	public void setFeatureId(long featureId) {
		this.featureId = featureId;
	}

	public long getFatherFeatureId() {
		return fatherFeatureId;
	}

	public void setFatherFeatureId(long fatherFeatureId) {
		this.fatherFeatureId = fatherFeatureId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
