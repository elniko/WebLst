package com.ubpartner.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="clients")
@XmlRootElement
public class Client implements Serializable{
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  
  private String client;
  
  private String user;
  
  @Column(name="created_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt = new Date();

  @OneToMany(mappedBy="client", fetch=FetchType.LAZY)
  private Set<Guid> guidList;
  
  
public Client(String cli, String us) {
	client = cli;
	user = us;
};
  
  public Client(){}

@XmlElement
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getClient() {
	return client;
}
public void setClient(String client) {
	this.client = client;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}


public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}


public Set<Guid> getGuidList() {
	return guidList;
}


public void setGuidList(Set<Guid> guidList) {
	this.guidList = guidList;
}


  
}
