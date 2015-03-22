package net.www.protocol.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by nick on 21/03/15.
 */
public class TestURLConnection extends URLConnection {


    public TestURLConnection(URL url) {
        super(url);
    }

    @Override
    public void connect() throws IOException {

    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        return super.getOutputStream();
    }


}
