package com.epam.client;

import com.epam.client.service.GreetingService;
import com.epam.client.service.GreetingServiceAsync;
import com.epam.client.service.RegisterService;
import com.epam.client.service.RegisterServiceAsync;
import com.epam.client.widgets.LoginDialogBox;
import com.epam.client.widgets.RegisterDialogBox;
import com.epam.client.widgets.SearchDialogBox;
import com.epam.server.services.UserService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
@Component
public class CoddingBattle implements EntryPoint {

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync accountService = GWT.create(GreetingService.class);

  private final RegisterServiceAsync registerService = GWT.create(RegisterService.class);

  private LoginDialogBox loginDialogBox;
  private SearchDialogBox searchDialogBox;
  private RegisterDialogBox registerDialogBox;

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
    registerDialogBox = new RegisterDialogBox(user -> {
      registerService.register(user, new AsyncCallback<Void>() {
        @Override
        public void onFailure(Throwable caught) {
          Window.alert("can't register");
        }

        @Override
        public void onSuccess(Void result) {
          registerDialogBox.hide();
        }
      });
    });

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
            Window.alert("failed to login");

          }
        }
      });

    }, registerDialogBox);


    RootPanel.get().add(loginDialogBox);
    loginDialogBox.show();
    loginDialogBox.center();



  }
}
