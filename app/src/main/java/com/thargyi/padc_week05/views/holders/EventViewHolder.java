package com.thargyi.padc_week05.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.thargyi.padc_week05.R;
import com.thargyi.padc_week05.data.vos.EventVO;
import com.thargyi.padc_week05.fragments.EventFragment;

/**
 * Created by aung on 6/26/16.
 */
public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @Bind(R.id.tv_title)
    TextView tvTitle;

    @Bind(R.id.iv_photo)
    ImageView ivPhoto;

    @Bind(R.id.tv_desc)
    TextView tvEventDesc;

    private EventVO mEvent;
    private EventFragment.ControllerEventItem mEventItemController;

    public EventViewHolder(View view, EventFragment.ControllerEventItem eventItemController) {
        super(view);
        ButterKnife.bind(this, view);

        view.setOnClickListener(this);
        mEventItemController = eventItemController;
    }

    public void setData(EventVO event) {
        this.mEvent = event;

        tvTitle.setText(event.getTitle());
        tvEventDesc.setText(event.getDesc());


        Glide.with(ivPhoto.getContext())
                .load(event.getPhoto())
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(ivPhoto);
    }

    @Override
    public void onClick(View view) {
        mEventItemController.onTapEvent(mEvent, ivPhoto);
    }
}
