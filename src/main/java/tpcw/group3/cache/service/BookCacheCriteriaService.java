package tpcw.group3.cache.service;

import tpcw.group3.cache.model.CachableEntity;
import tpcw.group3.cache.model.criteria.Criteria;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Level.*;

/**
 * The type Book cache criteria service.
 */
public class BookCacheCriteriaService implements CacheCriteria {

    private static Logger LOG = Logger.getLogger(BookCacheCriteriaService.class.getName());

	private static BookCacheCriteriaService service;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static BookCacheCriteriaService getInstance() {
		if (service == null) {
			service = new BookCacheCriteriaService();
		}
		return service;
	}

    private SortedMap<Criteria, List<CachableEntity>> cacheMap;
    private final AtomicInteger CACHE_BUFFER = new AtomicInteger(50);
    private final int CACHE_THRESHOLD = 1000;

    /**
     * Instantiates a new Book cache criteria service.
     */
    public BookCacheCriteriaService() {
    	cacheMap = new TreeMap<>(Comparator.comparing(Criteria::getNumberOfHits));
    }

	public void add(Criteria criteria, List<CachableEntity> entities) {
		if (cacheMap.containsKey(criteria)) {
			cacheMap.get(criteria);
		}
		cache(criteria, entities);
	}
	
	public List<CachableEntity> getByCriteria(Criteria criteria) {
        LOG.log(INFO, String.format("GETTING CRITERIA {} ", criteria));
        // Add a hit to cache if cache present and Return
        Optional<Criteria> criteriaOptional = cacheMap.keySet().stream().filter(cacheKey -> cacheKey.equals(criteria)).findAny();
        criteriaOptional.ifPresent(Criteria::addHit);
		if (cacheMap.containsKey(criteria)) {
            LOG.log(INFO, String.format("GOT CRITERIA {} FROM CACHE", criteria));
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
        if( cacheMap.size() < CACHE_BUFFER.get()) {
            criteria.addHit();
            cacheMap.put(criteria, entities);
        } else  {
          LOG.log(INFO, "APPLYING POLICY");
          applyPolicy(criteria, entities);
        }

	}

	private void applyPolicy(Criteria criteria, List<CachableEntity> entities) {
        if(CACHE_THRESHOLD < cacheMap.size()) {
            CACHE_BUFFER.addAndGet(CACHE_BUFFER.get());
            cacheMap.put(criteria, entities);
        } else {
            LOG.log(SEVERE, "CACHE NOT ADDED DUE TO BUFFER HIT THRESOLD");
        }
	}

}
