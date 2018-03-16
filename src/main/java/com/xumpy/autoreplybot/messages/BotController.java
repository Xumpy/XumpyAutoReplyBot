package com.xumpy.autoreplybot.messages;

import com.xumpy.autoreplybot.dao.AutoReplyDao;
import com.xumpy.autoreplybot.model.AutoReplyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class BotController {
    @Autowired AutoReplyDao autoReplyDao;

    private List<String> returnSingleValue(String text){
        List<String> singleValue = new ArrayList<>();
        singleValue.add(text);

        return singleValue;
    }

    @Transactional
    public List<String> control(String text){
        if (text.startsWith("!add") || text.startsWith("! add")){
            return insertNewValue(text);
        }
        if (text.startsWith("!delete") || text.startsWith("! delete")){
            return deleteKey(text);
        }
        return returnSingleValue("not recognized");
    }

    private List<String> extractQuotes(String text){
        List<String> stringsBetweenQuotes = new ArrayList<String>();

        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            stringsBetweenQuotes.add(matcher.group(1));
        }

        return stringsBetweenQuotes;
    }

    private List<String> deleteKey(String text){
        List<String> values = extractQuotes(text);

        if (values.size() == 1){
            autoReplyDao.deleteKey(values.get(0));

            return returnSingleValue("ok");
        }
        return returnSingleValue("not ok");
    }

    private List<String> insertNewValue(String text){
        try{
            List<String> values = extractQuotes(text);

            if (values.size() == 2){
                AutoReplyEntity autoReplyEntity = new AutoReplyEntity();
                autoReplyEntity.setKey(values.get(0));
                autoReplyEntity.setReply(values.get(1));

                autoReplyDao.save(autoReplyEntity);

                return returnSingleValue("ok");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return returnSingleValue("not ok");
    }
}
