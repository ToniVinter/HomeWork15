package ro.fasttrackit.plannerApp;

import java.io.UncheckedIOException;

public class NoActivityException extends RuntimeException {
    public NoActivityException(String message){
        super(message);
    }

}
