package mngwserc.mb.mbb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.mb.mbb.service.MBBDrotMemService;
import mngwserc.mb.mbb.service.dao.MBBDrotMemDAO;

import org.springframework.stereotype.Service;



import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 탈퇴회원 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: MBBDrotMemServiceImpl.java
 * @Description		: 탈퇴회원 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.02.22
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author				   description
 *   ===========    ==============    =============================
 *    2016.02.22		허진영				    최초생성
 * </pre>
 */
@Service("mBBDrotMemService")
public class MBBDrotMemServiceImpl extends EmfAbstractService implements MBBDrotMemService {

	@Resource(name="mBBDrotMemDAO")
	private MBBDrotMemDAO mBBDrotMemDAO; 
	
	/**
     * 탈퇴회원 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectDrotMemList(EmfMap emfMap) throws Exception 
	{
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);
		
		//리스트 가져오기
		List<EmfMap> list = mBBDrotMemDAO.selectDrotMemList(emfMap);		
		
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
     * 탈퇴회원 목록을 조회한다. (엑셀다운로드)
     * 
     * @param EmfMap
	 * @return List<EmfMap>
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */	
	public List<EmfMap> excelDrotMemList(EmfMap emfMap) throws Exception 
	{
		return mBBDrotMemDAO.excelDrotMemList(emfMap);
	}
}
