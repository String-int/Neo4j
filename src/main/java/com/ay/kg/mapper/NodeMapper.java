package com.ay.kg.mapper;

import com.ay.kg.model.Node;
import org.apache.ibatis.annotations.Mapper;
import org.neo4j.driver.v1.Record;
import java.util.List;

@Mapper
public interface NodeMapper {

    /**
     *
     * 支持多条件组合查询
     */
    List<Node> getNodeOne(Node node);



    /**
     * 获取某个节点的所有关系
     * @param leftLabel
     * @param leftNodeNumber
     * @return
     */
//    List<Record> getNodeAndRelationshipList(String leftLabel, String leftNodeNumber);

    /**
     * 根据节点关系获取双向节点信息
     * @param leftLabel
     * @param leftNodeNumber
     * @param leftType
     * @return
     */
//    List<Record> getNodeListByRelationship(String leftLabel,String leftNodeNumber,String leftType);

    /**
     * 获取标签中节点的id
     * @param leftLabel
     * @return
     */
    List<String> getNodeIdList(String leftLabel);


    /**
     * 随机获取有关系的节点
     * 根据A节点标签获取,A节点的数据和A节点的下一级节点数据
     * http://localhost:8080/node/getRandNode?leftLabel=age&nodeNumber=c989ff1d2a6911ec9c3e00e04a68073f&num=6
     * @param leftLabel
     * @param leftNodeNumber
     * @param num
     * @return
     */
    List<Record> getNodeAndRelationshipList(String leftLabel,String leftNodeNumber,Long num);

    List<Record> getNodeInformation(String leftLabel,String leftNodeNumber);

    /***
     * 批量查询
     * @param leftLabel
     * @param nodeNumberList
     * @return
     */
    List<Node> BatchQuery(String leftLabel,List<String> nodeNumberList);

    /**
     * 添加单个节点
     * @param node
     * @return
     */
    int addNode(Node node);

    /**
     * 添加节点的关系 1-->2
     * @param leftLabel 第一个节点
     * @param rightLabel 第二个节点
     * @param leftNodeNumber 第一个节点的名字
     * @param rightNodeNumber 第二个节点的名字
     * @param leftType 关系
     * @return
     */
    int createNodeRelationship(String leftLabel,String rightLabel,String leftNodeNumber,String rightNodeNumber,String leftType);

    /**
     * 创建两个新节点以及对应关系{无关系属性}
     * @param node
     * @return
     */
    int createNewNodeRelationship(Node node);

    /**
     * 修改节点的属性
     * @param leftLabel
     * @param nodeNumberList
     * @param FieldName
     * @param fieldValue
     * @return
     */
    int BatchModification(String leftLabel,String[] nodeNumberList,String FieldName, String fieldValue);

    int updateNode(Node node);

    /**
     * 删除节点的所有关系
     * @param leftLabel
     * @param leftNodeNumber
     * @return
     */
    int removeNodeAllRelationship(String leftLabel,List<String> leftNodeNumber);

    /**
     * 删除节点的某一个关系
     * @param leftLabel
     * @param leftNodeNumber
     * @param rightLabel
     * @param rightNodeNumber
     * @param leftType
     * @return
     */
    int removeNodetoNodeOneRelationship(String leftLabel,String  leftNodeNumber,String rightLabel,String  rightNodeNumber,String leftType);

    /**
     * 删除节点关于某一标签内节点的所有关系
     *      * 因为要删除与A节点有相关关系的B节点时，B节点所在的Label（标签）可能与A节点的Label不是同一个，所以要传两个Label
     * @param leftLabel
     * @param leftNodeNumber
     * @param rightLabel
     * @return
     */
    int removeNodetoNodeAllRelationship(String leftLabel,String  leftNodeNumber,String rightLabel);

    /**
     * 删除节点
     * @param leftLabel
     * @param leftNodeNumber
     * @return
     */
    int removeNode(String leftLabel,List<String> leftNodeNumber);
    /**
     * 获取某个标签的个数
     * @param  leftLabel
     * @return
     */
    int getNodeCount(String leftLabel);

    /**
     * 修改节点关系
     * @param leftLabel
     * @param leftNodeNumber
     * @param leftType
     * @param rightLabel
     * @param rightNodeNumber
     * @param righType
     * @return
     */
    int updateNodeRelationshipOne(String leftLabel,String  leftNodeNumber,String leftType,String rightLabel,String  rightNodeNumber,String righType);

}