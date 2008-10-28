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
package com.google.gwt.gears.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.gears.client.database.Database;
import com.google.gwt.gears.client.desktop.Desktop;
import com.google.gwt.gears.client.geolocation.Geolocation;
import com.google.gwt.gears.client.httprequest.HttpRequest;
import com.google.gwt.gears.client.localserver.LocalServer;
import com.google.gwt.gears.client.workerpool.WorkerPool;

/**
 * Factory class used to create all other Gears objects.
 */
public final class Factory extends JavaScriptObject {
  /**
   * String used to request a Database instance from Gears.
   */
  public static final String DATABASE = "beta.database";

  /**
   * String used to request a LocalServer instance from Gears.
   */
  public static final String LOCALSERVER = "beta.localserver";

  /**
   * String used to request a Database instance from Gears.
   */
  public static final String WORKERPOOL = "beta.workerpool";

  /**
   * String used to request an HttpRequest instance from Gears
   */
  public static final String HTTPREQUEST = "beta.httprequest";

  /**
   * String used to request an Desktop instance from Gears
   */
  private static final String DESKTOP = "beta.desktop";

  /**
   * String used to request an Geolocation instance from Gears
   */
  private static final String GEOLOCATION = "beta.geolocation";

  /**
   * Returns the singleton instance of the Factory class or <code>null</code>
   * if Gears is not installed or accessible.
   * 
   * @return singleton instance of the Factory class or <code>null</code> if
   *         Gears is not installed or accessible
   */
  public static native Factory getInstance() /*-{
    return $wnd.google && $wnd.google.gears && $wnd.google.gears.factory;
  }-*/;

  protected Factory() {
    // Required for overlay types
  }

  /**
   * Creates a new {@link Database} instance.
   * 
   * @return a new {@link Database} instance
   */
  public Database createDatabase() {
    return create(DATABASE);
  }

  /**
   * Creates a new {@link LocalServer} instance.
   * 
   * @return a new {@link LocalServer} instance
   */
  public LocalServer createLocalServer() {
    return create(LOCALSERVER);
  }

  /**
   * Creates a new {@link WorkerPool} instance.
   * 
   * @return a new {@link WorkerPool} instance
   */
  public WorkerPool createWorkerPool() {
    return create(WORKERPOOL);
  }

  /**
     * Creates a new {@link HttpRequest} instance.
     * 
     * @return a new {@link HttpRequest} instance
     */
  public HttpRequest createHttpRequest() {
    return create(HTTPREQUEST);
  }
  
  /**
   * Creates a new {@link Desktop} instance.
   * 
   * @return a new {@link Desktop} instance
   */
  public Desktop createDesktop() {
    return create(DESKTOP);
  }

  /**
   * Creates a new {@link Geolocation} instance.
   * 
   * @return a new {@link Geolocation} instance
   */
  public Geolocation createGeolocation() {
    return create(GEOLOCATION);
  }

  /**
   * Returns a description of the build of Gears installed. This string is
   * purely informational. Application developers should not rely on the format
   * of data returned. The contents and layout may change over time.
   * 
   * @return build description string
   */
  public native String getBuildInfo() /*-{
    return this.getBuildInfo();
  }-*/;

  /**
   * Returns the version of Gears installed, as a string of the form
   * Major.Minor.Build.Patch (e.g., '0.10.2.0').
   * 
   * @return string of the form Major.Minor.Build.Patch
   */
  public native String getVersion() /*-{
    return this.version;
  }-*/;

  /**
   * Creates an instance of the specified Gears object.
   * 
   * @param <T> Gears object type to return
   * @param className name of the object to create
   * @return an instance of the specified Gears object
   */
  private native <T extends JavaScriptObject> T create(String className) /*-{
    return this.create(className);
  }-*/;
}
