package com.ubpartner.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@Entity
@Table(name="guids")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Guid implements Serializable{
	
	
	
	String signature;
	
	
	String startDate;
	
	
	String endDate;
	

	Boolean withXvt;
	
	int activations;
	
	Boolean cheating;
	
	
	Date createdAt = new Date();
	
	String api;
	
	
	String oldGuid;
	
	Boolean isNew;
	
	
	String endXvt;
	
	
     //@EmbeddedId
	GuidPk primaryKey = new GuidPk();
	
  
  String period;
  
  
  String periodXvt;
	
	
	Client client;
	
	public Guid(){}
	
	public Guid(GuidPk pk, int clId, String sig, String sDate, String eDate, boolean xvt, int activ, boolean cheat, String apiTools, String oGuid, boolean isn ,String xvtDate, String nPeriod, String xvtPeriod ) {
		
		
		signature = sig;
		startDate = sDate;
		endDate = eDate;
		withXvt = xvt;
		activations = activ;
		cheating = cheat;
		api = apiTools;
		oldGuid = oGuid;
		isNew = isn;
		endXvt = xvtDate;
		primaryKey = pk;
		period = nPeriod;
		periodXvt = xvtPeriod;
		//guid = pk.getGuid();
		//product = pk.getProduct();
		//version = pk.getVersion();
	}
	
@XmlElement
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	@Column(name="start_date")
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	@Column(name="end_date")
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Column(name="xvt")
	public Boolean getWithXvt() {
		return withXvt;
	}
	public void setWithXvt(Boolean withXvt) {
		this.withXvt = withXvt;
	}
	public int getActivations() {
		return activations;
	}
	public void setActivations(int activations) {
		this.activations = activations;
	}
	public Boolean getCheating() {
		return cheating;
	}
	public void setCheating(Boolean cheating) {
		this.cheating = cheating;
	}
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedAt() {
		return createdAt;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getOldGuid() {
		return oldGuid;
	}
	public void setOldGuid(String oldGuid) {
		this.oldGuid = oldGuid;
	}
	public Boolean getIsNew() {
		return isNew;
	}
	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}
	@Column(name="end_xvt_date")
	public String getEndXvt() {
		return endXvt;
	}
	public void setEndXvt(String endXvt) {
		this.endXvt = endXvt;
	}
//	public int getClientId() {
//		return clientId;
//	}
//	public void setClientId(int clientId) {
//		this.clientId = clientId;
//	}
	
	
	
	
	

    @EmbeddedId
	public GuidPk getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(GuidPk primaryKey) {
		this.primaryKey = primaryKey;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client_id")
	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	
	@Column
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	@Column (name ="period_xvt")
	public String getPeriodXvt() {
		return periodXvt;
	}

	public void setPeriodXvt(String periodXvt) {
		this.periodXvt = periodXvt;
	}




	

	
	
	
}


	
	
	
