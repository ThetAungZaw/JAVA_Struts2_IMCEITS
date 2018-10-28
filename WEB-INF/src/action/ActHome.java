package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.struts2.ServletActionContext;

import service.*;

public class ActHome extends ActionSupport{
	
	public String funHome()
	{
		ServletActionContext.getServletContext().setAttribute("selectedLink", "masterhome");
		return SUCCESS;
	}
	
	public String funInactive()
	{
		ServletActionContext.getServletContext().setAttribute("selectedLink", "Inactive");
		return SUCCESS;
	}
}

