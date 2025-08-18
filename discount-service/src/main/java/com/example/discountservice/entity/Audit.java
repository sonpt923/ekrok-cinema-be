package com.example.discountservice.entity;

public class Audit {

    //| id | BIGINT PK AI | |
    //| entity_type | ENUM('CAMPAIGN','CODE','BENEFIT','CONDITION','USAGE') | |
    //| entity_id | BIGINT | ID bản ghi bị thay đổi |
    //| change_type | ENUM('INSERT','UPDATE','DELETE') | |
    //| before_data | JSON | Dữ liệu trước khi thay đổi |
    //| after_data | JSON | Dữ liệu sau khi thay đổi |
    //| changed_by | BIGINT | Ai thay đổi |
    //| changed_at | DATETIME | |

}
