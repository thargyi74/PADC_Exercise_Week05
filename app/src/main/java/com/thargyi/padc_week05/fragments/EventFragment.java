package com.thargyi.padc_week05.fragments;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.thargyi.padc_week05.R;
import com.thargyi.padc_week05.adapters.EventAdapter;
import com.thargyi.padc_week05.data.models.EventModel;
import com.thargyi.padc_week05.data.vos.EventVO;

/**
 * A placeholder fragment containing a simple view.
 */
public class EventFragment extends Fragment {

    private EventAdapter mEventAdapter;
    private ControllerEventItem mEventItemController;

    public static EventFragment newInstance() {
        return new EventFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mEventItemController = (ControllerEventItem) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEventAdapter = new EventAdapter(EventModel.getInstance().getEventList(), mEventItemController);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        RecyclerView rvEvent = (RecyclerView) view.findViewById(R.id.rv_events);
        rvEvent.setAdapter(mEventAdapter);
        rvEvent.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000); //ms
            }
        });

        return view;
    }

    public interface ControllerEventItem {
        void onTapEvent(EventVO event, ImageView ivStockPhoto);
    }
}
