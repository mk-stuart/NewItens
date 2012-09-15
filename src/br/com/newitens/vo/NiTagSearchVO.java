/**
 * 
 */
package br.com.newitens.vo;

/**
 * @author Felipe
 *
 */
public class NiTagSearchVO {

	private long tagSearchId;        
	private String description;
	
	public NiTagSearchVO(){
		tagSearchId = 0;
		description = new String();
	}
	
	public NiTagSearchVO(long tagSearchId, String description){
		this.tagSearchId = tagSearchId;
		this.description = description;
	}

	public long getTagSearchId() {
		return tagSearchId;
	}

	public void setTagSearchId(long tagSearchId) {
		this.tagSearchId = tagSearchId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
