package com.sprMbts.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustController {
	
	@Autowired
	private ICustService custService;
	
	private static final Logger logger = LoggerFactory.getLogger(CustController.class);
	
	@RequestMapping(value = "/")
	public String home() {
		
		logger.info("Home called ==============");
		return "redirect:/cstStart.jsp";
	}
	
	//전체리스트
	@RequestMapping("sltMul")
	public String main(Model model, @ModelAttribute("PAGE_NO") String pageNo) 
			throws Exception {
		
		logger.info("Select Mul ==============");
		return custService.selectAll(model, pageNo);
	}
	
	//단건조회
	@RequestMapping("sltOne")
	public String selectOne(Model model, @ModelAttribute("PAGE_NO") String pageNo, 
			@ModelAttribute("CODE") String code) throws Exception {
		
		logger.info("Select One ==============");
		return custService.selectOne(model, pageNo, code);
	}
	
	//등록페이지
	@RequestMapping("insertCstForm")
	public String insertCstForm() {
		
		logger.info("Insert Page ==============");
		return "cstInsertForm";
	}
	
	//등록
	@RequestMapping("insertCst")
	public String insertCst(Cst cst) throws Exception {
		
		logger.info("Insert Cst ==============");
		return custService.insertCst(cst);
	}
	
	//수정
	@RequestMapping("updateCst")
	public String updateCst(Cst cst, @ModelAttribute("PAGE_NO") String pageNo) 
			throws Exception {
		
		logger.info("Update Cst ==============");
		return custService.updateCst(cst, pageNo);
	}
	
	//삭제
	@RequestMapping("deleteCst")
	public String deleteCst(@ModelAttribute("CODE") String code) 
			throws Exception {
		
		logger.info("Delete Cst ==============");
		return custService.deleteCst(code);
	}

}
