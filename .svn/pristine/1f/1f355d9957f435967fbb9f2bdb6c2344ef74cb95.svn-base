package mngwserc.mb.mbc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List; 

import javax.annotation.Resource;

import emf.core.util.EMFSecurityUtil;
import mngwserc.co.util.COPaginationUtil;
import mngwserc.mb.mbc.service.MBCQscnMemService;
import mngwserc.mb.mbc.service.dao.MBCQscnMemDAO;
import mngwserc.mb.sso.exception.SsoException;
import mngwserc.mb.sso.service.SSOService;

import org.springframework.stereotype.Service;




import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.sim.service.SeedCipher;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 휴면계정 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: MBCQscnMemServiceImpl.java
 * @Description		: 휴면계정을 관리르 위한 ServiceImpl
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
@Service("mBCQscnMemService")
public class MBCQscnMemServiceImpl extends EmfAbstractService implements MBCQscnMemService {

	@Resource(name="mBCQscnMemDAO")
	private MBCQscnMemDAO mBCQscnMemDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;

	@Resource(name="ssoService")
	private SSOService ssoService;

	private String ENCODE = EgovProperties.getProperty("Global.CHARCODE");
	
	/**
     * 휴면계정 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectQscnMemList(EmfMap emfMap) throws Exception
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
		List<EmfMap> list = mBCQscnMemDAO.selectDrotMemList(emfMap);		
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
			//2017.04.24 박주석 디아모 솔루션 도입 작업
//			for(int i = 0; i < list.size(); i++)
//			{
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("email"))))
//				{
//					list.get(i).put("email", SeedCipher.decrypt(list.get(i).getString("email"), ENCODE));
//				}
//			}

			// SSO 통합아이디 [S]
			for (int i=0; i<list.size(); i++) {
				HashMap ssoMemberInfo = null;
				String strCi = list.get(i).getString("ci");
				list.get(i).put("ssoId", "");
				// 동일 CI값의 회원이 SSO에 존재하는지 확인
				try
				{
					EMFSecurityUtil.maskEmfMap(list.get(i), "name", "hp", "email");
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

			cmmUseService.actionViewAuthLogV2("회원관리 - 휴면계정", "", "S", null);
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		return emfMap;
	}

	/**
     * 휴면계정 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectQscnMem(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		EmfMap memInfo = mBCQscnMemDAO.selectQscnMem(emfMap);
		
    	if(memInfo != null)
    	{
			// SSO 통합아이디 [S]
			HashMap ssoMemberInfo = null;
			String strCi = memInfo.getString("ci");
			memInfo.put("ssoId", "");
			// 동일 CI값의 회원이 SSO에 존재하는지 확인
			try
			{
				ssoMemberInfo = ssoService.find(null, null, strCi, lgnMap.getString("loginIp"));
				if (ssoMemberInfo != null && ssoMemberInfo.get("id") != null) 
				{
					memInfo.put("ssoId", ssoMemberInfo.get("id"));
				}
			}
			catch (SsoException ex)
			{
			}
			catch (Exception ex)
			{
			}
			// SSO 통합아이디 [E]

			emfMap.put("memInfo", memInfo);
    		//2017.04.24 박주석 디아모 솔루션 도입 작업
//    		if(!"".equals(EMFStringUtil.nullConvert(memInfo.get("email"))))
//			{
//    			memInfo.put("email", SeedCipher.decrypt(memInfo.getString("email"), ENCODE));
//			}
//    		
//    		if(!"".equals(EMFStringUtil.nullConvert(memInfo.get("hp"))))
//			{
//    			memInfo.put("hp", SeedCipher.decrypt(memInfo.getString("hp"), ENCODE));
//			}
//    		
//    		if(!"".equals(EMFStringUtil.nullConvert(memInfo.get("tel"))))
//			{
//    			memInfo.put("tel", SeedCipher.decrypt(memInfo.getString("tel"), ENCODE));
//			}
//    		
//    		if(!"".equals(EMFStringUtil.nullConvert(memInfo.get("adrDtl"))))
//			{
//    			memInfo.put("adrDtl", SeedCipher.decrypt(memInfo.getString("adrDtl"), ENCODE));
//			}
    	}
    	
    	//공통코드 배열 셋팅
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		//회원 - 가입경로
		cdDtlList.add("JOIN_PATH_GB");
		
		//회원 - 관심정보
		cdDtlList.add("INTR_GB");
		
		//회원 - 선호정보
		cdDtlList.add("PFRN_GB");

		cmmUseService.actionViewAuthLogV2("회원관리 - 휴면계정", "", "D", null);

		//정의된 코드id값들의 상세 코드 맵 반환		
		emfMap.put("cdDtlList", cmmUseService.selectCmmCodeBindAll(cdDtlList));
		
    	return emfMap;
	}

	/**
	 * 휴면상태를 해제한다.
	 *
	 * @param emfMap
	 * @throws Exception
	 */
	public void updateQscnYn(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));

		//mBCQscnMemDAO.updateQscnYn(emfMap);

		// MB_MEM_MST(유저테이블)에 입력 후, MB_QSCN_MEM_MST(휴먼테이블)에서 삭제한다.
		mBCQscnMemDAO.qscnMemChange(emfMap);
		mBCQscnMemDAO.deleteQscnMemChange(emfMap);

		cmmUseService.actionViewAuthLogV2("회원관리 - 휴면계정 - 해제", "", "M", null);
	}
	
	/**
     * 휴면계정 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public List<EmfMap> excelQscnMemList(EmfMap emfMap) throws Exception 
	{
		List<EmfMap> list = mBCQscnMemDAO.excelQscnMemList(emfMap);
		cmmUseService.actionViewAuthLogV2("회원관리 - 휴면계정", "", "E", null);
		//2017.04.24 박주석 디아모 솔루션 도입 작업
//		for(int i = 0; i < list.size(); i++)
//		{
//			if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("email"))))
//			{
//				list.get(i).put("email", SeedCipher.decrypt(list.get(i).getString("email"), ENCODE));
//			}
//		}
		
		return list;
	}

	/**
     * 휴면회원으로 전환한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public void qscnChange(EmfMap emfMap) throws Exception {
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));

		mBCQscnMemDAO.qscnChange(emfMap);
		
		mBCQscnMemDAO.deleteQscnChange(emfMap);
		cmmUseService.actionViewAuthLogV2("회원관리 - 휴면계정 - 휴면전환", "", "M", null);
	}
}