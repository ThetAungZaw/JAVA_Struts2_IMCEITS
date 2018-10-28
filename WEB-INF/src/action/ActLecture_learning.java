
package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.*;
import java.io.*;
import java.util.*;
import service.*;

public class ActLecture_learning extends ActionSupport {

	private Lecture lecture;
	private List<Lecture> lecture_list;

	private Language language;
	private List<Language> language_list_user;

	private Section section;
	private List<Section> section_list;
	
	private int CurrentSectionID;
	
	

	
	public int getCurrentSectionID() {
		return CurrentSectionID;
	}

	public void setCurrentSectionID(int currentSectionID) {
		CurrentSectionID = currentSectionID;
	}

	public List<Lecture> getLecture_list() {
		return lecture_list;	
	}

	public void setLecture_list(List<Lecture> lecture_list) {
		this.lecture_list = lecture_list;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}



	public List<Language> getLanguage_list_user() {
		return language_list_user;
	}

	public void setLanguage_list_user(List<Language> language_list_user) {
		this.language_list_user = language_list_user;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public List<Section> getSection_list() {
		return section_list;
	}

	public void setSection_list(List<Section> section_list) {
		this.section_list = section_list;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	private void FunGetDataList() {
		
		DBLanguage dbLanguage = new DBLanguage();
		language_list_user = dbLanguage.FunRetrieve();

		DBSection dbSection = new DBSection();
		section_list = dbSection.FunRetrieve(language.getLanguageID());

		
		
		DBLecture dbLecture = new DBLecture();		
		if (section == null && section_list != null) 
		{	
			section = section_list.get(0);	 
		}
		if(section != null)//language never be a null but section might be null for first time//
		{
			lecture_list = dbLecture.FunRetrieve(language.getLanguageID(),section.getSectionID());
			CurrentSectionID = section.getSectionID();
		}
			System.err.println("////////////" +CurrentSectionID);

	}
	
	

	public String execute() {
		FunGetDataList();
		
		return SUCCESS;
	}

	// public void validate()
	// {
	// /*if(lecture != null)
	// {
	// if(lecture.getLectureTitle().equals(""))
	// addFieldError("lecture.LectureTitle","Define lecture title....!");
	// }*/
	// }

}
