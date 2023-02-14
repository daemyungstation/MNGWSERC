/**
 * 
 */
package mngwserc.bm.bma.service.impl;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.bm.bma.service.BMABoardCommentService;
import mngwserc.bm.bma.service.dao.BMABoardCommentDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 게시글 댓글 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: BMABoardCommentServiceImpl.java
 * @Description		: 게시글 댓글 관리를 위한 ServiceImpl
 * @author 허진영
 * @since 2016.04.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since		   author				  description
 *   ==========    ==============    =============================
 *   2016.04.12		   허진영				   최초 생성
 * </pre>
 */
@Service("bMABoardCommentService")
public class BMABoardCommentServiceImpl extends EmfAbstractService implements BMABoardCommentService {

	@Resource(name="bMABoardCommentDAO")
	private BMABoardCommentDAO bMABoardCommentDAO;

	@Resource(name="BoardCommentIdgen")
	private EgovTableIdGnrService boardCommentIdgen;		
    
	/**
	 * 게시글에 대한 댓글을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectBoardCommentList(EmfMap emfMap) throws Exception
	{
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);
		
		//리스트 가져오기
		List<EmfMap> list = bMABoardCommentDAO.selectBoardCommentList(emfMap);
		
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
	 * 게시글에 대한 댓글을 등록한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertBoardComment(EmfMap emfMap) throws Exception
	{		
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		int idx = boardCommentIdgen.getNextIntegerId();
		
		emfMap.put("cidx", idx);
		emfMap.put("groupId", EMFStringUtil.nvl(emfMap.getString("groupId"), String.valueOf(idx)));
		emfMap.put("reDepth", EMFStringUtil.nvl(emfMap.getString("reDepth"), String.valueOf(0)));
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regNm", lgnMap.getString("name"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modNm", lgnMap.getString("name"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));

  		bMABoardCommentDAO.insertBoardComment(emfMap);
	}
	
	/**
	 * 게시글에 대한 댓글을 수정한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateBoardComment(EmfMap emfMap) throws Exception
	{		
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modNm", lgnMap.getString("name"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
  		bMABoardCommentDAO.updateBoardComment(emfMap);
	}
	
	/**
	 * 게시글에 대한 댓글을 삭제한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void deleteBoardComment(EmfMap emfMap) throws Exception
	{		
  		bMABoardCommentDAO.deleteBoardComment(emfMap);
	}
	
	/**
	 * 댓글 숨기기(상태값 변경)
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateBoardStatus(EmfMap emfMap) throws Exception
	{		
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modNm", lgnMap.getString("name"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
  		bMABoardCommentDAO.updateBoardStatus(emfMap);
	}
	
	/**
	 *  게시글에 대한 댓글을 조회한다. (엑셀 다운로드)
	 * 
	 * @param EmfMap    
	 * @return EmfMap  
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> excelBoardCommentList(EmfMap emfMap) throws Exception 
	{
		return bMABoardCommentDAO.excelBoardCommentList(emfMap);
	}
}
