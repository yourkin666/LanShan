package com.example.lanshan.mapper;

import com.example.lanshan.pojo.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface MovieMapper {
    @Select("select * from movies where name=#{name} ")
    Movie getMovie(String name);
    @Select("select * from movies")
    List<Movie> findAll();
}
