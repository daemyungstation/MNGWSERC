package mngwserc.sc.sca.service;

/**
 * <pre> 
 * 스케줄링을 위한 Service
 * </pre>
 * 
 * @ClassName		: SCASchedulingService.java
 * @Description		: 스케줄링을 위한 Service
 * @author 허진영
 * @since 2016.03.28
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author				   description
 *   ===========    ==============    =============================
 *    2016.03.28	    허진영					최초생성
 * </pre>
 */ 
public interface SCASchdService {

    /**
     * 1년이상 미로그인 시 휴면계정으로 전환한다.
     *
     * @throws Exception
     */
    public void qscnChngScheduler() throws Exception;

    /**
     * 휴면계정 전환 1주일전 안내메일 발송한다.
     *
     * @throws Exception
     */
    public void sendMailSchedular() throws Exception;

    public void sendMailSchedularTest() throws Exception;
}
