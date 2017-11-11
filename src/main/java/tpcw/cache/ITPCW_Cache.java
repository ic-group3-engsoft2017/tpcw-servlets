package tpcw.cache;

import java.util.Optional;

import tpcw.model.Entity;

public interface ITPCW_Cache {
	public void add(Entity entity);
	public Optional<Entity> getById(Long id);
}
