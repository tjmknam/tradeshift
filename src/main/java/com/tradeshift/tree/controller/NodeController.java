package com.tradeshift.tree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradeshift.tree.model.Node;
import com.tradeshift.tree.service.NodeServiceImpl;
import com.tradeshift.tree.util.CustomResponse;

@RestController
@RequestMapping("/tree")
public class NodeController {
	
	@Autowired
	private NodeServiceImpl nodeService;
	
	
	
	@GetMapping("/allchildren/{nodeId}")
    public ResponseEntity<CustomResponse<List<Node>>> getAllChildren(@PathVariable Long nodeId) {
        return ResponseEntity.ok(nodeService.getAllChildren(nodeId));
    }

	
	@PutMapping("/changeparent/{nodeId}/{parentId}")
	public ResponseEntity<CustomResponse> changeParent(@PathVariable Long nodeId, @PathVariable Long parentId) {
        return ResponseEntity.ok(nodeService.changeParentNode(nodeId, parentId));
    }

}
