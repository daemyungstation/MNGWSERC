package mngwserc.ri.ria.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import mngwserc.co.cob.service.COBLgnService;
import mngwserc.ri.ria.service.RIAInviteMemService;

import org.apache.poi.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 유치회원 조회를 위한 Controller
 * </pre>
 * 
 * @ClassName		: RIAInviteMemController.java
 * @Description		: 유치회원 조회를 위한 Controller
 * @author 김필기
 * @since 2016.04.08
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.04.08		김필기					 최초생성
 * </pre>
 */
@Controller
@RequestMapping("/mngwsercgateway/allowance/invite-mem/")
public class RIAInviteMemController extends EmfController {
	
	@Resource(name = "rIAInviteMemService")
    private RIAInviteMemService rIAInviteMemService;

	/** EgovLoginService */
	@Resource(name = "cOBLgnService")
    private COBLgnService cOBLgnService;
	
	/**
	 * 유치회원 목록을 조회한다.
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	@RequestMapping(value="/index.do")
	public String selectInviteMemList(EmfMap emfMap,  ModelMap modelMap) throws Exception
	{
		String url = "error/blank.error";
		String strEmpleNo = "";
		
		try
		{
			EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();
			//lgnMap.put("empleNo", rIAInviteMemService.selectEmplenoById(lgnMap.getString("id")));
			strEmpleNo = rIAInviteMemService.selectEmplenoById(lgnMap.getString("id"));
		
			if ("".equals(strEmpleNo))
			{
				modelMap.addAttribute("msg", "사원번호가 존재하지 않습니다.");
				modelMap.addAttribute("url", "javascript:history.back();");
			}
			else
			{
				lgnMap.put("empleNo", strEmpleNo);				
				
				/* header 데이터 생성 시작 */				
				List<EmfMap> gnbMenuList = new ArrayList<EmfMap>();
				gnbMenuList = (List<EmfMap>)RequestContextHolder.getRequestAttributes().getAttribute("menuList", RequestAttributes.SCOPE_SESSION);

				if(gnbMenuList == null)
				{
					EmfMap loginMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
					gnbMenuList = cOBLgnService.getMenuList(loginMap);					
					RequestContextHolder.getRequestAttributes().setAttribute("menuList", gnbMenuList, RequestAttributes.SCOPE_SESSION);
				}
				modelMap.addAttribute("gnbMenuList", gnbMenuList);
				
				List<EmfMap> lnbMenuList = new ArrayList();
				
				EmfMap emfMap2 = null;
				
				int votLeft = 0;
				int firtLeft = 0;
				int votRight = 0;
				int firtRight = 0;
				
				EmfMap gnbEmfMap = new EmfMap();
				String pageTitle = "";
				if(gnbMenuList != null){
					gnbEmfMap = (EmfMap)gnbMenuList.get(0);
					pageTitle = gnbEmfMap.getString("menuNm");
				}
				modelMap.addAttribute("pageTitle", pageTitle);
				
				int pageNo = 0;
				if(gnbEmfMap.getString("menuSeq") != null)
					pageNo = Integer.parseInt(gnbEmfMap.getString("menuSeq"));
				if(gnbMenuList != null && gnbMenuList.size() > 0)
				{
					List<EmfMap> parentMenuList = cOBLgnService.getParentMenuList(pageNo);
					EmfMap lnbFirstMap = (EmfMap)parentMenuList.get(1);
					for(int i = 0; i < gnbMenuList.size(); i++)
					{
						emfMap2 = (EmfMap)gnbMenuList.get(i);
						votLeft = Integer.parseInt(emfMap2.getString("lftVal"));
						firtLeft = Integer.parseInt(lnbFirstMap.getString("lftVal"));
						votRight = Integer.parseInt(emfMap2.getString("rhtVal"));
						firtRight = Integer.parseInt(lnbFirstMap.getString("rhtVal"));
						
						if(votLeft >= firtLeft && votRight <= firtRight)
						{
							lnbMenuList.add(emfMap2);
						}
					}
					modelMap.addAttribute("lnbMenuList", lnbMenuList);
				}
				/* header 데이터 생성 종료 */
				
				emfMap.put("empleNo", strEmpleNo);
				
				System.out.println("LDJ_emfMap-------------------------------------" + emfMap);
				
				EmfMap rtnMap = rIAInviteMemService.selectInviteMemList(emfMap);				
				
				modelMap.addAttribute("rtnMap", rtnMap);
				
				url = "mngwserc/ri/ria/RIAInviteMemList.admin";
			}			
		}
		catch (Exception he) 
		{
			if (log.isDebugEnabled()) 
			{
				log.debug(he);
            }
			throw new EmfException(he.getMessage());
		} 
		
		return url;
	}
}
