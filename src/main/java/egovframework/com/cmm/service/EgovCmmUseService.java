package egovframework.com.cmm.service;

import java.util.ArrayList;
import java.util.List;

import emf.core.vo.EmfMap;

/**
 * 
 * 공통코드등 전체 업무에서 공용해서 사용해야 하는 서비스를 정의하기 위한 서비스 인터페이스 
 * @author 공통서비스 개발팀 이삼섭
 * @since 2009.04.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.11  이삼섭          최초 생성
 *
 * </pre>
 */
public interface EgovCmmUseService {
	/**
     * 공통코드를 조회한다.
     * 
     * @param ArrayList<String>
     * @return EmfMap
     * @throws Exception
     */
    public EmfMap selectCmmCodeBindAll(ArrayList<String> cdDtList) throws Exception;

    /**
     * 공통코드를 조회한다.
     * 
     * @param EmfMap
     * @return List<EmfMap>
     * @throws Exception
     */
    public List<EmfMap> selectCmmCodeDetail(EmfMap emfMap) throws Exception;
    
    /**
     * 링크코드를 조회한다.
     * 
     * @param EmfMap
     * @return EmfMap
     * @throws Exception
     */
    public List<EmfMap> selectCmmLinkCode(EmfMap emfMap) throws Exception;
    
    /**
     * LGB2B용 링크코드를 조회한다.
     * 
     * @param EmfMap
     * @return EmfMap
     * @throws Exception
     */
    public List<EmfMap> selectCmmLinkCodeLGB2B(EmfMap emfMap) throws Exception;
    
    /**
     * ComDefaultCodeVO의 리스트를 받아서 여러개의 코드 리스트를 맵에 담아서 리턴한다.
     * 
     * @param EmfMap
     * @return EmfMap
     * @throws Exception
     */
    public EmfMap selectCmmCodeDetails(List<EmfMap> emfList) throws Exception;

	public void actionViewAuthLog(EmfMap logMap) throws Exception;

    /**
     *
     * @param gubun 구분(메뉴,행동)
     * @param reason 사유
     * @param flag Flag L("로그인"), S("조회"), D("상세"), C("등록"), M("수정"), R("삭제"), J("회원가입"), W("회원탈퇴"), E("엑셀다운"), U("엑셀업로드");
     * @param other 기타
     * @throws Exception
     */
    public void actionViewAuthLogV2(String gubun, String reason, String flag,  EmfMap other) throws Exception;
}
