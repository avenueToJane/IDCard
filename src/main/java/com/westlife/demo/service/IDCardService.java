package com.westlife.demo.service;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.westlife.demo.common.RequestDto;
import com.westlife.demo.mapper.IDCardMapper;
import com.westlife.demo.model.IDCard;
import com.westlife.demo.util.ConcurrentDateUtil;
import com.westlife.demo.util.DateDay;

@Service
public class IDCardService {
	
	protected static final Logger logger = LoggerFactory.getLogger(IDCardService.class);
	@Autowired
	private IDCardMapper idCardMapper;
	public IDCard selectByIDCard(RequestDto requestDto) throws ParseException {
		String areas=requestDto.getIDCard().substring(0, 6);//前六位为行政区划代码
		IDCard idcard = idCardMapper.selectByIDCard(areas);
		if(idcard==null) {
			return null;
		}
		idcard.setIDCard(requestDto.getIDCard());
		String year=requestDto.getIDCard().substring(6, 10);//出生年
		String month=requestDto.getIDCard().substring(10, 12);//出生月
		String day=requestDto.getIDCard().substring(12, 14);//出生日
		String birthday=year+"年"+month+"月"+day+"日";//出生年月日
		idcard.setBirthday(birthday);
		idcard.setNumber(requestDto.getIDCard().substring(14, 17));//顺序码
		idcard.setAddressCode(areas);//地址码
		idcard.setBirthCode(requestDto.getIDCard().substring(6, 14));//出生日期码
		idcard.setCheckCode(requestDto.getIDCard().substring(17, 18));//校验码
		String sex=requestDto.getIDCard().substring(16, 17);
		Date date=new Date();
		String nowYear=ConcurrentDateUtil.formatDateYYYY(date);//当前年份
		String age=String.valueOf(Integer.valueOf(nowYear)-Integer.valueOf(year));
		idcard.setAge(age);//年龄
		String lifeDay=DateDay.day(requestDto.getIDCard().substring(6, 14));
		String millisecond=DateDay.millisecond(requestDto.getIDCard().substring(6, 14));
		idcard.setMillisecond(millisecond);
		idcard.setLifeDay(lifeDay);
		int sexInt=Integer.valueOf(sex);
		if(sexInt%2!=0) {//基数
				idcard.setSex("男");
		}else {//偶数
				idcard.setSex("女");
		}
		String describe=
		"  省份："+idcard.getProvince()+
		"  所属市："+idcard.getCity()+
		"  县区："+idcard.getArea()+
		"  出生年月："+birthday+
		"  性别："+idcard.getSex()+
		"  年龄："+idcard.getAge()+
		"  你来到这个世界：" + idcard.getLifeDay() + "天"+
		"  你来到这个世界：" + idcard.getMillisecond() + "毫秒"+
		"  地址码："+idcard.getAddressCode()+
		"  出生日期码："+idcard.getBirthCode()+
		"  顺序码："+idcard.getNumber()+
		"  校验码："+idcard.getCheckCode();
		
		idcard.setDescribe(describe);
		return idcard;
	}
	
	public List<IDCard> selectAll() {
		List<IDCard> idCardsList=idCardMapper.selectAll();
		return idCardsList;
	}

	public IDCard selectByAreaId(String areaId) {
		
		return idCardMapper.selectByAreaId(areaId);
	}

}
