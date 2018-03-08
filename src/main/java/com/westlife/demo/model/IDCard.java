package com.westlife.demo.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "身份证信息", description = "身份证信息")
public class IDCard implements Serializable{

	private static final long serialVersionUID = 4716047378092754966L;
	
	@ApiModelProperty("省份id")
	private String provinceid;
	@ApiModelProperty("省份名称")
	private String province;
	
	
	@ApiModelProperty("城市id")
	private String cityid;
	@ApiModelProperty("城市名称")
	private String city;
	
	@ApiModelProperty("地区id")
	private String areaid;
	@ApiModelProperty("地区名称")
	private String area;
	@ApiModelProperty("出生日期")
	private String birthday;
	@ApiModelProperty("性别")
	private String sex;
	@ApiModelProperty("顺序码")
	private String number;
	@ApiModelProperty("信息描述")
	private String describe;
	
	
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
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	@Override
	public String toString() {
		return "IDCard [provinceid=" + provinceid + ", province=" + province + ", cityid=" + cityid + ", city=" + city
				+ ", areaid=" + areaid + ", area=" + area + ", birthday=" + birthday + ", sex=" + sex + ", number="
				+ number + ", describe=" + describe + "]";
	}
	
	
	
}
