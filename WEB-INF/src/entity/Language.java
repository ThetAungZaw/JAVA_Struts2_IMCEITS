package entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.*;
import java.util.*;
@Entity
@Table (name="tLanguage")

public class Language implements Serializable{
	
	@Id
	@GeneratedValue
	private int LanguageID;
	private String LanguageName;
	private String LogoName;
	private boolean CanTest;
	//it also effect//
//	@Column(name = "CanTest", columnDefinition="BIT DEFAULT 0", nullable = false)
//	private Boolean CanTest = false;
	
//	@Column(name = "CanTest", columnDefinition="BIT DEFAULT 0", nullable = false)
//	private boolean CanTest = false;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "language")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Lecture> lecture = new HashSet<Lecture>();
	
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "language")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Question> question = new HashSet<Question>();

	public int getLanguageID() {
		return LanguageID;
	}

	public void setLanguageID(int languageID) {
		LanguageID = languageID;
	}

	public String getLanguageName() {
		return LanguageName;
	}

	public void setLanguageName(String languageName) {
		LanguageName = languageName;
	}

	

	public String getLogoName() {
		return LogoName;
	}

	public void setLogoName(String logoName) {
		LogoName = logoName;
	}

	public boolean isCanTest() {
		return CanTest;
	}

	public void setCanTest(boolean canTest) {
		CanTest = canTest;
	}

	public Set<Lecture> getLecture() {
		return lecture;
	}

	public void setLecture(Set<Lecture> lecture) {
		this.lecture = lecture;
	}

	public Set<Question> getQuestion() {
		return question;
	}

	public void setQuestion(Set<Question> question) {
		this.question = question;
	}	
	

   	
	
}

