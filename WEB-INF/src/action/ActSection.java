		
package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import java.io.*;
import java.util.*;

import org.apache.struts2.ServletActionContext;

import service.*;

public class ActSection extends ActionSupport{
	
	private Section section;
	private List<Section> list;
	
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	public List<Section> getList() {
		return list;
	}

	public void setList(List<Section> list) {
		this.list = list;
	}
	
	public String fill()
	{
		ServletActionContext.getServletContext().setAttribute("selectedLinkAdmin", "section");
		FunGetDataList();
		return SUCCESS;
	}
	
	public String search()
	{
		
		System.out.println("section obj : " + section);
		System.out.println("section name : " + section.getSectionName());
		
		System.out.println("Search");
		DBSection db = new DBSection();
		
		list = db.FunRetrieve(section.getSectionName());
		
		return SUCCESS;
	}
	
	private void FunGetDataList()
	{
		if(section != null)section.setSectionName("");		
		System.out.println("Fill Method");
		DBSection db = new DBSection();
		list = db.FunRetrieve();
		System.out.println(list);
	}
	
	public String create()
	{
		DBSection db = new DBSection();
		db.FunSave(section);
		FunGetDataList();
		return SUCCESS;
	}
	
	public String edit()
	{		
		DBSection db = new DBSection();
		db.FunUpdate(section);
		FunGetDataList();
		return SUCCESS;
	}
	
	public String delete()
	{
		System.out.println("l name " + section.getSectionName());
		DBSection db = new DBSection();
		db.FunDelete(section);
		FunGetDataList();
		return SUCCESS;
	}

	public String execute()
	{
		return SUCCESS;
	}
	
//	public void validate()
//	{
//		/*if(section != null)
//			{
//				if(section.getSectionName().equals(""))
//					addFieldError("section.SectionName","Define section name....!");	
//			}*/
//	}
		
}

