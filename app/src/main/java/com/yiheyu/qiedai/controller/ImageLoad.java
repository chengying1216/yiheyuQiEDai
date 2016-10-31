package com.yiheyu.qiedai.controller;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by 一合鱼 on 2016,10,31,0031.
 *
 * 图片加载
 */

public class ImageLoad {

    /**
     *
     * @param context
     * @param address
     * @param imageView
     */

    public static void lodeImage(Context context, String address, ImageView imageView) {
        Picasso.with(context).load(address).into(imageView);
    }

}
