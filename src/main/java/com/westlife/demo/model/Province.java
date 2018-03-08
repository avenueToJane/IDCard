package com.westlife.demo.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "省份信息", description = "身份信息")
public class Province implements Serializable{
	
	private static final long serialVersionUID = 6800064366913732687L;
	@ApiModelProperty("唯一id")
	private int id;
	@ApiModelProperty("省份id")
	private String provinceid;
	@ApiModelProperty("省份名称")
	private String province;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	

}
