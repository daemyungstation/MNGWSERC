/**
 * 
 */
package mngwserc.bm.bma.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 게시판 관리 DAO
 * </pre>
 * 
 * @ClassName		: BMABoardMngDAO
 * @Description		: 게시판 관리 DAO
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

@Repository("bMABoardMngDAO")
public class BMABoardMngDAO extends EmfAbstractDAO {

    /**
     * 게시판 속성정보 한 건을 상세조회 한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public EmfMap selectMaster(EmfMap emfMap) throws Exception
    {
    	return (EmfMap) selectByPk("BMABoardMngDAO.selectMaster", emfMap);
    }
    
    /**
	 * 게시판 속성정보기반으로 공지사항 데이터를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectNoticeBoardList(EmfMap emfMap) throws Exception
	{
		return list("BMABoardMngDAO.selectNoticeBoardList", emfMap);
	}
    
	/**
	 * 게시판 속성정보기반으로 데이터를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> selectBoardList(EmfMap emfMap) throws Exception
	{
		return list("BMABoardMngDAO.selectBoardList", emfMap);
	}    

    /**
     * 게시물 한 건에 대하여 상세 내용을 조회 한다.
     * 
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public EmfMap selectBoardRead(EmfMap emfMap) throws Exception
    {
    	return (EmfMap) selectByPk("BMABoardMngDAO.selectBoardRead", emfMap);
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
		insert("BMABoardMngDAO.insertBoardArticle", emfMap);
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
		update("BMABoardMngDAO.updateBoardArticle", emfMap);
	}
	
	/**
	 * 해당 게시물에 이전글 조회한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public EmfMap selectBoardPrev(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("BMABoardMngDAO.selectBoardPrev", emfMap);
    }
    
	/**
	 * 해당 게시물에 다음글 조회한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public EmfMap selectBoardNext(EmfMap emfMap) throws Exception 
    {
    	return (EmfMap) selectByPk("BMABoardMngDAO.selectBoardNext", emfMap);
    }

	/**
	 * 게시글 삭제한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void deleteBoardMulti(EmfMap emfMap) throws Exception
	{
		update("BMABoardMngDAO.deleteBoardMulti", emfMap);
	}
	
	/**
	 * 게시글 승인 / 미승인처리 (블라인드)
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void blindBoardMulti(EmfMap emfMap) throws Exception
	{
		update("BMABoardMngDAO.blindBoardMulti", emfMap);
	}	
}