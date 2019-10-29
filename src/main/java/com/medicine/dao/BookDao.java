package com.medicine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medicine.bean.Book;
import com.medicine.vo.ExamBook;
import com.medicine.vo.RBooks;

import java.util.List;
import java.util.Map;

public interface BookDao extends BaseMapper<Book> {

    List<RBooks> selectBookByTypeId(Map map);

    List<RBooks> selectAllBooks();

    List<RBooks> selectAllBooksByLevel(Integer level);

    List<RBooks> selectBookhot(Map map);

    List<ExamBook> selectListType(Integer flag);

    List<ExamBook> selectHotExamBook(Integer flag);

//    List<RBooks> selectBookByType(Page<RBooks> page, @Param("map") Map map);
}
