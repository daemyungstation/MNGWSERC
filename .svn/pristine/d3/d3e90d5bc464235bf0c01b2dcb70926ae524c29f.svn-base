package mngwserc.cn.cna.service;

import emf.core.vo.EmfMap;

public interface CNADirectChoiceService {

	/**
	 * 다이렉트 초이스 목록 조회
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */   
	EmfMap selectDirectChoiList(EmfMap emfMap) throws Exception;

   /**
    * 다이렉트 초이스를 등록한다.
    * 
    * @param EmfMap 검색할 데이터
	 * @return String View URL
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
    */   
	void idci(EmfMap emfMap) throws Exception;

	/**
	 * 다이렉트 초이스 상세정보 조회
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */   
	EmfMap selectDirectChoice(EmfMap emfMap) throws Exception;

	/**
	 * 다이렉트 초이스 수정
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return EmfMap
	 * @throws Exception 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */   
	void udc(EmfMap emfMap) throws Exception;

	/**
	 * 다이렉트 초이스 삭제
	 * 
	 * @param EmfMap 검색할 데이터
	 * @return void
	 * @throws Exception 
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */  
	void ddcl(EmfMap emfMap);

	 /**
     * 다이렉트 초이스 미리보기 상세를 조회한다.
     * 
     * @param EmfMap 검색할 데이터
     * @return String URL
     * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
     */  
	EmfMap selectFileInfoByFileSeq(EmfMap emfMap) throws Exception;

}
