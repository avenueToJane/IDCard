package com.westlife.demo.controller;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
/*import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;*/
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.westlife.demo.common.AjaxResult;
import com.westlife.demo.common.GeneralException;
import com.westlife.demo.common.RequestDto;
import com.westlife.demo.common.RequestUser;
import com.westlife.demo.model.IDCard;
import com.westlife.demo.model.Province;

import com.westlife.demo.service.IDCardService;
import com.westlife.demo.service.RedisService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@Controller
@Api(value = "根据查询身份证号查询身份信息Swagger",description="简单的API")
@RestController
@EnableScheduling//定时任务的注解
public class IDCardControllerSwagger
{
	protected static final Logger logger = LoggerFactory.getLogger(IDCardControllerSwagger.class);

	@Autowired
	private IDCardService idCardService;
	
	private ConcurrentHashMap<String, Object> pool = new ConcurrentHashMap<>();

	@Autowired
	private RedisTemplate   redisTemplate;//注入redisService类
	 
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisService redisService;
	
	@ApiOperation(value = "查询身份证信息", notes = "根据查询身份证号查询身份信息")
	@RequestMapping(value="/queryIDCrad", method = RequestMethod.POST)
	public IDCard queryIDCrad(@ApiParam("身份证号码") @Valid @RequestBody(required = true)RequestDto requestDto
			,BindingResult result) throws GeneralException, ParseException{
		if (result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
			throw new GeneralException("5001" ,fieldErrors.get(0).getDefaultMessage());
		}
		
		IDCard idCard=idCardService.selectByIDCard(requestDto);
		if(idCard==null) {
			throw new GeneralException("5002" ,"请输入正确的身份证号码");
		}
		pool.put("idCard", idCard);
		redisService.setObj("idCardRedis", idCard);
		pool.put("idCardMap", idCard);
		return idCard;
	}
	/*@ApiOperation(value = "查询ConcurrentHashMap的idCard缓存", notes = "缓存obj") 
	@RequestMapping(value="/queryMapIdCard", method = RequestMethod.POST)
	public Object queryMapList(){
		
		return pool.get("idCardMap");//从缓存map中拿数据;
	}
	
	@ApiOperation(value = "查询Redis的IdCard缓存", notes = "缓存obj") 
	@RequestMapping(value="/queryRedisIdCard", method = RequestMethod.POST)
	public Object queryRedisList(){
		return redisService.getObj("idCardRedis");//从缓存redis中拿数据;
	}
	
	// 每1分钟执行一次
		@Scheduled(cron = "0 0/1 * * * ? ")
		public void timer() {
			redisService.flushDB();//清空所有redis数据
		}*/
}
