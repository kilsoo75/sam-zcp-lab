package io.noga.sample.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private SearchService service;
	
	@GetMapping("/search") 
	public String search(@RequestParam String q) throws Exception {
		logger.info("--------- search start ----------");
		logger.debug("Param is {}", q);
		
		return service.search(q);
	}
}
