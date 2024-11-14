package com.hand.training.service.impl;

import com.hand.training.mapper.ExampleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shaoqin.zhou@hand-china.com
 * @since 2024-11-13 23:14:49
 */
@Service
public class ExampleServiceImpl {
    @Autowired
    private ExampleMapper exampleMapper;
}
