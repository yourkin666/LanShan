package com.example.lanshan.service;

import com.example.lanshan.mapper.MovieMapper;
import com.example.lanshan.pojo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieMapper movieMapper;
    @Override
    public Movie getMovie(String name) {
        Movie movie = (Movie) movieMapper.getMovie(name);
        return movie;
    }
}
