package mngwserc.sc.sca.service.impl;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.mb.mbc.service.dao.MBCQscnMemDAO;
import mngwserc.sc.sca.service.SCASchdService;
import mngwserc.sc.sca.service.dao.SCAQscnSchdDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.MailService;
import egovframework.com.utl.fcc.service.EgovDateUtil;
import egovframework.com.utl.sim.service.SeedCipher;
import emf.core.extend.service.EmfAbstractService;
import emf.core.util.EMFStringUtil;
import emf.core.vo.EmfMap;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre> 
 * 스케줄링을 위한 ServiceImpl
 * </pre>
 * 
 * @ClassName		: SCASchdMngServiceImpl.java
 * @Description		: 스케줄링을 위한 ServiceImpl.java
 * @author 허진영
 * @since 2016.03.28
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2016.03.28		허진영					최초생성
 * </pre>
 */ 
@Service("sCASchdService")
public class SCASchdServiceImpl extends EmfAbstractService implements SCASchdService {
	
	@Resource(name="sCAQscnSchdDAO")
    private SCAQscnSchdDAO sCAQscnSchdDAO;
	
	@Resource(name = "mailService")
	private MailService mailService;

	@Autowired
	private MBCQscnMemDAO mbcQscnMemDAO;
	
	private String ENCODE = EgovProperties.getProperty("Global.CHARCODE");
	
    /**
     * 1년이상 미로그인 시 휴면계정으로 전환한다.
     * 
     * @param 
     * @return 
     * @throws Exception 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    @Override
    @Transactional
    public void qscnChngScheduler() throws Exception {
    	// 휴면 회원 테이블로 복사
		EmfMap emfMap = new EmfMap();
		emfMap.put("modId", "scheduler");
		emfMap.put("modIp", "127.0.0.1");
		mbcQscnMemDAO.qscnChange(emfMap);
		// 일반 회원 테이블에서 휴면전환된 회원 삭제
		mbcQscnMemDAO.deleteQscnChange(new EmfMap());
    }
    
	/**
     * 휴면계정 전환 1주일전 안내메일 발송한다.
     * 
     * @param
	 * @return 
	 * @throws Exception 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public void sendMailSchedular() throws Exception {
    	List<EmfMap> qscnMemList = sCAQscnSchdDAO.selectQscnMemList();
    	EmfMap tmpMap = null;
    	EmfMap mailMap = new EmfMap();
    	
    	for (int i = 0; i < qscnMemList.size(); i++) {
    		tmpMap = qscnMemList.get(i);
    		log.info(String.format("Send 휴면 계정 전환 안내 Mail : %s",   tmpMap));
    		if (!"".equals(EMFStringUtil.nullConvert(tmpMap.getString("email")))) {
    			mailMap.put("subject", "[대명아임레디] 휴면 계정 전환 안내");
    			//2017.04.24 박주석 디아모 솔루션 도입 작업
//    			mailMap.put("toUser", SeedCipher.decrypt(tmpMap.getString("email"), ENCODE));
    			mailMap.put("toUser", tmpMap.getString("email") );
    			mailMap.put("name", tmpMap.getString("name"));
    			//mailMap.put("qscnChngDtm", EgovDateUtil.convertDate(tmpMap.getString("qscnChngDtm"), "yyyy-MM-dd HH:mm:ss", "yyyy년 MM월 dd일", ""));
    			mailMap.put("qscnChngDtm", tmpMap.getString("qscnChngDtm"));
    			mailService.sendTempleteMail(mailMap, "sc/sca/SCAQscnChngGuide.html");
				log.info(String.format("Send 휴면 계정 전환 안내 Mail - Success : %s",   tmpMap));
    		}
    	}
    }

	public void sendMailSchedularTest() throws Exception {

		EmfMap mailMap = new EmfMap();

		mailMap.put("email", "captin76@naver.com");
		mailMap.put("name", "고객1님");
		mailMap.put("qscnChngDtm", "2022-01-01 00:00:00");

		mailMap.put("subject", "휴면계정 테스트");
		mailMap.put("toUser", "captin76@naver.com");

		log.info(String.format("Send 휴면 계정 전환 안내 Mail : %s",   mailMap));

		mailMap.put("subject", "[대명아임레디] 휴면 계정 전환 안내");
		//2017.04.24 박주석 디아모 솔루션 도입 작업
//    			mailMap.put("toUser", SeedCipher.decrypt(tmpMap.getString("email"), ENCODE));
		mailMap.put("toUser", mailMap.getString("email") );
		mailMap.put("name", mailMap.getString("name"));
		//mailMap.put("qscnChngDtm", EgovDateUtil.convertDate(tmpMap.getString("qscnChngDtm"), "yyyy-MM-dd HH:mm:ss", "yyyy년 MM월 dd일", ""));
		mailMap.put("qscnChngDtm", mailMap.getString("qscnChngDtm"));
		mailService.sendTempleteMail(mailMap, "sc/sca/SCAQscnChngGuide.html");
//		mailMap.put("email", "kil2510@naver.com");
//		mailMap.put("toUser", "kil2510@naver.com");
//		mailService.sendTempleteMail(mailMap, "sc/sca/SCAQscnChngGuide.html");
		log.info(String.format("Send 휴면 계정 전환 안내 Mail - Success : %s",   mailMap));


	}


}
