package mngwserc.co.coc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.coc.service.CMFAppynService;
import mngwserc.co.coc.service.dao.CMFAppynDAO;
import mngwserc.co.util.COPaginationUtil;
import mngwserc.mb.sso.exception.SsoException;
import mngwserc.mb.sso.service.SSOService;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 확인요청 내역 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CMFAppynServiceImpl.java
 * @Description		: 확인요청 내역 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.02.11
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.11		허진영					 최초생성
 * </pre>
 */
@Service("cMFAppynService")
public class CMFAppynServiceImpl extends EmfAbstractService implements CMFAppynService {

	@Resource(name="cMFAppynDAO")
	private CMFAppynDAO cMFAppynDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;

	@Resource(name="ssoService")
	private SSOService ssoService;

	/**
     * 확인요청 내역 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectChkReqnList(EmfMap emfMap) throws Exception
    {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cMFAppynDAO.selectChkReqnList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));

		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//처리현황 TYPE
		cdDtlList.add("APPYN_STTS");
		
		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
		
		return emfMap;
    }
    
	/**
     * 확인요청 내역을 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteChkReqnList(int[] delSeq) throws Exception
	{
		EmfMap emfMap = new EmfMap();
		
		emfMap.put("delSeq", delSeq);
		
		cMFAppynDAO.deleteChkReqn(emfMap);
	}
	
	/**
     * 확인요청 내역 처리현황을 수정한다.
     * 
     * @param EmfMap
	 * @return int
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChkReqnPrcsCd(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		if("".equals(emfMap.getString("id"))){
			String[] seqList = (String[])emfMap.get("delSeq");
			String appYn = emfMap.getString("allAppyn");
			
			for(String id : seqList){
				emfMap.put("id", id);
				emfMap.put("appyn", appYn);
				
				//확인요청 내역 처리현황을 수정한다.
				cMFAppynDAO.updateChkAllReqnPrcsCd(emfMap);
			}
		}else{

			//확인요청 내역 처리현황을 수정한다.
			cMFAppynDAO.updateChkReqnPrcsCd(emfMap);
		}
		
	}
}
