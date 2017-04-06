/**
 * 
 */
package com.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author spark
 *
 */

@Controller
public class SpringBootController {
	
	@RequestMapping("/springboot/demo")
	public ModelAndView loadPag(){
		return new ModelAndView("welcome");
	}

}
