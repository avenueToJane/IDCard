package com.westlife.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.westlife.demo.mapper.IDCardMapper;
import com.westlife.demo.model.IDCard;




/**
 * 启动加载类
 * @author 28953
 *
 */
@Component
public class LoadDataService implements CommandLineRunner{
	
	protected static final Logger logger = LoggerFactory.getLogger(LoadDataService.class);
	@Autowired
	private IDCardMapper idCardMapper;

    @Override
    public void run(String... arg0) throws Exception {
    	logger.info("************************启动时加载数据(iDCardList数据)**********************》》》》》》》》");
            List<IDCard> list = idCardMapper.selectAll();
        
            RuntimeData.getIDCardMap().put("iDCardList", list);
       
       logger.info("************************结束加载数据(iDCardList数据)**********************》》》》》》》》");
       
    }
}
