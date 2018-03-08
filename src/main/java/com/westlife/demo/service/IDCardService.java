package com.westlife.demo.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.westlife.demo.common.RequestDto;
import com.westlife.demo.mapper.IDCardMapper;
import com.westlife.demo.model.IDCard;

@Service
public class IDCardService {
	
	protected static final Logger logger = LoggerFactory.getLogger(IDCardService.class);
	@Autowired
	private IDCardMapper idCardMapper;
	public IDCard selectByIDCard(RequestDto requestDto) {
		String areas=requestDto.getIDCard().substring(0, 6);//前六位为行政区划代码
		IDCard idcard = idCardMapper.selectByIDCard(areas);
		if(idcard==null) {
			return null;
		}
		String year=requestDto.getIDCard().substring(6, 10);//出生年
		String month=requestDto.getIDCard().substring(10, 12);//出生月
		String day=requestDto.getIDCard().substring(12, 14);//出生日
		String birthday=year+"年"+month+"月"+day+"日";//出生年月日
		idcard.setBirthday(birthday);
		idcard.setNumber(requestDto.getIDCard().substring(14, 17));//顺序码
		String sex=requestDto.getIDCard().substring(17, 18);
		if(!"X".equals(sex)) {
			int sexInt=Integer.valueOf(sex);
			if(sexInt%2==0) {//偶数
				idcard.setSex("男");
			}else {
				idcard.setSex("女");
			}
		}else {
			idcard.setSex("男");
		}
		String describe="省份："+idcard.getProvince()+"  所属市："+idcard.getCity()+"  县区："+idcard.getArea()
		+"  出生年月："+birthday+"  性别："+idcard.getSex()+"  顺序码："+idcard.getNumber();
		idcard.setDescribe(describe);
		return idcard;
	}

}
