package com.projectManager.service.exception;


import java.util.List;

import com.projectManager.service.view.MessageView;

/**
 * ApplicationException is application level custom exception.
 * This is used to handle different negative scenarios across application.
 */
public class ServiceApplicationException extends RuntimeException {

    private static final long         serialVersionUID       = 7303744796795747314L;
    private String                    itsMessageKey          = null;
    private transient List<String>    itsErrorDetails        = null;
    private transient List<MessageView> itsMessages            = null;

    public ServiceApplicationException(final String inMessageKey) {
        super(inMessageKey);
        this.itsMessageKey = inMessageKey;
    }

    public ServiceApplicationException(final String inMessageKey, final List<String> inErrorDetails) {
        super(inMessageKey);
        this.itsErrorDetails = inErrorDetails;
        this.itsMessageKey = inMessageKey;
    }

    public ServiceApplicationException(final Exception inException, final String inMessageKey) {
        super(inException);
        this.itsMessageKey = inMessageKey;
    }

    public ServiceApplicationException(final Throwable inCause) {
        super(null, inCause);
        this.itsMessageKey = inCause.getLocalizedMessage();
    }

    public String getMessageKey() {
        return itsMessageKey;
    }

    public void setMessageKey(final String inMessageKey) {
        itsMessageKey = inMessageKey;
    }

    public List<String> getErrorDetails() {
        return itsErrorDetails;
    }

    public void setErrorDetails(final List<String> inErrorDetails) {
        itsErrorDetails = inErrorDetails;
    }

    public List<MessageView> getMessages() {
        return itsMessages;
    }

	public void setMessages(final List<MessageView> inMessages) {
        itsMessages = inMessages;
    }

}
