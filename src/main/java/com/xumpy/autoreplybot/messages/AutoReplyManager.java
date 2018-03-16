package com.xumpy.autoreplybot.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutoReplyManager {
    @Autowired ReplyMessage replyMessage;
    @Autowired BotController botController;

    public List<String> manage(String text){
        if (text.startsWith("!")){
            return botController.control(text);
        } else {
            return replyMessage.fromMessage(text);
        }
    }
}
