package mngwserc.om.omb.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.coc.service.COCAdmMngService;
import mngwserc.co.util.COPaginationUtil;
import mngwserc.om.omb.service.OMBOrderMngService;
import mngwserc.om.omb.service.dao.OMBOrderMngDAO;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.sim.service.EgovNetworkState;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

/**
 * <pre>
 * 외주업체 발주관리를 위한 ServiceImpl
 * </pre>
 *
 * @ClassName		: PRAOrderMngServiceImpl.java
 * @Description		: 외주업체 발주관리를 위한 ServiceImpl
 * @author 김필기
 * @since 2016.02.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.02.12		김필기					 최초생성
 * </pre>
 */
@Service("oMBOrderMngService_bak")
public class OMBOrderMngServiceImpl_bak extends EmfAbstractService implements OMBOrderMngService {

	@Resource(name="oMBOrderMngDAO")
	private OMBOrderMngDAO oMBOrderMngDAO;

	// 서비스 선언
	@Resource(name="cOCAdmMngService")
	private COCAdmMngService cOCAdmMngService;

	@Resource(name="EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	/**
	 * 외주업체 발주관리 목록을 조회한다.
	 *
	 * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectOrderMngList(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보

		String id = lgnMap.getString("id");	// 아이디
		//페이징 처리
		if(!"".equals(emfMap.getString("p")))
		{
			emfMap.put("cntPage", emfMap.getString("p"));
		}
		PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);

		emfMap.put("paginationInfo", paginationInfo);

		//리스트 가져오기
		if("Y".equals(emfMap.getString("orderdateMng")))
		{
			// 발주관리 관리자 아이디 목록
			emfMap.put("admList", cOCAdmMngService.getRoleAdmList(emfMap));

			id = emfMap.getString("id");

			if("".equals(emfMap.getString("daysel")))
			{
				emfMap.put("daysel", "joinDt");
			}
		}
		else
		{
			if("".equals(emfMap.getString("daysel")))
			{
				emfMap.put("daysel", "orderDt");
			}
		}

		if("".equals(emfMap.getString("strtDt")) || "".equals(emfMap.getString("endDt")))
		{
			Calendar day = Calendar.getInstance();

			if("Y".equals(emfMap.getString("orderdateMng")))
			{
				day.add(Calendar.DATE, -1);
			}

			emfMap.put("strtDt", new SimpleDateFormat("yyyy-MM-dd").format(day.getTime()));
			emfMap.put("endDt", new SimpleDateFormat("yyyy-MM-dd").format(day.getTime()));
		}

		emfMap.put("id", id);
		if( emfMap.get("idList") == null) {
			emfMap.put("idList", new ArrayList());
		}
		if(!"".equals(id) || (emfMap.get("idList") != null && ((List)emfMap.get("idList")).size() > 0 ) )
		{
			List<EmfMap> dataList = oMBOrderMngDAO.selectOrderMngList(emfMap);

			EmfMap count = oMBOrderMngDAO.selectOrderMngListCnt(emfMap);

			emfMap.put("orderCountYn", "Y");

			EmfMap ordCount = oMBOrderMngDAO.selectOrderMngListCnt(emfMap);

			emfMap.put("totCnt", count.getString("cnt"));
			emfMap.put("ordCnt", ordCount.getString("cnt"));
			emfMap.put("list", dataList);

			if(dataList.size() > 0)
			{
				paginationInfo.setTotalRecordCount(Integer.parseInt(count.getString("cnt")));
			}
			else
			{
				paginationInfo.setTotalRecordCount(0);
			}

			emfMap.put("totalCount", paginationInfo.getTotalRecordCount());

			/**
			 * 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
			 * 2017.12.26
			 */
			EmfMap logMap = new EmfMap();
//			logMap.put("gubun", "외주업체 관리 - 발주 관리 조회");
//			logMap.put("flag", "S");
//			logMap.put("name", lgnMap.getString("name"));
//			logMap.put("hp", StringUtils.defaultIfEmpty(lgnMap.getString("hp"), lgnMap.getString("tel")));
//			logMap.put("id", lgnMap.getString("id"));
//			logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
			logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
			logMap.put("gubun", "외주업체 관리 - 발주 관리 조회");
			logMap.put("flag", "S");
			logMap.put("name", lgnMap.getString("name"));
			logMap.put("hp", StringUtils.defaultIfEmpty(lgnMap.getString("hp"), lgnMap.getString("tel")));
			logMap.put("id", lgnMap.getString("id"));
			cmmUseService.actionViewAuthLog(logMap);
		}

		return emfMap;
	}

	/**
	 * 외주업체 발주관리 상세를 조회한다.
	 *
	 * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public EmfMap selectOrderMng(EmfMap emfMap) throws Exception
	{
		if("".equals(emfMap.getString("accntNo")))
		{
			throw new Exception("NOKEY");
		}
    	
		/*
		 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
		 2017.12.26
		 */
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보
		EmfMap logMap = new EmfMap();
//		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
//		logMap.put("gubun", "외주업체 관리 - 발주 관리 상세조회");
//		logMap.put("flag", "D");
//		logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
//		logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
//		logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
		logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
		logMap.put("gubun", "외주업체 관리 - 발주 관리 상세조회");
		logMap.put("flag", "D");
		logMap.put("name", lgnMap.getString("name"));
		logMap.put("hp", StringUtils.defaultIfEmpty(lgnMap.getString("hp"), lgnMap.getString("tel")));
		logMap.put("id", lgnMap.getString("id"));
		cmmUseService.actionViewAuthLog(logMap);

		return oMBOrderMngDAO.selectOrderMng(emfMap);
	}

	/**
	 * 외주업체 발주관리을 수정한다.
	 *
	 * @param EmfMap
	 * @return
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public void updateOrderMng(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보

		String id = lgnMap.getString("id");	// 아이디

		id = emfMap.getString("id");

		if("ord".equals(emfMap.getString("type")))
		{
			if("".equals(emfMap.getString("orderdate")))
			{
				emfMap.put("errorMsg", "발주일자를 넣으세요");
			}
			else
			{
				emfMap.put("id", id);
				emfMap.put("b2bStat", "");
				emfMap.put("orderdate", emfMap.getString("orderdate") + " 00:00:00");

				if("dyorder".equals(id))
				{
					emfMap.put("b2bStat", "DONGYANG");
				}
				else if("mmorder".equals(id))
				{
					emfMap.put("b2bStat", "LGU");
				}

				if("csvorder".equals(id) || "mmorder".equals(id) || "dyorder".equals(id) || "lgorder".equals(id) || "dhorder".equals(id) || "isollat".equals(id) || "sonoseason".equals(id) || "wmnetwork".equals(id))
				{
					List<String> accntNoList = emfMap.getList("accntNo");

					if(accntNoList.size() > 0)
					{
						emfMap.put("accntNo", accntNoList);
						oMBOrderMngDAO.insertDeliveryInfo(emfMap);
	
						/*
						 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
						 2017.12.26
						 */
						EmfMap logMap = new EmfMap();
//						logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
//						logMap.put("gubun", "외주업체 관리 - 발주 관리 발주일자 등록");
//						logMap.put("flag", "C");
//						logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
//						logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
//						logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
						logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
						logMap.put("gubun", "외주업체 관리 - 발주 관리 발주일자 등록");
						logMap.put("flag", "C");
						logMap.put("name", lgnMap.getString("name"));
						logMap.put("hp", StringUtils.defaultIfEmpty(lgnMap.getString("hp"), lgnMap.getString("tel")));
						logMap.put("id", lgnMap.getString("id"));
						cmmUseService.actionViewAuthLog(logMap);
					}
					else
					{
						emfMap.put("errorMsg", "한명 이상의 회원을 선택해주세요.");
					}
				}
				else
				{
					emfMap.put("errorMsg", "발주관리 아이디 값이 없습니다.");
				}
			}
		}
		else if("req".equals(emfMap.getString("type")))
		{
			if("".equals(emfMap.getString("reqdate")))
			{
				emfMap.put("errorMsg", "배송상황일자를 넣으세요");
			}
			else
			{
				emfMap.put("reqdate", emfMap.getString("reqdate") + " 00:00:00");

				List<String> accntNoList = emfMap.getList("accntNo");

				if(accntNoList.size() > 0)
				{
					emfMap.put("accntNo", accntNoList);

					oMBOrderMngDAO.updateReq(emfMap);
					
					/*
					 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
					 2017.12.26
					 */
					EmfMap logMap = new EmfMap();
//					logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
//					logMap.put("gubun", "외주업체 관리 - 발주 관리 배송상황 수정");
//					logMap.put("flag", "M");
//					logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
//					logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
//					logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
					logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
					logMap.put("gubun", "외주업체 관리 - 발주 관리 배송상황 수정");
					logMap.put("flag", "M");
					logMap.put("name", lgnMap.getString("name"));
					logMap.put("hp", StringUtils.defaultIfEmpty(lgnMap.getString("hp"), lgnMap.getString("tel")));
					logMap.put("id", lgnMap.getString("id"));
					cmmUseService.actionViewAuthLog(logMap);
				}
				else
				{
					emfMap.put("errorMsg", "한명 이상의 회원을 선택해주세요.");
				}
			}
		}
		else if("delv".equals(emfMap.getString("type")))
		{
			if("".equals(emfMap.getString("delvdate")))
			{
				emfMap.put("errorMsg", "납품일을 넣으세요");
			}
			else
			{
				emfMap.put("delvdate", emfMap.getString("delvdate") + " 00:00:00");

				List<String> accntNoList = emfMap.getList("accntNo");

				if(accntNoList.size() > 0)
				{

					emfMap.put("accntNo", accntNoList);
					oMBOrderMngDAO.updateDelv(emfMap);

					/*
					 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
					 2017.12.26
					 */
					EmfMap logMap = new EmfMap();
//					logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
//					logMap.put("gubun", "외주업체 관리 - 발주 관리 납품상황 수정");
//					logMap.put("flag", "M");
//					logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
//					logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
//					logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
					logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
					logMap.put("gubun", "외주업체 관리 - 발주 관리 납품상황 수정");
					logMap.put("flag", "M");
					logMap.put("name", lgnMap.getString("name"));
					logMap.put("hp", StringUtils.defaultIfEmpty(lgnMap.getString("hp"), lgnMap.getString("tel")));
					logMap.put("id", lgnMap.getString("id"));
					cmmUseService.actionViewAuthLog(logMap);
				}
				else
				{
					emfMap.put("errorMsg", "한명 이상의 회원을 선택해주세요.");
				}
			}
		}
		else if("hold".equals(emfMap.getString("type")))
		{
			if("".equals(emfMap.getString("holddate")))
			{
				emfMap.put("errorMsg", "보류일을 넣으세요");
			}
			else
			{
				emfMap.put("holddate", emfMap.getString("holddate") + " 00:00:00");

				List<String> accntNoList = emfMap.getList("accntNo");

				if(accntNoList.size() > 0)
				{

					emfMap.put("accntNo", accntNoList);
					oMBOrderMngDAO.updateHold(emfMap);

					/*
					 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
					 2017.12.26
					 */
					EmfMap logMap = new EmfMap();
//					logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
//					logMap.put("gubun", "외주업체 관리 - 발주 관리 보류일 수정");
//					logMap.put("flag", "M");
//					logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
//					logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
//					logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
					logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
					logMap.put("gubun", "외주업체 관리 - 발주 관리 보류일 수정");
					logMap.put("flag", "M");
					logMap.put("name", lgnMap.getString("name"));
					logMap.put("hp", StringUtils.defaultIfEmpty(lgnMap.getString("hp"), lgnMap.getString("tel")));
					logMap.put("id", lgnMap.getString("id"));
					cmmUseService.actionViewAuthLog(logMap);
				}
				else
				{
					emfMap.put("errorMsg", "한명 이상의 회원을 선택해주세요.");
				}
			}
		}
		else if("rpl".equals(emfMap.getString("type")))
		{
			EmfMap info = oMBOrderMngDAO.selectOrderMng(emfMap);

			// 상세화면 등록시
			if(!"".equals(emfMap.getString("delvdate")))
			{
				emfMap.put("delvdate", emfMap.getString("delvdate") + " 00:00:00");
			}
			else
			{
				emfMap.put("delvdate", "");
			}

			if(!"".equals(emfMap.getString("holddate")))
			{
				emfMap.put("holddate", emfMap.getString("holddate") + " 00:00:00");
			}
			else
			{
				emfMap.put("holddate", "");
			}

			if(!"".equals(emfMap.getString("reqdate")))
			{
				emfMap.put("reqdate", emfMap.getString("reqdate") + " 00:00:00");
			}
			else
			{
				emfMap.put("reqdate", "");
			}

			if(info.getString("updateAddr").equals(emfMap.getString("inspaddr")))
			{

			}
			else
			{
				emfMap.put("updateAddr", info.getString("updateAddr"));
			}

			emfMap.put("log", info.getString("deliveryLog"));
			emfMap.put("confdt", info.getString("confirmDt"));
			emfMap.put("delvdt", info.getString("deliveryDt"));
			emfMap.put("holddt", info.getString("holdDt"));
			emfMap.put("etc", info.getString("note"));

			oMBOrderMngDAO.updateReply(emfMap);
			
			/*
			 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
			 2017.12.26
			 */
			EmfMap logMap = new EmfMap();
//			logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
//			logMap.put("gubun", "외주업체 관리 - 발주 관리 상세내용 수정");
//			logMap.put("flag", "M");
//			logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
//			logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
//			logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
			logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
			logMap.put("gubun", "외주업체 관리 - 발주 관리 상세내용 수정");
			logMap.put("flag", "M");
			logMap.put("name", lgnMap.getString("name"));
			logMap.put("hp", StringUtils.defaultIfEmpty(lgnMap.getString("hp"), lgnMap.getString("tel")));
			logMap.put("id", lgnMap.getString("id"));
			cmmUseService.actionViewAuthLog(logMap);
		}
		else if("rowudt".equals(emfMap.getString("type")))
		{
			oMBOrderMngDAO.updateRowudt(emfMap);

			/*
			 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
			 2017.12.26
			 */
			EmfMap logMap = new EmfMap();
//			logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
//			logMap.put("gubun", "외주업체 관리 - 발주 관리 정보 수정");
//			logMap.put("flag", "M");
//			logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
//			logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
//			logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
			logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
			logMap.put("gubun", "외주업체 관리 - 발주 관리 정보 수정");
			logMap.put("flag", "M");
			logMap.put("name", lgnMap.getString("name"));
			logMap.put("hp", StringUtils.defaultIfEmpty(lgnMap.getString("hp"), lgnMap.getString("tel")));
			logMap.put("id", lgnMap.getString("id"));
			cmmUseService.actionViewAuthLog(logMap);
		}
		else
		{
			emfMap.put("errorMsg", "처리 구분이 없습니다.");
		}
	}

	public EmfMap selectOrderMngExcelList(EmfMap emfMap) throws Exception
	{
		EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();	// 로그인 사용자 정보

		String id = lgnMap.getString("id");	// 아이디

		//리스트 가져오기
		if("Y".equals(emfMap.getString("orderdateMng")))
		{
			id = emfMap.getString("id");

			if("".equals(emfMap.getString("daysel")))
			{
				emfMap.put("daysel", "joinDt");
			}
		}
		else
		{
			if("".equals(emfMap.getString("daysel")))
			{
				emfMap.put("daysel", "orderDt");
			}
		}

		if("".equals(emfMap.getString("strtDt")) || "".equals(emfMap.getString("endDt")))
		{
			Calendar day = Calendar.getInstance();

			if("Y".equals(emfMap.getString("orderdateMng")))
			{
				day.add(Calendar.DATE, -1);
			}

			emfMap.put("strtDt", new SimpleDateFormat("yyyy-MM-dd").format(day.getTime()));
			emfMap.put("endDt", new SimpleDateFormat("yyyy-MM-dd").format(day.getTime()));
		}

		emfMap.put("id", id);

		if(!"".equals(id))
		{

			List<EmfMap> dataList = oMBOrderMngDAO.selectOrderMngExcelList(emfMap);

			EmfMap count = oMBOrderMngDAO.selectOrderMngListCnt(emfMap);

			emfMap.put("totCnt", count.getString("cnt"));
			emfMap.put("list", dataList);

			/*
			 홈페이지 개인정보 로그 - 보안관련 로직 신규 구현
			 2017.12.26
			 */
			EmfMap logMap = new EmfMap();
//			logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
//			logMap.put("gubun", "외주업체 관리 - 발주 관리 엑셀다운로드");
//			logMap.put("flag", "M");
//			logMap.put("name", RequestContextHolder.getRequestAttributes().getAttribute("name", RequestAttributes.SCOPE_SESSION));
//			logMap.put("hp", RequestContextHolder.getRequestAttributes().getAttribute("hp", RequestAttributes.SCOPE_SESSION));
//			logMap.put("id", RequestContextHolder.getRequestAttributes().getAttribute("id", RequestAttributes.SCOPE_SESSION));
			logMap.put("ip", RequestContextHolder.getRequestAttributes().getAttribute("ip", RequestAttributes.SCOPE_SESSION));
			logMap.put("gubun", "외주업체 관리 - 발주 관리 엑셀다운로드");
			logMap.put("flag", "M");
			logMap.put("name", lgnMap.getString("name"));
			logMap.put("hp", StringUtils.defaultIfEmpty(lgnMap.getString("hp"), lgnMap.getString("tel")));
			logMap.put("id", lgnMap.getString("id"));
			cmmUseService.actionViewAuthLog(logMap);
		}

		return emfMap;
	}
}
