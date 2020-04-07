package com.boot.redis.controller;

import com.boot.redis.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjie
 * @classname UserController
 * @date 2020/04/07 0007 18:08:41
 * @description
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/setValue")
    public void setValue(){
        try {
            logger.info("====setValue start====");
            for (int i = 1; i <= 10; i++) {
                redisUtil.set(i+"",i*10);
            }
            logger.info("value:"+redisUtil.get("1"));
            logger.info("====setValue stop====");
        }catch (Exception e){
            logger.error("setValue error:"+e.getMessage(),e);
        }
    }

    @RequestMapping("/getValue")
    public Object getValue(@RequestParam Integer key){
        Object value = null;
        try {
            logger.info("====getValue start====");
            value = redisUtil.get(key+"");
            logger.info("key:"+key+",value:"+value);
            logger.info("====getValue stop====");
        }catch (Exception e){
            logger.error("getValue error:"+e.getMessage(),e);
        }
        return value;
    }


}
