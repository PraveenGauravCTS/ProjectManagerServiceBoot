package com.projectManager.service.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.projectManager.service.constant.ServiceConstant;
import com.projectManager.service.view.BaseView;
import com.projectManager.service.view.MessageView;
import com.projectManager.service.view.ResponseWrapperView;
@CrossOrigin
public class BaseService {

	@Autowired
	protected Environment itsProperties;

	/**
	 * get Success Message
	 * 
	 * @param inMessage
	 * @return ResponseWrapperView<BaseView>
	 */
	public ResponseWrapperView<BaseView> getSuccessMessage(final String inMessage) {
		final ResponseWrapperView<BaseView> theSuccessResponse = new ResponseWrapperView<BaseView>();
		final MessageView theMessageBO = new MessageView();
		final List<MessageView> theMessageList = new ArrayList<>();
		theMessageBO.setMessageID("WO0001S");
		theMessageBO.setMessageType("INFO");
		theMessageBO.setMessageDetail(inMessage);
		theMessageList.add(theMessageBO);
		theSuccessResponse.setStatus("Success");
		theSuccessResponse.setMessages(theMessageList);
		return theSuccessResponse;

	}

	/**
	 * get Failure Message
	 * 
	 * @param inMessage
	 * @return ResponseWrapperView<BaseView>
	 */
	public ResponseWrapperView<BaseView> getFailureMessage(final String inFailureMessageKey) {
		final ResponseWrapperView<BaseView> theFailedResponse = new ResponseWrapperView<BaseView>();
		final MessageView theMessageBO = new MessageView();
		final List<MessageView> theMessageList = new ArrayList<>();
		if (itsProperties != null) {
			theMessageBO.setMessageID(itsProperties.getProperty(inFailureMessageKey));
			theMessageBO
					.setMessageType(itsProperties.getProperty(inFailureMessageKey + ServiceConstant.PROP_TYPE_SUFFIX));
			theMessageBO.setMessageDetail(
					itsProperties.getProperty(inFailureMessageKey + ServiceConstant.PROP_DETAILS_SUFFIX));
		} else {
			theMessageBO.setMessageID("WO0001E");
			theMessageBO.setMessageType("ERROR");
			theMessageBO.setMessageDetail("We are having some temporary delay. Please try after Some time.");
			System.out.println(theMessageBO.getMessageID() + "  " + theMessageBO.getMessageType() + "  "
					+ theMessageBO.getMessageDetail());
		}
		theMessageList.add(theMessageBO);
		theFailedResponse.setStatus("Failure");
		theFailedResponse.setMessages(theMessageList);
		return theFailedResponse;

	}

}
