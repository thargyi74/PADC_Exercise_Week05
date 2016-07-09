package com.thargyi.padc_week05.data.models;

import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.thargyi.padc_week05.data.vos.EventVO;
import com.thargyi.padc_week05.utils.CommonInstances;
import com.thargyi.padc_week05.utils.JsonUtils;

/**
 * Created by aung on 6/25/16.
 */
public class EventModel {

    private static final String DUMMY_EVENT_LIST = "myanmar_attractions.json";

    private static EventModel objInstance;

    private List<EventVO> eventList;

    private EventModel() {
        eventList = initializeEventList();
    }

    public static EventModel getInstance() {
        if (objInstance == null) {
            objInstance = new EventModel();
        }

        return objInstance;
    }

    private List<EventVO> initializeEventList() {
        List<EventVO> eventList = new ArrayList<>();

        try {
            String dummyEventList = JsonUtils.getInstance().loadDummyData(DUMMY_EVENT_LIST);
            Type listType = new TypeToken<List<EventVO>>() {
            }.getType();
            eventList = CommonInstances.getGsonInstance().fromJson(dummyEventList, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    public List<EventVO> getEventList() {
        return eventList;
    }

    public EventVO getByTitle(String Title) {
        for (EventVO event : eventList) {
            if (event.getTitle().equals(Title)) {
                return event;
            }
        }
        return null;
    }
}
