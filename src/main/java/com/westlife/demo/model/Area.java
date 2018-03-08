package com.westlife.demo.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "地区信息", description = "地区信息")
public class Area implements Serializable{

	private static final long serialVersionUID = -7956896435095413930L;
	@ApiModelProperty("唯一id")
	private int id;
	@ApiModelProperty("地区id")
	private String areaid;
	@ApiModelProperty("地区名称")
	private String area;
	@ApiModelProperty("城市id")
	private String cityid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	

}
