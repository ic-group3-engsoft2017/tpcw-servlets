package tpcw.group3.cache.service;

import tpcw.group3.cache.model.CachableEntity;
import tpcw.group3.cache.model.criteria.Criteria;

import java.util.*;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;

public class BookCacheCriteriaService implements CacheCriteria {

    private static Logger LOG = Logger.getLogger("BookCacheCriteriaService");

	private static BookCacheCriteriaService service;

	public static BookCacheCriteriaService getInstance() {
		if (service == null) {
			service = new BookCacheCriteriaService();
		}
		return service;
	}

    private Map<Criteria, List<CachableEntity>> cacheMap;
    private final int CACHE_BUFFER = 50;
    
    public BookCacheCriteriaService() {
    	cacheMap = new HashMap<>();
    }

	public void add(Criteria criteria, List<CachableEntity> entities) {
		if (cacheMap.containsKey(criteria)) {
			cacheMap.get(criteria);
		}
		cache(criteria, entities);
	}
	
	public List<CachableEntity> getByCriteria(Criteria criteria) {
        // Add a hit to cache if cache present and Return
        Optional<Criteria> criteriaOptional = cacheMap.keySet().stream().filter(cacheKey -> cacheKey.equals(criteria)).findAny();
        criteriaOptional.ifPresent(Criteria::addHit);
		if (cacheMap.containsKey(criteria)) {
		    return cacheMap.get(criteria);
        }
		return Collections.emptyList();
	}

	private void cache(Criteria criteria, List<CachableEntity> entities) {
        Optional<Criteria> criteriaOptional = cacheMap.keySet().stream().filter(cacheKey -> cacheKey.equals(criteria)).findAny();
        if(criteriaOptional.isPresent() ) {
            LOG.log(SEVERE, "CACHE NOT ADDED DUE TO IT IS ALREADY IN BUFFER");
            return;
        }

        // If not Present check if Buffer is full to add
        if( cacheMap.size() < CACHE_BUFFER) {
            criteria.addHit();
            cacheMap.put(criteria, entities);
        } else  {
          LOG.log(INFO, "CACHE NOT ADDED DUE TO BUFFER FULL");
        }

	}

}
