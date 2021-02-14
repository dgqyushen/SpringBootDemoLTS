package com.qian.springbootlibrary.controller;

import com.qian.springbootlibrary.pojo.Book;
import com.qian.springbootlibrary.pojo.User;
import com.qian.springbootlibrary.service.BookService;
import com.qian.springbootlibrary.service.UserBookService;
import com.qian.springbootlibrary.service.UserService;
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
import java.util.HashMap;
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
    UserService userServiceImpl;

    @Autowired
    UserBookService userBookServiceImpl;



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

    @RequestMapping("/borrowbook")
    public Map<String,Object> borrowBook(int id){
        HashMap<String, Object> map = new HashMap<>();
        Book book = bookServiceImpl.getBookById(id);
        User user = (User) httpSession.getAttribute("user");
//        System.out.println(user);
//        System.out.println(book);
        ArrayList<String> borrowBookList = userBookServiceImpl.getAllBorrowBookByUserName(user.getUsername());
        if (borrowBookList.contains(book.getBookName())){
            map.put("msg","你已经借过这本书了！");
        }else {
//            borrowBookList.add(book.getBookName());
            book.setNum(book.getNum()-1);
            borrowBookList.add(book.getBookName());
//            httpSession.setAttribute("bookList",borrowBookList);
            bookServiceImpl.updateBook(book);
            //存书操作
            userServiceImpl.borrowBooks(book.getBookName(),user.getUsername());
            map.put("msg","借书成功");
        }
        return map;


//        //先保证用户借到书
//        bookList.add(book);
//        book.setNum(book.getNum()-1);
//        bookDao.save(book);
//        String str = bookList.toString();
//        userServiceImpl.updateBookListByUserName(str,user.getUsername());
    }

    @RequestMapping("/returnbook")
    public Map<String,Object> returnBook(int id){
        HashMap<String, Object> map = new HashMap<>();
        User user = (User) httpSession.getAttribute("user");
        ArrayList<String> bookList = userBookServiceImpl.getAllBorrowBookByUserName(user.getUsername());
        if (bookList==null){
            System.out.println("======================================");
            System.out.println("数组为null");
        }
        Book book = bookServiceImpl.getBookById(id);
        if (bookList.contains(book.getBookName())){
            bookList.remove(book.getBookName());
            book.setNum(book.getNum()+1);
            bookServiceImpl.updateBook(book);
            userBookServiceImpl.deleteByBookNameAndUserName(book.getBookName(),user.getUsername());
            httpSession.setAttribute("bookList",bookList);
            map.put("msg","归还成功");


        }else {
            map.put("msg","你没有借过此书或已经归还过了");
        }
        return map;


    }

}
