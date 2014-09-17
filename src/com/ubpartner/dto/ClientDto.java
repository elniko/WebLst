package com.ubpartner.dto;

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



public class ClientDto implements Serializable{
  
 
  private int id;
  
  private String client;
  
  private String user;
  
 
  private Date createdAt = new Date();


  private Set<GuidDto> guidList;
  
  
public ClientDto(String cli, String us) {
	client = cli;
	user = us;
};
  
  public ClientDto(){}

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
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

@Column(name="created_at")
public Date getCreatedAt() {
	return createdAt;
}
@Temporal(TemporalType.TIMESTAMP)
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
public Set<GuidDto> getGuidList() {
	return guidList;
}


public void setGuidList(Set<GuidDto> guidList) {
	this.guidList = guidList;
}


  
}
