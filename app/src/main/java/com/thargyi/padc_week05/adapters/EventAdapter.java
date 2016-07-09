package com.thargyi.padc_week05.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import com.thargyi.padc_week05.Week05App;
import com.thargyi.padc_week05.R;
import com.thargyi.padc_week05.data.vos.EventVO;
import com.thargyi.padc_week05.fragments.EventFragment;
import com.thargyi.padc_week05.views.holders.EventViewHolder;

/**
 * Created by Dell on 7/08/16.
 */
public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private LayoutInflater inflater;
    private List<EventVO> eventList;
    private EventFragment.ControllerEventItem mEventItemController;

    public EventAdapter(List<EventVO> eventList, EventFragment.ControllerEventItem eventItemController) {
        inflater = LayoutInflater.from(Week05App.getContext());
        this.eventList = eventList;
        mEventItemController = eventItemController;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.view_item, parent, false);
        final EventViewHolder eventVH = new EventViewHolder(view, mEventItemController);
        return eventVH;
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        holder.setData(eventList.get(position));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
