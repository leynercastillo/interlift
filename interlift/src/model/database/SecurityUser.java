package model.database;

// Generated 17-sep-2013 13:42:25 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * SecurityUser generated by hbm2java
 */
@Entity
@Table(name = "security_user", schema = "public")
public class SecurityUser implements java.io.Serializable {

	private static final long serialVersionUID = -2384110049643640951L;
	private int idSecurityUser;
	private String name;
	private String email;
	private String password;
	private String phone;
	private Boolean newFeature;
	private char status;
	private Set<Budget> budgets = new HashSet<Budget>(0);
	private Set<SecurityGroup> securityGroups = new HashSet<SecurityGroup>(0);
	private Set<Contact> contacts = new HashSet<Contact>(0);

	public SecurityUser() {
	}

	public SecurityUser(int idSecurityUser, String name, String email, String password, String phone, char status) {
		this.idSecurityUser = idSecurityUser;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.status = status;
	}

	public SecurityUser(int idSecurityUser, String name, String email, String password, String phone, Boolean newFeature, char status, Set<Budget> budgets, Set<SecurityGroup> securityGroups, Set<Contact> contacts) {
		this.idSecurityUser = idSecurityUser;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.newFeature = newFeature;
		this.status = status;
		this.budgets = budgets;
		this.securityGroups = securityGroups;
		this.contacts = contacts;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "security_user_seq")
	@SequenceGenerator(name = "security_user_seq", sequenceName = "security_user_id_security_user_seq")
	@Column(name = "id_security_user", unique = true, nullable = false)
	public int getIdSecurityUser() {
		return this.idSecurityUser;
	}

	public void setIdSecurityUser(int idSecurityUser) {
		this.idSecurityUser = idSecurityUser;
	}

	@Column(name = "name", nullable = false, length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "phone", nullable = false, length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "new_feature")
	public Boolean getNewFeature() {
		return this.newFeature;
	}

	public void setNewFeature(Boolean newFeature) {
		this.newFeature = newFeature;
	}

	@Column(name = "status", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "securityUser")
	public Set<Budget> getBudgets() {
		return this.budgets;
	}

	public void setBudgets(Set<Budget> budgets) {
		this.budgets = budgets;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "group_user", schema = "public", joinColumns = { @JoinColumn(name = "id_security_user", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_security_group", nullable = false, updatable = false) })
	public Set<SecurityGroup> getSecurityGroups() {
		return this.securityGroups;
	}

	public void setSecurityGroups(Set<SecurityGroup> securityGroups) {
		this.securityGroups = securityGroups;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "securityUser")
	public Set<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

}