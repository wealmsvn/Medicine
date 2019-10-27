package com.medicine.controller;

import com.medicine.bean.Book;
import com.medicine.service.TextBookService;
import com.medicine.vo.RBooks;
import com.medicine.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Api(tags = "首页的教材相关接口")
public class TextBookController {

    @Autowired
    private TextBookService textBookService;

    @GetMapping("/index/collegeBook")
    @ApiOperation(value = "教材菜单中的书籍入口")
    public Result textBook(Integer id,Integer level){
//        通过传入的书籍的id号去查相应的类似书籍
        System.out.println("123"+id);
        System.out.println(level);
        List<RBooks> listBook = textBookService.queryBooksByType(id,level);
        System.out.println(listBook);
        return Result.success(listBook);
    }


}
