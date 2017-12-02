package tpcw.group3.cache.model.criteria;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Criteria.
 */
public class Criteria {

	/**
	 * Instantiates a new Criteria.
	 */
	public Criteria() {
		numberOfHits = new AtomicInteger();
	}

	private AtomicInteger numberOfHits;

	/**
	 * Gets number of hits.
	 *
	 * @return the number of hits
	 */
	public Integer getNumberOfHits() {
		return numberOfHits.get();
	}

	/**
	 * Add hit.
	 */
	public void addHit() {
		numberOfHits.incrementAndGet();
	}

	@Override
	public String toString() {
		return "Criteria{" +
				"numberOfHits=" + numberOfHits +
				'}';
	}
}
