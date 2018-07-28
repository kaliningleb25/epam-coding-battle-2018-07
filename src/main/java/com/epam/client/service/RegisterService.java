package com.epam.client.service;

import com.epam.shared.model.User;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("register")
public interface RegisterService extends RemoteService {
    void register(User user);
}
