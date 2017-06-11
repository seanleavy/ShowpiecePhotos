package com.example.sean.showpiecephotos.model.Pojo.posts.nested.datum;


import java.util.HashMap;
import java.util.Map;

import com.example.sean.showpiecephotos.model.Pojo.posts.nested.datum.images.LowResolution;
import com.example.sean.showpiecephotos.model.Pojo.posts.nested.datum.images.StandardResolution;
import com.example.sean.showpiecephotos.model.Pojo.posts.nested.datum.images.Thumbnail;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "thumbnail",
        "low_resolution",
        "standard_resolution"
})
public class Images {

    @JsonProperty("thumbnail")
    private Thumbnail thumbnail;
    @JsonProperty("low_resolution")
    private LowResolution lowResolution;
    @JsonProperty("standard_resolution")
    private StandardResolution standardResolution;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("thumbnail")
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("low_resolution")
    public LowResolution getLowResolution() {
        return lowResolution;
    }

    @JsonProperty("low_resolution")
    public void setLowResolution(LowResolution lowResolution) {
        this.lowResolution = lowResolution;
    }

    @JsonProperty("standard_resolution")
    public StandardResolution getStandardResolution() {
        return standardResolution;
    }

    @JsonProperty("standard_resolution")
    public void setStandardResolution(StandardResolution standardResolution) {
        this.standardResolution = standardResolution;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
