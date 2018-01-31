package com.dzpykj.enums.test02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EnumTestController {
	@RequestMapping("/testEnum")
	@ResponseBody
	public Object testEnum(){
		return Constant.Gender.man;
		//return new User("1", "sdf", 24, "sdf");
	}
}
