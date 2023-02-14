package mngwserc.co.cob.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import emf.core.extend.dao.EmfAbstractDAO;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 로그인 DAO 구현
 * </pre>
 * 
 * @ClassName		: COBLgnDAO.java
 * @Description		: 로그인 DAO 구현
 * @author 박주석
 * @since 2015.11.02
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.02		박주석					최초생성
 * </pre>
 */
@Repository("cOBLgnDAO")
public class COBLgnDAO extends EmfAbstractDAO {
    
	/**
	 * 일반 로그인을 처리한다
	 * @param EmfMap
	 * @return EmfMap
	 * @exception 지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public EmfMap actionLogin(EmfMap emfMap) throws Exception
    {
    	EmfMap rtnMap = null;
    	
    	Object rtnObject = selectByPk("COBLgnDAO.actionLogin", emfMap);
    	
    	if(rtnObject != null)
    	{
    		rtnMap = (EmfMap)rtnObject;
    	}
    	
    	return rtnMap;
    }
    
    public EmfMap selectMemLgnCnt(String id) throws Exception {
    	return (EmfMap) selectByPk("COBLgnDAO.selectMemLgnCnt", id);
    }
    
    public void insertMemLgnCnt(EmfMap emfMap) throws Exception {
    	insert("COBLgnDAO.insertMemLgnCnt", emfMap);
    }
    
    public void updateMemLgnCnt(EmfMap emfMap) throws Exception {
    	update("COBLgnDAO.updateMemLgnCnt", emfMap);
    }
    
    /**
	 * 로그인 처리에따른 시간을 업데이트한다.
	 * @param EmfMap
	 * @return EmfMap
	 * @exception 지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public void setLgnLstDtm(EmfMap emfMap) throws Exception
    {
    	update("COBLgnDAO.setLgnLstDtm", emfMap);
    }
    
    /**
   	 * 비밀번호를 변경한다.
   	 * @param EmfMap
   	 * @return EmfMap
   	 * @exception 지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
   	 */
	public void setPwdChng(EmfMap emfMap) throws Exception
	{
		update("COBLgnDAO.setPwdChng", emfMap);
	}
    
    /**
	 * 로그인 처리에따른 메뉴를 가져온다.
	 * @param EmfMap
	 * @return EmfMap
	 * @exception 지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
    public List<EmfMap> getMenuList(EmfMap emfMap) throws Exception
    {
    	return list("COBLgnDAO.getMenuList", emfMap);
    }
    
    /**
	 * 상위 부모의 메뉴를 가져온다.
	 * @param EmfMap
	 * @return EmfMap
	 * @exception Exception
	 */
    public List<EmfMap> getParentMenuList(int pageNo) throws Exception
    {
    	return list("COBLgnDAO.getParentMenuList", pageNo);
    }

	public void setAdmAuthLog(EmfMap emfMap) throws Exception{
		insert("COBLgnDAO.setAdmAuthLog", emfMap);
	}

	public void setAdmAuth(EmfMap emfMap) throws Exception{
		insert("COBLgnDAO.setAdmAuth", emfMap);
	}


    /**
     * 섹션 삭제 및 로그아웃 처리
     * @param emfMap
     * @throws Exception
     */
	public void setAdmAuthLogOut(EmfMap emfMap) throws Exception {
		update("COBLgnDAO.setAdmAuthLogOut", emfMap);
	}

	/**
	 * 아이디의 가장 최근에 로그인한 시퀀스 조회
	 * @param emfMap
	 * @return
	 */
	public EmfMap getMaxLogId(EmfMap emfMap) {
    	EmfMap rtnMap = null;
    	
    	Object rtnObject = selectByPk("COBLgnDAO.getMaxLogId", emfMap);
    	
    	if(rtnObject != null)
    	{
    		rtnMap = (EmfMap)rtnObject;
    	}
    	
    	return rtnMap;
	}

	public int updateInfo(EmfMap infoMap) {
		
		return update("COBLgnDAO.updateInfo", infoMap);
		
	}
}
