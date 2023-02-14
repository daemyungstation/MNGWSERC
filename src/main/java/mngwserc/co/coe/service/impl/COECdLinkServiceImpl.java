package mngwserc.co.coe.service.impl;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.coe.service.COECdLinkService;
import mngwserc.co.coe.service.COECdMngService;
import mngwserc.co.coe.service.dao.COECdLinkDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 링크코드 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: COECdLinkServiceImpl.java
 * @Description		: 링크코드 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.03.28
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				   description
 *   ===========    ==============    =============================
 *   2016.03.28			허진영					최초 생성
 * </pre>
 */

@Service("cOECdLinkService")
public class COECdLinkServiceImpl extends EmfAbstractService implements COECdLinkService {
	
	@Resource(name="cOECdLinkDAO")
	private COECdLinkDAO cOECdLinkDAO;
	
	@Resource(name="cOECdMngService")
	private COECdMngService cOECdMngService;
	
	/**
	 * 코드 링크 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public EmfMap selectLinkList(EmfMap emfMap) throws Exception
    {
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> admList = cOECdLinkDAO.selectLinkList(emfMap);
		
		emfMap.put("list", admList);
		
		if(admList.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(admList.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		return emfMap;
    }
	
	/**
	 * 링크코드를 등록한다.
	 * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertCdLink(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();

		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));	

		cOECdLinkDAO.deleteCdLink(emfMap);
		
		String[] cd = emfMap.getString("lowrDtlCds").split(",");
		
		for(int i = 0; i < cd.length; i++)
		{
			if(!"".equals(EgovStringUtil.nullConvert(cd[i])))
			{
				emfMap.put("lowrDtlCd", cd[i]);
				
				cOECdLinkDAO.insertCdLink(emfMap);
			}
		}
	}
	
	/**
	 * 링크코드를 삭제한다.
	 * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void deleteCdLinkList(EmfMap emfMap) throws Exception
	{
		List<String> delList = emfMap.getList("delSeq");
		
		EmfMap paramMap = null;
		
		String strDel = "";
		
		String[] arrDelData = null;
		
		for(int i = 0; i < delList.size(); i++)
		{
			paramMap = new EmfMap();
			strDel = (String) delList.get(i);
			arrDelData = strDel.split("\\^");
			
			paramMap.put("highrCd", arrDelData[0]);
			paramMap.put("highrDtlCd", arrDelData[1]);
			paramMap.put("lowrCd", arrDelData[2]);
			paramMap.put("lowrDtlCd", arrDelData[3]);
			
			cOECdLinkDAO.deleteCdLink(paramMap);
		}
	}
}