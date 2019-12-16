package com.example.mtgcardsearcher.exception;

import com.example.mtgcardsearcher.model.MTGAPI;

import java.io.IOException;

/**
 * Thrown by {@link MTGAPI} when an http request to magicthegathering.io API fails to return anything.
 *
 * @author nniklas
 *
 */
public class HttpRequestFailedException extends RuntimeException {

    public HttpRequestFailedException(IOException e) {
        super(e);
    }

}