package com.chenyh.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "user")
@Data
@Accessors(chain = true)
public class User {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String userName;
    private Integer age;
    private String method;
    private String address;


}
