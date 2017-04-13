/**
 * 
 */
package org.spring.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author spark
 *
 */

@Controller
public class SparingbootController {
	@RequestMapping("/springboot/demo")
	public ModelAndView loadPage(){
		return new ModelAndView("welcome");
	}

}
