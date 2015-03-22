package net.www.protocol.test;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/**
 * Created by nick on 21/03/15.
 */
public class TestURLStreamHandlerFactory implements URLStreamHandlerFactory {
    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        return new TestStreamHandler();
    }
}
