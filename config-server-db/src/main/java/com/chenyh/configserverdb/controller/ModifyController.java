package com.chenyh.configserverdb.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("c")
public class ModifyController {


    @GetMapping("a")
    public String set(){
        return new String("111111");
    }
}
