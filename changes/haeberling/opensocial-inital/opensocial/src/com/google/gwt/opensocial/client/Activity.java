/*
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwt.opensocial.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Representation of an activity.
 *
 * @see "http://code.google.com/apis/opensocial/docs/0.8/reference/#opensocial.Activity"
 */
public final class Activity extends JavaScriptObject {
  protected Activity() {
  }

  /**
   * All of the fields that activities can have.
   */
  public enum Field {
    /**
     * A string specifying the title template message ID in the gadget spec.
     */
    TITLE_ID("titleId"),

    /**
     * A string specifying the primary text of an activity.
     */
    TITLE("title"),

    /**
     * A map of custom keys to values associated with this activity. These will
     * be used for evaluation in templates.
     */
    TEMPLATE_PARAMS("templateParams"),

    /**
     * A string specifying the URL that represents this activity.
     */
    URL("url"),

    /**
     * Any photos, videos, or images that should be associated with the
     * activity.
     */
    MEDIA_ITEMS("mediaItems"),

    /**
     * A string specifying the body template message ID in the gadget spec.
     */
    BODY_ID("bodyId"),

    /**
     * A string specifying an optional expanded version of an activity.
     */
    BODY("body"),

    /**
     * An optional string ID generated by the posting application.
     */
    EXTERNAL_ID("externalId"),

    /**
     * A string specifing the title of the stream.
     */
    STREAM_TITLE("streamTitle"),

    /**
     * A string specifying the stream's URL.
     */
    STREAM_URL("streamUrl"),

    /**
     * A string specifying the stream's source URL.
     */
    STREAM_SOURCE_URL("streamSourceUrl"),

    /**
     * A string specifying the URL for the stream's favicon.
     */
    STREAM_FAVICON_URL("streamFaviconUrl"),

    /**
     * A number between 0 and 1 representing the relative priority of this
     * activity in relation to other activities from the same source
     */
    PRIORITY("priority"),

    /**
     * A string ID that is permanently associated with this activity. This value
     * can not be set.
     */
    ID("id"),

    /**
     * The string ID of the user who this activity is for. This value can not be
     * set.
     *
     * @see "http://code.google.com/apis/opensocial/docs/0.8/reference/#opensocial.Activity.Field.USER_ID"
     */
    USER_ID("userId"),

    /**
     * A string specifying the application that this activity is associated
     * with. This value can not be set.
     */
    APP_ID("appId"),

    /**
     * A string specifying the time at which this activity took place in
     * milliseconds since the epoch. This value can not be set.
     */
    POSTED_TIME("postedTime");

    private String value = null;

    private Field(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }
  }

  /**
   * Gets the activity data that's associated with the specified key.
   *
   * @param key The key to get data for
   * @return The data
   */
  public String getField(Field key) {
    return nativeGetField(key.toString());
  }
  
  /**
   * Gets an ID that can be permanently associated with this activity.
   *
   * @return The ID
   */
  public native String getId() /*-{
    return this.getId();
  }-*/;

  /**
   * Sets data for this activity associated with the given key.
   *
   * @param key The key to set data for
   * @param data The data to set
   */
  public void setField(Field key, String data) {
    nativeSetField(key.toString(), data);
  }
  
  private native String nativeGetField(String value) /*-{
    return this.getField(value);
  }-*/;
  
  private native void nativeSetField(String key, String data) /*-{
    this.setField(key, data);
  }-*/;
}