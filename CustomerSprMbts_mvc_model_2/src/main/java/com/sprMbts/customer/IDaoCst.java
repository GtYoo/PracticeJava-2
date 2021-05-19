package com.sprMbts.customer;

import java.util.HashMap;
import java.util.List;

public interface IDaoCst {
	
	Cst getUser(int code);
	
	List<Cst> getAllUser(HashMap<String, Object> hm);
	
	void insertUser(Cst cst);
	
	void updateUser(Cst cst);
	
	void deleteUser(int code);
	
	int cstCnt();
}
