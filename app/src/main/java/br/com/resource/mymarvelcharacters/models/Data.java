package br.com.resource.mymarvelcharacters.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Created by pmoreirr on 11/03/2018.
 */

public class Data implements Serializable {

    @SerializedName("limit")
    private int limit;
    @SerializedName("results")
    private Results[] results;
    @SerializedName("offset")
    private int offset;

    public Data() {
    }

    public Data(int limit, Results[] results, int offset) {
        this.limit = limit;
        this.results = results;
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Results[] getResults() {
        return results;
    }

    public void setResults(Results[] results) {
        this.results = results;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
