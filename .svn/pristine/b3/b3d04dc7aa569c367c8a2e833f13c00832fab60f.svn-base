package mngwserc.sm.smb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.sm.smb.service.SMBOprtGuideService;
import mngwserc.sm.smb.service.dao.SMBOprtGuideDAO;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 이용안내 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: SMBOprtGuideServiceImpl.java
 * @Description		: 이용안내 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.02.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 	    since		   author				  description
 *   ==========    ==============    =============================
 *   2016.02.12		   허진영				   최초 생성
 * </pre>
 */
@Service("sMBOprtGuideService")
public class SMBOprtGuideServiceImpl extends EmfAbstractService implements SMBOprtGuideService {

	@Resource(name="sMBOprtGuideDAO")
    private SMBOprtGuideDAO sMBOprtGuideDAO;
	
	@Resource(name="oprtGuideIdgen")
	private EgovTableIdGnrService oprtGuideIdgen;	
		
	/**
	 * 이용안내 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */    
	public EmfMap selectOprtGuideList(EmfMap emfMap) throws Exception
    {
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = sMBOprtGuideDAO.selectOprtGuideList(emfMap);
		
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
	 * 이용안내 상세를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */    
	public EmfMap selectOprtGuide(EmfMap emfMap) throws Exception
    {	
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("oprtGuideSeq"))))
    	{
			EmfMap oprtGuideInfo = sMBOprtGuideDAO.selectOprtGuide(emfMap);
	
	    	if(oprtGuideInfo != null)
	    	{
				emfMap.put("oprtGuideInfo", oprtGuideInfo);
	    	}
    	}
		
		return emfMap;
    }
	
	/**
     * 이용안내를 등록한다.
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertOprtGuide(EmfMap emfMap) throws Exception
	{
		
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("oprtGuideSeq", oprtGuideIdgen.getNextIntegerId());
		emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		sMBOprtGuideDAO.insertOprtGuide(emfMap);				
	}
	
	/**
     * 이용안내 수정
     * 
     * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateOprtGuide(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		sMBOprtGuideDAO.updateOprtGuide(emfMap);				
	}
	
	/**
     * 이용안내를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteOprtGuideList(int[] delSeq) throws Exception
	{	
		EmfMap emfMap = new EmfMap();
		
		emfMap.put("delSeq", delSeq);
		
		sMBOprtGuideDAO.deleteOprtGuide(emfMap);
	}

    /**
	 * 이용안내를 복사한다.
	 * 
	 * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void insertOprtGuideCopy(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("oprtGuideSeq", oprtGuideIdgen.getNextIntegerId());
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		sMBOprtGuideDAO.insertOprtGuideCopy(emfMap);
	}

}