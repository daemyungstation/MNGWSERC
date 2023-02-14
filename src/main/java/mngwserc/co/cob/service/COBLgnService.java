package mngwserc.co.cob.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import emf.core.vo.EmfMap;

/**
 * 일반 로그인, 인증서 로그인을 처리하는 비즈니스 인터페이스 클래스
 * @author 공통서비스 개발팀 박지욱
 * @since 2009.03.06
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 * 
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2009.03.06  박지욱          최초 생성 
 *  2011.08.26  서준식          EsntlId를 이용한 로그인 추가
 *  2015.04.15  박주석          관리자 권한에 따른 기간 가져오기
 *  </pre>
 */
public interface COBLgnService {
	/**
	 * 일반 로그인을 처리한다
	 * @param EmfMap
	 * @return EmfMap
	 * @exception Exception
	 */
	public EmfMap actionLogin(HttpServletRequest request, EmfMap emfMap) throws Exception;
    
    /**
	 * 일반 로그아웃을 처리한다.
	 * @param EmfMap
	 * @return EmfMap
	 * @exception Exception
	 */
    public void actionLogout(HttpServletRequest request) throws Exception;
    
    /**
     * 관리자 비밀번호 강제 변경
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap setPwdChng(EmfMap emfMap) throws Exception;

    /**
     * 관리자 비밀번호를 변경을 연기한다.
     * 
     * @param EmfMap
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */
    public EmfMap pwdChngLater(EmfMap paramMap) throws Exception;
    
    /**
	 * 메뉴 리스트를 가져온다.
	 * @param EmfMap
	 * @return EmfMap
	 * @exception Exception
	 */
    public List<EmfMap> getMenuList(EmfMap emfMap) throws Exception;
    
    /**
	 * 상위 부모의 메뉴를 가져온다.
	 * @param EmfMap
	 * @return EmfMap
	 * @exception Exception
	 */
    public List<EmfMap> getParentMenuList(int pageNo) throws Exception;

	public EmfMap checkLogin(HttpServletRequest request, EmfMap paramMap) throws Exception;

	public EmfMap moveLogin(HttpServletRequest request, EmfMap emfMap) throws Exception;

	public EmfMap getMaxLogId(EmfMap emfMap) throws Exception;

	public int updateInfo(EmfMap infoMap) throws Exception;
}
