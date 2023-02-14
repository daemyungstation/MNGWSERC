package mngwserc.co.coa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import mngwserc.co.coa.service.COASampleService;
import mngwserc.co.coa.service.dao.COASampleDAO;

import org.springframework.stereotype.Service;

import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;


/**
 * <pre> 
 * 샘플 Service 구현
 * </pre>
 * 
 * @ClassName		: CMASampleService.java
 * @Description		: 샘플 Service 구현
 * @author 박주석
 * @since 2015.11.02
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 		since			author					description
 *   ===========    ==============    =============================
 *    2015.11.02		박주석					최초생성
 * </pre>
 */ 
@Service("cOASampleService")
public class COASampleServiceImpl extends EmfAbstractService implements COASampleService {
	
	//Data Access Object
	@Resource(name="cOASampleDAO")
	private COASampleDAO cOASampleDAO;
	
	/**
	 * 샘플 리스트
	 * 
	 * @param ModelMap
	 * @return resultVO:List 조회조건에 검색된 데이터
	 * @throws 비지니스 로직이나 DAO 처리 중 에러가 발생할 경우 Exception을 Throw 한다.
	 */
	public List selectSampleList(EmfMap egovMap) throws Exception
	{    	
    	return cOASampleDAO.selectSampleList(egovMap);
    }
}
