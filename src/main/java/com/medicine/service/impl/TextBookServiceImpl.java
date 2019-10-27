package com.medicine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.medicine.bean.Book;
import com.medicine.dao.BookDao;
import com.medicine.service.TextBookService;
import com.medicine.vo.RBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TextBookServiceImpl  extends  ServiceImpl<BookDao,Book> implements TextBookService {

    @Autowired
    JedisPool jedisPool;

    @Override
    public List<RBooks> queryBooksByType(Integer bookTypeId, Integer levelId) {
//        查询到得书籍放到redis中，增加查询效率,判断传入参数是否为空，为空时可以使用

        List<RBooks> bookList=null;
        if(bookTypeId !=null && levelId !=null){
            Map map = new HashMap();
            map.put("bookTypeId",bookTypeId);
            map.put("levelId",levelId);
            bookList = getBaseMapper().selectBookByTypeId(map);
        }
        System.out.println(bookList);

       return bookList;
    }

}