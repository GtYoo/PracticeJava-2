package com.sprMbts.customer;

import org.springframework.ui.Model;

public interface ICustService {
	
	String selectAll(Model model, String pageNo) throws Exception;
	
	String selectOne(Model model, String pageNo, String code) throws Exception;
	
	String insertCst(Cst cst) throws Exception;
	
	String updateCst(Cst cst, String pageNo) throws Exception;
	
	String deleteCst(String code) throws Exception;
}
