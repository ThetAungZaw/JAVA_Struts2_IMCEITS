package entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import java.io.*;
import java.util.Date;
@Entity
@Table (name="tLecture")

public class Lecture implements Serializable{
	
	@Id
	@GeneratedValue
	private int LectureID;
	private String Title;
	private String DetailDescription;
	private String SampleCode;
	private String CreateDate;
	private String SortAlphabet;
	private boolean TryYourSelf;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LanguageID", nullable = false)
	private Language language;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SectionID", nullable = false)
	private Section section;

	public int getLectureID() {
		return LectureID;
	}

	public void setLectureID(int lectureID) {
		LectureID = lectureID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDetailDescription() {
		return DetailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		DetailDescription = detailDescription;
	}

	public String getSampleCode() {
		return SampleCode;
	}

	public void setSampleCode(String sampleCode) {
		SampleCode = sampleCode;
	}

	

	public String getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(String createDate) {
		CreateDate = createDate;
	}

	public String getSortAlphabet() {
		return SortAlphabet;
	}

	public void setSortAlphabet(String sortAlphabet) {
		SortAlphabet = sortAlphabet;
	}

	public boolean isTryYourSelf() {
		return TryYourSelf;
	}

	public void setTryYourSelf(boolean tryYourSelf) {
		TryYourSelf = tryYourSelf;
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

		
}

