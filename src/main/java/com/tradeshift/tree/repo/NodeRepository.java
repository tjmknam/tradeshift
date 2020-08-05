package com.tradeshift.tree.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tradeshift.tree.model.Node;

@Repository
public class NodeRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	public Node getNodeById(Long id) {
		return entityManager.find(Node.class, id);
	}
	
	public List<Node> getAllChildrenNodesByPath(String path) {
		List<Node> result = entityManager.createQuery("SELECT * FROM NODE WHERE PATH LIKE :path", Node.class)
                .setParameter("path", path+"%")
                .getResultList();
		
		return result;
	}
	
	public void changeParent(String oldPath, String newPath) {
    	//update to new path from path-only up to oldPath
		//attach new path + old path where path like old path
		entityManager.createNativeQuery("UPDATE NODE SET PATH = :newPath || SUBSTRING(PATH, :length) WHERE PATH LIKE :oldPath")
	            .setParameter("newPath", newPath)
	            .setParameter("length", oldPath.length() + 1)
	            .setParameter("oldPath", oldPath+"%")
	            .executeUpdate();    
	}

}
