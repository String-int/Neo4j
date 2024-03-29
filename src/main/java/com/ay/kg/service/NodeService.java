package com.ay.kg.service;

import com.ay.kg.model.ApocInfo;
import com.ay.kg.model.Node;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NodeService {

    /**
     *
     * 支持多条件组合查询
     */
    List<Node> getNodeOne(Node node);


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
     * @param label
     * @param nodeNumber
     * @param num
     * @return
     */
    List<Map> getNodeAndRelationshipList(String label,String nodeNumber,Long num,String pageNumber);


    List<Map> getNodeInformation(String leftLabel,String leftNodeNumber);

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
     * @param nodeNumberList
     * @return
     */
    int BatchModification(String leftLabel,  String[] nodeNumberList,String FieldName, String fieldValue);

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
     * 修改节点关系
     * @param leftLabel
     * @param leftNodeNumber
     * @param leftType
     * @param rightLabel
     * @param rightNodeNumber
     * @param rightType
     * @return
     */
    int updateNodeRelationshipOne(String leftLabel,String  leftNodeNumber,String leftType,String rightLabel,String  rightNodeNumber,String rightType);

    /**
     * 查询所有关系的数量
     * @return
     */
    int getAllNotNodeNum();
    /**
     * 当前的节点有几条关系
     * @param label
     * @param nodeNumber
     * @return
     */
    int getNodeNodeRelationshiCount(@Param("label") String label, @Param("nodeNumber") String nodeNumber);
    /**
     * 节点的深度查询
     * @param leftLabel
     * @param num
     * @param leftNodeNumber
     * @param pageNum
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Node> getDepthOfQueryNode(@Param("leftLabel") String leftLabel, @Param("num") Integer num, @Param("leftNodeNumber") String leftNodeNumber, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    /**
     * 节点深度查询得到的节点数
     * @param leftLabel
     * @param num
     * @param leftNodeNumber
     * @return
     */
    int getDepthOfQueryNodeCount(@Param("leftLabel") String leftLabel, @Param("num") Integer num, @Param("leftNodeNumber") String leftNodeNumber);
    /**
     * 查询没有关系的节点
     * @return pageNum
     * @return pageSize
     */
    List<Node> getPageNotRelationShipNode(@Param("leftNodeNumber") String leftNodeNumber, @Param("leftNodeName") String leftNodeName, @Param("leftLabel") String leftLabel, @Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    /**
     * 查询没有关系节点的数量
     * @return
     */
    int getNotRelationShipNodeCount(@Param("leftNodeNumber") String leftNodeNumber, @Param("leftNodeName") String leftNodeName, @Param("leftLabel") String leftLabel);
    /**
     * 批量创建关系
     * @param leftLabel
     * @param rightLabel
     * @param leftNodeNumber
     * @param rightNodeNumber
     * @param type
     * @return
     */
    int batchCreateRelationShip(@Param("leftLabel") String leftLabel,@Param("leftNodeNumber")List<String> leftNodeNumber,@Param("rightLabel")String rightLabel,@Param("rightNodeNumber")List<String> rightNodeNumber,@Param("type")String type);


    /**
     * 用csv的方式批量导入节点关系
     * @param apocInfo
     * @return
     */
    Integer importCsv(ApocInfo apocInfo);

    /**
     * 关系比例
     * @param leftLabel
     * @return
     */
    Map getRelationshipProportion(@Param("leftLabel") String leftLabel);
    /**
     * 查询所有节点
     * @param leftNodeNumber
     * @param leftNodeName
     * @param leftLabel
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Node> getAllNode(String leftNodeNumber, String leftNodeName, String leftLabel, int pageNum, int pageSize);

    /**
     * 查询所有节点的数量
     * @param leftNodeNumber
     * @param leftNodeName
     * @param leftLabel
     * @param pageNum
     * @param pageSize
     * @return
     */
    int getAllNodeCount(String leftNodeNumber, String leftNodeName, String leftLabel);

}
