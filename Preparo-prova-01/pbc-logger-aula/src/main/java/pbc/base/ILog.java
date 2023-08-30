package pbc.base;

import pbc.exception.LoggerException;

import java.io.IOException;

public interface ILog {

    void setSource(String source) throws LoggerException; // Quem é a origem

    void log(String message) throws LoggerException; // Log por mensagem de texto

    void log(Throwable throwable) throws LoggerException; // Mensagem de exceção

}
