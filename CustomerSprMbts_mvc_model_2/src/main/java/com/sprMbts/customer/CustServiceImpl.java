package com.sprMbts.customer;

import java.util.HashMap;
import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Service("custService")
public class CustServiceImpl implements ICustService {
	
	@Autowired
	private IDaoCst daoCst;
	
	@Autowired
	private IDaoHist daoHist;
	
	//리스트에서 보여줄 건수 설정
	final int MAX_ROWS = 5;
	
	private static final Logger logger = LoggerFactory.getLogger(CustServiceImpl.class);
	
	//전체조회
	@Override
	public String selectAll(Model model, String pageNo) throws Exception {
		
		logger.info("SelectAll Cst called =============");
		
		int nPageNo = 0;
		int cnt 	= 0;
		
		if(pageNo == null)
		{
			nPageNo = 1;
		}
		else
		{
			nPageNo = Integer.parseInt(pageNo);
		}
		
		cnt = daoCst.cstCnt();
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("PAGE_NO", (nPageNo - 1) * MAX_ROWS + 1);
		hm.put("MAX_ROWS", MAX_ROWS + 1);
		
		List<Cst> list = daoCst.getAllUser(hm);
		
		int pageCnt 	= cnt / MAX_ROWS + (cnt % MAX_ROWS == 0 ? 0 : 1);
		int startPage 	= 1;
		
		if(nPageNo % 5 != 0)
		{
			startPage = (int)(nPageNo / 5) * 5 + 1;
		}
		else
		{
			startPage = ((int)(nPageNo / 5) - 1) * 5 + 1;
		}
		
		int pageBlock 	= 10;
		int endPage 	= startPage + pageBlock - 1;
		
		if(endPage > pageCnt)
		{
			endPage = pageCnt;
		}
		
		model.addAttribute("LIST", list);
		model.addAttribute("STARTPAGE", startPage);
		model.addAttribute("ENDPAGE", endPage);
		model.addAttribute("PAGE_NO", nPageNo);
		model.addAttribute("PAGECOUNT", pageCnt);
		model.addAttribute("COUNT", cnt);
		

		return "cstView";
	}
	
	//단건조회
	@Override
	public String selectOne(Model model, String pageNo, String code) throws Exception {
		
		logger.info("SeleceOne Cst called =============");
		
		int nPageNo = Integer.parseInt(pageNo);
		int nCode 	= Integer.parseInt(code);
		
		Cst cstDto = daoCst.getUser(nCode);
		
		model.addAttribute("PAGE_NO", nPageNo);
		model.addAttribute("CST", cstDto);
		
		return "cstViewInfoSearch";
	}
	
	//등록
	@Override
	@Transactional
	public String insertCst(Cst cst) throws Exception {
		
		logger.info("Insert Cst called =============");
		logger.info("입력한 CODE : {}"		, cst.getCode());
		logger.info("입력한 NAME : {}"		, cst.getName());
		logger.info("입력한 EMAIL : {}"	, cst.getEmail());
		logger.info("입력한 TEL : {}"		, cst.getTel());
		logger.info("입력한 WEIGHR : {}"	, cst.getWeight());
		
		Cst cstDto = daoCst.getUser(cst.getCode());
		
		if(cstDto != null)
		{
			throw new Exception();
		}
		
		daoCst.insertUser(cst);
		daoHist.insertHist("Insert " + cst.toString());
		
		return "redirect:/sltMul?PAGE_NO=1";
	}
	
	//수정
	@Override
	@Transactional
	public String updateCst(Cst cst, String pageNo) throws Exception {
		
		logger.info("Update Cst called =============");
		logger.info("입력한 CODE : {}"		, cst.getCode());
		logger.info("입력한 NAME : {}"		, cst.getName());
		logger.info("입력한 EMAIL : {}"	, cst.getEmail());
		logger.info("입력한 TEL : {}"		, cst.getTel());
		logger.info("입력한 WEIGHR : {}"	, cst.getWeight());
		
		Cst cstDto = daoCst.getUser(cst.getCode());
		
		if(cstDto == null)
		{
			throw new Exception();
		}
		
		daoCst.updateUser(cst);
		daoHist.insertHist("Update " + cst.toString());
		
		return "redirect:/sltMul?PAGE_NO=" + pageNo;
	}
	
	//삭제
	@Override
	@Transactional
	public String deleteCst(String code) throws Exception {
		
		logger.info("Delete Cst called =============");
		logger.info("입력한 CODE : {}" , code);
		
		int nCode = Integer.parseInt(code);
		
		Cst cstDto = daoCst.getUser(nCode);
		
		if(cstDto == null)
		{
			throw new Exception();
		}
		
		daoCst.deleteUser(nCode);
		daoHist.insertHist("Delete " + cstDto.toString());
		
		return "redirect:/sltMul?PAGE_NO=1";
	}
}
