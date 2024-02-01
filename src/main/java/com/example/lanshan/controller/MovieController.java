package com.example.lanshan.controller;

import com.example.lanshan.mapper.MovieMapper;
import com.example.lanshan.pojo.Movie;
import com.example.lanshan.pojo.Result;
import com.example.lanshan.service.MovieService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieMapper movieMapper;
    @GetMapping("/movieInfo")
    public Result<Movie> getMovie(@PathParam("name") String name){
        Movie movie =  movieService.getMovie(name);
        return Result.success(movie);
    }
    @GetMapping("/movie")
    public List<Movie> findAll(){
        List<Movie> movies = movieMapper.findAll();
        return movies;
    }

}
