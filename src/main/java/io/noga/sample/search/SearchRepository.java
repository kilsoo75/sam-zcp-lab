package io.noga.sample.search;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

@Repository
public class SearchRepository implements ApplicationContextAware {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchRepository.class);
	
	private JsonNode rootNode;
	
	@Autowired
	private ResourceLoader loader;
	
	@Value("${data.path}")
	private String dataPath;
	
	/**
	 * @param q
	 * @return
	 * @throws Exception
	 */
	public String search(String q) throws Exception {
		checkInitialized();
		
		logger.debug("search - {}", q);
		
		ObjectMapper result = new ObjectMapper();
		ArrayNode resultArray = result.createArrayNode();
		
		Iterator<JsonNode> elements = rootNode.elements();
		while (elements.hasNext()) {
			JsonNode next = elements.next();
			
			try {
				
				String tag = next.path("tags").get(0).textValue();
				if (q.equals(tag)) {
					logger.debug("Add this node - {}", next);
					resultArray.add(next);
				}
			} catch (NullPointerException ne) {
				// pass
				logger.error("Nullpointer", ne);
				logger.debug("Skip this node - {}", next);
			}
		}
		
		return resultArray.toString();
	}
	
	private void checkInitialized() throws Exception {
		if (rootNode == null) {
			throw new Exception("Data is null.");
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		try {
			Resource resource = loader.getResource(dataPath);
			
			// file = ResourceUtils.getFile(dataPath);
			ObjectMapper objectMapper = new ObjectMapper();
			rootNode = objectMapper.readTree(resource.getInputStream());
		} catch (FileNotFoundException e) {
			logger.error("{} not exists.", dataPath, e);
		} catch (JsonParseException e) {
			logger.error("Parsing error. {}", dataPath, e);
		} catch (JsonMappingException e) {
			logger.error("Could not mapp json object. {}", dataPath, e);
		} catch (IOException e) {
			logger.error("Could not read {}", dataPath, e);
		}
		
	}

}
