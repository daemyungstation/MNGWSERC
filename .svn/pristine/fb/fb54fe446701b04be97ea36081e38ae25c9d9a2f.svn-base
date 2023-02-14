package mngwserc.mb.mbc.web;

import javax.annotation.Resource; 

import mngwserc.mb.mbc.service.MBCQscnMemService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 휴면계정 관리를 위한 Controller
 * </pre>
 * 
 * @ClassName		: MBCQscnMemController.java
 * @Description		: 휴면계정 관리를 위한 Controller
 * @author 허진영
 * @since 2016.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				  description
 *   ===========    ==============    =============================
 *    2016.02.22		허진영					최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwserc/mbc/qscn")
public class MBCQscnMemController extends EmfController {
	
	/** 서비스 **/
	@Resource(name="mBCQscnMemService")
	private MBCQscnMemService mBCQscnMemService; 
	
	/**
     * 휴면계정 목록을 조회한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/list.do")
	public String selectQscnMemList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			EmfMap rtnMap = mBCQscnMemService.selectQscnMemList(emfMap);
			
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
		
		return "mngwserc/mb/mbc/MBCQscnMemList.admin";
	}
	
	/**
     * 휴면계정 상세를 조회한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/view.do")
	public String selectQscnMem(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			EmfMap rtnMap = mBCQscnMemService.selectQscnMem(emfMap);
			
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
		
		return "mngwserc/mb/mbc/MBCQscnMemView.admin";
	}
	
	/**
     * 휴면상태를 해제한다.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/update.do")
	public String updateQscnYn(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			mBCQscnMemService.updateQscnYn(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "redirect:./list.do";
	}
	
	/**
     * 휴면계정 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
//	/*BLOCK_EXCEL*/ @RequestMapping(value="/excel.do")
	public String excelQscnMemList(EmfMap emfMap, ModelMap modelMap) throws Exception
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
			modelMap.addAttribute("excelList", mBCQscnMemService.excelQscnMemList(emfMap));
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
				
		return "mngwserc/mb/mbc/MBCQscnMemExcel";
	}

	/**
     * 휴면상태 전환.
     * 
     * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	@RequestMapping(value="/qscnChange.do")
	public String qscnChange(EmfMap emfMap, ModelMap modelMap) throws Exception
	{
		try
		{
			mBCQscnMemService.qscnChange(emfMap);
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return "redirect:./list.do";
	}
}