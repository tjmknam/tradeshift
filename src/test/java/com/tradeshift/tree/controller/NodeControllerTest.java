//package com.tradeshift.tree.controller;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.tradeshift.tree.App;
//import com.tradeshift.tree.service.NodeService;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes=App.class)
//@AutoConfigureMockMvc
//@Transactional
//public class NodeControllerTest {
//	
//	
//	@Autowired
//	private MockMvc mvc;
//	
//	@Autowired
//    private NodeService nodeService;
//	
//	@Test
//	public void testGetAllChildren() throws Exception {
//		mvc.perform(MockMvcRequestBuilders
//				.get("/tree/allchildren/1")
//				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
//	}
//	
//	@Test
//	public void testChangeParent() throws Exception {
//		mvc.perform(MockMvcRequestBuilders
//				.get("/tree/changeparent/5/3").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
//	}
//
//}
