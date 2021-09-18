package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookMapper {
//    增加一本书
    int addBook(Books books);
//    删除一本书
    int deleteBookById(@Param("bookID") int id);
//    更新一本书
    int updateBook(Books books);
//    查询一本书
    Books queryBookById(@Param("bookID") int id);
//    查询所有的书
    List<Books> queryAllBook();
//通过用户名查询一本书
    Books queryBookByName(@Param("bookName") String bookName);
//
    Books queryBookByPublish(@Param("publish") String publish);

    Books queryBookByAuthor(@Param("author") String author);

}
