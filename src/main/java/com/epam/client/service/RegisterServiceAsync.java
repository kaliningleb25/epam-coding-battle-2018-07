package com.epam.client.service;

import com.epam.shared.model.User;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

public interface RegisterServiceAsync {
    void register(User user, AsyncCallback<Void> async);
}
