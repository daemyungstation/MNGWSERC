package mngwserc.co.cof.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 로그생성(시스템)를 위한 Aspect Class
 * </pre>
 * 
 * @ClassName		: COFSysLogAspect.java
 * @Description		: 로그생성(시스템)를 위한 Aspect Class
 * @author 김대환
 * @since 2015.11.19
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author			 description
 *   ===========    ==============    =================
 *    2015.11.19		김대환			  최초생성
 * </pre>
 */
public class COFSysLogAspect {

	@Resource(name="cOFSysLogService")
	private COFSysLogService cOFSysLogService;
	
	private Log log = LogFactory.getLog(getClass());

	/**
	 * 시스템 로그정보를 생성한다.
	 * sevice Class의 select로 시작되는 Method
	 *
	 * @param ProceedingJoinPoint
	 * @return Object
	 * @throws Exception
	 */
	public Object logSelect(ProceedingJoinPoint joinPoint) throws Throwable
	{
		StopWatch stopWatch = new StopWatch();

		try
		{
			stopWatch.start();
			
			Object retValue = joinPoint.proceed();
			
			return retValue;
		} 
		catch (Throwable e)
		{
			throw e;			
		} 
		finally 
		{
			logRecord(joinPoint, stopWatch, "R");
		}
	}
	
	/**
	 * 시스템 로그정보를 생성한다.
	 * sevice Class의 insert로 시작되는 Method
	 *
	 * @param ProceedingJoinPoint
	 * @return Object
	 * @throws Exception
	 */
	public Object logInsert(ProceedingJoinPoint joinPoint) throws Throwable
	{
		StopWatch stopWatch = new StopWatch();
		
		try
		{
			stopWatch.start();

			Object retValue = joinPoint.proceed();
			
			return retValue;
		}
		catch (Throwable e) 
		{
			throw e;
		} 
		finally 
		{
			logRecord(joinPoint, stopWatch, "C");
		}
	}

	/**
	 * 시스템 로그정보를 생성한다.
	 * sevice Class의 update로 시작되는 Method
	 *
	 * @param ProceedingJoinPoint
	 * @return Object
	 * @throws Exception
	 */
	public Object logUpdate(ProceedingJoinPoint joinPoint) throws Throwable 
	{		
		StopWatch stopWatch = new StopWatch();
		
		try
		{
			stopWatch.start();
			
			Object retValue = joinPoint.proceed();
			
			return retValue;
		} 
		catch (Throwable e) 
		{
			throw e;
		} 
		finally 
		{
			logRecord(joinPoint, stopWatch, "U");
		}
	}

	/**
	 * 시스템 로그정보를 생성한다.
	 * sevice Class의 delete로 시작되는 Method
	 *
	 * @param ProceedingJoinPoint
	 * @return Object
	 * @throws Exception
	 */
	public Object logDelete(ProceedingJoinPoint joinPoint) throws Throwable {

		StopWatch stopWatch = new StopWatch();

		try
		{
			stopWatch.start();

			Object retValue = joinPoint.proceed();
			
			return retValue;
		} 
		catch (Throwable e) 
		{
			throw e;
		} 
		finally 
		{
			logRecord(joinPoint, stopWatch, "D");
		}
	}

	/**
	 * 시스템 로그정보를 생성한다.
	 * sevice Class의 excel로 시작되는 Method
	 *
	 * @param ProceedingJoinPoint
	 * @return Object
	 * @throws Exception
	 */
	public Object logExcel(ProceedingJoinPoint joinPoint) throws Throwable 
	{
		StopWatch stopWatch = new StopWatch();

		try
		{
			stopWatch.start();

			Object retValue = joinPoint.proceed();
			
			return retValue;
		}
		catch (Throwable e) 
		{
			throw e;
		} 
		finally
		{
			logRecord(joinPoint, stopWatch, "X");
		}
	}
	
	/**
	 * 시스템 로그정보를 생성한다.
	 * sevice Class의 print로 시작되는 Method
	 *
	 * @param ProceedingJoinPoint
	 * @return Object
	 * @throws Exception
	 */
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable 
	{
		StopWatch stopWatch = new StopWatch();

		try 
		{
			stopWatch.start();

			Object retValue = joinPoint.proceed();
			
			return retValue;
		} 
		catch (Throwable e) 
		{
			throw e;
		} 
		finally 
		{
			logRecord(joinPoint, stopWatch, "P");
		}
	}
	
	/**
	 * 시스템 로그정보를 생성한다.
	 * sevice Class의 download로 시작되는 Method
	 *
	 * @param ProceedingJoinPoint
	 * @return Object
	 * @throws Exception
	 */
	public Object logDownload(ProceedingJoinPoint joinPoint) throws Throwable
	{
		StopWatch stopWatch = new StopWatch();

		try 
		{
			stopWatch.start();
			
			Object retValue = joinPoint.proceed();
			
			return retValue;
		} 
		catch (Throwable e) 
		{
			throw e;
		} 
		finally 
		{
			logRecord(joinPoint, stopWatch, "P");
		}
	}
	
	
	/**
	 * 서비스 익셉션
	 *
	 * @param ProceedingJoinPoint
	 * @param Exception
	 * @return 
	 * @throws Exception
	 */
	public void logException(JoinPoint joinPoint, Exception exception) throws Exception 
	{
		Class clz = joinPoint.getTarget().getClass();
		String classNm = clz.getSimpleName();
		String funcNm = joinPoint.getSignature().getName();
		String errCdCntn = getKey(exception);
		String errGbcd = "01";
		String dbErrCd = "";
		try
		{
			if (null != errCdCntn) 
			{
				if (errCdCntn.indexOf("ORA-") > -1) 
				{
					dbErrCd = getOraMessage(getKey(exception));
					errGbcd = "02";
				} 
				else if (errCdCntn.indexOf("JDBC-") > -1) 
				{
					dbErrCd = getTiberoMessage(getKey(exception));
					errGbcd = "02";
				}
			}
			if(log.isDebugEnabled())
			{
				log.debug("ERROR*************************************************************************");
				log.debug(errCdCntn + "\n");
				log.debug("ERROR*************************************************************************");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		throw exception;
	}
	
	/**
	 * 티베로 메시지 출력
	 *
	 * @param ProceedingJoinPoint
	 * @param Exception
	 * @return 
	 * @throws Exception
	 */
	private String getTiberoMessage(String sExce)
	{
		String[] splitStr = sExce.split("\n");
		String result_msg = null;
		if (splitStr.length > 0) 
		{
			for (int i = 0; i < splitStr.length; i++) 
			{
				if (splitStr[i].contains("JDBC-")) 
				{
					int start_length = splitStr[i].indexOf("JDBC-");
					result_msg = splitStr[i].substring(start_length, start_length + 10);
					result_msg = result_msg.replace(":", "");
				}
			}
		}
		return result_msg;
	}
	
	/**
	 * 오라클 메시지 출력
	 *
	 * @param ProceedingJoinPoint
	 * @param Exception
	 * @return 
	 * @throws Exception
	 */
	private String getOraMessage(String sExce)
	{
		String[] splitStr = sExce.split("\n");
		String result_msg = null;
		if (splitStr.length > 0) 
		{
			for (int i = 0; i < splitStr.length; i++) 
			{
				if (splitStr[i].contains("ORA-")) 
				{
					int start_length = splitStr[i].indexOf("ORA-");
					result_msg = splitStr[i].substring(start_length, start_length + 9);
				}
			}
		}
		return result_msg;
	}
	
	/**
	 * 익셉션의 내용을 가져온다.
	 *
	 * @param Exception
	 * @return 
	 * @throws Exception
	 */
	private String getKey(Exception e)
	{
		String rMsg = "";
		String local_ip = "";
		String sServerIp = "";
		StringBuffer suf = new StringBuffer();
		try
		{
			InetAddress address = InetAddress.getLocalHost();
			local_ip = address.getHostAddress();
		} 
		catch (UnknownHostException ue) 
		{
			local_ip = "unknownhost";
		}
		suf.append("[").append(local_ip).append("] ");
		sServerIp = suf.toString();
		StringWriter strW = new StringWriter();
		e.printStackTrace(new PrintWriter(strW));
		String tempLog = strW.toString();
		rMsg = sServerIp + tempLog.substring(0, 3900) + "...";
		return rMsg;
	}
	
	private void logRecord(ProceedingJoinPoint joinPoint, StopWatch stopWatch, String prcsCd) throws Exception 
	{
		try
		{
			stopWatch.stop();
			String srvcNm = joinPoint.getTarget().getClass().getName();
			String fncNm = joinPoint.getSignature().getName();
			String trgtMenuNm = String.valueOf(RequestContextHolder.getRequestAttributes().getAttribute("pageIndicator", RequestAttributes.SCOPE_SESSION));
			String prcsTime = Long.toString(stopWatch.getTotalTimeMillis());
			String reqnId = "";
			String reqnIp = "";
	    
			/* Authenticated */
	        Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
	        
	    	if(isAuthenticated.booleanValue()) 
	    	{
	    		EmfMap admLgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();
	    		
	    		reqnId = EgovStringUtil.nullConvert(admLgnMap.getString("id"));
	    		reqnIp = EgovStringUtil.nullConvert(admLgnMap.getString("loginIp"));
	    	}
	    	
	    	EmfMap sysLogMap = new EmfMap();
	    	
	    	sysLogMap.put("srvcNm", srvcNm);
	    	sysLogMap.put("fncNm", fncNm);
	    	sysLogMap.put("trgtMenuNm", trgtMenuNm);
	    	sysLogMap.put("prcsCd", prcsCd);
	    	sysLogMap.put("prcsTime", prcsTime);
	    	sysLogMap.put("reqnId", reqnId);
	    	sysLogMap.put("reqnIp", reqnIp);
			
			if(prcsCd.equals("S"))
			{
				cOFSysLogService.logInsertSysLog(sysLogMap);
			}
			else
			{
				if(!"".equals(EMFStringUtil.nullConvert(trgtMenuNm)))
				{
					cOFSysLogService.logInsertSysLog(sysLogMap);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
