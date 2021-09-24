package br.edu.infnet.venturaHR_web.model.domain;

import java.util.List;

public class Erro {
    private String timestamp;
    private int status;
    private String error;
    private String trace;
    private String message;
    private String path;
    private List<ErroValidacao> errors;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ErroValidacao> getErrors() {
        return errors;
    }

    public void setErrors(List<ErroValidacao> errors) {
        this.errors = errors;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
