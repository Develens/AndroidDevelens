package com.develens.andydevelens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageSlider extends PagerAdapter {

    private Context context;
    private ArrayList<String> data;
    private Integer[] idata;
    private  int layout, image_res;
    private boolean StringList, StringLayoutList, IntList, IntLayoutList;

    public ImageSlider(Context context, ArrayList<String> data){
        this.context = context;
        this.data = data;
        StringList = true;
        StringLayoutList = false;
        IntList = false;
        IntLayoutList = false;
    }

    public ImageSlider(Context context, ArrayList<String> data, int layout, int imageres){
        this.context = context;
        this.data = data;
        this.layout = layout;
        this.image_res = imageres;
        StringList = false;
        StringLayoutList = true;
        IntList = false;
        IntLayoutList = false;
    }

    public ImageSlider(Context context, Integer[] data){
        this.context = context;
        this.idata = data;
        StringList = false;
        StringLayoutList = false;
        IntList = true;
        IntLayoutList = false;
    }

    public ImageSlider(Context context, Integer[] data, int layout, int imageres){
        this.context = context;
        this.idata = data;
        this.layout = layout;
        this.image_res = imageres;
        StringList = false;
        StringLayoutList = false;
        IntList = false;
        IntLayoutList = true;
    }

    @Override
    public int getCount() {
        if (StringList){
            return data.size();
        }else if (StringLayoutList){
            return data.size();
        }else if (IntList){
            return idata.length;
        }else if (IntLayoutList){
            return idata.length;
        }else {
            return 0;
        }
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object == view;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (StringList){
            View view = LayoutInflater.from(context).inflate(R.layout.layout_image_slider, null);
            ImageView imageView = view.findViewById(R.id.image);
            Picasso.get().load(data.get(position)).into(imageView);
            container.addView(view);
            return view;
        }else if (StringLayoutList){
            View view = LayoutInflater.from(context).inflate(layout, null);
            ImageView imageView = view.findViewById(image_res);
            Picasso.get().load(data.get(position)).into(imageView);
            container.addView(view);
            return view;
        }else if (IntList){
            View view = LayoutInflater.from(context).inflate(R.layout.layout_image_slider, null);
            ImageView imageView = view.findViewById(R.id.image);
            imageView.setImageDrawable(context.getResources().getDrawable(idata[position]));
            container.addView(view);
            return view;
        }else if (IntLayoutList){
            View view = LayoutInflater.from(context).inflate(layout, null);
            ImageView imageView = view.findViewById(image_res);
            imageView.setImageDrawable(context.getResources().getDrawable(idata[position]));
            container.addView(view);
            return view;
        }else {
            return false;
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object view) {
        container.removeView((View) view);
    }
}
