package org.infinispan.quickstart.clusteredcache.loader;

import org.infinispan.commons.configuration.Builder;
import org.infinispan.configuration.cache.AbstractStoreConfigurationBuilder;
import org.infinispan.configuration.cache.PersistenceConfigurationBuilder;

public class TestConfigBuilder extends AbstractStoreConfigurationBuilder<TestConfig, TestConfigBuilder> {

	private String nodeName;

	public TestConfigBuilder(PersistenceConfigurationBuilder builder) {
		super(builder);
	}

	@Override
	public Builder<?> read(TestConfig template) {
		// AbstractStore-specific configuration
		fetchPersistentState = template.fetchPersistentState();
		ignoreModifications = template.ignoreModifications();
		properties = template.properties();
		purgeOnStartup = template.purgeOnStartup();
		async.read(template.async());
		singletonStore.read(template.singletonStore());
		preload = template.preload();
		shared = template.shared();

		nodeName = template.nodeName();

		return this;
	}

	@Override
	public TestConfigBuilder self() {
		return this;
	}

	@Override
	public TestConfig create() {
		return new TestConfig(purgeOnStartup, fetchPersistentState, ignoreModifications, async.create(),
				singletonStore.create(), preload, shared, properties, nodeName);
	}
	
	public TestConfigBuilder withNodeName(String nodeName) {
		this.nodeName = nodeName;
		return this;
	}
}
