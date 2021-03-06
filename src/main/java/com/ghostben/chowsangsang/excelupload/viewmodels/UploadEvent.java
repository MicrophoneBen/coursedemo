package com.ghostben.chowsangsang.excelupload.viewmodels;


import lombok.Getter;
import lombok.Setter;


/**
 * Created by xschen on 9/11/2017.
 */
@Getter
@Setter
public class UploadEvent {
   private String eventType = "progress";
   private Object state;

   public UploadEvent() {
   }

   public String getEventType() {
      return eventType;
   }

   public void setEventType(String eventType) {
      this.eventType = eventType;
   }

   public Object getState() {
      return state;
   }

   public void setState(Object state) {
      this.state = state;
   }

   public UploadEvent(String eventType, Object state) {
      this.eventType = eventType;
      this.state = state;
   }
}
