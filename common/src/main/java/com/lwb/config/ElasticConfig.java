package com.lwb.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @Author liuweibo
 * @Date 2018/4/4
 */
@Configuration
public class ElasticConfig {

    private Logger logger = LoggerFactory.getLogger(ElasticConfig.class);

    @Value("${es.hosts}")
    private String ES_HOSTS;

    @Value("${es.cluster}")
    private String ES_CLUSTER;

    private final String CLUSTER_NAME = "cluster.name";

    private final String CLIENT_TRANSPORT_SNIFF = "client.transport.sniff";

    private TransportClient client;

    @Bean("esClient")
    public TransportClient getClient() {
        Settings settings = Settings.builder().put(CLUSTER_NAME, ES_CLUSTER).put(CLIENT_TRANSPORT_SNIFF, true).build();
        PreBuiltTransportClient pbtc = new PreBuiltTransportClient(settings);
        String[] hosts = ES_HOSTS.split(",");
        for (String host : hosts) {
            String[] ipAndPort = host.split(":");
            try {
                pbtc.addTransportAddresses( new InetSocketTransportAddress( InetAddress.getByName(ipAndPort[0]), Integer.valueOf(ipAndPort[1]) ) );
            } catch (UnknownHostException e) {
                logger.error("not find host: {}", ipAndPort[0]);
            }
            client = pbtc;
            List<DiscoveryNode> nodes = client.listedNodes();
            for (DiscoveryNode node : nodes) {
                logger.info("discover node: {}", node.getHostAddress());
            }
        }
        return client;
    }

}
