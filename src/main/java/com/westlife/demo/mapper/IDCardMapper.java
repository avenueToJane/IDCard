package com.westlife.demo.mapper;


import java.util.List;

import com.westlife.demo.model.IDCard;

public interface IDCardMapper {
	
   IDCard selectByIDCard(String areaid);
   List<IDCard> selectAll();
}
