package com.westlife.demo.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "城市信息", description = "城市信息")
public class City implements Serializable{

	private static final long serialVersionUID = 2189587471657120426L;
	@ApiModelProperty("唯一id")
	private int id;
	@ApiModelProperty("城市id")
	private String cityid;
	@ApiModelProperty("城市名称")
	private String city;
	@ApiModelProperty("省份id")
	private String provinceid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	


}
