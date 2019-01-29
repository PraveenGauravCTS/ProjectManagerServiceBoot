package com.projectManager.service.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

@Api
@ApiModel(value="errorResponse")
@JsonInclude(content = Include.NON_EMPTY)
public class MessageView {

    private String              itsMessageID = null;
    private String              itsMessageType = null;
    private String              itsMessageDetail = null;


    public MessageView() {}

    public String getMessageID() {
        return itsMessageID;
    }

    public void setMessageID(final String inMessageID) {
        itsMessageID = inMessageID;
    }

    public String getMessageType() {
        return itsMessageType;
    }

    public void setMessageType(final String inMessageType) {
        itsMessageType = inMessageType;
    }

    public String getMessageDetail() {
        return itsMessageDetail;
    }

    public void setMessageDetail(final String inMessageDetail) {
        itsMessageDetail = inMessageDetail;
    }

}
