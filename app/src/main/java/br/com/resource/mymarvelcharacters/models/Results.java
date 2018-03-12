package br.com.resource.mymarvelcharacters.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by pmoreirr on 11/03/2018.
 */

public class Results implements Serializable {

    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("thumbnail")
    private Thumbnail thumbnail;

    public Results() {
    }

    public Results(String name, String description, Thumbnail thumbnail) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }
}
