package com.medicine.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.medicine.service.CourseService;
import com.medicine.service.TextBookService;
import com.medicine.bean.Course;
import com.medicine.vo.ExamBook;
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

    @Autowired
    private CourseService courseService;

    @GetMapping("/index/collegeBook")
    @ApiOperation(value = "教材菜单中的书籍入口")
    public Result textBook(Integer id,Integer level){
//        通过传入的书籍的id号去查相应的类似书籍

        List<RBooks> listBook = textBookService.queryBooksByType(id,level);

//        IPage<RBooks> page =textBookService.queryPage(id,level,pageno,3);
        return Result.success(listBook);
    }

    @GetMapping("/index/hotBooks")
    @ApiOperation(value = "教材中最热书籍")
    public Result hotBooks(Integer id,Integer level){

        List<RBooks> listBook = textBookService.queryBooksHot(id,level);

        return Result.success(listBook);
    }

    @ApiOperation(value = "首页推荐图书" )
    @GetMapping("/index/listBooks")
    public Result queryAllBooks(Integer level){
        List<RBooks> rBooksList = textBookService.queryListBooks(level);
        return Result.success(rBooksList);
    }
    @ApiOperation(value = "首页推荐课程")
    @GetMapping("/index/lisCourse")
    public Result instrationCourse(Integer levelId){
        List<Course> course = courseService.queryCourse(levelId);
        return Result.success(course);
    }

    @GetMapping("/index/examBooks")
    @ApiOperation(value = "考试用书")
    public Result examBook(Integer flag){
        List<ExamBook> list = textBookService.queryListByType(flag);
        return Result.success(list);
    }

    @GetMapping("/index/hotExambook")
    @ApiOperation(value = "最热考试用书")
   public Result hotExamBook(Integer flag){

        List<ExamBook> list = textBookService.queryHotExamBook(flag);
        return Result.success(list);
    }



}
