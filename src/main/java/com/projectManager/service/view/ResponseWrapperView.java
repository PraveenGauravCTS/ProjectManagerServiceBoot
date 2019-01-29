package com.projectManager.service.view;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projectManager.service.view.BaseView;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWrapperView<T extends BaseView> {

    private T                 itsResponse = null;
    private String            itsStatus = null;
    private List<MessageView> itsMessages = null;

    public T getResponse() {
        return itsResponse;
    }

    public void setResponse(final T inResponse) {
        itsResponse = inResponse;
        setStatus("Success");
    }

    public String getStatus() {
        return itsStatus;
    }

    public void setStatus(final String inStatus) {
        itsStatus = inStatus;
    }

    public List<MessageView> getMessages() {
        return itsMessages;
    }

    public void setMessages(final List<MessageView> inMessages) {
        itsMessages = inMessages;
    }

}
