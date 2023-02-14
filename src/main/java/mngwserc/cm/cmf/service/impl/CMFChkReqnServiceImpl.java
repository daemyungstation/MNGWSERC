package mngwserc.cm.cmf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.cm.cmf.service.CMFChkReqnService;
import mngwserc.cm.cmf.service.dao.CMFChkReqnDAO;
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
 * @ClassName		: CMFChkReqnServiceImpl.java
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
@Service("cMFChkReqnService")
public class CMFChkReqnServiceImpl extends EmfAbstractService implements CMFChkReqnService {

	@Resource(name="cMFChkReqnDAO")
	private CMFChkReqnDAO cMFChkReqnDAO;
	
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
		
		// SSO 통합아이디 [S] - SSO 통합 회원아이디 검색
		if (emfMap.getString("f") != null && emfMap.getString("f").equals("3") && emfMap.getString("q") != null)
		{
			emfMap.put("ci", "");
			HashMap ssoMemberInfo = null;
			String strId = (String)emfMap.getString("q");
			try
			{
				ssoMemberInfo = ssoService.find(strId, null, null, lgnMap.getString("loginIp"));
				if (ssoMemberInfo != null && ssoMemberInfo.get("id") != null) 
				{
					emfMap.put("ci", ssoMemberInfo.get("ci"));
				}
			}
			catch (SsoException ex)
			{
			}
			catch (Exception ex)
			{
			}
		}
		// SSO 통합아이디 [E]

		//리스트 가져오기
		List<EmfMap> list = cMFChkReqnDAO.selectChkReqnList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));

			// SSO 통합아이디 [S]
			for (int i=0; i<list.size(); i++) {
				HashMap ssoMemberInfo = null;
				String strCi = list.get(i).getString("ci");
				list.get(i).put("ssoId", "");
				// 동일 CI값의 회원이 SSO에 존재하는지 확인
				try
				{
					ssoMemberInfo = ssoService.find(null, null, strCi, lgnMap.getString("loginIp"));
					if (ssoMemberInfo != null && ssoMemberInfo.get("id") != null) 
					{
						list.get(i).put("ssoId", ssoMemberInfo.get("id"));
					}
				}
				catch (SsoException ex)
				{
					continue;
				}
				catch (Exception ex)
				{
					continue;
				}
			}
			// SSO 통합아이디 [E]

		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//처리현황 TYPE
		cdDtlList.add("PROCESS_TYPE");
		
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
		
		cMFChkReqnDAO.deleteChkReqn(emfMap);
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
		
		if("".equals(emfMap.getString("reqnSeq"))){
			int[] reqnSeqList = (int[])emfMap.get("delSeq");

			for(int i = 0 ; i < reqnSeqList.length ; i++){
				emfMap.put("reqnSeq", reqnSeqList[i]);

				//확인요청 처리현황 로그를 등록한다.
				cMFChkReqnDAO.insertChkReqnPrcsLog(emfMap);
				
				//확인요청 내역 처리현황을 수정한다.
				cMFChkReqnDAO.updateChkReqnPrcsCd(emfMap);
			}	
		}else{
			//확인요청 처리현황 로그를 등록한다.
			cMFChkReqnDAO.insertChkReqnPrcsLog(emfMap);
			
			//확인요청 내역 처리현황을 수정한다.
			cMFChkReqnDAO.updateChkReqnPrcsCd(emfMap);
		}
		
	}
}
