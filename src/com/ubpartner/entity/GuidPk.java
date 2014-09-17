package com.ubpartner.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;



@Embeddable
	public class GuidPk implements Serializable {
		
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