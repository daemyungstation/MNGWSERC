package mngwserc.fair.service.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;
import mngwserc.co.util.COPaginationUtil;
import mngwserc.fair.service.FairProductInputService;
import mngwserc.fair.service.dao.FairProductInputDAO;

/**
 * <pre> 
 * 박람회 제품 입력폼 관리 Implement
 * </pre>
 * 
 * @ClassName		: FairProductInputServiceImpl.java
 * @Description		: 박람회 제품 입력폼 관리 Implement
 * @author inuscommunity
 * @since 2019. 10. 23.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 	    since			author	               description
 *  ============    ==============    =============================
 *  2019. 10. 23.	   inuscomm                 최초생성
 * </pre>
 */

@Service("fairProductInputService")
public class FairProductInputServiceImpl extends EmfAbstractService implements FairProductInputService {
	
	/** 서비스 **/
	@Resource(name="fairProductInputDAO")
	private FairProductInputDAO fairProductInputDAO;
	
	/** SEQ **/
	@Resource(name="fairProductInputIdgen")
    private EgovIdGnrService fairProductInputIdgen;
	
	/**
     * 목록 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap selectList(EmfMap emfMap) throws Exception {

		PaginationInfo paginationInfo = COPaginationUtil.getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    

		//리스트 가져오기
		List<EmfMap> list = fairProductInputDAO.selectList(emfMap);
		
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
     * 상세 조회
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap select(EmfMap emfMap) throws Exception {

		//리스트 가져오기
		List<EmfMap> list = fairProductInputDAO.select(emfMap);
		EmfMap row = new EmfMap();
		if(!list.isEmpty()) 
		{
			row = list.get(0);
		}
		return row;
	}
	
	/**
	 * 등록
	 */
	public void insert(EmfMap emfMap) throws Exception 
	{
		
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));

		emfMap.put("FPI_SEQ", fairProductInputIdgen.getNextIntegerId());

    	fairProductInputDAO.insert(emfMap);
	}

	/**
	 * 수정
	 */
	public void update(EmfMap emfMap) throws Exception 
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
    	fairProductInputDAO.update(emfMap);		
	}
	
	/**
	 * 삭제
	 */
	public void delete(EmfMap emfMap) throws Exception 
	{
		fairProductInputDAO.delete(emfMap);
	}
}