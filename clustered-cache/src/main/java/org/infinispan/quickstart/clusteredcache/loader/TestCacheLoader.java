package org.infinispan.quickstart.clusteredcache.loader;

import org.infinispan.marshall.core.MarshalledEntry;
import org.infinispan.persistence.spi.CacheLoader;
import org.infinispan.persistence.spi.InitializationContext;

public class TestCacheLoader implements CacheLoader<Integer, String> {

	private InitializationContext ctx;
	private String nodeName;

	@Override
	public void start() {
		// nothing to do
	}

	@Override
	public void stop() {
		// nothing to do
	}

	@Override
	public void init(InitializationContext ctx) {
		this.ctx = ctx;
		TestConfig configuration = ctx.getConfiguration();
		nodeName = configuration.nodeName();
	}

	@Override
	public MarshalledEntry<Integer, String> load(Integer key) {
		System.out.println("Loading value for key " + key);

		String value = key.toString() + " loaded by " + nodeName;

		return createResult(key, value);
	}

	private <K, V> MarshalledEntry<K, V> createResult(K key, V value) {
		if (value == null) {
			return null;
		} else {
			return createMarshalledEntry(key, value);
		}
	}

	@SuppressWarnings("unchecked")
	private <K, V> MarshalledEntry<K, V> createMarshalledEntry(K key, V value) {
		return ctx.getMarshalledEntryFactory().newMarshalledEntry(key, value, null);
	}

	@Override
	public boolean contains(Integer key) {
		return true;
	}

}
