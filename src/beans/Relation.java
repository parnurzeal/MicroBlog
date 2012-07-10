package beans;

import java.io.*;
import java.sql.*;

public class Relation implements Serializable {
	private int relationID_;
	private int ownerID_;
	private String ownerName_;
	private String message_;
	private Timestamp relateDate_;
	
	public Relation() {}

	public Relation(int relationID, int ownerID, String ownerName, String password,
						String message, Timestamp relateDate) {
		this.relationID_ = relationID;
		this.ownerID_ = ownerID;
		this.ownerName_ = ownerName;
		this.message_ = message;
		this.relateDate_ = relateDate;

	}

	public int getRelationID() {
		return relationID_;
	}

	public void setRelationID(int relationID) {
		this.relationID_ = relationID;
	}
	
	public int getOwnerID() {
		return ownerID_;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID_ = ownerID;
	}
	public String getOwnerName() {
		return ownerName_;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName_ = ownerName;
	}

	public String getMessage() {
		return message_;
	}

	public void setMessage(String message) {
		this.message_ = message;
	}

	public Timestamp getRelateDate() {
		return relateDate_;
	}

	public void setRelateDate(Timestamp relateDate) {
		this.relateDate_ = relateDate;
	}
}
