package br.com.resource.mymarvelcharacters.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by pmoreirr on 11/03/2018.
 */

public class Thumbnail implements Serializable {

    @SerializedName("path")
    private String path;
    @SerializedName("extension")
    private String extension;

    public Thumbnail() {
    }

    public Thumbnail(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
