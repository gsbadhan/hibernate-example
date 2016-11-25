package com.one2one.bidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "student_info")
public class StudentInfo {

	// use student.id value in student_info.id
	@Id
	@GeneratedValue(generator = "studTableFrgnKey")
	@GenericGenerator(name = "studTableFrgnKey", strategy = "foreign", parameters = {
			@Parameter(value = "student", name = "property") })
	@Column(name = "stud_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "class")
	private String studClass;

	@Column(name = "section")
	private String section;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "stud_id")
	private Student student;
	
	public StudentInfo() {
	}

	public StudentInfo(String studClass, String section, Student student) {
		super();
		this.studClass = studClass;
		this.section = section;
		this.student = student;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudClass() {
		return studClass;
	}

	public void setStudClass(String studClass) {
		this.studClass = studClass;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentInfo other = (StudentInfo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
