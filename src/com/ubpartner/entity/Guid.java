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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@Entity
@Table(name="guids")
@XmlRootElement
public class Guid implements Serializable{
	
	
	
	public String signature;
	
	@Column(name="start_date")
	String startDate;
	
	@Column(name="end_date")
	String endDate;
	
	@Column(name="xvt")
	Boolean withXvt;
	
	int activations;
	
	Boolean cheating;
	
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	Date createdAt = new Date();
	
	String api;
	
	@Column(name="old_guid")
	String oldGuid;
	
	Boolean isNew;
	
	@Column(name="end_xvt_date")
	String endXvt;
	
	
     @EmbeddedId
	GuidPk primaryKey = new GuidPk();
	
  @Column
  String period;
  
  @Column (name ="period_xvt")
  String periodXvt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client_id")
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
	
	@XmlValue
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
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
	public Date getCreatedAt() {
		return createdAt;
	}
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
	
	
	
	
	


	public GuidPk getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(GuidPk primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getPeriodXvt() {
		return periodXvt;
	}

	public void setPeriodXvt(String periodXvt) {
		this.periodXvt = periodXvt;
	}




	@Embeddable
	public static class GuidPk implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		
		private  String guid = null;
		
		
		private  String  product = null;
		
		private  String version = null;
		
		public  GuidPk(){}
		
		public  GuidPk(String g, String t, String v) {
			guid = g;
			product = t;
			version = v;
		}

		public String getGuid() {
			return guid;
		}

		public void setGuid(String guid) {
			this.guid = guid;
		}

		
		public String getProduct() {
			return product;
		}

		public void setProduct(String product) {
			this.product = product;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
		 /**
	     * (non-Javadoc)
	     *
	     * @see java.lang.Object#hashCode()
	     */
	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((product == null) ? 0 : product.hashCode());
	        result = prime * result + ((version == null) ? 0 : version.hashCode());
	        result = prime * result + ((guid == null) ? 0 : guid.hashCode());
	        return result;
	    }
	     
	    /**
	     * (non-Javadoc)
	     *
	     * @see java.lang.Object#equals(java.lang.Object)
	     */
	    @Override
	    public boolean equals(Object obj) {
	    	
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (!(obj instanceof GuidPk)) {
	            return false;
	        }
	        
	        GuidPk other = (GuidPk) obj;
	        
	        if (!guid.equals(other.guid)) {
	            return false;
	        }
	       
	     
	        if (!product.equals(other.product)) {
	            return false;
	        }
	        if (!version.equals(other.version)) {
	            return false;
	        }
	        
	        return true;
	    }

	}

	
	
	
}


	
	
	
