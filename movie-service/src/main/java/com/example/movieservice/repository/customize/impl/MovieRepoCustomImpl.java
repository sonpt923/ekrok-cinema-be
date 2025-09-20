package com.example.movieservice.repository.customize.impl;

import com.example.core.dto.response.ListDataResponse;
import com.example.core.utils.ObjectUtil;
import com.example.movieservice.dto.request.MovieRequest;
import com.example.movieservice.entity.Movie;
import com.example.movieservice.repository.customize.MovieRepoCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MovieRepoCustomImpl implements MovieRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ListDataResponse<Movie> getMovies(MovieRequest request) {
        ListDataResponse<Movie> listDataResponse = new ListDataResponse<>();
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        sql.append("SELECT m.* FROM movie m WHERE 1 = 1 ");

        if (!ObjectUtil.objectIsNullorEmpty(request.getCode())) {
            sql.append(" AND m.code LIKE CONCAT('%', :code, '%') ");
            params.put("code", request.getCode());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getTitle())) {
            sql.append(" AND m.title like CONCAT('%',:title,'%') ");
            params.put("title", request.getTitle());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getAgeRestriction())) {
            sql.append(" AND m.age_restriction = :ageRestriction ");
            params.put("ageRestriction", request.getAgeRestriction());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getCountry())) {
            sql.append(" AND m.country = :country ");
            params.put("country", request.getCountry());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getLanguage())) {
            sql.append(" AND m.language = :language ");
            params.put("language", request.getLanguage());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getType())) {
            sql.append(" AND m.type = :type ");
            params.put("type", request.getType());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getStatus())) {
            sql.append(" AND m.status = :status ");
            params.put("status", request.getStatus());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getReleaseDate())) {
            sql.append(" AND m.release_date = :releaseDate ");
            params.put("releaseDate", request.getReleaseDate());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getCreatedBy())) {
            sql.append(" AND m.created_by like CONCAT('%',:createdBy,'%') ");
            params.put("createdBy", request.getCreatedBy());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getUpdatedBy())) {
            sql.append(" AND m.updated_by like CONCAT('%',:updatedBy,'%') ");
            params.put("updatedBy", request.getUpdatedBy());
        }

        sql.append(" AND m.is_deleted = :isDeleted ");
        params.put("isDeleted", request.getIsDeleted());

        if (!ObjectUtil.objectIsNullorEmpty(request.getPage())) {
            sql.append(" LIMIT  :page, :size  ");
            if (request.getPage() == 0) {
                params.put("page", 0);
            } else {
                params.put("page", (request.getPage() * request.getPageSize()));
            }
            params.put("size", request.getPageSize());
        }

        Query query = entityManager.createNativeQuery(sql.toString(), Movie.class);
        params.forEach(query::setParameter);
        listDataResponse.setData(query.getResultList());

        sql.setLength(0);
        params.clear();

        sql.append(" SELECT COUNT(*) FROM movie m WHERE 1 = 1 ");

        if (!ObjectUtil.objectIsNullorEmpty(request.getCode())) {
            sql.append(" AND m.code like CONCAT('%',:code,'%') ");
            params.put("code", request.getCode());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getTitle())) {
            sql.append(" AND m.title like CONCAT('%',:title,'%') ");
            params.put("title", request.getTitle());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getAgeRestriction())) {
            sql.append(" AND m.age_restriction = :ageRestriction ");
            params.put("ageRestriction", request.getAgeRestriction());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getCountry())) {
            sql.append(" AND m.country = :country ");
            params.put("country", request.getCountry());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getLanguage())) {
            sql.append(" AND m.language = :language ");
            params.put("language", request.getLanguage());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getType())) {
            sql.append(" AND m.type = :type ");
            params.put("type", request.getType());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getStatus())) {
            sql.append(" AND m.status = :status ");
            params.put("status", request.getStatus());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getReleaseDate())) {
            sql.append(" AND m.release_date = :releaseDate ");
            params.put("releaseDate", request.getReleaseDate());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getCreatedBy())) {
            sql.append(" AND m.created_by like CONCAT('%',:createdBy,'%') ");
            params.put("createdBy", request.getCreatedBy());
        }

        if (!ObjectUtil.objectIsNullorEmpty(request.getUpdatedBy())) {
            sql.append(" AND m.updated_by like CONCAT('%',:updatedBy,'%') ");
            params.put("updatedBy", request.getUpdatedBy());
        }

        sql.append(" AND m.is_deleted = :isDeleted ");
        params.put("isDeleted", request.getIsDeleted());

        query = entityManager.createNativeQuery(sql.toString());
        params.forEach(query::setParameter);
        Long totalRecord = Long.valueOf(query.getSingleResult().toString());
        listDataResponse.setTotalRecord(totalRecord);

        return listDataResponse;
    }


}
