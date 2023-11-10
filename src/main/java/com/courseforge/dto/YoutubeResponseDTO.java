package com.courseforge.dto;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Data;
import com.google.api.client.util.Key;
import com.google.api.services.youtube.model.Video;

import java.util.List;

public final class YoutubeResponseDTO extends GenericJson {
   @Key
   private String etag;
   @Key
   private String eventId;
   @Key
   private List<Video> items;
   @Key
   private String kind;
   @Key
   private String nextPageToken;
  
   @Key
   private String prevPageToken;

   @Key
   private String visitorId;

   public YoutubeResponseDTO() {
   }

   public String getEtag() {
      return this.etag;
   }

   public YoutubeResponseDTO setEtag(String var1) {
      this.etag = var1;
      return this;
   }

   public String getEventId() {
      return this.eventId;
   }

   public YoutubeResponseDTO setEventId(String var1) {
      this.eventId = var1;
      return this;
   }

public List<Video> getItems() {
      return this.items;
   }

   public YoutubeResponseDTO setItems(List<Video> var1) {
      this.items = var1;
      return this;
   }

   public String getKind() {
      return this.kind;
   }

   public YoutubeResponseDTO setKind(String var1) {
      this.kind = var1;
      return this;
   }

   public String getNextPageToken() {
      return this.nextPageToken;
   }

   public YoutubeResponseDTO setNextPageToken(String var1) {
      this.nextPageToken = var1;
      return this;
   }

   public String getPrevPageToken() {
      return this.prevPageToken;
   }

   public YoutubeResponseDTO setPrevPageToken(String var1) {
      this.prevPageToken = var1;
      return this;
   }

   public String getVisitorId() {
      return this.visitorId;
   }

   public YoutubeResponseDTO setVisitorId(String var1) {
      this.visitorId = var1;
      return this;
   }

   public YoutubeResponseDTO set(String var1, Object var2) {
      return (YoutubeResponseDTO)super.set(var1, var2);
   }

   public YoutubeResponseDTO clone() {
      return (YoutubeResponseDTO)super.clone();
   }

   static {
      Data.nullOf(Video.class);
   }
}
