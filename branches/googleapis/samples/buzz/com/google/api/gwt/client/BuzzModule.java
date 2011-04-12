/*
 * Copyright 2011 Google Inc.
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
package com.google.api.gwt.samples.buzz.client;

import com.google.api.gwt.buzz.v1.shared.Buzz;
import com.google.api.gwt.samples.buzz.shared.BuzzTest;
import com.google.api.gwt.shared.OAuth2Login;
import com.google.api.gwt.shared.OAuth2Login.OAuth2LoginReceiver;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * A simple GWT module do display a user's recent Buzz posts.
 */
public class BuzzModule extends BuzzTest implements EntryPoint {

  @Override
  protected Buzz createBuzz() {
    return GWT.create(Buzz.class);
  }

  void go() {
    loginBuilder()//
        .setClientId("629256018955.apps.googleusercontent.com")//
        .build(new OAuth2LoginReceiver() {

          @Override
          public void onFailure(Throwable t) {

          }

          @Override
          public void onSuccess(OAuth2Login login) {
            initializeTransport(login.getAuthorizationCode());
          }
        });
  }

  @Override
  public void onModuleLoad() {
    final Button b = new Button("Log in and display buzz feed");
    b.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        go();
        b.setVisible(false);
      }
    });
    RootPanel.get().add(b);
  }

  @Override
  protected void println(String value) {
    RootPanel.get().add(new Label(value));
  }
}
