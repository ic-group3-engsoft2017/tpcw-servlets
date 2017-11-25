package tpcw.group3.cache.model.criteria;

import java.util.concurrent.atomic.AtomicInteger;

public class Criteria {

	public Criteria() {
		numberOfHits = new AtomicInteger();
	}

	private AtomicInteger numberOfHits;

	public Integer getNumberOfHits() {
		return numberOfHits.get();
	}

	public void addHit() {
		numberOfHits.incrementAndGet();
	}

}
