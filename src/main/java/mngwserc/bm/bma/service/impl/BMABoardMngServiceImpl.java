/**
 * 
 */
package mngwserc.bm.bma.service.impl;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.bm.bma.service.BMABoardMngService;
import mngwserc.bm.bma.service.dao.BMABoardMngDAO;
import mngwserc.co.util.COPaginationUtil;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 게시판 관리 ServiceImpl
 * </pre>
 * 
 * @ClassName		: BMABoardMngServiceImpl
 * @Description		: 게시판 관리 ServiceImpl
 * @author 안진용
 * @since 2015. 11. 24.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015. 11. 24.		안진용					최초생성
 * </pre>
 */
@Service("bMABoardMngService")
public class BMABoardMngServiceImpl extends EmfAbstractService implements BMABoardMngService 
{
	@Resource(name="bMABoardMngDAO")
	private BMABoardMngDAO bMABoardMngDAO;
	
	@Resource(name="EgovFileMngService")
    private EgovFileMngService fileMngService;
	
	@Resource(name="BoardIdgen")
	private EgovTableIdGnrService boardIdgen;		
	
	private String ENCODE = EgovProperties.getProperty("Global.CHARCODE");
	
	/**
	 * 게시판 속성정보 한 건을 상세조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectMaster(EmfMap emfMap) throws Exception
	{
		return bMABoardMngDAO.selectMaster(emfMap);
	}    

	/**
	 * 게시판 속성정보기반으로 데이터를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectBoardList(EmfMap emfMap) throws Exception
	{
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);

		//공지리스트 가져오기
		emfMap.put("noticeList", bMABoardMngDAO.selectNoticeBoardList(emfMap));
				
		//리스트 가져오기
		List<EmfMap> list = bMABoardMngDAO.selectBoardList(emfMap);
		
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
	 *  게시물에 상세정보를 조회한다.
	 * 
	 * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */  	
  	public EmfMap selectBoardRead(EmfMap emfMap) throws Exception
  	{
  		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("idx"))))
  		{
  			EmfMap boardInfo = bMABoardMngDAO.selectBoardRead(emfMap);
  			
  			if(boardInfo != null)
  			{
  				emfMap.put("boardInfo", boardInfo);
  				
  				if(!"".equals(EMFStringUtil.nullConvert(boardInfo.get("atchFileId"))))
  				{
  					emfMap.put("atchFileList", fileMngService.selectFileInfs(boardInfo));
  				}
  				
  				String communityType = EMFStringUtil.nullConvert(emfMap.getString("communityType"));
  				
  				if( ("PHOTO".equals(communityType) || "PHOTOLIST".equals(communityType) || "EVENT".equals(communityType) ) && !"".equals(EMFStringUtil.nullConvert(boardInfo.get("thumnailFileId"))))
  				{
  					emfMap.put("atchFileId", boardInfo.getString("thumnailFileId"));
  					
  					emfMap.put("thumFileList", fileMngService.selectFileInfs(emfMap));
  				}
  				
  				if(!"".equals(EMFStringUtil.nullConvert(boardInfo.get("contentsFileId"))))
  				{
  					emfMap.put("atchFileId", boardInfo.getString("contentsFileId"));
  					
  					emfMap.put("contentsFileList", fileMngService.selectFileInfs(emfMap));
  				}
  				
  				//이전글 다음글 가져오기
				emfMap.put("prevBoardMap", bMABoardMngDAO.selectBoardPrev(emfMap));
				emfMap.put("nextBoardMap", bMABoardMngDAO.selectBoardNext(emfMap));
				
				//불량단어 필터링
				if(!"".equals(EgovStringUtil.nullConvert(emfMap.getString("poorWordNm"))))
				{
					boardInfo.put("contents", EgovStringUtil.wordfilter(boardInfo.getString("contents"), emfMap.getString("poorWordNm")));
				}
  			}
  		}
		
  	    return emfMap;  		
  	}  	

	/**
	 * 게시물을 등록한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertBoardArticle(EmfMap emfMap) throws Exception
	{		
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("idx", boardIdgen.getNextIntegerId());
		emfMap.put("notifyYn", EMFStringUtil.nvl(emfMap.getString("notifyYn"), "N"));
		emfMap.put("openYn", EMFStringUtil.nvl(emfMap.getString("openYn"), "Y"));
		emfMap.put("odtmYn", EMFStringUtil.nvl(emfMap.getString("odtmYn"), "N"));
		emfMap.put("useYn", EMFStringUtil.nvl(emfMap.getString("useYn"), "Y"));
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regNm", lgnMap.getString("name"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modNm", lgnMap.getString("name"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		bMABoardMngDAO.insertBoardArticle(emfMap);		
	}
	
	/**
	 * 게시물을 수정한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateBoardArticle(EmfMap emfMap) throws Exception
	{		
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("notifyYn", EMFStringUtil.nvl(emfMap.getString("notifyYn"), "N"));
		emfMap.put("openYn", EMFStringUtil.nvl(emfMap.getString("openYn"), "Y"));
		emfMap.put("odtmYn", EMFStringUtil.nvl(emfMap.getString("odtmYn"), "N"));
		emfMap.put("useYn", EMFStringUtil.nvl(emfMap.getString("useYn"), "Y"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modNm", lgnMap.getString("name"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		bMABoardMngDAO.updateBoardArticle(emfMap);
	}

	/**
	 * 게시글 삭제한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void deleteBoardMulti(EmfMap emfMap, int[] delidx) throws Exception
	{
		emfMap.put("delidx", delidx);

		bMABoardMngDAO.deleteBoardMulti(emfMap);
	}  	
  	  	
	/**
	 * 게시글 승인 / 미승인처리한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void blindBoardMulti(EmfMap emfMap, int[] delidx) throws Exception
	{
		emfMap.put("delidx", delidx);
		
		bMABoardMngDAO.blindBoardMulti(emfMap);
	}
}