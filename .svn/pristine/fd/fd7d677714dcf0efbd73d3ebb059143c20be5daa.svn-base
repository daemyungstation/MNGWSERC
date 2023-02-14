package mngwserc.co.cod.service.dao;

import java.util.List; 



import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 메뉴 관리를 위한 DAO
 * </pre>
 * 
 * @ClassName		: CODMenuDAO.java
 * @Description		: 메뉴 관리를 위한 DAO
 * @author 박주석
 * @since 2015.11.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.12		박주석					최초생성
 * </pre>
 */
@Repository("cODMenuDAO")
public class CODMenuDAO extends EmfAbstractDAO
{	
	/**
	 * 관리자 메뉴 리스트를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getMenuList(EmfMap emfMap) throws Exception
	{ 
		return list("CODMenuDAO.getMenuList", emfMap);
	}
	
	/**
	 * 메뉴의 상세정보를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectMenuDtl(EmfMap emfMap) throws Exception
	{
		EmfMap menuDtlMap = null;
		
		Object menuDtlObj = selectByPk("CODMenuDAO.selectMenuDtl", emfMap);
		
		if(menuDtlObj != null)
		{
			menuDtlMap = (EmfMap) menuDtlObj;
		}
		
		return menuDtlMap;
	}
	
	/**
	 * 해당 메뉴의 오른쪽 값을 가져온다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return int
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int getRhtVal(EmfMap emfMap) throws Exception
	{
		return (Integer)selectByPk("CODMenuDAO.getRhtVal", emfMap);
	}	
	
	/**
	 * 해당 메뉴의 깊이를 가져온다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return int
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int getDpth(EmfMap emfMap) throws Exception
	{
		return (Integer)selectByPk("CODMenuDAO.getDpth", emfMap);
	}	
	
	/**
	 * 해당 메뉴의 왼쪽 값을 지정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void setLftVal(EmfMap emfMap) throws Exception
	{
		update("CODMenuDAO.setLftVal", emfMap);
	}
	
	/**
	 * 해당 메뉴의 오른쪽 값을 지정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void setRhtVal(EmfMap emfMap) throws Exception
	{
		update("CODMenuDAO.setRhtVal", emfMap);
	}
	
	/**
	 * 메뉴를 추가한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int insertMenu(EmfMap emfMap) throws Exception
	{
		return insert("CODMenuDAO.insertMenu", emfMap);
	}
	
	/**
	 * 메뉴명을 수정한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int updateMenuNm(EmfMap emfMap) throws Exception
	{
		return update("CODMenuDAO.updateMenuNm", emfMap);
	}
	
	/**
	 * 메뉴를 삭제한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int deleteMenu(EmfMap emfMap) throws Exception
	{
		return delete("CODMenuDAO.deleteMenu", emfMap);
	}
	
	/**
	 * 메뉴의 하위노드 왼쪽키값 변경
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void setDeleteUpdateLftVal(EmfMap emfMap) throws Exception
	{
		update("CODMenuDAO.setDeleteUpdateLftVal", emfMap);
	}
	
	/**
	 * 메뉴의 하위노드 오른쪽키값 변경
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void setDeleteUpdateRhtVal(EmfMap emfMap) throws Exception
	{
		update("CODMenuDAO.setDeleteUpdateRhtVal", emfMap);
	}
	
	/**
	 * 메뉴의 하위노드 위치 변경
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void setDeleteUpdatePstn(EmfMap emfMap) throws Exception
	{
		update("CODMenuDAO.setDeleteUpdatePstn", emfMap);
	}
	
	/**
	 * 메뉴를 이동한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void setMenuMove(String sql) throws Exception
	{
		update("CODMenuDAO.setMenuMove", sql);
	}	
	
	/**
	 * 메뉴 자식의 갯수를 가져온다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public Integer getMoveExits(EmfMap emfMap) throws Exception
	{
		return (Integer)selectByPk("CODMenuDAO.getMoveExits", emfMap);
	}
	
	/**
	 * 하위 트리들을 가져온다.
	 * 
	 * @param Map 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getMoveNodeIds(EmfMap emfMap) throws Exception
	{
		return list("CODMenuDAO.getMoveNodeIds", emfMap);
	}
	
	/**
	 * 최상위 position을 가져온다.
	 * 
	 * @param Map 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public Integer getMaxPosition(EmfMap emfMap) throws Exception
	{
		return (Integer)selectByPk("CODMenuDAO.getMaxPosition", emfMap);
	}
	
	/**
	 * 움직일 노드 갯수 확인
	 * 
	 * @param Map 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public Integer getMoveExits2(EmfMap emfMap) throws Exception
	{
		return (Integer)selectByPk("CODMenuDAO.getMoveExits2", emfMap);
	}
	
	/**
	 * 하위트리갯수를 가져온다.
	 * 
	 * @param Map 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public Integer getRefInd(EmfMap vo) throws Exception
	{
		return (Integer)selectByPk("CODMenuDAO.getRefInd", vo);
	}
	
	/**
	 * 메뉴의 정보를 업데이트 한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int updateMenuInf(EmfMap emfMap) throws Exception
	{
		return update("CODMenuDAO.updateMenuInf", emfMap);
	}	
	
	/**
	 * 게시판 카테고리의 노출 정보를 수정
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int updateUserUseYn(EmfMap emfMap) throws Exception
	{
		return update("CODMenuDAO.updateUserUseYn", emfMap);
	}	
	
	/**
	 * 상위부모를 다 가져온다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getParntData(EmfMap emfMap) throws Exception
	{
		return list("CODMenuDAO.getParntData", emfMap);
	}	
	
	/**
	 * 하위노드를 다 가져온다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getChildData(EmfMap emfMap) throws Exception
	{
		return list("CODMenuDAO.getChildData", emfMap);
	}	
}
