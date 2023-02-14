package mngwserc.om.omf.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.util.COPaginationUtil;
import mngwserc.om.omf.service.OMFOutsourcingPageMngService;
import mngwserc.om.omf.service.dao.OMFOutsourcingPageMngDAO;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.idgnr.impl.EgovTableIdGnrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 외주업체 페이지 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: OMFOutsourcingPageMngServiceImpl.java
 * @Description		: 외주업체 페이지 관리를 위한 ServiceImpl
 * @author 김필기
 * @since 2016.05.16
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.05.16		김필기					 최초생성
 * </pre>
 */ 
@Service("oMFOutsourcingPageMngService")
public class OMFOutsourcingPageMngServiceImpl extends EmfAbstractService implements OMFOutsourcingPageMngService {
	
	@Resource(name="oMFOutsourcingPageMngDAO")
	private OMFOutsourcingPageMngDAO oMFOutsourcingPageMngDAO;
	
	@Resource(name="EgovCmmUseService")
    private EgovCmmUseService cmmUseService;	

	@Resource(name="outsourcingPageMstIdgen")
	private EgovTableIdGnrService outsourcingPageMstIdgen;

	/**
     * 외주업체 코드별 관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOutsourcingPageMngList(EmfMap emfMap) throws Exception
    {
    	PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
    	
    	//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);    	
		
		//리스트 가져오기
		List<EmfMap> dataList = oMFOutsourcingPageMngDAO.selectOutsourcingPageMngList(emfMap);

		emfMap.put("list", dataList);

		if(dataList.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(dataList.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}    	
    	
		return emfMap;
    }
    
    /**
     * 외주업체 코드별 관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOutsourcingPageMngInfo(EmfMap emfMap) throws Exception
    {
    	if(!"".equals(emfMap.getString("seq")))
    	{
    		EmfMap info = oMFOutsourcingPageMngDAO.selectOutsourcingPageMngInfo(emfMap);
        	
        	if(info != null)
        	{
            	emfMap.put("info", info);
        	}
    	}
    	
    	return emfMap;
    }

    /**
     * 외주업체 코드별 관리 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOutsourcingCode(EmfMap emfMap) throws Exception
    {
		ArrayList<String> cdDtlList = new ArrayList<String>();
		
		cdDtlList.add("OUTSOURCING");

    	return cmmUseService.selectCmmCodeBindAll(cdDtlList);
    }
    
    /**
     * 외주업체 페이지 관리 정보를 저장한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
//    public void insertOutsourcingPageMngInf(EmfMap emfMap) throws Exception
    public void iopmi(EmfMap emfMap) throws Exception
    {
    	emfMap.put("overrapChk", "Y");
    	
    	EmfMap info = oMFOutsourcingPageMngDAO.selectOutsourcingPageMngInfo(emfMap);
    	if(info == null)
    	{
        	emfMap.put("seq", outsourcingPageMstIdgen.getNextIntegerId());
        	emfMap.put("b2bCd", emfMap.getString("b2bCd").toUpperCase());
        	oMFOutsourcingPageMngDAO.insertOutsourcingPageMngInf(emfMap);
        	makeFile(EgovProperties.getProperty("Globals.outsourcingRootPath") + "/oca/OCAOutsourcingWrite"+emfMap.getString("oscCd")+".jsp", "");
    	}
    	else
    	{
    		throw new Exception("외주업체 코드 중복 등록");
    	}
    }

    /**
     * 외주업체 페이지 관리 정보를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
//    public void updateOutsourcingPageMngInf(EmfMap emfMap) throws Exception
    public void uopm(EmfMap emfMap) throws Exception
    {
    	System.out.println("Service Start --------------------------------------------------");
    	oMFOutsourcingPageMngDAO.updateOutsourcingPageMngInf(emfMap);
    	System.out.println("Service end --------------------------------------------------");
    }
    
	public void makeFile(String filePath, String data) throws IOException
	{
		//템플릿 파일 위치
		String templateFilePath = EgovProperties.getProperty("Globals.outsourcingRootPath") + "/template.jsp";

		StringBuffer templateJsp = new StringBuffer();	 
		String line = null;
		BufferedReader br = null;
		
		try
		{
	        br = new BufferedReader(new InputStreamReader(new FileInputStream(templateFilePath), "UTF-8"));
	        
	        while((line=br.readLine()) != null)
	        {
	        	templateJsp.append(line).append("\n");
	        }
	        
	        br.close();
	        br = null;
	        line = null;
	        
	        BufferedWriter jspFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
			jspFile.write(templateJsp.toString().replace("$contents$", data));
			jspFile.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(br != null) br.close();
		}
	}    
}
