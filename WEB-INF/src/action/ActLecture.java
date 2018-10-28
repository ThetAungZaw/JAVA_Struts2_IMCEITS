
package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.*;
import sun.launcher.resources.launcher;

public class ActLecture extends ActionSupport{
	
	private Lecture lecture;
	private List<Lecture> list;
	
	private List<Language> language_list;
	private List<Section> section_list;

	private Language language ;
	private Section section;
	
	private Integer LectureID;
	
	
	
	

	public Integer getLectureID() {
		return LectureID;
	}

	public void setLectureID(Integer lectureID) {
		LectureID = lectureID;
	}



	private Date date;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	
	public List<Lecture> getList() {
		return list;
	}

	public void setList(List<Lecture> list) {
		this.list = list;
	}
	
	
	
	public String fill()
	{
		ServletActionContext.getServletContext().setAttribute("selectedLinkAdmin", "lecture");
		FunGetDataList();
		return SUCCESS;
	}
	
	

//	public String search()
//	{
//		System.out.println("Search");
//		DBLecture db = new DBLecture();
//		list = db.FunRetrieve( language.getLanguageID(), section.getSectionID(),lecture.getTitle());
//		FunFillLanguageAndSection();
//		return SUCCESS;
//	}
	
	public String search_lecture()
	{
		System.out.println("Search act new ");
		DBLecture db = new DBLecture();
		list = db.FunRetrieve(language.getLanguageID(), section.getSectionID(),lecture.getTitle());
		FunFillLanguageAndSectionForIndexPage();
		return SUCCESS;
	}
	
	private void FunFillLanguageAndSectionForIndexPage()
	{
		FunFillLanguageAndSection();
		
		//language for All//
		Language l = new Language();
		l.setLanguageID(-1);
		l.setLanguageName("All");
		language_list.add(l);
		
		//section for All//
		Section s = new Section();
		s.setSectionID(-1);
		s.setSectionName("All");
		section_list.add(s);
		
		System.err.println("language 2 42 " + language);
		if(language == null)
		{
			language = new Language();
			language.setLanguageID(-1);
		}
		
		System.err.println("section 2 42 "+ section);
		if(section == null)
		{
			section = new Section();
			section.setSectionID(-1);
		}
	}
	
	private void FunGetDataList()
	{
		if(lecture != null)lecture.setTitle("");
		System.out.println("Fill Method");
		DBLecture db = new DBLecture();
		System.out.println("Before FunRetrieve...");
		

		
		
		FunFillLanguageAndSectionForIndexPage();
		
		if(language ==null)
		{
			language = new Language();
			language.setLanguageID(-1);
		}
		
		if(section == null)
		{
			section = new Section();
			section.setSectionID(-1);
		}
		
		list = db.FunRetrieve(language.getLanguageID(), section.getSectionID());

		System.out.println("After FunRetrieve..."+list);
		
	}
	
	public String create()
	{
		System.out.println("start create");
		 
		//Date Format
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		   //get current date time with Date()
		  date = new Date();
		lecture.setCreateDate(dateFormat.format(date).toString());
		
		System.out.println("languageid"+language.getLanguageID());
		System.out.println("Language:"+language);
		System.out.println("secid"+section.getSectionID());
		System.out.println("sec:"+section);
		
		lecture.setLanguage(language);
		lecture.setSection(section);
		
		DBLecture db = new DBLecture();
		System.out.println("db ok");
		db.FunSave(lecture);
		
		FunGetDataList();
		return SUCCESS;
	}
	
	public String edit()
	{	
		
		System.out.println("start edit");
		DBLecture db = new DBLecture();
		System.out.println("db ok");
		db.FunUpdate(lecture);
		FunGetDataList();
		return SUCCESS;
	}
	
	public String delete()
	{
		System.err.println("lecture " + lecture);
		System.out.println("l name " + lecture.getTitle());
		DBLecture db = new DBLecture();
		db.FunDelete(lecture);
		FunGetDataList();
		return SUCCESS;
	}

	public String execute()
	{
		return SUCCESS;
	}
	
	public void validateEdit()
	{		
		if(language.getLanguageID() < 0)
		{
			addFieldError("language.LanguageID", "*");
		}
		
		if(section.getSectionID() < 0)
		{
			addFieldError("section.SectionID", "*");
		}
		
		FunFillLanguageAndSection();
	}
	
	
	public void validateCreate()
	{		
		if(language.getLanguageID() < 0)
		{
			addFieldError("language.LanguageID", "*");
		}
		
		if(section.getSectionID() < 0)
		{
			addFieldError("section.SectionID", "*");
		}
		
		FunFillLanguageAndSection();
	}
	
	
	public void FunFillLanguageAndSection()
	{
		DBLanguage dblanguage = new DBLanguage();
		language_list = dblanguage.FunRetrieve();
		
		DBSection dbsection = new DBSection();
		section_list = dbsection.FunRetrieve();		
	}
	
	public String create_preparation()
	{	
		FunFillLanguageAndSection();
		
		return SUCCESS;
	}
	
	public String edit_preparation()
	{	
		System.err.println("LectureID " + LectureID);
				
		DBLecture dbLec = new DBLecture();		
		lecture = dbLec.FunRetrieve(LectureID);
		
		System.err.println("lecture " + lecture);
		
		FunFillLanguageAndSection();
		return SUCCESS;
	}

	public List<Language> getLanguage_list() {
		return language_list;
	}

	public void setLanguage_list(List<Language> language_list) {
		this.language_list = language_list;
	}

	public List<Section> getSection_list() {
		return section_list;
	}

	public void setSection_list(List<Section> section_list) {
		this.section_list = section_list;
	}
	
	
}

