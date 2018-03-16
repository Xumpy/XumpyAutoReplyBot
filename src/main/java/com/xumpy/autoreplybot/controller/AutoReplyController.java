package com.xumpy.autoreplybot.controller;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.xumpy.autoreplybot.dao.AutoReplyDao;
import com.xumpy.autoreplybot.model.AutoReplyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AutoReplyController {

    @Autowired AutoReplyDao autoReplyDao;

    @RequestMapping("/list")
    @Transactional
    public List<AutoReplyEntity> listAll() {
        List<AutoReplyEntity> allReplies = new ArrayList<>();

        for (AutoReplyEntity autoReplyEntity: autoReplyDao.findAll()){
            allReplies.add(autoReplyEntity);
        }

        return allReplies;
    }
}
