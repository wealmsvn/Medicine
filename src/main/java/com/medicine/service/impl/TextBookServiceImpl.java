package com.medicine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.medicine.bean.Book;
import com.medicine.dao.BookDao;
import com.medicine.service.TextBookService;
import com.medicine.utils.JsonUtils;
import com.medicine.vo.ExamBook;
import com.medicine.vo.RBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
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
//        书籍放入redis中
        Jedis jedis = jedisPool.getResource();
        List<RBooks> bookList=null;
        if(bookTypeId !=null && levelId !=null){
            Map map = new HashMap();
            map.put("bookTypeId",bookTypeId);
            map.put("levelId",levelId);
            if(jedis.exists(bookTypeId+"")){
                String s = jedis.get(bookTypeId + "");
                bookList = JsonUtils.jsonToList(s,RBooks.class);
            }else{
                bookList = getBaseMapper().selectBookByTypeId(map);
                jedis.set(bookTypeId+"",JsonUtils.objectToJson(bookList));
            }
        }
        System.out.println(bookList);

       return bookList;
    }

    @Override
    public List<RBooks> queryListBooks(Integer level) {
//        数据缓存起来
        List<RBooks> rBooks = null ;
        System.out.println(level);
        if (level !=null && level !=0){
            rBooks = getBaseMapper().selectAllBooksByLevel(level);
        }else{
            rBooks = getBaseMapper().selectAllBooks();
        }
        return rBooks;
    }

    @Override
    public List<RBooks> queryBooksHot(Integer bookTypeId, Integer levelId) {

        Jedis jedis = jedisPool.getResource();

        List<RBooks> bookList=null;
        if(bookTypeId !=null && levelId !=null) {
            Map map = new HashMap();
            map.put("bookTypeId", bookTypeId);
            map.put("levelId", levelId);
            bookList = getBaseMapper().selectBookhot(map);
        }
        return bookList;
    }

    @Override
    public List<ExamBook> queryListByType(Integer flag) {

            List<ExamBook> examBooks = null;

            examBooks = getBaseMapper().selectListType(flag);

            return examBooks;

    }

    @Override
    public List<ExamBook> queryHotExamBook(Integer flag) {

        List<ExamBook> examBooks = null;
        examBooks = getBaseMapper().selectHotExamBook(flag);

        return examBooks;
    }

//    @Override
//    public IPage<RBooks> queryPage(Integer id, Integer levelId, Integer pageno, int i) {
//
//        Page<RBooks> page= new Page<>(pageno,i);
//        Map map = new HashMap();
//        map.put("id",id);
//        map.put("levelId",levelId);
////        map.put("pageno",pageno);
////        map.put("i",i);
////        page.setRecords(getBaseMapper().selectBookByType(page,map));
//        return page;
//    }

}