package com.medicine.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.medicine.bean.Book;
import com.medicine.vo.RBooks;

import java.util.List;

public interface TextBookService extends IService<Book> {

    List<RBooks> queryBooksByType(Integer id, Integer level);
}
