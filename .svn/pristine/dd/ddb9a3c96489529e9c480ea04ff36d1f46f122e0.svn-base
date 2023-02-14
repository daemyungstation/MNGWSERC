package mngwserc.cm.cmg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.cm.cmg.service.CMGAcntChngService;
import mngwserc.cm.cmg.service.dao.CMGAcntChngDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;

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
 * 결제계좌 변경내역 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CMGAcctModPtcServiceImpl.java
 * @Description		: 결제계좌 변경내역 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.03.07
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.03.07		허진영					 최초생성
 * </pre>
 */
@Service("cMGAcntChngService")
public class CMGAcntChngServiceImpl extends EmfAbstractService implements CMGAcntChngService {
	
	@Resource(name="cMGAcntChngDAO")
	private CMGAcntChngDAO cMGAcntChngDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
	
	private String ENCODE = EgovProperties.getProperty("Global.CHARCODE");
	
	/**
	 * 결제계좌 변경내역 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public EmfMap selectAcntChngList(EmfMap emfMap) throws Exception
	{
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cMGAcntChngDAO.selectAcntChngList(emfMap);
		
		if(list.size() > 0)
		{
			for (int j=0; j<list.size(); j++) { 
				
				String name = list.get(j).getString("name");
				String hp = list.get(j).getString("hp");
				String bfrCardNo = list.get(j).getString("bfrCardNo");
				String aftCardNo = list.get(j).getString("aftCardNo");
				String bfrCardExprYr = list.get(j).getString("bfrCardExprYr");
				String bfrCardExprMm = list.get(j).getString("bfrCardExprMm");
				String aftCardExprYr = list.get(j).getString("aftCardExprYr");
				String aftCardExprMm = list.get(j).getString("aftCardExprMm");
				String nameNosk = list.get(j).getString("name");
				String hpNosk = list.get(j).getString("hp");
				String bfrCardNoNosk = list.get(j).getString("bfrCardNo");
				String aftCardNoNosk = list.get(j).getString("aftCardNo");
				String bfrCardExprYrNosk = list.get(j).getString("bfrCardExprYr");
				String bfrCardExprMmNosk = list.get(j).getString("bfrCardExprMm");
				String aftCardExprYrNosk = list.get(j).getString("aftCardExprYr");
				String aftCardExprMmNosk = list.get(j).getString("aftCardExprMm");

				if ( name != null && name != "" && name.length() > 1 ) {
					char ch = name.charAt(0);
					
					if (ch>='가' && ch<='힣') {
						name = name.substring(0,1) + "*" + name.substring(2,name.length());
						list.get(j).put("name", name);
					}
					
					if (ch>='A' && ch<='Z') {
						if(name.length() < 4) {
							name = name.substring(0,2) + "*";
							list.get(j).put("name", name);
						} else if(name.length() < 5) {
							name = name.substring(0,2) + "**";
							list.get(j).put("name", name);
						} else {
							name = name.substring(0,2) + "***" + name.substring(5,name.length());
							list.get(j).put("name", name);
						}
					}
	
					if (ch>='a' && ch<='z') {
						if(name.length() < 4) {
							name = name.substring(0,2) + "*";
							list.get(j).put("name", name);
						} else if(name.length() < 5) {
							name = name.substring(0,2) + "**";
							list.get(j).put("name", name);
						} else {
							name = name.substring(0,2) + "***" + name.substring(5,name.length());
							list.get(j).put("name", name);
						}
					}
				}
				
				if ( hp != null && hp != "") {
					if(hp.length() >=9 ) {
						hp = hp.substring(0,4) + "****" + hp.substring(8,hp.length());
					} else if(hp.length() >=4 ) {
						hp = hp.substring(0,4) + "****";
					}
					list.get(j).put("hp", hp);
				}

				if ( bfrCardNo != null && bfrCardNo != "" ) {
					if(bfrCardNo.length() >= 13) {
						bfrCardNo = bfrCardNo.substring(0,4) + "-****-****-" + bfrCardNo.substring(12,bfrCardNo.length());
					}else if(bfrCardNo.length() >= 4) {
						bfrCardNo = bfrCardNo.substring(0,4) + "-****-****-";
					}
					list.get(j).put("bfrCardNo", bfrCardNo);
				}

				if ( aftCardNo != null && aftCardNo != "" ) {
					if(aftCardNo.length() >= 13) {
						aftCardNo = aftCardNo.substring(0,4) + "-****-****-" + aftCardNo.substring(12,aftCardNo.length());
					}else if(aftCardNo.length() >= 4) {
						aftCardNo = aftCardNo.substring(0,4) + "-****-****-";
					}
					list.get(j).put("aftCardNo", aftCardNo);
				}

				if ( bfrCardExprYr != null && bfrCardExprYr != "" ) {
					bfrCardExprYr = "**";
					list.get(j).put("bfrCardExprYr", bfrCardExprYr);
				}

				if ( bfrCardExprMm != null && bfrCardExprMm != "" ) {
					bfrCardExprMm = "**";
					list.get(j).put("bfrCardExprMm", bfrCardExprMm);
				}

				if ( aftCardExprYr != null && aftCardExprYr != "" ) {
					aftCardExprYr = "**";
					list.get(j).put("aftCardExprYr", aftCardExprYr);
				}

				if ( aftCardExprMm != null && aftCardExprMm != "" ) {
					aftCardExprMm = "**";
					list.get(j).put("aftCardExprMm", aftCardExprMm);
				}

				list.get(j).put("nameNosk", nameNosk);
				list.get(j).put("hpNosk", hpNosk);
				list.get(j).put("bfrCardNoNosk", bfrCardNoNosk);
				list.get(j).put("aftCardNoNosk", aftCardNoNosk);
				list.get(j).put("bfrCardExprYrNosk", bfrCardExprYrNosk);
				list.get(j).put("bfrCardExprMmNosk", bfrCardExprMmNosk);
				list.get(j).put("aftCardExprYrNosk", aftCardExprYrNosk);
				list.get(j).put("aftCardExprMmNosk", aftCardExprMmNosk);
			}
		}
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
			//2017.04.24 박주석 디아모 솔루션 도입 작업
//			for(int i = 0; i < list.size(); i++)
//			{
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("hp"))))
//				{
//					list.get(i).put("hp", SeedCipher.decrypt(list.get(i).getString("hp"), ENCODE));
//				}
//				
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("bfrAcntNo"))))
//				{
//					list.get(i).put("bfrAcntNo", SeedCipher.decrypt(list.get(i).getString("bfrAcntNo"), ENCODE));
//				}
//				
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("bfrCardNo"))))
//				{
//					list.get(i).put("bfrCardNo", SeedCipher.decrypt(list.get(i).getString("bfrCardNo"), ENCODE));
//				}
//				
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("aftAcntNo"))))
//				{
//					list.get(i).put("aftAcntNo", SeedCipher.decrypt(list.get(i).getString("aftAcntNo"), ENCODE));
//				}
//				
//				if(!"".equals(EMFStringUtil.nullConvert(list.get(i).get("aftCardNo"))))
//				{
//					list.get(i).put("aftCardNo", SeedCipher.decrypt(list.get(i).getString("aftCardNo"), ENCODE));
//				}
//			}
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		return emfMap;
	}

	/**
	 * 결제계좌 변경내역 상세목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public EmfMap selectAcntChngListDtl(EmfMap emfMap) throws Exception
	{
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> list = cMGAcntChngDAO.selectAcntChngList(emfMap);
		
		emfMap.put("list", list);
		
		return emfMap;
	}
	
	/**
     * 결제계좌 변경내역 처리현황을 수정한다.
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
		
		cMGAcntChngDAO.updateChngPtcPrcsYn(emfMap);
	}
}
