package dao;

import java.sql.*;
import java.util.*;
import beans.*;

public class GenericDAO{
	protected Connection con_;

	public GenericDAO(){
		this(null);
	}
	
	public GenericDAO(Connection con) {
		this.con_ = con;
	}
}
