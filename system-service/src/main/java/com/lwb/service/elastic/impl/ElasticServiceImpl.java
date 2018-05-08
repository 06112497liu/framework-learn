package com.lwb.service.elastic.impl;

import com.lwb.service.elastic.ElasticService;
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author liuweibo
 * @Date 2018/4/4
 */
@Service
public class ElasticServiceImpl implements ElasticService {

    @Resource
    private TransportClient esClient;

    @Override
    public void hello() {
        String response = esClient.prepareGet("lwb", "student", "vTkstGIBOMlDG_DvJjfm").execute().actionGet().getSourceAsString();
        NodesInfoResponse nodesInfo = esClient.admin().cluster().prepareNodesInfo().execute().actionGet();
        System.out.println(nodesInfo.getClusterName());
    }
}
