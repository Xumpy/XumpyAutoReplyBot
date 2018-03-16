package com.xumpy.autoreplybot.messages;

import com.vdurmont.emoji.EmojiParser;
import com.xumpy.autoreplybot.dao.AutoReplyDao;
import com.xumpy.autoreplybot.model.AutoReplyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ReplyMessage {
    @Autowired AutoReplyDao autoReplyDao;

    private List<String> returnSingleValue(String text){
        List<String> singleValue = new ArrayList<>();
        singleValue.add(text);

        return singleValue;
    }

    @Transactional
    public List<String> fromMessage(String text){
        Random generator = new Random();
        List<AutoReplyEntity> replyEntities = autoReplyDao.selectKeys(text.replaceAll("[^A-Za-z0-9]", ""));

        if (replyEntities.size() != 0){
            return returnSingleValue(EmojiParser.parseToUnicode(replyEntities.get(generator.nextInt(replyEntities.size())).getReply()));
        } else {
            return new ArrayList<>();
        }
    }
}
