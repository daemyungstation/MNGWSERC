package mngwserc.cn.cnb.service;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 이용안내 관리를 위한 Service
 * </pre>
 * 
 * @ClassName		: CNBOprtGuideService.java
 * @Description		: 이용안내 관리를 위한 Service
 * @author 허진영
 * @since 2016.02.12
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since		   author				  description
 *   ==========    ==============    =============================
 *   2016.02.12		   허진영				   최초 생성
 * </pre>
 */ 
public interface CNBOprtGuideService {
	
	/**
     * 이용안내 목록을 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap selectOprtGuideList(EmfMap emfMap) throws Exception;

    /**
     * 이용안내 상세를 조회한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
	public EmfMap selectOprtGuide(EmfMap emfMap) throws Exception;
	
    /**
     * 이용안내를 등록한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
//	public void insertOprtGuide(EmfMap emfMap) throws Exception;
	public void iog(EmfMap emfMap) throws Exception;
	
	/**
     * 이용안내를 수정한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
//	public void updateOprtGuide(EmfMap emfMap) throws Exception;
	public void uog(EmfMap emfMap) throws Exception;
	
    /**
     * 이용안내를 삭제한다.
     * 
     * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
//	public void deleteOprtGuideList(int[] delSeq) throws Exception;
	public void dogl(int[] delSeq) throws Exception;
	
    /**
	 * 이용안내를 복사한다.
	 * 
	 * @param EmfMap
	 * @return 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */	
//	public void insertOprtGuideCopy(EmfMap emfMap) throws Exception;
	public void iogc(EmfMap emfMap) throws Exception;

}
