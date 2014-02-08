/*
 * Copyright (c) www.bugull.com
 */

package com.bugull.redis.recipes;

import com.bugull.redis.Connection;
import com.bugull.redis.exception.RedisException;
import com.bugull.redis.utils.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 *
 * @author Frank Wen(xbwen@hotmail.com)
 */
public abstract class StringRecipe extends BaseRecipe {
    
    public String get(String key) throws RedisException {
        return new String(get(key.getBytes()));
    }
    
    public byte[] get(byte[] key) throws RedisException {
        byte[] result = null;
        JedisPool pool = Connection.getInstance().getPool();
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            result = jedis.get(key);
        }catch(Exception ex){
            throw new RedisException(ex.getMessage(), ex);
        }finally{
            JedisUtil.returnToPool(pool, jedis);
        }
        return result;
    }

}
