package com.westlife.demo.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "身份证信息", description = "身份证信息")
public class IDCard implements Serializable{

	private static final long serialVersionUID = 4716047378092754966L;
	@ApiModelProperty("省份证号码")
	private String IDCard;
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
	@ApiModelProperty("校验码")
	private String checkCode;
	@ApiModelProperty("地址码")
	private String addressCode;
	@ApiModelProperty("出生日期码")
	private String birthCode;
	
	@ApiModelProperty("信息描述")
	private String describe;
	@ApiModelProperty("年龄")
	private String age;
	@ApiModelProperty("来到世多少天")
	private String lifeDay;
	@ApiModelProperty("来到世多少毫秒")
	private String millisecond;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getLifeDay() {
		return lifeDay;
	}
	public void setLifeDay(String lifeDay) {
		this.lifeDay = lifeDay;
	}
	public String getMillisecond() {
		return millisecond;
	}
	public void setMillisecond(String millisecond) {
		this.millisecond = millisecond;
	}
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	public String getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	public String getBirthCode() {
		return birthCode;
	}
	public void setBirthCode(String birthCode) {
		this.birthCode = birthCode;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	@Override
	public String toString() {
		return "IDCard [IDCard=" + IDCard + ", provinceid=" + provinceid + ", province=" + province + ", cityid="
				+ cityid + ", city=" + city + ", areaid=" + areaid + ", area=" + area + ", birthday=" + birthday
				+ ", sex=" + sex + ", number=" + number + ", checkCode=" + checkCode + ", addressCode=" + addressCode
				+ ", birthCode=" + birthCode + ", describe=" + describe + ", age=" + age + ", lifeDay=" + lifeDay
				+ ", millisecond=" + millisecond + "]";
	}
	
	
	
	
}
