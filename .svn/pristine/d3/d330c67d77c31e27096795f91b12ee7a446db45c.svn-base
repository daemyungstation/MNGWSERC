package mngwserc.sm.sma.service.impl;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.sm.sma.service.SMAPopMngService;
import mngwserc.sm.sma.service.dao.SMAPopMngDAO;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 팝업 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: SMAPopMngServiceImpl.java
 * @Description		: 팝업 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.02.11.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				   description
 *   ===========    ==============    =============================
 *   2016.02.11.		허진영			 		최초생성
 * </pre>
 */
@Service("sMAPopMngService")
public class SMAPopMngServiceImpl extends EmfAbstractService implements SMAPopMngService {
	
	@Resource(name="sMAPopMngDAO")
    private SMAPopMngDAO sMAPopMngDAO;
	
	@Resource(name="popIdgen")
	private EgovTableIdGnrService popIdgen;	
		
	/**
	 * 팝업 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */    
	public EmfMap selectPopList(EmfMap emfMap) throws Exception
    {
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);
		
		//리스트 가져오기
		List<EmfMap> list = sMAPopMngDAO.selectPopList(emfMap);
	
		emfMap.put("list", list);	
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		return emfMap;		
    }
	
	/**
	 * 팝업 상세를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */    
	public EmfMap selectPop(EmfMap emfMap) throws Exception
    {	
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("popSeq"))))
    	{
			EmfMap popInfo = sMAPopMngDAO.selectPop(emfMap);
			
			if(popInfo != null)
	    	{
				emfMap.put("popInfo", popInfo);
	    	}
    	}
		
		return emfMap;
    }
	
	/**
     * 팝업을 등록한다.
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertPop(EmfMap emfMap) throws Exception {
		mappingRegisterInfo(emfMap);
		
		emfMap.put("popSeq", popIdgen.getNextIntegerId());
		
		//게시시작, 종료일 setting
		emfMap.put("ptupStrtDt", emfMap.getString("ptupStrtDt").replaceAll("-", ""));
		emfMap.put("ptupEndDt", emfMap.getString("ptupEndDt").replaceAll("-", ""));
		
		sMAPopMngDAO.insertPop(emfMap);
	}
	
	/**
     * 팝업을 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updatePop(EmfMap emfMap) throws Exception
	{
		EmfMap admLgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		//게시시작, 종료일 setting
		emfMap.put("ptupStrtDt", emfMap.getString("ptupStrtDt").replaceAll("-", ""));
		emfMap.put("ptupEndDt", emfMap.getString("ptupEndDt").replaceAll("-", ""));
		
		emfMap.put("modId", admLgnMap.getString("id"));
		emfMap.put("modIp", admLgnMap.getString("loginIp"));
		
		sMAPopMngDAO.updatePop(emfMap);				
	}
	
	/**
     * 팝업를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deletePopList(int[] delSeq) throws Exception
	{	
		EmfMap emfMap = new EmfMap();
		
		emfMap.put("delSeq", delSeq);
			
		sMAPopMngDAO.deletePop(emfMap);
	}

	/**
	 * 메인 팝업 목록 조회
	 *
	 * @param emfMap
	 * @return
	 * @throws Exception
	 */
	public EmfMap selectMainPopList(EmfMap emfMap) throws Exception {
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);

		List<EmfMap> list = sMAPopMngDAO.selectMainPopList(emfMap);

		if (list.size() > 0) {
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		} else {
			paginationInfo.setTotalRecordCount(0);
		}

		emfMap.put("paginationInfo", paginationInfo);
		emfMap.put("list", list);

		return emfMap;
	}

	public void setMainPopup(EmfMap emfMap) throws Exception {
		mappingRegisterInfo(emfMap);
		if (emfMap.get("alwaysYn") == null) {
			emfMap.put("alwaysYn", "N");
		}
		//게시시작, 종료일 setting
		emfMap.put("startDtm", emfMap.getString("startDtm").replaceAll("-", ""));
		emfMap.put("endDtm", emfMap.getString("endDtm").replaceAll("-", ""));

		sMAPopMngDAO.insertMainPop(emfMap);
	}

	@Override
	public EmfMap getMainPop(EmfMap emfMap) {
		emfMap.put("popInfo", sMAPopMngDAO.getMainPop(emfMap));
		return emfMap;
	}

	@Override
	public void putMainPopup(EmfMap emfMap) {
		mappingRegisterInfo(emfMap);
		if (emfMap.get("alwaysYn") == null) {
			emfMap.put("alwaysYn", "N");
		}
		//게시시작, 종료일 setting
		emfMap.put("ptupStrtDt", emfMap.getString("ptupStrtDt").replaceAll("-", ""));
		emfMap.put("ptupEndDt", emfMap.getString("ptupEndDt").replaceAll("-", ""));

		sMAPopMngDAO.putMainPopup(emfMap);
	}

	@Override
	public void delMainPopList(int[] delSeq) {
		sMAPopMngDAO.delMainPopList(delSeq);
	}

	private void mappingRegisterInfo(EmfMap emfMap) {
		EmfMap admLgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("regId", admLgnMap.getString("id"));
		emfMap.put("regIp", admLgnMap.getString("loginIp"));
		emfMap.put("modId", admLgnMap.getString("id"));
		emfMap.put("modIp", admLgnMap.getString("loginIp"));
	}
}
