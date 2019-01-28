package io.noga.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class SampleApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHome() {
		logger.debug("getHome");
		return "Hello prod application!.";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean loggingFilter(){
	    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
	    
	    registrationBean.setFilter(new MdcLoggingFilter());
	         
	    return registrationBean;    
	}
}

