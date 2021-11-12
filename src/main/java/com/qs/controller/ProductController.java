package com.qs.controller;

import com.qs.javabean.Product;

import com.qs.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@Api(tags = {"产品controller"})
public class ProductController {
    @Autowired
    private ProductService service;
    public List<Product> list = service.getList();
    /*@Autowired
    private ProductMapper mapper;*/
    @RequestMapping("/list")
    @ApiOperation(value = "查询用户列表")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "pageNum", value = "当前页数"),
//            @ApiImplicitParam(name = "pageSize", value = "每页记录数")
//    })
    public ModelAndView getList(){
        System.out.println(list);
        System.out.println("innnn");
        List<Product> list = service.getList();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", list);
        mv.setViewName("list.jsp");
        return mv;
    }

    @RequestMapping("/listByPid")
    @ApiOperation(value = "查询用户列表")
    public ModelAndView getListByPid(){
        System.out.println("innnn listByPid");
        List<Product> list = service.getList2(1);
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", list);
        mv.setViewName("list.jsp");
        return mv;
    }

    @GetMapping("/insert")
    public ModelAndView insert(){
        Map<String, Object> mapVal = new HashMap<>();
        mapVal.put("mapId","223345");
        mapVal.put("mapName", "测试2");
        mapVal.put("mapPri", 1111.22);
        int i = service.insertProduct(mapVal);
        if(i > 0){
            System.out.println("插入成功！");
        }
        return null;
    }

    @GetMapping("/fenye")
    public ModelAndView fenye(){
        Map<String,Object> condition = new HashMap<>();
        condition.put("startPage",1);
        condition.put("num", 2);
        List<Product> fenye = service.fenye(condition);
        ModelAndView mv = new ModelAndView();
        mv.addObject("fenye",fenye);
        mv.setViewName("fenye.jsp");
        return mv;
    }

    @GetMapping("/fenye2")
    public ModelAndView fenye2() throws IOException {
        System.out.println("分页2in");
        InputStream is = Resources.getResourceAsStream("applicationContext.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(is);
        SqlSession sqlSession = build.openSession();
        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);
        //通过Java代码层面实现分页
        List<Product> fenye = sqlSession.selectList("com.kaung.dao.UserMapper.getUserByRowBounds", null, rowBounds);
        for (Product product : fenye) {
            System.out.println(product);
        }
        sqlSession.close();
        ModelAndView mv = new ModelAndView();
        mv.addObject("fenye",fenye);
        mv.setViewName("fenye.jsp");
        return mv;
    }
}
