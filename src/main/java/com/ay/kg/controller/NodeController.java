package com.ay.kg.controller;

import com.ay.kg.model.Node;
import com.ay.kg.service.NodeService;
import com.ay.kg.util.Result;
import com.ay.kg.util.JavaGetProperty;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.neo4j.driver.v1.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(value = "NodeController" ,tags={"节点模块的业务接口"})
@RestController
@RequestMapping("/node")
public class NodeController  extends JavaGetProperty{

    @Autowired
    private NodeService nodeService;

    /**
     * 支持多条件组合查询
     * http://localhost:8080/node/getNodeOne?leftLabel=me&leftNodeName=刘哈哈
     * @param node
     * @return
     */
    @ApiOperation(value="获取单个节点信息",tags = {"获取单个节点信息"},notes="支持多条件组合查询")
    @RequestMapping(value = "getNodeOne", method = RequestMethod.POST)
    public String getNodeOne(Node node){
            List<Node> list=  nodeService.getNodeOne(node);
            if(list!=null){
                return  Result.toClient(list);
            }else{
                return  Result.toClient("400","无数据");
            }
    }


    /**
     * 获取某个节点的所有关系
     * http://localhost:8080/node/getNodeAndRelationshipList?leftLabel=age&leftNodeNumber=c98a09db2a6911ec9c3e00e04a68073f
     * @param leftLabel
     * @param leftNodeNumber
     * @return
     */
//    @ApiOperation(value="获取某个节点的所有关系",tags = {"获取某个节点的所有关系"},notes="获取某个节点的所有关系")
//    @RequestMapping(value = "getNodeAndRelationshipList", method = RequestMethod.POST)
//    public String getNodeAndRelationshipList(
//            @ApiParam(name="leftLabel",value="标签名称",required=true)  String leftLabel,
//            @ApiParam(name="leftNodeNumber",value="节点UUID",required=true)  String leftNodeNumber) {
//        List<Record> list=nodeService.getNodeAndRelationshipList( leftLabel,   leftNodeNumber);
//        return Result.toClient(list);
//    }


    /**
     * 根据节点关系获取双向节点信息
     * http://localhost:8080/node/getNodeListByRelationship?leftLabel=age&leftNodeNumber=c98a09db2a6911ec9c3e00e04a68073f&leftType=所属
     * @param leftLabel
     * @param leftNodeNumber
     * @param leftType
     * @return
     */
//    @ApiOperation(value="根据节点关系获取双向节点信息",tags = {"根据节点关系获取双向节点信息"}, notes="根据节点关系获取双向节点信息,")
//    @RequestMapping(value = "getNodeListByRelationship", method = RequestMethod.POST)
//    public String getNodeListByRelationship(@ApiParam(name="leftLabel",value="标签名称",required=true) String leftLabel,
//                                            @ApiParam(name="leftNodeNumber",value="节点UUID",required=true) String leftNodeNumber,
//                                            @ApiParam(name="leftType",value="关系",required=true) String leftType) {
//        List<Record> list= nodeService.getNodeListByRelationship( leftLabel,    leftNodeNumber,  leftType);
//
//        return Result.toClient(list);
//    }

    /**
     * 根据A节点标签获取,A节点的数据和A节点的下一级节点数据
     * http://localhost:8080/node/getNodeAndRelationshipList?label=age&nodeNumber=c989ff1d2a6911ec9c3e00e04a68073f&num=6
     * @param label
     * @param nodeNumber
     * @param num
     * @return
     */

    @ApiOperation(value="获取节点及下一级节点数据",tags = {"获取节点及下一级节点数据"}, notes="根据A节点标签获取,A节点的数据和A节点的下一级节点数据,")
    @RequestMapping(value = "getNodeAndRelationshipList", method = RequestMethod.POST)
    public String getNodeAndRelationshipList(@ApiParam(name="leftLabel",value="节点标签",required=true) String label,
                              @ApiParam(name="leftNodeNumber",value="节点UUID",required=true) String nodeNumber,
                              @ApiParam(name="num",value="要获取的数量",required=true) Long num) {

        List<Record> list= nodeService.getNodeAndRelationshipList(label, nodeNumber, num);
        System.err.println(list);
        if(list.size()!=0){
            return Result.toClient(list);
        }else {
            return Result.toClient(nodeService.getNodeInformation(label,nodeNumber));
        }

    }

    /***
     * 批量查询的节点数据
     * @param label
     * @param nodeNumberList
     * @return
     */
    @ApiOperation(value="获取对应nodeNumber的节点数据",tags = {"获取对应nodeNumber的节点数据"}, notes="获取对应nodeNumber的节点数据")
    @RequestMapping(value = "BatchQuery", method = RequestMethod.POST)
    public List <Node> BatchQuery(@ApiParam(name="label",value="节点标签",required=true)String label,
                                    @ApiParam(name="nodeNumberList",value="节点UUID",required=true) @RequestParam List<String> nodeNumberList){

        return nodeService.BatchQuery(label,nodeNumberList);
    }


    /**
     * #
     * 获取某个标签的个数
     * http://localhost:8080/node/getNodeCount?label=people
     * @param
     * @return
     */
//    @ApiOperation(value="根据标签名获取节点的个数", notes="根据标签名获取节点的个数")
////    @ApiImplicitParam(name = "标签名", value = "节点的标签名", required = true, dataType = "String", paramType = "path")
//    @RequestMapping(value = "getNodeCount", method = RequestMethod.POST)
//    public int getNodeCount(String label) {
//        return nodeService.getNodeCount(label);
//    }

    /**
     * 添加单个节点
     * http://localhost:8080/node/addNode?leftNodeName=刘备&leftGender=男&leftAge=18&leftCover=125.img&leftIntro=大耳贼&leftCategory=皇帝&leftAuthor=中山靖王之后&leftOpusContent=桃园三兄弟大哥&leftLabel=me&leftNodeNumber=18&leftTexture=红红&leftFunctionCategory=哈哈&leftParentAge=拉拉
     * @param node
     * @return
     */
    @ApiOperation(value="创建新节点", tags = {"创建新节点"},notes="根据 Node 对象创建节点")
    @RequestMapping(value = "addNode", method = RequestMethod.POST)
    public int  addNode(Node node) {
        return nodeService.addNode(node);
    }

    /**
     * 添加节点的关系 1-->2
     * http://localhost:8080/node/createNodeRelationship?leftLabel=me&rightLabel=me&leftNodeNumber=1728&rightNodeNumber=1943&leftType=朋友
     * @param leftLabel 第一个节点
     * @param rightLabel 第二个节点
     * @param leftNodeNumber 第一个节点的UUID
     * @param rightNodeNumber 第二个节点的UUID
     * @param leftType 关系
     * @return
     */
    @ApiOperation(value="添加节点的关系", tags = {"添加节点的关系"},notes="添加节点的关系A-->B")
    @RequestMapping(value = "createNodeRelationship", method = RequestMethod.POST)
    public int createNodeRelationship(@ApiParam(name="leftLabel",value="标签名称",required=true) String leftLabel,
                                      @ApiParam(name="rightLabel",value="标签名称",required=true) String rightLabel,
                                      @ApiParam(name="leftNodeNumber",value="A节点UUID",required=true) String  leftNodeNumber,
                                      @ApiParam(name="rightNodeNumber",value="B节点UUID",required=true) String  rightNodeNumber,
                                      @ApiParam(name="leftType",value="要创建的关系",required=true) String leftType) {
        return nodeService.createNodeRelationship(leftLabel,rightLabel,leftNodeNumber,rightNodeNumber,leftType);
    }

    /**
     * 创建两个新节点以及对应关系{无关系属性}
     * http://localhost:8080/node/createNewNodeRelationship?leftNodeName=马三&leftGender=男&leftAge=18&leftCover=125.img&leftIntro=大马猴&leftCategory=蜡&leftAuthor=中山靖王之后&leftOpusContent=桃园三兄弟大哥&leftLabel=me&leftNodeNumber=1236&leftTexture=红红&leftFunctionCategory=哈哈&leftParentAge=拉拉&rightNodeName=于占鳌&rightGender=男&rightAge=19&rightCover=125.img&rightIntro=大老鳖&rightCategory=火&rightAuthor=中山靖王之后&rightOpusContent=桃园三兄弟大哥&rightLabel=me&rightNodeNumber=1537&rightTexture=红红&rightFunctionCategory=哈哈&rightParentAge=拉拉&leftType=兄弟
     * @param node
     * @return
     */
    @ApiOperation(value="创建新节点关系",tags = {"创建新节点关系"}, notes="创建新节点间的关系")
    @RequestMapping(value = "createNewNodeRelationship", method = RequestMethod.POST)
    public String createNewNodeRelationship(Node node) {
        int num=nodeService.createNewNodeRelationship(node);
        if(num>=3){//创建两个节点，一条关系
            return  Result.toClient("200","创建成功");
        }else {
            return   Result.toClient("400","创建失败");
        }
    }

    /**
     *
     * String fieldName,
     * 修改节点的属性
     * @param leftLabel
     * @param nodeNumberList
     * @param
     * @param fieldValue
     * @return
     */
    //http://localhost:8080/node/BatchModification?leftLabel=me&nodeNumberList=1236&nodeNumberList=18&fieldName=&fieldValue=哈哈
    @ApiOperation(value="修改节点的属性", tags = {"修改节点的属性"},notes="修改节点的属性，条件是label,nodeId")
    @RequestMapping(value = "BatchModification", method = RequestMethod.POST)
    public String BatchModification( String leftLabel,String nodeNumberList, String fieldName, String fieldValue,String fieldNodeNumber) {
        System.err.println(nodeNumberList);
        String[] nodeNumberListArray = nodeNumberList.split(",");
        System.err.println(nodeNumberListArray);
        int n=nodeService.BatchModification(leftLabel,nodeNumberListArray, fieldName,  fieldValue);

        if(n<0){
            return "OK";
        }else {
            return "NO";
        }
    }


    @ApiOperation(value="修改节点的属性", tags = {"修改节点的属性"},notes="修改节点的属性，条件是label,nodeId")
    @RequestMapping(value = "updateNode", method = RequestMethod.POST)
    public String updateNode(Node node) {

        int n=nodeService.updateNode(node);
        System.err.println(n);
        if(n<0){
            return "OK";
        }else {
            return "NO";
        }
    }

    /**
     * 修改节点之间的关系
     * http://localhost:8080/node/updateNodeRelationship?leftLabel=me&leftNodeNumber=1236&rightLabel=me&rightNodeNumber=1537&leftType=兄弟&righType=塑料姐妹情
     * @param leftLabel
     * @param leftNodeNumber
     * @param rightLabel
     * @param rightNodeNumber
     * @param leftType
     * @param righType
     * @return
     */
    @ApiOperation(value="修改节点之间的关系",tags = {"修改节点之间的关系"}, notes="修改节点之间的关系，type是要删除的关系，type2是要添加的关系")
    @RequestMapping(value = "updateNodeRelationship",method = RequestMethod.POST)
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public String updateNodeRelationship(@ApiParam(name="leftLabel",value="第一个标签名称",required=true) String leftLabel,
                                         @ApiParam(name="leftNodeNumber",value="第一个标签ID",required=true) String  leftNodeNumber,
                                         @ApiParam(name="rightLabel",value="第二个标签名称",required=true) String rightLabel,
                                         @ApiParam(name="rightNodeNumber",value="第二个标签ID",required=true) String  rightNodeNumber,
                                         @ApiParam(name="leftType",value="原来关系",required=true) String leftType,
                                         @ApiParam(name="righType",value="新关系",required=true) String righType){

        int n= nodeService.updateNodeRelationshipOne(leftLabel,leftNodeNumber,leftType,rightLabel,rightNodeNumber,righType);
            if(n>0){
                return "修改成功";
            }else {
                return "失败";
            }
    }

    /**
     * 删除节点的所有关系
     * http://localhost:8080/node/removeNodeAllRelationship?leftLabel=me&leftNodeNumber=18
     * @param leftLabel
     * @param leftNodeNumber
     * @return
     */
    @ApiOperation(value="删除节点的所有关系",tags = {"删除节点的所有关系"}, notes="删除节点的所有关系，条件是label,nodeId")
    @RequestMapping(value = "removeNodeAllRelationship", method = RequestMethod.POST)
    public int removeNodeAllRelationship(@ApiParam(name="leftLabel",value="标签名称",required=true) String leftLabel,
                                         @ApiParam(name="leftNodeNumber",value="节点ID",required=true) @RequestParam List<String> leftNodeNumber) {

        return nodeService.removeNodeAllRelationship(leftLabel,leftNodeNumber);
    }

    /**
     * 删除节点的某一个关系
     * http://localhost:8080/node/removeNodetoNodeOneRelationship?leftLabel=me&leftNodeNumber=1236&rightLabel=me&rightNodeNumber=1537&leftType=塑料姐妹情
     * @param leftLabel
     * @param leftNodeNumber
     * @param rightLabel
     * @param rightNodeNumber
     * @param leftType
     * @return
     */
    @ApiOperation(value="删除节点的某一个关系",tags = {"删除节点的某一个关系"}, notes="删除节点的某一个关系，条件是label,  nodeId, label2,  nodeId2, type")
    @RequestMapping(value = "removeNodetoNodeOneRelationship", method = RequestMethod.POST)
    public int removeNodetoNodeOneRelationship(@ApiParam(name="leftLabel",value="第一个标签",required=true) String leftLabel,
                                               @ApiParam(name="leftNodeNumber",value="第一个节点ID",required=true) String  leftNodeNumber,
                                               @ApiParam(name="rightLabel",value="第二个标签",required=true) String rightLabel,
                                               @ApiParam(name="rightNodeNumber",value="第二个节点ID",required=true) String  rightNodeNumber,
                                               @ApiParam(name="leftType",value="关系",required=true) String leftType) {

        return nodeService.removeNodetoNodeOneRelationship( leftLabel,  leftNodeNumber, rightLabel,  rightNodeNumber, leftType);
    }


    /**
     * 删除节点关于某一标签内节点的所有关系
     * 因为要删除与A节点有相关关系的B节点时，B节点所在的Label（标签）可能与A节点的Label不是同一个，所以要传两个Label
     * http://localhost:8080/node/removeNodetoNodeAllRelationship?leftLabel=you&leftNodeNumber=1537&rightLabel=me
     * @param leftLabel
     * @param leftNodeNumber
     * @param rightLabel
     * @return
     */
    @ApiOperation(value="删除节点关于某一标签内节点的所有关系",tags = {"删除节点关于某一标签内节点的所有关系"}, notes="删除节点关于某一标签内节点的所有关系，条件是label,  nodeId, label2")
    @RequestMapping(value = "removeNodetoNodeAllRelationship", method = RequestMethod.POST)
    public int removeNodetoNodeAllRelationship(@ApiParam(name="leftLabel",value="第一个标签名称",required=true) String leftLabel,
                                               @ApiParam(name="leftNodeNumber",value="第一个标签的UUID",required=true) String  leftNodeNumber,
                                               @ApiParam(name="rightLabel",value="第二个标签名称",required=true) String rightLabel) {
        return nodeService.removeNodetoNodeAllRelationship( leftLabel,  leftNodeNumber, rightLabel);
    }

    /**
     * 删除节点
     * http://localhost:8080/node/removeNode?label=me&nodeNumber=18
     * @param label
     * @param nodeNumber
     * @return
     */
    @ApiOperation(value="删除节点",tags = {"删除节点"}, notes="删除节点,条件是label 和 nodeId")
    @RequestMapping(value = "removeNode", method = RequestMethod.POST)
    public String removeNode(@ApiParam(name="leftLabel",value="标签名称",required=true) String label,
                          @ApiParam(name="leftNodeNumber",value="标签ID",required=true) @RequestParam List<String>  nodeNumber) throws Exception{

        int n=nodeService.removeNode( label,  nodeNumber);


        if(n>0){
            return Result.toClient("200","删除成功！");
        }else {
            return Result.toClient("400","删除失败，该节点具有关系");
        }

    }

//    @ApiOperation(value="删除节点",tags = {"删除节点"}, notes="删除节点,条件是label 和 nodeId")
//    @RequestMapping(value = "getNodeId", method = RequestMethod.POST)
//    public List<String> getNodeId(@ApiParam(name="leftLabel",value="标签名称",required=true) String leftLabel) {
//        return  nodeService.getNodeIdList(leftLabel);
//    }

    /**
     * 批量删除(删除多个节点，多个关系)
     * http://localhost:8080/node/removeMultipleNodesAndMultipleRelationship?leftLabel=me&leftNodeNumber=18&leftLabel=age&leftNodeNumber=18
     * @param label http://localhost:8080/node/removeMultipleNodesAndMultipleRelationship?leftLabel=hi&leftNodeNumber=123611&leftLabel=you&leftNodeNumber=1821&leftNodeNumber=1537
     * @param nodeNumber
     * @return
     */
//    @ApiOperation(value="批量删除(删除多个节点，多个关系)",tags = {"批量删除(删除多个节点，多个关系)"}, notes="删除多个节点，多个关系")
//    @RequestMapping(value = "removeMultipleNodesAndMultipleRelationship", method = RequestMethod.POST)
//    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
//    public String removeMultipleNodesAndMultipleRelationship(@ApiParam(name="leftLabel",value="标签名称",required=true) @RequestParam List<String> label,
//                                                             @ApiParam(name="leftNodeNumber",value="标签ID",required=true) @RequestParam List<String> nodeNumber) {
//        for(int i=0;i<label.size();i++) {
//            List<String> listId = nodeService.getNodeIdList(label.get(i));
//            for (int j = 0; j < listId.size(); j++) {
//                for (int z = 0; z < nodeNumber.size(); z++) {
//                    if (listId.get(j).equals(nodeNumber.get(z))) {
//                        int n = nodeService.removeNodeAllRelationship(label.get(i), nodeNumber);
//                        if (n > 0) {
//                            int m = nodeService.removeNode(label.get(i), nodeNumber);
//                            return Result.toClient("200", "删除成功");
//                        } else {
//                            return Result.toClient("400", "删除失败");
//                        }
//                    }
//                    continue;
//                }
//            }
//        }
//        System.out.println("leftLabel"+label);
//        System.out.println("leftNodeNumber"+nodeNumber);
//        return "请联系管理员";
//    }

}
