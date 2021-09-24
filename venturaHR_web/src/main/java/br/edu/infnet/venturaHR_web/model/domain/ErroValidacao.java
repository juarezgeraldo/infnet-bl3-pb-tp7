package br.edu.infnet.venturaHR_web.model.domain;

import java.util.List;

public class ErroValidacao {
    private List<String> codes;
    private List<Argument> arguments;
    private String defaultMessage;
    private String objectName;
    private String field;
    private String rejectedValue;
    private boolean bindingFailure;
    private String code;

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public List<String> getCodes() {
        return codes;
    }

    public void setCodes(List<String> codes) {
        this.codes = codes;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(String rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public boolean isBindingFailure() {
        return bindingFailure;
    }

    public void setBindingFailure(boolean bindingFailure) {
        this.bindingFailure = bindingFailure;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
