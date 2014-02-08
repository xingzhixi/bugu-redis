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

package com.bugull.redis.listener;

import java.util.Map;

/**
 * Listener to transfer files.
 * 
 * @author Frank Wen(xbwen@hotmail.com)
 */
public abstract class FileListener {
    
    public abstract void onRequest(String fromClientId, String fileId, Map<String,String> extras);
    
    public abstract void onAccept(String fromClientId, String fileId, Map<String,String> extras);
    
    public abstract void onReject(String fromClientId, String fileId, Map<String,String> extras);
    
    public abstract void onFileData(String fileId, byte[] data);
    
    public abstract void onFileEnd(String fileId);
    
    public abstract void onError(String fileId);

}
