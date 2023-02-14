package mngwserc.fair.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;

import mngwserc.fair.service.FairConfigService;
import mngwserc.fair.service.dao.FairConfigDAO;

/**
 * <pre> 
 * 박람회 설정 관리 Implement
 * </pre>
 * 
 * @ClassName		: FairConfigServiceImpl.java
 * @Description		: 박람회 설정 관리 Implement
 * @author inuscommunity
 * @since 2019. 10. 15.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 	    since			author	               description
 *  ============    ==============    =============================
 *  2019. 10. 15.	   inuscomm                 최초생성
 * </pre>
 */

@Service("fairConfigService")
public class FairConfigServiceImpl extends EmfAbstractService implements FairConfigService {
	
	/** 서비스 **/
	@Resource(name="fairConfigDAO")
	private FairConfigDAO fairConfigDAO;
	
	/** SEQ **/
	@Resource(name="fairConfigIdgen")
    private EgovIdGnrService fairConfigIdgen;
	
	/**
     * 목록 조회
     * 
     * @param
	 * @return EmfMap
	 * @throws Exception
     */
	public EmfMap select() throws Exception {
		List<EmfMap> configList = fairConfigDAO.select();
		EmfMap configRow = new EmfMap();
		if(!configList.isEmpty()) 
		{
			configRow = configList.get(0);
		}
		return configRow;
	}
	
	/**
     * 업데이트
     * 
     * @param
	 * @return EmfMap
	 * @throws Exception
     */
	public void update(EmfMap emfMap) throws Exception {
		List<EmfMap> configList = fairConfigDAO.select();
		EmfMap configRow = new EmfMap();
		
		EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();

		if(configList.isEmpty())
		{
			emfMap.put("FCFG_SEQ", fairConfigIdgen.getNextIntegerId());
			emfMap.put("regId", lgnMap.getString("id"));
			emfMap.put("regIp", lgnMap.getString("loginIp"));

			fairConfigDAO.insert(emfMap);
		}else 
		{
			configRow = configList.get(0);
			emfMap.put("FCFG_SEQ", configRow.get("fcfgSeq"));
			emfMap.put("modId", lgnMap.getString("id"));
			emfMap.put("modIp", lgnMap.getString("loginIp"));
		
			fairConfigDAO.update(emfMap);
		}
	}
}