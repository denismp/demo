/**
 * 
 */
package com.example.demo.view.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author denisputnam
 *
 */
public abstract class History implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7899925096623354858L;
	protected String createdBy;
	protected Date createdDate;
	protected String updatedBy;
	protected Date updatedDate;
	
	/**
	 * @return the createdBy
	 */
	public abstract String getCreatedBy();
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the createdDate
	 */
	public abstract Date getCreatedDate();
	/**
	 * @param createdDate the createdDate to set
	 */
	public abstract void setCreatedDate(Date createdDate);
	/**
	 * @return the updatedBy
	 */
	public abstract String getUpdatedBy();
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public abstract void setUpdatedBy(String updatedBy);
	/**
	 * @return the updatedDate
	 */
	public abstract Date getUpdatedDate();
	/**
	 * @param updatedDate the updatedDate to set
	 */
	public abstract void setUpdatedDate(Date updatedDate);

}
