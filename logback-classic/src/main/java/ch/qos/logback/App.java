package ch.qos.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class App {

private static final Logger log = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        log.info("Hello, ");
        log.error("world !");
        log.warn("world depuis warn!");
    }
}