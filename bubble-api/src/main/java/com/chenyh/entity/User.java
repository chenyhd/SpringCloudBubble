package com.chenyh.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@ToString
@Accessors(chain=true)
public class User {
    private String name;
    private String age;
    private String dbSource;
}
