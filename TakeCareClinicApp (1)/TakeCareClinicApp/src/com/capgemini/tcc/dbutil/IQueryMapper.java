package com.capgemini.tcc.dbutil;

public interface IQueryMapper {
	public final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	public final String USERNAME="system";
	public final String PASSWORD="admin";
	
	public final String PATIENT_INSERT_QUERY="INSERT INTO PATIENT VALUES(SEQ_PID.NEXTVAL,?,?,?,?,SYSDATE)";
	public final String PATIENT_ID_QUERY_SEQUENCE="SELECT SEQ_PID.CURRVAL FROM DUAL";
	public final String PATIENT_SELECTBYID_QUERY="SELECT * FROM PATIENT WHERE PID=?";
	
}
