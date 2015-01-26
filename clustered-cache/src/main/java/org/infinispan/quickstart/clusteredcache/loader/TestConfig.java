package org.infinispan.quickstart.clusteredcache.loader;

import java.util.Properties;

import org.infinispan.commons.configuration.BuiltBy;
import org.infinispan.commons.configuration.ConfigurationFor;
import org.infinispan.configuration.cache.AbstractStoreConfiguration;
import org.infinispan.configuration.cache.AsyncStoreConfiguration;
import org.infinispan.configuration.cache.SingletonStoreConfiguration;

@BuiltBy(TestConfigBuilder.class)
@ConfigurationFor(TestCacheLoader.class)
public class TestConfig extends AbstractStoreConfiguration {

	private String nodeName;

	public TestConfig(boolean purgeOnStartup, boolean fetchPersistentState, boolean ignoreModifications,
			AsyncStoreConfiguration async, SingletonStoreConfiguration singletonStore, boolean preload, boolean shared,
			Properties properties, String nodeName) {
		super(purgeOnStartup, fetchPersistentState, ignoreModifications, async, singletonStore, preload, shared,
				properties);

		this.nodeName = nodeName;
	}

	public String nodeName() {
		return nodeName;
	}

}
