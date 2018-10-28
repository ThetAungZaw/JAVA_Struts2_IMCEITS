package action;

import com.opensymphony.xwork2.ActionSupport;

public class ActTryCode extends ActionSupport {

	private String SampleCode;

	
	public String getSampleCode() {
		return SampleCode;
	}


	public void setSampleCode(String sampleCode) {
		SampleCode = sampleCode;
	}


	public String execute() {
		return SUCCESS;
	}

}
