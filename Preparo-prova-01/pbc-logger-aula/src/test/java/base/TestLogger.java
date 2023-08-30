package base;

import pbc.base.Logger;
import pbc.exception.LoggerException;

public class TestLogger {

    public static void main(String[] args) throws LoggerException {

        Logger logger = new Logger();

        logger.setSource("validation");

        logger.log("testando o log...");

        logger.log(new Exception("Exception 01"));
    }

}
