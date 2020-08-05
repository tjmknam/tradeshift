package com.tradeshift.tree.service;

import java.util.List;

import com.tradeshift.tree.model.Node;
import com.tradeshift.tree.util.CustomResponse;

public interface NodeService {
	
	
	CustomResponse<List<Node>> getAllChildren(Long nodeId);
	
	CustomResponse<String> changeParentNode(Long nodeId, Long newParentId);

}
