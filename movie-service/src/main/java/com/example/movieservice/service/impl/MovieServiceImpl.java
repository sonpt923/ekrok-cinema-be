package com.example.movieservice.service.impl;

import com.example.core.dto.response.ListDataResponse;
import com.example.core.exception.ValidateException;
import com.example.core.utils.ObjectUtil;
import com.example.movieservice.dto.request.MovieRequest;
import com.example.movieservice.entity.Movie;
import com.example.movieservice.repository.MovieRepository;
import com.example.movieservice.service.MovieGenreService;
import com.example.movieservice.service.MovieService;
import com.example.movieservice.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieGenreService movieGenreService;

    @Override
    @Transactional
    public Object createMovie(MovieRequest movieRequest, String username) {
        validateCreate(movieRequest);
        Movie movie = Movie.builder().code(movieRequest.getCode()).title(movieRequest.getTitle())
                .poster(movieRequest.getPoster()).trailer(movieRequest.getTrailer())
                .ageRestriction(movieRequest.getAgeRestriction()).duration(movieRequest.getDuration())
                .country(movieRequest.getCountry()).language(movieRequest.getLanguage())
                .type(movieRequest.getType()).status(movieRequest.getStatus())
                .releaseDate(movieRequest.getReleaseDate()).createdBy(username)
                .createdAt(new Timestamp(System.currentTimeMillis())).isDeleted(false)
                .build();
        movieRepository.save(movie);
        return null;
    }

    @Override
    public Movie updateMovie(MovieRequest movieRequest, String username) {
        validateUpdate(movieRequest);
        return null;
    }

    @Override
    public Movie getMovie(Long id) {
        Movie movie = movieRepository.findByIdAndIsDeleted(id, false);
        if (ObjectUtil.objectIsNullorEmpty(movie)){
            throw new ValidateException("API001", "can't find movie by id");
        }
        return movie;
    }

    @Override
    public ListDataResponse<Movie> getMovies(MovieRequest request) {
        return null;
    }

    @Override
    public Object deleteMovie(Long id) {
        return null;
    }

    private void validateCreate(MovieRequest request) {

        if (ObjectUtil.objectIsNullorEmpty(request)) {
            throw new ValidateException("Movie request cannot be null", "");
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getCode())) {
            throw new ValidateException("Movie code is required", "");
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getTitle())) {
            throw new ValidateException("Movie title is required", "");
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getPoster())) {
            throw new ValidateException("Poster URL is required", "");
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getTrailer())) {
            throw new ValidateException("Trailer URL is too long", "");
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getAgeRestriction())) {
            int age = request.getAgeRestriction();
            if (!(age == 0 || age == 13 || age == 16 || age == 18)) {
                throw new ValidateException("Invalid age restriction (allowed: 0, 13, 16, 18), ", "");
            }
        }

        if (request.getDuration() != null && request.getDuration() <= 0) {
            throw new ValidateException("Duration must be greater than 0", "");
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getCountry())) {
            throw new ValidateException("Country is required", "");
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getLanguage())) {
            throw new ValidateException("Language is required", "");
        }

        if (request.getType() == null ||
                !(request.getType().equalsIgnoreCase(Constant.TYPE.MOVIE) || request.getType().equalsIgnoreCase(Constant.TYPE.EPOSIDE))) {
            throw new ValidateException("Type must be either MOVIE or EP", "");
        }

        // Status: 0 = draft, 1 = released, 2 = archived (ví dụ)
        if (request.getStatus() == null || request.getStatus() < 0) {
            throw new ValidateException("Invalid movie status", "");
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getReleaseDate())) {
//            if (request.getReleaseDate().after(new java.util.Date(4102444800000L))) {
//                throw new ValidateException("Release date is not realistic", "");
//            }
        }
    }

    private void validateUpdate(MovieRequest movieRequest){

    }
}
