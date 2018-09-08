//package com.chenyh;
//
//import com.chenyh.controller.UserController;
//import com.chenyh.ack.UserService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//@RunWith(SpringRunner.class)
////@SpringBootTest(classes = UserProviderApplication01.class)
//@WebMvcTest(UserController.class)
//@ContextConfiguration(classes=UserProviderApplication01.class)
//public class ControllTest {
//
//    @Autowired
//    private MockMvc mvc;
//
////    @Autowired
////    private WebApplicationContext context;
//
//    @MockBean
//    private UserService userService;
//
////    @MockBean
////    private DiscoveryClient client;
//
////    @Before
////    public void setupMockMvc() throws Exception {
////        mvc = MockMvcBuilders.webAppContextSetup(context).build();
////    }
//
//    @Test
//    public void testScore() throws Exception {
//
//        MvcResult result = mvc.perform(
//                MockMvcRequestBuilders.get("/user/list")
//                        .accept(MediaType.APPLICATION_JSON))
//                        .andReturn();
//        int statusCode = result.getResponse().getStatus();
////        Assert.assertEquals(statusCode, 200);
//        String body = result.getResponse().getContentAsString();
//        System.out.println("body:"+body);
//        System.out.println("单元测试");
//    }
//
//
//}
