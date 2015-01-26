Clustered Cache Quickstart
==========================

This modified quickstart demonstrates *embedded cache* running on *two nodes* in 
*Java SE*.

The example can be deployed using Maven from the command line or from Eclipse using
JBoss Tools.

For more information, including how to set up Maven or JBoss Tools in Eclipse, 
refer to the [Getting Started Guide](https://docs.jboss.org/author/display/ISPN/Getting+Started+Guide+-+Clustered+Cache+in+Java+SE).

* Compile the application by running `mvn clean compile dependency:copy-dependencies -DstripVersion`

* To try with a *replicated* cache, run the following command in separated terminals:
    * `java -Djava.net.preferIPv4Stack=true -Djgroups.bind_addr=127.0.0.1 -cp "target/classes:target/dependency/*" org.infinispan.quickstart.clusteredcache.Node -r A`
    * `java -Djava.net.preferIPv4Stack=true -Djgroups.bind_addr=127.0.0.1 -cp "target/classes:target/dependency/*" org.infinispan.quickstart.clusteredcache.Node -r B`

* Nodes spawn a thread that 'adds' a random entry to the cache in 10s interval:
	* Every fourth round, an entry is added directly via `cache.put`
	* Every other round, the CacheLoader is triggered by accessing the entry with `cache.get`

* After some time, you'll see 'put' entries in both nodes, but the entries loaded by the CacheLoader only appear in the node that loaded them

* When restarting *one* node, it will retrieve all entries from the other node
