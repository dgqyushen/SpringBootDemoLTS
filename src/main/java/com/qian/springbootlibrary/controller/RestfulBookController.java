package com.qian.springbootlibrary.controller;

import com.qian.springbootlibrary.dao.BookDao;
import com.qian.springbootlibrary.pojo.Book;
import com.qian.springbootlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Predicate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@CrossOrigin
@RestController
public class RestfulBookController {

    @Autowired
    BookService bookServiceImpl;
    @Autowired
    HttpSession httpSession;
    @Autowired
    BookDao bookDao;


    @RequestMapping("/getallbooks")
    public Map<String,Object> getAllBook(@RequestParam(required = false,defaultValue = "1")int page, @RequestParam(required = false)int limit, HttpServletRequest httpServletRequest){
        Map map = new ConcurrentHashMap<String,Object>();
        int count = bookServiceImpl.getAllBook().size();
//        bookDao.findAll(se)
        Specification<Book> specification = (root,query,cb) -> {
            List<Predicate> predicate = new ArrayList<>();
//            predicate.add(cb.equal(root.get("id").as(Integer.class),1));
//            predicate.add(cb.equal(root.get("id").as(Integer.class),1));
            Predicate[] pre = new Predicate[predicate.size()];
            return query.where(predicate.toArray(pre)).getRestriction();
        };
        int pageSize = Integer.parseInt(httpServletRequest.getParameter("limit").trim());
        int pageIndex = Integer.parseInt(httpServletRequest.getParameter("page").trim())-1;
        List<Book> bookPageByCondition = bookServiceImpl.getBookPageByCondition(specification, PageRequest.of(pageIndex, pageSize));
        map.put("code",0);
        map.put("msg"," ");
        map.put("count",count);
        map.put("data",bookPageByCondition);

        return map;
    }


    @RequestMapping("/delbookbyid")
    public void delBookById(int id){
//        System.out.println(id);
        bookServiceImpl.delBookById(id);
        httpSession.setAttribute("msg","删除书本成功");
    }
}
