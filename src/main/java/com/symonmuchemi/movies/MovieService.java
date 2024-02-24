/* This class defines the business logic of the application  */
package com.symonmuchemi.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

     /**
      * returns a list of all movie objects int the repository
      * the findAll() method is defined in the MongoRepository class
      * */
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }
}
// TODO: Find out why an empty array is returned