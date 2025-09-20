package com.example.userservice.repository.customize.impl;

import com.example.core.dto.response.ListDataResponse;
import com.example.core.utils.ObjectUtil;
import com.example.userservice.dto.request.GroupRequest;
import com.example.userservice.entity.Group;
import com.example.userservice.repository.customize.GroupRepoCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

@Repository
public class GroupRepoCustomImpl implements GroupRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ListDataResponse<Object> findGroupsByCondition(GroupRequest request) {
        ListDataResponse<Object> listDataResponse = new ListDataResponse();
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        sql.append("WITH RECURSIVE group_tree AS (\n" +
                "    SELECT gr.id, gr.parent_id\n" +
                "    FROM user u\n" +
                "    INNER JOIN group_user gu ON u.id = gu.user_id\n" +
                "    INNER JOIN `group` gr ON gr.id = gu.group_id\n" +
                "    WHERE u.id = 123 " +
                "" +
                "    UNION ALL" +
                "" +
                "    SELECT c.id, c.parent_id" +
                "    FROM `group` c" +
                "    INNER JOIN group_tree gt ON c.parent_id = gt.id )" +
                "SELECT * " +
                "FROM group_tree;");

        if (ObjectUtil.objectIsNullorEmpty(request.getCode())) {
            sql.append(" AND gr.code like :code ");
            params.put("code", request.getCode());
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getName())) {
            sql.append(" AND gr.name like CONCAT('%', :name '%') ");
            params.put("name", request.getName());
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getParentId())) {
            sql.append(" AND gr.parent_id like :parentId ");
            params.put("parentCode", request.getParentId());
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getStatus())) {
            sql.append(" AND gr.status = :status ");
            params.put("status", request.getStatus());
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getCreatedBy())) {
            sql.append(" AND gr.created_by = :createdBy ");
            params.put("createdBy", request.getCreatedBy());
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getUpdatedBy())) {
            sql.append(" AND gr.updated_by = :updated_by ");
            params.put("updatedBy", request.getUpdatedBy());
        }

        sql.append(" AND u.is_deleted = :isDeleted ");
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


        Query query = entityManager.createQuery(sql.toString());
        params.forEach(query::setParameter);
        listDataResponse.setData(query.getResultList());

        sql.setLength(0);
        params.clear();

        sql.append("WITH RECURSIVE `group_tree` AS ( " +
                "    SELECT id, name, parent_id" +
                "    FROM `group`" +
                "    WHERE id = :group_id   " +
                "    UNION ALL " +
                "    SELECT c.id, c.name, c.parent_id " +
                "    FROM `group` c " +
                "    INNER JOIN `group` ct ON c.parent_id = ct.id " +
                ") " +
                "SELECT * FROM `group_tree` WHERE 1 = 1");


        if (ObjectUtil.objectIsNullorEmpty(request.getCode())) {
            sql.append(" AND gr.code like :code ");
            params.put("code", request.getCode());
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getName())) {
            sql.append(" AND gr.name like CONCAT('%', :name '%') ");
            params.put("name", request.getName());
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getParentId())) {
            sql.append(" AND gr.parent_id like :parentId ");
            params.put("parentCode", request.getParentId());
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getStatus())) {
            sql.append(" AND gr.status = :status ");
            params.put("status", request.getStatus());
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getCreatedBy())) {
            sql.append(" AND gr.created_by = :createdBy ");
            params.put("createdBy", request.getCreatedBy());
        }

        if (ObjectUtil.objectIsNullorEmpty(request.getUpdatedBy())) {
            sql.append(" AND gr.updated_by = :updated_by ");
            params.put("updatedBy", request.getUpdatedBy());
        }

        sql.append(" AND u.is_deleted = :isDeleted ");
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


        query = entityManager.createNativeQuery(sql.toString());
        params.forEach(query::setParameter);
        Long totalRecord = Long.valueOf(query.getSingleResult().toString());
        listDataResponse.setTotalRecord(totalRecord);

        return listDataResponse;
    }
}
