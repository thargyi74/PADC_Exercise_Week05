package com.thargyi.padc_week05.data.vos;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;

/**
 * Created by aung on 6/25/16.
 */
public class EventVO {



    @SerializedName("title")
    private String Title;

    @SerializedName("desc")
    private String Desc;

    @SerializedName("images")
    private String Images;


    public EventVO(String Title, String Images, String Desc) {
        this.Title = Title;
        this.Images = Images;
        this.Desc = Desc;

    }

    public String getTitle() {
        return Title;
    }

    public String getPhoto() {
        return Images;
    }

    public String getDesc() {
        return Desc;
    }


}
