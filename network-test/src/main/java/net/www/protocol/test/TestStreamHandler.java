package net.www.protocol.test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * Created by nick on 21/03/15.
 */
public class TestStreamHandler extends URLStreamHandler {
    @Override
    protected URLConnection openConnection(final URL u) throws IOException {
        return new TestURLConnection(u);
    }
}
