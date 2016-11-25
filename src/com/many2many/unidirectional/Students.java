package com.many2many.unidirectional;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Students {
	@Id
	@Column(name = "stud_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_cources", joinColumns = { @JoinColumn(name = "sc_stud_id") }, inverseJoinColumns = {
			@JoinColumn(name = "sc_cource_id") })
	private Set<Courses> cources;

	public Students() {
	}

	public Students(String name, Set<Courses> cources) {
		super();
		this.name = name;
		this.cources = cources;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Courses> getCources() {
		return cources;
	}

	public void setCources(Set<Courses> cources) {
		this.cources = cources;
	}

}
