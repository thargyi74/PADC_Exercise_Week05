package com.thargyi.padc_week05.views.items;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.thargyi.padc_week05.R;
import com.thargyi.padc_week05.data.vos.EventVO;

/**
 * Created by aung on 6/25/16.
 */
public class ViewItemEvent extends CardView {

    private TextView tvTitle;
    private ImageView ivPhoto;
    private TextView tvDesc;


    public ViewItemEvent(Context context) {
        super(context);
    }

    public ViewItemEvent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewItemEvent(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tvTitle = (TextView) findViewById(R.id.tv_title);
        ivPhoto = (ImageView) findViewById(R.id.iv_photo);
        tvDesc = (TextView) findViewById(R.id.tv_desc);

    }

    public void setData(EventVO event) {
        tvTitle.setText(event.getTitle());
        tvDesc.setText(event.getDesc());


        Glide.with(getContext())
                .load(event.getPhoto())
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .into(ivPhoto);
    }
}
