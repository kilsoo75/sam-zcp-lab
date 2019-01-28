package io.noga.sample.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

	private static final Logger logger = LoggerFactory.getLogger(SearchService.class);
	
	@Autowired
	private SearchRepository searchRepository;
	
	public String search(String q) throws Exception{
		logger.debug("search - {}", q);
		return searchRepository.search(q);
	}
}
