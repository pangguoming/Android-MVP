package com.buildersaccess.haustalk.utility.volley.volleytoolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.ImageLoader;

import java.io.File;

/**
 * Created by pangg_000 on 12/30/2014.
 */
/*
 * Extends from DisckBasedCache --> Utility from volley toolbox.
 * Also implements ImageCache, so that we can pass this custom implementation
 * to ImageLoader.
 */
public  class DiskBitmapCache extends DiskBasedCache implements ImageLoader.ImageCache {

    public DiskBitmapCache(File rootDirectory, int maxCacheSizeInBytes) {
        super(rootDirectory, maxCacheSizeInBytes);
    }

    public DiskBitmapCache(File cacheDir) {
        super(cacheDir);
    }

    public Bitmap getBitmap(String url) {
        final Entry requestedItem = get(url);

        if (requestedItem == null)
            return null;

        return BitmapFactory.decodeByteArray(requestedItem.data, 0, requestedItem.data.length);
    }

    public void putBitmap(String url, Bitmap bitmap) {

        final Entry entry = new Entry();

/*			//Down size the bitmap.If not done, OutofMemoryError occurs while decoding large bitmaps.
 			// If w & h is set during image request ( using ImageLoader ) then this is not required.
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Bitmap downSized = BitmapUtil.downSizeBitmap(bitmap, 50);

			downSized.compress(Bitmap.CompressFormat.JPEG, 100, baos);
			byte[] data = baos.toByteArray();
	        entry.data = data ; */

        entry.data = BitmapUtil.convertBitmapToBytes(bitmap) ;
        put(url, entry);
    }
}