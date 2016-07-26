/**
 * 
 */
package co.com.ivan.test.elasticSearch;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

/**
 * @author ivan.trebilcock
 *
 */
public class ElasticTest {
	
	
	 
	 
	public static void main(String[] args) throws UnknownHostException {
		  
		
		Client client = TransportClient.builder().build()
		        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("host1"), 9300))
		        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("host2"), 9300));
	}

}
