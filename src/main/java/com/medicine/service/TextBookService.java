package com.medicine.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.medicine.bean.Book;
import com.medicine.vo.ExamBook;
import com.medicine.vo.RBooks;

import java.util.List;

public interface TextBookService extends IService<Book> {

    List<RBooks> queryBooksByType(Integer id, Integer level);

    List<RBooks> queryListBooks(Integer level);

    List<RBooks> queryBooksHot(Integer id, Integer level);

    List<ExamBook> queryListByType(Integer flag);

    List<ExamBook> queryHotExamBook(Integer flag);

//    IPage<RBooks> queryPage(Integer id, Integer level, Integer pageno, int i);
}
