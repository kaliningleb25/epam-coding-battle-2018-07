package com.epam.client;

import com.epam.client.service.GreetingService;
import com.epam.client.service.GreetingServiceAsync;
import com.epam.client.widgets.LoginDialogBox;
import com.epam.client.widgets.SearchDialogBox;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CoddingBattle implements EntryPoint {

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync accountService = GWT.create(GreetingService.class);

  private LoginDialogBox loginDialogBox;
  private SearchDialogBox searchDialogBox;

  private void initHeader() {
    RootPanel search = RootPanel.get("search");
    Button btSearch = new Button("Search");
    btSearch.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        searchDialogBox.show();
      }
    });
    search.add(btSearch);
  }


  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {

    searchDialogBox =new SearchDialogBox(s-> Window.alert("search"));

    initHeader();


    loginDialogBox = new LoginDialogBox((userName, password) -> {
      accountService.login(userName, password, new AsyncCallback<Boolean>() {
        @Override
        public void onFailure(Throwable throwable) {
//          LOG.log(Level.SEVERE, "Login failed");
        }

        @Override
        public void onSuccess(Boolean result) {
          if (result) {
            loginDialogBox.hide();
////            RootPanel.get().remove(loginDialogBox);
////            RootPanel.get().add(tabPanel); // If no ref - link to <body>
//            LOG.log(Level.SEVERE, messages.successfulLogin(userName));
          } else {
//            LOG.log(Level.SEVERE, "Login failed");
          }
        }
      });

    });


    RootPanel.get().add(loginDialogBox);
    loginDialogBox.show();
    loginDialogBox.center();



  }
}
