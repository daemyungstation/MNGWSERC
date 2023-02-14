package mngwserc.co.cod.service.impl;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.cod.service.CODMenuService;
import mngwserc.co.cod.service.dao.CODMenuDAO;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 메뉴 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: CODMenuServiceImpl.java
 * @Description		: 메뉴 관리를 위한 ServiceImpl
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
@Service("cODMenuService")
public class CODMenuServiceImpl extends EmfAbstractService implements CODMenuService 
{
	@Resource(name="cODMenuDAO")
	private CODMenuDAO cODMenuDAO;
	
	@Resource(name="menuIdgen")
	private EgovTableIdGnrService menuIdgen;
	
	/**
	 * 관리자 메뉴 리스트를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getMenuList(EmfMap emfMap) throws Exception
	{
		return cODMenuDAO.getMenuList(emfMap);
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
		return cODMenuDAO.selectMenuDtl(emfMap);
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
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		int menuSeq = menuIdgen.getNextIntegerId();
		
		emfMap.put("menuSeq", menuSeq);
		
		if("cms".equals(emfMap.getString("menuGb")))
		{			
			emfMap.put("admLink", "/mngwserc/contentsid/"+menuSeq+"/index.do");
		}
		
		emfMap.put("rhtVal", cODMenuDAO.getRhtVal(emfMap));
		emfMap.put("dpth", cODMenuDAO.getDpth(emfMap));
		
		cODMenuDAO.setLftVal(emfMap);
		cODMenuDAO.setRhtVal(emfMap);
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cODMenuDAO.insertMenu(emfMap);
		
		return menuSeq;
	}
	
	/**
	 * 메뉴명을 수정한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int updateMenuNm(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		return cODMenuDAO.updateMenuNm(emfMap);
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
		int rtnCnt = 0;
		
		EmfMap menuDtlMap = cODMenuDAO.selectMenuDtl(emfMap);
		
		if(menuDtlMap != null)
		{
			rtnCnt = cODMenuDAO.deleteMenu(menuDtlMap);
			
			cODMenuDAO.setDeleteUpdateLftVal(menuDtlMap);
			cODMenuDAO.setDeleteUpdateRhtVal(menuDtlMap);
			cODMenuDAO.setDeleteUpdatePstn(menuDtlMap);
		}
		
		return rtnCnt;
	}
	
	/**
	 * 메뉴를 이동한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateMenuPstn(EmfMap emfMap) throws Exception
	{
		String sqlStr1 = "";
		String sqlStr2 = "";
		String sqlStr3 = "";
		String sqlStr4 = "";
		String sqlStr5 = "";
		String sqlStr6 = "";
		String sqlStr7 = "";
		String sqlStr8 = "";
		String sqlStr9 = "";
		String sqlStr10 = "";
		String sqlStr11 = "";
		String node_ids = "";
		
		int MaxPosition = 0;
		
		int node_parntSeq = 0;
		int node_pstn = 0;
		int node_lftVal = 0;
		int node_rhtVal = 0;
		int node_dpth = 0;
		
		int refNode_parntSeq = 0;
		int refNode_pstn = 0;
		int refNode_lftVal = 0;
		int refNode_rhtVal = 0;
		int refNode_dpth = 0;
		
		int ndif = 2;
		int ref_ind = 0;
		int self = 0;
		int ldif = 0;
		int idif = 0;
		
		int menuSeq = Integer.parseInt(emfMap.getString("menuSeq"));
		int pstn = Integer.parseInt(emfMap.getString("pstn"));
		int refSeq = Integer.parseInt(emfMap.getString("refSeq"));
		int isCopy = Integer.parseInt(emfMap.getString("isCopy"));
		
		//현재 트리
		EmfMap currMenuMap = cODMenuDAO.selectMenuDtl(emfMap);
		
		//이동할 트리
		EmfMap tmpMap = new EmfMap();
		tmpMap.put("menuSeq", refSeq);
		
		EmfMap refMap = cODMenuDAO.selectMenuDtl(tmpMap);
		
		node_parntSeq = Integer.parseInt(currMenuMap.getString("parntSeq"));
		node_pstn = Integer.parseInt(currMenuMap.getString("pstn"));
		node_lftVal = Integer.parseInt(currMenuMap.getString("lftVal"));
		node_rhtVal = Integer.parseInt(currMenuMap.getString("rhtVal"));
		node_dpth = Integer.parseInt(currMenuMap.getString("dpth"));
		
		refNode_parntSeq = Integer.parseInt(refMap.getString("parntSeq"));
		refNode_pstn = Integer.parseInt(refMap.getString("pstn"));
		refNode_lftVal = Integer.parseInt(refMap.getString("lftVal"));
		refNode_rhtVal = Integer.parseInt(refMap.getString("rhtVal"));
		refNode_dpth = Integer.parseInt(refMap.getString("dpth"));
		
		if(node_lftVal > 0)
		{
			EmfMap exitMap = new EmfMap();
			exitMap.put("lftVal", node_lftVal);
			exitMap.put("rhtVal", node_rhtVal);
			exitMap.put("refSeq", refSeq);
			
			Integer exitMenuSeq = moveExits(exitMap);
			
			if(exitMenuSeq != null)
			{
				return;
			}
			
			EmfMap nodeIdsMap = new EmfMap();
			nodeIdsMap.put("lftVal", node_lftVal);
			nodeIdsMap.put("rhtVal", node_rhtVal);
			
			List<EmfMap> moveNodeIds = getMoveNodeIdx(nodeIdsMap);
			
			for(int q = 0; q < moveNodeIds.size(); q++)
			{
				EmfMap moveNodeIdMap = moveNodeIds.get(q);
				
				if("".equals(node_ids))
				{
					node_ids = moveNodeIdMap.getString("menuSeq");
				}
				else
				{
					node_ids = node_ids + "," + moveNodeIdMap.getString("menuSeq");
				}
			}
			
			ndif = node_rhtVal - node_lftVal + 1;
		}
		
		if("".equals(node_ids))
		{
			node_ids = "0";
		}
		
		EmfMap maxMap = new EmfMap();
		maxMap.put("refSeq", refSeq);
		
		MaxPosition = maxPosition(maxMap);
		
		if(pstn >= MaxPosition)
		{
			pstn = MaxPosition;
		}
		
		if(node_lftVal > 0 && isCopy == 0)
		{
			sqlStr1 = "UPDATE CO_MENU_MST SET PSTN = PSTN - 1 WHERE PARNT_SEQ = " + node_parntSeq + " AND PSTN  > " + node_pstn;
			sqlStr2 = "UPDATE CO_MENU_MST SET LFT_VAL = LFT_VAL - " + ndif + " WHERE LFT_VAL > " + node_rhtVal;
			sqlStr3 = "UPDATE CO_MENU_MST SET RHT_VAL = RHT_VAL - " + ndif + " WHERE RHT_VAL > " + node_lftVal +" AND MENU_SEQ NOT IN (" + node_ids + ")";
		}
		
		if(isCopy == 0)
		{
			sqlStr4 = "UPDATE CO_MENU_MST SET PSTN = PSTN + 1 WHERE PARNT_SEQ = " + refSeq + " AND PSTN >= " + pstn + " AND MENU_SEQ NOT IN (" + node_ids + ")";
		}
		else
		{
			sqlStr5 = "UPDATE CO_MENU_MST SET PSTN = PSTN + 1 WHERE PARNT_SEQ = " + refSeq + " AND PSTN >= " + pstn;
		}			
						
		if(refSeq != 0)
		{
			ref_ind = refNode_rhtVal;
		}
		
		if(ref_ind < 1)
		{
			ref_ind = 1;
		}
		
		if(node_lftVal > 0 && isCopy == 0 && node_parntSeq == refSeq && pstn > node_pstn)
		{
			self = 1;
		}
		
		EmfMap moveExitsMap = new EmfMap();
		moveExitsMap.put("self", self);
		moveExitsMap.put("pstn", pstn);
		moveExitsMap.put("refSeq", refSeq);

		Integer moveExits2 = moveExits2(moveExitsMap);
		
		if(moveExits2 != 0)
		{
			ref_ind = getRefInd(moveExitsMap);
		}
		
		if(node_lftVal > 0 && isCopy == 0 && node_lftVal < ref_ind)
		{
			ref_ind = ref_ind - ndif;
		}

		if(isCopy == 0) 
		{
			sqlStr6 = "UPDATE CO_MENU_MST SET LFT_VAL = LFT_VAL + " + ndif + " WHERE LFT_VAL >= " + ref_ind + " AND MENU_SEQ NOT IN (" + node_ids + ")";
			sqlStr7 = "UPDATE CO_MENU_MST SET RHT_VAL = RHT_VAL + " + ndif + " WHERE RHT_VAL >= " + ref_ind + " AND MENU_SEQ NOT IN (" + node_ids + ")";
		}
		else
		{
			sqlStr8 = "UPDATE CO_MENU_MST SET LFT_VAL = LFT_VAL + " + ndif + " WHERE LFT_VAL >= " + ref_ind;
			sqlStr9 = "UPDATE CO_MENU_MST SET RHT_VAL = RHT_VAL + " + ndif + " WHERE RHT_VAL >= " + ref_ind;
		}
		
		if(refSeq != 0)
		{
			ldif = refNode_dpth + 1;
		}
		
		idif = ref_ind;
		
		if(node_lftVal > 0)
		{
			ldif = node_dpth - (refNode_dpth + 1);
			idif = node_lftVal - ref_ind;
			
			if(isCopy == 0) 
			{
				sqlStr10 = "UPDATE CO_MENU_MST SET PARNT_SEQ = " + refSeq + ", PSTN = " + pstn + " WHERE MENU_SEQ = " + menuSeq;
				sqlStr11 = "UPDATE CO_MENU_MST SET LFT_VAL = LFT_VAL - " + idif + ", RHT_VAL = RHT_VAL - " + idif + ", DPTH = DPTH - " + ldif + " WHERE MENU_SEQ IN (" + node_ids + ")";
			}
		}
		
		if(!"".equals(sqlStr1))
		{
		    EmfMap param1 = new EmfMap();
		    param1.put("node_parntSeq", node_parntSeq);
		    param1.put("node_pstn", node_pstn);
		    setMenuMove(sqlStr1);
		}		   
		if(!"".equals(sqlStr2))
		{
			EmfMap param2 = new EmfMap();
			param2.put("ndif", ndif);
			param2.put("node_rhtVal", node_rhtVal);
			setMenuMove(sqlStr2);
		}		   
		if(!"".equals(sqlStr3))
		{
			EmfMap param3 = new EmfMap();
			param3.put("ndif", ndif);
			param3.put("node_lftVal", node_lftVal);
			param3.put("node_ids", node_ids);
			setMenuMove(sqlStr3);
		}		   
		if(!"".equals(sqlStr4))
		{
			EmfMap param4 = new EmfMap();
			param4.put("refSeq", refSeq);
			param4.put("pstn", pstn);
			param4.put("node_ids", node_ids);
			setMenuMove(sqlStr4);
		}
		if(!"".equals(sqlStr5))
		{
			EmfMap param5 = new EmfMap();
			param5.put("refSeq", refSeq);
			param5.put("pstn", pstn);
			setMenuMove(sqlStr5);
		}		   
		if(!"".equals(sqlStr6))
		{
			EmfMap param6 = new EmfMap();
			param6.put("ndif", ndif);
			param6.put("ref_ind", ref_ind);
			param6.put("node_ids", node_ids);
			setMenuMove(sqlStr6);
		}
		if(!"".equals(sqlStr7))
		{
			EmfMap param7 = new EmfMap();
			param7.put("ndif", ndif);
			param7.put("ref_ind", ref_ind);
			param7.put("node_ids", node_ids);
			setMenuMove(sqlStr7);
		}		   
		if(!"".equals(sqlStr8))
		{
		   	EmfMap param8 = new EmfMap();
		   	param8.put("ndif", ndif);
		   	param8.put("ref_ind", ref_ind);
		   	setMenuMove(sqlStr8);
		}		   
		if(!"".equals(sqlStr9))
		{
		   	EmfMap param9 = new EmfMap();
		   	param9.put("ndif", ndif);
		   	param9.put("ref_ind", ref_ind);
		   	param9.put("node_ids", node_ids);
		   	setMenuMove(sqlStr9);
		}		   
		if(!"".equals(sqlStr10))
		{
		   	EmfMap param10 = new EmfMap();
		   	param10.put("refSeq", refSeq);
		   	param10.put("pstn", pstn);
		   	param10.put("menuSeq", menuSeq);
		   	setMenuMove(sqlStr10);
		}		   
		if(!"".equals(sqlStr11))
		{
			EmfMap param11 = new EmfMap();
			param11.put("idif", idif);
			param11.put("ldif", ldif);
			param11.put("node_ids", node_ids);
			setMenuMove(sqlStr11);
		}	
	}
	
	/**
	 * 메뉴를 이동한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	private void setMenuMove(String sql) throws Exception
	{    	
		cODMenuDAO.setMenuMove(sql);
    }
	
	/**
	 * 메뉴순번을 가져온다.
	 * 
	 * @param Map 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public Integer moveExits(EmfMap emfMap) throws Exception
	{    	
    	return cODMenuDAO.getMoveExits(emfMap);
    }
	
	/**
	 * 하위메뉴들을 가져온다.
	 * 
	 * @param Map 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getMoveNodeIdx(EmfMap emfMap) throws Exception
	{    	
		return cODMenuDAO.getMoveNodeIds(emfMap);
    }
	
	/**
	 * 최상위 position을 가져온다.
	 * 
	 * @param Map 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public int maxPosition(EmfMap emfMap) throws Exception
	{    	
    	return cODMenuDAO.getMaxPosition(emfMap);
    }
	
	/**
	 * 하위메뉴갯수를 가져온다.
	 * 
	 * @param Map 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public Integer moveExits2(EmfMap emfMap) throws Exception
	{    	
    	return cODMenuDAO.getMoveExits2(emfMap);
    }	
	
	/**
	 * 하위메뉴갯수를 가져온다.
	 * 
	 * @param Map 검색할 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public Integer getRefInd(EmfMap vo) throws Exception
	{    	
		return cODMenuDAO.getRefInd(vo);
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
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();

		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		return cODMenuDAO.updateMenuInf(emfMap);
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
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		return cODMenuDAO.updateUserUseYn(emfMap);
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
		return cODMenuDAO.getParntData(emfMap);
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
		return cODMenuDAO.getChildData(emfMap);
	}
}
