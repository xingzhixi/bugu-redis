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

package com.bugull.redis.recipes;

import com.bugull.redis.Connection;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Frank Wen(xbwen@hotmail.com)
 */
public class QueueRecipeTest {
    
    @Test
    public void test() throws Exception {
        Connection conn = Connection.getInstance();
        conn.setHost("192.168.0.200");
        conn.setPassword("foobared");
        conn.connect();
        
        QueueRecipe queue = new QueueRecipe();
        queue.offer("my_queue", "a");
        queue.offer("my_queue", "b");
        
        Assert.assertEquals(queue.poll("my_queue"), "a");
        Assert.assertEquals(queue.poll("my_queue"), "b");
        Assert.assertNull(queue.poll("my_queue"));
        
        conn.disconnect();
    }

}
