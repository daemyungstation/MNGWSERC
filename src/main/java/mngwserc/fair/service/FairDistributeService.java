package mngwserc.fair.service;

import java.util.List;

import emf.core.vo.EmfMap;

/**
 * <pre> 
 * 박람회 배포 관리 Service
 * </pre>
 * 
 * @ClassName		: FairDistributeService.java
 * @Description		: 박람회 배포 관리 Service
 * @author inuscommunity
 * @since 2019. 10. 14.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 	since			author	          description
 *  =============   ==============    =============================
 *  2019. 10. 14.	inuscomm          최초생성
 * </pre>
 */

public interface FairDistributeService {

	//설정 조회
	public EmfMap makeMain() throws Exception;
}
