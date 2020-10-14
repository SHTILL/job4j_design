package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");

        boolean boolVar = true;
        char    charVar = 'c';
        byte    byteVar = 17;
        short   shortVar  = 1024;
        int     intVar    = 65800;
        long    longVar   = 123456789;
        float   floatVar  = 168.78f;
        double  doubleVar = 169.78;
        LOG.debug("Variables are: {} {} {} {} {} {} {} {}", boolVar, charVar, byteVar, shortVar, intVar, longVar, floatVar, doubleVar);
    }
}