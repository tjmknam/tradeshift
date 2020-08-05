package com.tradeshift.tree.util;

import com.tradeshift.tree.model.Node;

public class NodeUtil {
	
	public static Long getParentId(Node node) {
        //last id in the path is the parent id

		String path = node.getPath();
		//if no parent, it's a root node
        if (path == null || path.isEmpty()) {
        	return null;
        }
            
        //second last occurrence of char in String
        return Long.valueOf(path.substring(path.lastIndexOf('|', path.length() - 2) + 1, path.length() - 1));
    }

    public static Long getRootId(Node node) {
        //first id in the path is the root id

    	String path = node.getPath();
    	//if no parent, it's a root node
        if (path == null || path.isEmpty()) {
        	return node.getId();
        }
        
        return Long.valueOf(path.substring(0, path.indexOf('|')));
    }
    
    public static int getHeight(Node node) {
        //number of | will be the height because we are adding the extra | at the end of the path
        String path = node.getPath();
        int count = 0;
        for(char c : path.toCharArray()) {
        	if(c == '|') {
        		count++;
        	}
        }
        
        return count;
    }
    
    //children path will be the current path + the current node
    //use this data to find all children nodes from the current node
    public static String createChildrenPath(Node node) {
    	String currentPath = node.getPath();
    	return ((currentPath == null || currentPath.isEmpty()) ? "" : currentPath) + node.getId() + "|";
    	
    	
    }
}
