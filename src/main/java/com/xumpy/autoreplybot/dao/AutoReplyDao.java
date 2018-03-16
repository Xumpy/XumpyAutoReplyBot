package com.xumpy.autoreplybot.dao;

import com.xumpy.autoreplybot.model.AutoReplyEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutoReplyDao extends CrudRepository<AutoReplyEntity, Long>{
    @Query("from AutoReplyEntity where lower(:text) like '%' || lower(replace(key, ' ', '')) || '%'")
    List<AutoReplyEntity> selectKeys(@Param("text") String text);

    @Modifying
    @Query("delete from AutoReplyEntity where lower(:key) = lower(replace(key, ' ', ''))")
    void deleteKey(@Param("key") String key);
}
