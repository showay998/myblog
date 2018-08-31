package com.xuwei.blog.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private transient Timestamp createDate;
	private transient Timestamp updateDate;
	private transient Boolean isValid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

}
