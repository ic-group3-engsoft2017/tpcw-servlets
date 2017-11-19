package tpcw.group3.cache.service;

import tpcw.group3.cache.model.CachableEntity;
import tpcw.group3.cache.model.criteria.Criteria;

import java.util.*;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

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
		if (cacheMap.containsKey(criteria)) {
		    return cacheMap.get(criteria);
        }
		return Collections.emptyList();
	}

	private void cache(Criteria criteria, List<CachableEntity> entities) {
        // Add a hit to cache if cache present and Return
        Optional<Criteria> criteriaOptional = cacheMap.keySet().stream().filter(cacheKey -> cacheKey.equals(criteria)).findAny();
        criteriaOptional.ifPresent(Criteria::addHit);
        if(criteriaOptional.isPresent() ) {
            return;
        }

        // If not Present check if Buffer is full to add
        if( cacheMap.size() < CACHE_BUFFER) {
            cacheMap.put(criteria, entities);
        } else  {
          LOG.log(INFO, "CACHE NOT ADDED DUE TO BUFFER FULL");
        }

	}
	
	private TreeSet<CachableEntity> createNewSet() {
		return new TreeSet<>(Comparator.comparingInt(CachableEntity::getNumberOfHits).reversed());
	}	
	



	
}
