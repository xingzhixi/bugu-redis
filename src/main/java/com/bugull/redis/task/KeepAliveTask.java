/*
 * Copyright (c) www.bugull.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bugull.redis.task;

import com.bugull.redis.RedisConnection;
import com.bugull.redis.utils.Constant;
import com.bugull.redis.utils.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Sending online message in period.
 * 
 * @author Frank Wen(xbwen@hotmail.com)
 */
public class KeepAliveTask implements Runnable {

    @Override
    public void run() {
        RedisConnection conn = RedisConnection.getInstance();
        JedisPool pool = conn.getPool();
        String key = Constant.ONLINE + conn.getClientId();
        int seconds = (int)(conn.getKeepAlive() * 1.5F);
        Jedis jedis = null;
        try{
            jedis = pool.getResource();
            jedis.setex(key, seconds, "T");  //T stands for True
        }catch(Exception ex){
            //ignore ex
        }finally{
            JedisUtil.returnToPool(pool, jedis);
        }
    }

}
