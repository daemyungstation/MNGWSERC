package mngwserc.mb.mba.service.impl;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.mb.mba.service.MBAMemChngService;
import mngwserc.mb.mba.service.dao.MBAMemChngDAO;

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
 * 회원정보 변경내역 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: MBAMemChngServiceImpl.java
 * @Description		: 회원정보 변경내역 관리를 위한 Service
 * @author 허진영
 * @since 2016.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author				   description
 *   ===========    ==============    =============================
 *    2016.02.22		허진영					최초 생성
 * </pre>
 */
@Service("mBAMemChngService")
public class MBAMemChngServiceImpl extends EmfAbstractService implements MBAMemChngService {
	
	@Resource(name="mBAMemChngDAO")
	private MBAMemChngDAO mBAMemChngDAO;
	
	@Resource(name="EgovCmmUseService")
	private EgovCmmUseService cmmUseService;
	
	private String ENCODE = EgovProperties.getProperty("Global.CHARCODE");
	
	/**
     * 회원정보 변경내역 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectMemChngList(EmfMap emfMap) throws Exception
	{
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = mBAMemChngDAO.selectMemChngList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
			//2017.04.24 박주석 디아모 솔루션 도입 작업
//			for(int i = 0; i < list.size(); i++)
//			{
//				
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("bfrEmail"))))
//				{
//					list.get(i).put("bfrEmail", SeedCipher.decrypt(list.get(i).getString("bfrEmail"), ENCODE));
//				}
//				
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("bfrHp"))))
//				{
//					list.get(i).put("bfrHp", SeedCipher.decrypt(list.get(i).getString("bfrHp"), ENCODE));
//				}
//				
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("bfrTel"))))
//				{
//					list.get(i).put("bfrTel", SeedCipher.decrypt(list.get(i).getString("bfrTel"), ENCODE));
//				}
//				
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("bfrAdrDtl"))))
//				{
//					list.get(i).put("bfrAdrDtl", SeedCipher.decrypt(list.get(i).getString("bfrAdrDtl"), ENCODE));
//				}
//				
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("aftEmail"))))
//				{
//					list.get(i).put("aftEmail", SeedCipher.decrypt(list.get(i).getString("aftEmail"), ENCODE));
//				}
//				
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("aftHp"))))
//				{
//					list.get(i).put("aftHp", SeedCipher.decrypt(list.get(i).getString("aftHp"), ENCODE));
//				}
//				
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("aftTel"))))
//				{
//					list.get(i).put("aftTel", SeedCipher.decrypt(list.get(i).getString("aftTel"), ENCODE));
//				}
//				
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("aftAdrDtl"))))
//				{
//					list.get(i).put("aftAdrDtl", SeedCipher.decrypt(list.get(i).getString("aftAdrDtl"), ENCODE));
//				}
//			}
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "회원 관리 - 회원정보 변경 내역 조회");
		logMap.put("flag", "S");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
		
		return emfMap;
	}
	
	/**
     * 회원정보 변경내역 처리현황을 수정한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateChngPtcPrcsYn(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		mBAMemChngDAO.updateChngPtcPrcsYn(emfMap);

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "회원 관리 - 회원정보 변경 내역 수정");
		logMap.put("flag", "M");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
	}
	
	/**
     * 회원정보 변경내역 목록을 조회한다. (엑셀 다운로드)
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public List<EmfMap> excelMemChngList(EmfMap emfMap) throws Exception
	{
		List<EmfMap> list = mBAMemChngDAO.excelMemChngList(emfMap);
		//2017.04.24 박주석 디아모 솔루션 도입 작업
//		for(int i = 0; i < list.size(); i++)
//		{
//			if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("bfrEmail"))))
//			{
//				list.get(i).put("bfrEmail", SeedCipher.decrypt(list.get(i).getString("bfrEmail"), ENCODE));
//			}
//			
//			if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("bfrHp"))))
//			{
//				list.get(i).put("bfrHp", SeedCipher.decrypt(list.get(i).getString("bfrHp"), ENCODE));
//			}
//			
//			if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("bfrTel"))))
//			{
//				list.get(i).put("bfrTel", SeedCipher.decrypt(list.get(i).getString("bfrTel"), ENCODE));
//			}
//			
//			if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("bfrAdrDtl"))))
//			{
//				list.get(i).put("bfrAdrDtl", SeedCipher.decrypt(list.get(i).getString("bfrAdrDtl"), ENCODE));
//			}
//			
//			if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("aftEmail"))))
//			{
//				list.get(i).put("aftEmail", SeedCipher.decrypt(list.get(i).getString("aftEmail"), ENCODE));
//			}
//			
//			if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("aftHp"))))
//			{
//				list.get(i).put("aftHp", SeedCipher.decrypt(list.get(i).getString("aftHp"), ENCODE));
//			}
//			
//			if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("aftTel"))))
//			{
//				list.get(i).put("aftTel", SeedCipher.decrypt(list.get(i).getString("aftTel"), ENCODE));
//			}
//			
//			if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("aftAdrDtl"))))
//			{
//				list.get(i).put("aftAdrDtl", SeedCipher.decrypt(list.get(i).getString("aftAdrDtl"), ENCODE));
//			}
//		}
		

		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap logMap = new EmfMap();
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "회원 관리 - 회원정보 변경 내역 엑셀다운로드");
		logMap.put("flag", "E");
		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		if(logMap.getString("id") != null && !logMap.getString("id").equals("")){
			cmmUseService.actionViewAuthLog(logMap);
		}
		
		return list;
	}
}
