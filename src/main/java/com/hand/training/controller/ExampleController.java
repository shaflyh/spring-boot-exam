package com.hand.training.controller;

import com.hand.training.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaoqin.zhou@hand-china.com
 * @since 2024-10-13 23:16:29
 */
@RestController
@RequestMapping("/example")
public class ExampleController {
    @Autowired
    private ExampleService exampleService;

    @RequestMapping("/sayHi")
    public String sayHi() {
        return "Hi";
    }
}
