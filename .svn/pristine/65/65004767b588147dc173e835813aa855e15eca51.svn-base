package mngwserc.cs.csa.web;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.cs.csa.service.CSAJoinCnslService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 가입 상담관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: CSAJoinCnslController
 * @Description		: 가입 상담관리 위한 Controller
 * @author 허진영
 * @since 2016.02.04
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.02.04		허진영					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/customer-center/join-counseling")
public class CSAJoinCnslController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="cSAJoinCnslService")
    private CSAJoinCnslService cSAJoinCnslService;
	
	/**
	 * 가입 상담 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/index.do")
	public String selectJoinCnslList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");	
		
		if(!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 15)
		{
			emfMap.put("f", f);
			emfMap.put("q", q);
		}
		else
		{
			emfMap.put("f", "");
			emfMap.put("q", "");
		}
		
		try
		{
			EmfMap rtnMap = cSAJoinCnslService.selectJoinCnslList(emfMap);
			
			modelMap.addAttribute("rtnMap", rtnMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "mngwserc/cs/csa/CSAJoinCnslList.admin";
	}
	
	/**
	 * 가입 상담 상세를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/write.do")
	public String selectJoinCnsl(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			String prcsCd = emfMap.getString("prcsCd");
			
			EmfMap rtnMap = cSAJoinCnslService.selectJoinCnsl(emfMap);
			
			modelMap.addAttribute("sPrcsCd", prcsCd);
			modelMap.addAttribute("rtnMap", rtnMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}

		return "mngwserc/cs/csa/CSAJoinCnslWrite.admin";
	}
	
	/**
	 *  가입 상담 답변을 등록한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String updateJoinCnslAnsw(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			cSAJoinCnslService.updateJoinCnslAnsw(emfMap);
			
			modelMap.addAttribute("f", emfMap.getString("f"));
			modelMap.addAttribute("q", emfMap.getString("q"));
			modelMap.addAttribute("inqryCd", emfMap.getString("inqryCd"));
			modelMap.addAttribute("prcsCd", emfMap.getString("sPrcsCd"));
			modelMap.addAttribute("pageIndex", emfMap.getString("pageIndex"));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}

		return "redirect:./write.do?joinCnslSeq=" + emfMap.getString("joinCnslSeq");
	}
	
	/**
	 * 가입 상담을 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String deleteJoinCnslList(EmfMap emfMap, ModelMap modelMap, @RequestParam(value="delSeq", required=true) int[] delSeq) throws Exception
	{
		try
		{
			cSAJoinCnslService.deleteJoinCnslList(delSeq);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		}
		
		return "redirect:./index.do";
	}
	
	/**
	 * 가입 상담 목록을 조회한다. (엑셀 다운로드)
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/excel.do")
	public String excelJoinCnslList(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		//검색어 체크
		String f = emfMap.getString("f");
		String q = emfMap.getString("q");	
		
		if(!"".equals(EMFStringUtil.nullConvert(q)) && q.length() <= 15)
		{
			emfMap.put("f", f);
			emfMap.put("q", q);
		}
		else
		{
			emfMap.put("f", "");
			emfMap.put("q", "");
		}
		
		try
		{
			List<EmfMap> list = cSAJoinCnslService.excelJoinCnslList(emfMap);
			
			modelMap.addAttribute("excelList", list);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "mngwserc/cs/csa/CSAJoinCnslExcel";
	}
}
