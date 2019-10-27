package com.medicine.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.medicine.bean.Book;
import com.medicine.vo.RBooks;

import java.util.List;
import java.util.Map;

public interface BookDao extends BaseMapper<Book> {

    List<RBooks> selectBookByTypeId(Map map);
}
