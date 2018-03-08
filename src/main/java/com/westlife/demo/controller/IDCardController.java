package com.westlife.demo.controller;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

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
import org.springframework.ui.Model;
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

@Controller
// @RestController
@EnableScheduling // 定时任务的注解
public class IDCardController {
	protected static final Logger logger = LoggerFactory.getLogger(IDCardControllerSwagger.class);

	@Autowired
	private IDCardService idCardService;

	private ConcurrentHashMap<String, Object> pool = new ConcurrentHashMap<>();

	@Autowired
	private RedisTemplate redisTemplate;// 注入redisService类

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisService redisService;

	// 首页
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/query")
	public String queryIDCrad(RequestDto requestDto,Model model) throws ParseException{
		String IDCards=requestDto.getIDCard();
		
		String reg18 = "(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[0-9X]$)";
		Boolean bool=Pattern.matches(reg18, IDCards);
		if(!bool) {//不符合
			model.addAttribute("error","请输入正确的身份证号码格式，为18位");
			return "index";
		}
		IDCard idCard = idCardService.selectByIDCard(requestDto);
		if (idCard == null) {
			model.addAttribute("error","请输入正确的身份证号码");
			return "index";
		}
		System.out.println(idCard);
		model.addAttribute("idCard", idCard);
		return "info";
	}
}
