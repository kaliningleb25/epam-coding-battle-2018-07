package com.epam.server;

import com.epam.client.service.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
        GreetingService {

    private final Map<String, String> users = new HashMap<String, String>() {{
        put("admin", "123");
        put("vasya", "321");
    }};

    @Override
    public boolean login(String userName, String password) {
        return Optional.ofNullable(users.get(userName))
                .filter(password::equals)
                .isPresent();
    }
}
