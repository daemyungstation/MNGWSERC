package egovframework.com.cmm.service.impl;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import egovframework.com.cmm.service.EgovUserDetailsService;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import emf.core.vo.EmfMap;

/**
 *
 * @author 공통서비스 개발팀 서준식
 * @since 2011. 8. 12.
 * @version 1.0
 * @see
 *
 * <pre>
 * 개정이력(Modification Information)
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2011. 8. 12.    서준식        최초생성
 *
 *  </pre>
 */

public class EgovTestUserDetailsServiceImpl extends AbstractServiceImpl implements EgovUserDetailsService {

	public Object getAuthenticatedUser()
	{
		EmfMap hapMap = new EmfMap();
		hapMap.put("admSeq", "1");
		hapMap.put("id", "devadmin");
		hapMap.put("password", "a4ayc/80/OGda4BO/1o/V0etpOqiLx1JwB5S3beHW0s=");
		hapMap.put("authCd", "99");
		hapMap.put("email", "a3@aa.aa");				
		hapMap.put("name", "박주석");
		hapMap.put("loginIp", "192.168.0.5");
		RequestContextHolder.getRequestAttributes().setAttribute("admLgnMap", hapMap, RequestAttributes.SCOPE_SESSION);
		return hapMap;
	}

	public Boolean isAuthenticated() 
	{
		// 인증된 유저인지 확인한다.
		return true;
	}
}
