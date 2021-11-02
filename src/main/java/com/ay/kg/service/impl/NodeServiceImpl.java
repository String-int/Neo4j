package com.ay.kg.service.impl;

import com.ay.kg.mapper.NodeMapper;
import com.ay.kg.model.Node;
import com.ay.kg.service.NodeService;
import org.neo4j.driver.v1.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NodeServiceImpl implements NodeService {
    @Autowired
    private NodeMapper nodeMapper;


    @Override
    public List<Node> getNodeOne(Node node) {
        return nodeMapper.getNodeOne(node);
    }

//    @Override
//    public List<Record> getNodeAndRelationshipList(String leftLabel, String leftNodeNumber) {
//        return nodeMapper.getNodeAndRelationshipList(leftLabel,leftNodeNumber);
//    }

//    @Override
//    public List<Record> getNodeListByRelationship(String leftLabel, String leftNodeNumber, String leftType) {
//        return nodeMapper.getNodeListByRelationship( leftLabel,  leftNodeNumber,  leftType);
//    }



    @Override
    public List<String> getNodeIdList(String leftLabel) {
        return nodeMapper.getNodeIdList(leftLabel);
    }

    @Override
    public List<Record> getNodeAndRelationshipList(String leftLabel, String leftNodeNumber, Long num) {
        return nodeMapper.getNodeAndRelationshipList( leftLabel,  leftNodeNumber,  num);
    }

    @Override
    public List<Record> getNodeInformation(String leftLabel, String leftNodeNumber) {
        return nodeMapper.getNodeInformation( leftLabel, leftNodeNumber);
    }

    @Override
    public List<Node> BatchQuery(String leftLabel, List<String> nodeNumberList) {
        return nodeMapper.BatchQuery(leftLabel,nodeNumberList);
    }

    @Override
    public int addNode(Node node) {
        return nodeMapper.addNode(node);
    }

    @Override
    public int createNodeRelationship(String leftLabel, String rightLabel, String leftNodeNumber, String rightNodeNumber, String leftType) {
        return nodeMapper.createNodeRelationship( leftLabel,  rightLabel,  leftNodeNumber,  rightNodeNumber,  leftType);
    }

    @Override
    public int createNewNodeRelationship(Node node) {
        return nodeMapper.createNewNodeRelationship(node);
    }

    @Override
    public int BatchModification(String leftLabel,  String[] nodeNumberList,String FieldName, String fieldValue) {
        return nodeMapper.BatchModification(leftLabel,nodeNumberList, FieldName,  fieldValue);
    }

    @Override
    public int updateNode(Node node) {
        return nodeMapper.updateNode(node);
    }

    @Override
    public int removeNodeAllRelationship(String leftLabel, List<String> leftNodeNumber) {
        return nodeMapper.removeNodeAllRelationship(leftLabel,leftNodeNumber);
    }

    @Override
    public int removeNodetoNodeOneRelationship(String leftLabel, String leftNodeNumber, String rightLabel, String rightNodeNumber, String leftType) {
        return nodeMapper.removeNodetoNodeOneRelationship( leftLabel,  leftNodeNumber,  rightLabel,  rightNodeNumber,  leftType);
    }

    @Override
    public int removeNodetoNodeAllRelationship(String leftLabel, String leftNodeNumber, String rightLabel) {
        return nodeMapper.removeNodetoNodeAllRelationship( leftLabel,  leftNodeNumber,  rightLabel);
    }

    @Override
    public int removeNode(String leftLabel, List<String> leftNodeNumber) {
        return nodeMapper.removeNode(leftLabel,leftNodeNumber);
    }

    @Override
    public int getNodeCount(String leftLabel) {
        return nodeMapper.getNodeCount(leftLabel);
    }

    @Override
    public int updateNodeRelationshipOne(String leftLabel, String leftNodeNumber, String leftType, String rightLabel, String rightNodeNumber, String righType) {
        return nodeMapper.updateNodeRelationshipOne( leftLabel,  leftNodeNumber,  leftType,  rightLabel,  rightNodeNumber,  righType);
    }
}
