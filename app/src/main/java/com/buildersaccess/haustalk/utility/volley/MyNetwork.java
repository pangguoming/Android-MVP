/**
 * Copyright 2013 Ognyan Bankov
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
package com.buildersaccess.haustalk.utility.volley;

import android.app.ActivityManager;
import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.buildersaccess.haustalk.R;
import com.buildersaccess.haustalk.utility.volley.volleytoolbox.BitmapLruCache;
import com.buildersaccess.haustalk.utility.volley.volleytoolbox.DiskBitmapCache;

/**
 * Helper class that is used to provide references to initialized RequestQueue(s) and ImageLoader(s)
 * 
 * @author Ognyan Bankov
 * 
 */
public class MyNetwork {
    private static RequestQueue mRequestQueue;
    private static ImageLoader mImageLoader;
    private static int defaultTimeout;
    private static String hostURL;

    private MyNetwork() {
        // no instances
    }

    public static void init(Context context) {
        defaultTimeout=context.getResources().getInteger(R.integer.default_timeout);
        hostURL=context.getString(R.string.host_url);
        mRequestQueue = Volley.newRequestQueue(context);
        int memClass = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE))
                .getMemoryClass();
        // Use 1/8th of the available memory for this memory cache.
        int cacheSize = 1024 * 1024 * memClass / 8;
        mImageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache(cacheSize));
        //mImageLoader = new ImageLoader(mRequestQueue, new DiskBitmapCache(context.getCacheDir(),cacheSize));
    }
    public static String getHostURL(){
        return hostURL;
    }
    public static int getDefaultTimeout(){
        return defaultTimeout;
    }
    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("RequestQueue not initialized");
        }
    }
    /**
     * Returns instance of ImageLoader initialized with {@see FakeImageCache} which effectively means
     * that no memory caching is used. This is useful for images that you know that will be show
     * only once.
     * 
     * @return
     */
    public static ImageLoader getImageLoader() {
        if (mImageLoader != null) {
            return mImageLoader;
        } else {
            throw new IllegalStateException("ImageLoader not initialized");
        }
    }
}

