package mngwserc.co.cog.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.cod.service.dao.CODMenuDAO;
import mngwserc.co.cog.service.COGCntnsMngService;
import mngwserc.co.cog.service.dao.COGCntnsMngDAO;
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
 * 컨텐츠 관리를 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: COGCntnsMngServiceImpl.java
 * @Description		: 컨텐츠 관리를 위한 ServiceImpl
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
@Service("cOGCntnsMngService")
public class COGCntnsMngServiceImpl extends EmfAbstractService implements COGCntnsMngService {
	
	@Resource(name="cODMenuDAO")
    private CODMenuDAO cODMenuDAO;	
	
	@Resource(name="cOGCntnsMngDAO")
	private COGCntnsMngDAO cOGCntnsMngDAO;

	@Resource(name="cOGCntnsMngProcess")
	private COGCntnsMngProcess cOGCntnsMngProcess;
	
	@Resource(name="cntnsIdgen")
	private EgovTableIdGnrService cntnsIdgen;

	static String rootDir  = EgovProperties.getProperty("Globals.contentsRootPath");	

	/**
	 * 컨텐츠 메뉴를 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectCntnsList(EmfMap emfMap) throws Exception
	{
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
		
		//페이징 처리
		emfMap.put("paginationInfo", paginationInfo);
		
		//리스트 가져오기
		List<EmfMap> list = cOGCntnsMngDAO.selectCntnsList(emfMap);
		
		emfMap.put("list", list);
		
		if(list.size() > 0)
		{
			paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
		}
		else
		{
			paginationInfo.setTotalRecordCount(0);
		}
		
		//연관 메뉴 가져오기
		List<EmfMap> relMenuList = cOGCntnsMngDAO.getRelMenuList(emfMap);
		
		emfMap.put("relMenuList", relMenuList);
		
		return emfMap;
	}
	
	/**
	 * 컨텐츠 상세내용을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectCntns(EmfMap emfMap) throws Exception
	{
		if(!"".equals(EMFStringUtil.nullConvert(emfMap.get("cntsSeq"))))
    	{
			EmfMap cntnsInfo = cOGCntnsMngDAO.selectCntns(emfMap);
			
			if(cntnsInfo != null)
			{
				emfMap.put("cntnsInfo", cntnsInfo);
				
				List<EmfMap> cntnsLogList = cOGCntnsMngDAO.selectCntnsLogList(emfMap);
				
				if(cntnsLogList.size() > 0)
				{
					emfMap.put("cntnsLogList", cntnsLogList);
				}
			}
    	}
		
		return emfMap;
	}
	
	/**
	 * 컨텐츠 메뉴를 등록한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertCntns(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("cntsSeq", cntnsIdgen.getNextIntegerId());
		emfMap.put("ver", cOGCntnsMngDAO.getCntnsVer(emfMap) + ".0");
		emfMap.put("regId", lgnMap.getString("id") );
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cOGCntnsMngDAO.insertCntns(emfMap);
	}
	
	/**
	 * 컨텐츠 메뉴를 수정한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateCntns(EmfMap emfMap) throws Exception
	{
		//컨텐츠 수정
		cOGCntnsMngDAO.updateCntns(emfMap);
		
		//수정로그 입력
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		cOGCntnsMngDAO.insertCntnsModLog(emfMap);	//로그 입력.	
	}	
	
	/**
	 * 컨텐츠 메뉴를 삭제한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void deleteCntns(EmfMap emfMap) throws Exception
	{
		cOGCntnsMngDAO.deleteCntns(emfMap);
	}

	/**
	 * 컨텐츠 메뉴를 일반복사한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertCopyCntns(EmfMap emfMap) throws Exception{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("copyCntsSeq", cntnsIdgen.getNextIntegerId());
		emfMap.put("copyMenuSeq", emfMap.getString("menuSeq"));
		emfMap.put("ver", cOGCntnsMngDAO.getCntnsVer(emfMap) + ".0");
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
	
		cOGCntnsMngDAO.insertCopyCntns(emfMap);
	}
	
	/**
	 * CMS 다중 복사시 CMS 리스트 팝업 내용
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return List<EmfMap> 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List<EmfMap> getCntnsList(EmfMap emfMap) throws Exception
	{
		return cOGCntnsMngDAO.getCntnsList(emfMap);
	}
	
	/**
	 * 컨텐츠 메뉴를 다중복사한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void insertMultiCopyCntns(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		emfMap.put("regId", lgnMap.getString("id"));
		emfMap.put("regIp", lgnMap.getString("loginIp"));
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));
		
		String menuSeqArr[] = emfMap.getString("menuSeqArr").split(",");
		
		EmfMap verMap = new EmfMap();
		
		if(menuSeqArr != null)
		{
			for(int i = 0; i < menuSeqArr.length; i++)
			{
				if(!"".equals(menuSeqArr[i]))
				{
					emfMap.put("copyCntsSeq", cntnsIdgen.getNextIntegerId());
					emfMap.put("copyMenuSeq", menuSeqArr[i]);
					verMap.put("menuSeq", menuSeqArr[i]);
					emfMap.put("ver", cOGCntnsMngDAO.getCntnsVer(verMap) + ".0");
					
					cOGCntnsMngDAO.insertCopyCntns(emfMap);					
				}
			}
		}
	}	
	
	/**
	 * 컨텐츠 승인한다.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateApprovalCntns(EmfMap emfMap) throws Exception
	{
		cOGCntnsMngDAO.updateApprovalContents(emfMap);
	}	

	/**
	 * 컨텐츠 승인시 컨텐츠 생성 로직.
	 * 
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void createApprovalCntns(EmfMap emfMap) throws Exception
	{
		String menuSeq = emfMap.getString("menuSeq");

		try
		{
			// 해당 컨텐츠를 배포중인 메뉴 가져오기
			List<EmfMap> relMenuList = cOGCntnsMngDAO.getRelMenuList(emfMap);
			
			if(relMenuList.size() > 0)
			{
				for(int i = 0; i < relMenuList.size(); i++)
				{
					EmfMap relMap = relMenuList.get(i);
					
					String url = relMap.getString("userLink");
					String filePath = rootDir + url.split("/contentsid/")[0] + "/" + menuSeq;

					File file = new File(filePath);
					if(!file.exists())
					{ 
						file.mkdirs(); 
					}

					File[] files = file.listFiles();
					
					if(files.length > 0)
					{
						// 파일 경로 셋팅
						String checkFilePath = filePath + "/index.jsp";

						// 변경될 파일 이름 셋팅
						String outFileName = "index_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

						// 파일 복사 실시
						cOGCntnsMngProcess.fileCopy(checkFilePath, checkFilePath.replace("index", outFileName));

						// 기존 index.jsp 파일을 삭제
						cOGCntnsMngProcess.fileDelete(checkFilePath);
					}
					
					// 현재 CMS ID에 대한 배포중인 CMS 정보 가져오기
					EmfMap cntnsInfo = cOGCntnsMngDAO.selectApprovalCntns(emfMap);
					
					// 컨텐츠 파일 생성
					cOGCntnsMngProcess.makeFile(filePath + "/index.jsp", cntnsInfo.getString("cntn"));
				}				
			}
		}
		catch(Exception e)
		{
			throw new Exception("CMS 생성 ERROR!!");
		}
	}
	
	/**
	 * 컨텐츠 생성로직
	 *
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
	public void createCntns(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
		
		int menuSeq = Integer.parseInt(emfMap.getString("menuSeq"));
		int cntsSeq = Integer.parseInt(emfMap.getString("refSeq"));

		//메뉴의 상세정보를 조회한다.
		EmfMap menuInf = cODMenuDAO.selectMenuDtl(emfMap);
		
		emfMap.put("modId", lgnMap.getString("id"));
		emfMap.put("modIp", lgnMap.getString("loginIp"));

		cODMenuDAO.updateMenuInf(emfMap);
		
		String prevUrl = menuInf.getString("userLink");		//DB에 저장된 URL
		String nextUrl = emfMap.getString("userLink");		//넘어온 URL
		
		if(prevUrl == null)
		{
			prevUrl = "";
		}
		
		if(nextUrl == null)
		{
			prevUrl = "";
		}
		
		try
		{
			if(prevUrl != "")
			{
				if(!prevUrl.equals(nextUrl))
				{
					String prevPath	= prevUrl.split("/contentsid/")[0] + "/" + cntsSeq;
					String changePath = nextUrl.split("/contentsid/")[0] + "/" + cntsSeq;
					
					// 기존 파일 이동
					cOGCntnsMngProcess.fileMove(prevPath, changePath);
				}			
			}
			
			// 파일 생성할 directory 셋팅
			if(nextUrl != "")
			{
				String filePath = rootDir + nextUrl.split("/contentsid/")[0] + "/" + cntsSeq;
				
				File file = new File(filePath);
				
				if(!file.exists())
				{ 
					file.mkdirs(); 
				}

				File[] files = file.listFiles();
				
				if(files.length > 0)
				{
					// 파일 경로 셋팅
					String checkFilePath = filePath + "/index.jsp";
					
					// 변경될 파일 이름 셋팅
					String outFileName = "index_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
					
					// 파일 복사 실시
					cOGCntnsMngProcess.fileCopy(checkFilePath,checkFilePath.replace("index", outFileName));
					
					// 기존 index.jsp 파일을 삭제
					cOGCntnsMngProcess.fileDelete(checkFilePath);
					
				}
				// 현재 CMS ID에 대한 배포중인 CMS 정보 가져오기
				// 2016.03.16 추가
				emfMap.put("menuSeq", cntsSeq);
				
				EmfMap cntnsInfo = cOGCntnsMngDAO.selectApprovalCntns(emfMap);
				
				// 컨텐츠 파일 생성
				if(cntnsInfo != null)
				{
					cOGCntnsMngProcess.makeFile(filePath + "/index.jsp", cntnsInfo.getString("cntn"));
				}
			}
		}
		catch(Exception e)
		{
			throw new Exception("CMS 생성 ERROR!!");
		}	
	}
	
	/**
	 * 컨텐츠 All 재배포
	 *
	 * @param EmfMap 데이터
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void selectContentsAllList() throws Exception
	{
		List<EmfMap> list = cOGCntnsMngDAO.selectContentsAllList();
		
		for(EmfMap emfMap : list)
		{
			this.createApprovalCntns(emfMap);			
		}
	}
}
