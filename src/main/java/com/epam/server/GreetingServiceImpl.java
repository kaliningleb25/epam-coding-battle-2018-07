package com.epam.server;

import com.epam.client.service.GreetingService;
import com.epam.server.services.UserService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The server-side implementation of the RPC service.
 */
@Component
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
        GreetingService {
    @Autowired
    UserService userService;

    private final Map<String, String> users = new HashMap<String, String>() {{
        put("admin", "123");
        put("vasya", "321");
    }};

    @Override
    public boolean login(String userName, String password) {

        return userService.checkPassword(userName,password);

    }
}
