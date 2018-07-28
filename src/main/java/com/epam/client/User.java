package com.epam.client;

import com.google.gwt.core.client.JavaScriptObject;

// Overlay Type
public class User extends JavaScriptObject {

    protected User() {}

    public final native int getId()/*-{ return this.id; }-*/;
    public final native String getLogin()/*-{ return this.login; }-*/;
    public final native String getURL()/*-{ return this.url; }-*/;
    public final native String getType()/*-{ return this.type; }-*/;
}
