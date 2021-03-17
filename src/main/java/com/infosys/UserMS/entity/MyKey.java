package com.infosys.UserMS.entity;

import java.io.Serializable;

public class MyKey implements Serializable{


	    private Integer BUYERID;

	    private Integer PRODID;

		public Integer getBUYERID() {
			return BUYERID;
		}

		public void setBUYERID(Integer bUYERID) {
			this.BUYERID = bUYERID;
		}

		public Integer getPRODID() {
			return PRODID;
		}

		public void setPRODID(Integer pRODID) {
			PRODID = pRODID;
		}

		


}
