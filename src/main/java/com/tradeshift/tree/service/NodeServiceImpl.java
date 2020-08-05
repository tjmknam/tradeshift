package com.tradeshift.tree.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradeshift.tree.model.Node;
import com.tradeshift.tree.repo.NodeRepository;
import com.tradeshift.tree.util.CustomResponse;
import com.tradeshift.tree.util.NodeUtil;


@Service
@Transactional
public class NodeServiceImpl implements NodeService {
	
	@Autowired
	NodeRepository nodeRepository;
	
	
	@Override
    public CustomResponse<List<Node>> getAllChildren(Long nodeId) {
        Node node = nodeRepository.getNodeById(nodeId);

        if (node == null) {
            return CustomResponse.Message("NODE DOES NOT EXIST");
        }

        
        List<Node> childrenNodes = nodeRepository.getAllChildrenNodesByPath(NodeUtil.createChildrenPath(node));

        if (childrenNodes == null) {
            childrenNodes = new ArrayList<>();
        }

        return new CustomResponse<>(childrenNodes);
    }
	
	
	@Override
    public CustomResponse changeParentNode(Long nodeId, Long newParentId) {
        Node node = nodeRepository.getNodeById(nodeId);
        Node newParentNode = nodeRepository.getNodeById(newParentId);

        if (node == null){
            // Node not found
            return CustomResponse.Message("NODE DOES NOT EXIST");
        }
        else if (newParentNode == null) {
            // Parent node not found
            return CustomResponse.Message("PARENT NODE DOES NOT EXIST");
        }

        String oldPath = NodeUtil.createChildrenPath(node);
        
        node.setPath(NodeUtil.createChildrenPath(newParentNode));
        
        String newPath = NodeUtil.createChildrenPath(node);
        
        nodeRepository.changeParent(oldPath, newPath);

        return new CustomResponse<>();
    }

}
