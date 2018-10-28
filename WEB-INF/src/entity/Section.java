package entity;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.*;
import java.util.*;
@Entity
@Table (name="tSection")

public class Section implements Serializable{
	
	@Id
	@GeneratedValue
	private int SectionID;
	private String SectionName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "section")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Set<Lecture> lecture = new HashSet<Lecture>();

	public int getSectionID() {
		return SectionID;
	}

	public void setSectionID(int sectionID) {
		SectionID = sectionID;
	}

	public String getSectionName() {
		return SectionName;
	}

	public void setSectionName(String sectionName) {
		SectionName = sectionName;
	}

	public Set<Lecture> getLecture() {
		return lecture;
	}

	public void setLecture(Set<Lecture> lecture) {
		this.lecture = lecture;
	}

	
}

