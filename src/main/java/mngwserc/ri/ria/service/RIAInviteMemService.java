package mngwserc.ri.ria.service;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 유치회원 조회를 위한 Service
 * </pre>
 * 
 * @ClassName		: RIAInviteMemService.java
 * @Description		: 유치회원 조회를 위한 Service
 * @author 김필기
 * @since 2016.04.08
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		 since			author					description
 *   ===========    ==============    =============================
 *    2016.04.08		김필기					 최초생성
 * </pre>
 */
public interface RIAInviteMemService {	
	
	/**
     * 유치회원 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectInviteMemList(EmfMap emfMap) throws Exception;

    /**
     * 로그인 ID로 사원번호를 조회한다.
     * 
     * @param String
	 * @return String
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public String selectEmplenoById(String string) throws Exception;
   
}
