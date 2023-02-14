package mngwserc.co.coc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.coc.service.COCAdmRoleMngService;
import mngwserc.co.coc.service.dao.COCAdmRoleMngDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 관리자 ROLE 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: COCAdmRoleMngServiceImpl.java
 * @Description		: 관리자 ROLE 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2015.11.13
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.13		허진영					최초생성
 * </pre>
 */ 
@Service("cOCAdmRoleMngService")
public class COCAdmRoleMngServiceImpl extends EmfAbstractService implements COCAdmRoleMngService {
	
	@Resource(name="cOCAdmRoleMngDAO")
    private COCAdmRoleMngDAO cOCAdmRoleMngDAO;
	
	@Resource(name="roleIdgen")
	private EgovTableIdGnrService roleIdgen;
	
	private String roleGb = EgovProperties.getProperty("Globals.roleGb");
	
	/**
	 * 관리자 ROLE 목록을 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public EmfMap selectAdmRoleList(EmfMap emfMap) throws Exception
    {
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);
		
		//관리자 ROLE 구분
		emfMap.put("roleGb", roleGb);
		
		//리스트 가져오기
		List<EmfMap> list = cOCAdmRoleMngDAO.selectAdmRoleList(emfMap);
		
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
	 * 관리자 상세를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public EmfMap selectAdmRole(EmfMap emfMap) throws Exception
    {
    	if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("roleCd"))))
    	{
    		EmfMap roleInfo = cOCAdmRoleMngDAO.selectAdmRole(emfMap);
    		
    		if(roleInfo != null)
    		{
    			emfMap.put("roleInfo", roleInfo);
    		}
    	}
    	
    	if("AUTH".equals(roleGb))
    	{
    		emfMap.put("admUserTypeList", cOCAdmRoleMngDAO.selectAdmUserTypeList(emfMap));
    	}
    	
    	emfMap.put("roleGb", roleGb);
    	
    	return emfMap;
    }
       
	/**
     * 관리자 ROLE을 등록한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void insertAdmRole(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		if(!"AUTH".equals(roleGb))
    	{
			emfMap.put("roleCd", roleIdgen.getNextStringId());
    	}
		
		emfMap.put("roleGb", roleGb);
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//관리자 ROLE 등록
		cOCAdmRoleMngDAO.insertAdmRole(emfMap);
		
		//관리자 메뉴정보를 Setting한다.
		setAdmMenu(emfMap);
    }
	
	/**
     * 관리자 ROLE을 수정한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void updateAdmRole(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		//관리자 ROLE 수정
    	cOCAdmRoleMngDAO.updateAdmRole(emfMap);
    	
    	//관리자 메뉴정보를 Setting한다.
    	setAdmMenu(emfMap);
	}
	
	/**
     * 관리자 ROLE을 삭제한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public void deleteAdmRole(EmfMap emfMap) throws Exception
	{
		//관리자 ROEL 삭제
		cOCAdmRoleMngDAO.deleteAdmRole(emfMap);
		
		//관리자 메뉴정보 삭제
		cOCAdmRoleMngDAO.deleteAdmMenu(emfMap);
	}
	 
    /**
     * 관리자 메뉴정보를 Setting한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void setAdmMenu(EmfMap emfMap) throws Exception
    {
    	//관리자 메뉴를 삭제한다.
    	cOCAdmRoleMngDAO.deleteAdmMenu(emfMap);
    	
    	//관리자 메뉴 set
    	if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("mChecked"))))
		{
    		String mChecked = emfMap.getString("mChecked");
    		
			String[] menuSeqs;
			
			if(mChecked.indexOf(",") > 0)
			{
				menuSeqs = mChecked.split(",");
			}
			else
			{
				menuSeqs = new String[]{mChecked};
			}
			
			if("AUTH".equals(roleGb))
			{
				if(!"99".equals(EMFStringUtil.nullConvert(emfMap.get("roleCd"))))
				{
					if(menuSeqs != null)
					{
						for(int q = 0; q < menuSeqs.length; q++)
						{
							emfMap.put("menuSeq", Integer.parseInt(menuSeqs[q]));
							cOCAdmRoleMngDAO.insertAdmMenu(emfMap);
						}
					}
				}
			}
			else
			{
				if(menuSeqs != null)
				{
					for(int q = 0; q < menuSeqs.length; q++)
					{
						emfMap.put("menuSeq", Integer.parseInt(menuSeqs[q]));
						cOCAdmRoleMngDAO.insertAdmMenu(emfMap);
					}
				}
			}
		}
    }
}