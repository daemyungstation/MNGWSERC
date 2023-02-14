package mngwserc.om.oma.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import mngwserc.om.oma.service.dao.OMACounselMngDAO;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ibm.icu.util.BytesTrie.Entry;

import emf.core.vo.EmfMap;

/**
 * LGU 대용량 엑셀 생성을 위한 핸들러
 *
 * @param 
 */
public class OMACounselExcelHandler implements ResultHandler {
	
	@Resource(name = "oMACounselMngDAO")
	private OMACounselMngDAO oMACounselMngDAO;
	
	private HSSFWorkbook workbook;
	private HSSFSheet sheet;
	private HSSFRow row;
	private HSSFCell cell;
	private int index = 1;
	private int pageNum = 1;
	
	//핸들러
	@Override
	public void handleResult(ResultContext context) {
		if(index ==60000) {
			pageNum++;
			createTitle();
			index = 1;
		}
		EmfMap emfMap = (EmfMap)context.getResultObject();
//		List<Entry> list = new ArrayList<Entry>(emfMap.entrySet());
//		
//		Collections.sort(list, new Comparator<Entry>(){
//
//			@Override
//			public int compare(Entry o1, Entry o2) {
//				// TODO Auto-generated method stub
//				return 0;
//			}
//			
//		});
		createBody(index, emfMap);
		index++;
//		System.out.println("pageNum : " + pageNum +", index : " + index);
	}
	
	//워크북 호출 및 헤더 작성
	public OMACounselExcelHandler (HSSFWorkbook calledWorkbook) {
		index = 1;
		this.workbook = calledWorkbook;
		createTitle();
	}
	
	//엑셀 헤더 작성  
	private void createTitle() {
		sheet = workbook.createSheet("LGU_Data_Sheet" + pageNum);
		
		row = sheet.createRow(0);
		
//		cell = row.createCell(0);
//		cell.setCellValue("접수구분");
		cell = row.createCell(0);
		cell.setCellValue("코드1");
		cell = row.createCell(1);
		cell.setCellValue("코드2");
		cell = row.createCell(2);
		cell.setCellValue("U+가입번호");
		cell = row.createCell(3);
		cell.setCellValue("대명가입번호");
		cell = row.createCell(4);
		cell.setCellValue("상담신청일");
		cell = row.createCell(5);
		cell.setCellValue("통화결과");
		cell = row.createCell(6);
		cell.setCellValue("가입일");
		cell = row.createCell(7);
		cell.setCellValue("납입회차");
		cell = row.createCell(8);
		cell.setCellValue("납입수단");
		cell = row.createCell(9);
		cell.setCellValue("해약(행사)일");
		
		cell = row.createCell(10);
		cell.setCellValue("주계약");
		
		cell = row.createCell(11);
		cell.setCellValue("채널유형코드명");
		cell = row.createCell(12);
		cell.setCellValue("유치대리점명");
		cell = row.createCell(13);
		cell.setCellValue("대리점/직영점 코드");
		
		cell = row.createCell(14);
		cell.setCellValue("도매직영점 판매구분");
		cell = row.createCell(15);
		cell.setCellValue("도매 판매점 POS 코드");
		cell = row.createCell(16);
		cell.setCellValue("도매 판매점명");
		cell = row.createCell(17);
		cell.setCellValue("판매사명");
		cell = row.createCell(18);
		cell.setCellValue("판매자 사번");
		
	}
	
	//엑셀 바디 작성
	private void createBody(int index, EmfMap emfMap) {
		row = sheet.createRow(index);
		
		String joinMethod = emfMap.getString("joinMethod");
		if (joinMethod.equals("fixedLine")){
			joinMethod = "TM";
		} else if (joinMethod.equals("electronicContract")){
			joinMethod = "전자계약";
		}
		 
		//  접수 구분
//		cell = row.createCell(0);
//		cell.setCellValue(joinMethod);
		// 코드1
		cell = row.createCell(0);
		cell.setCellValue(emfMap.getString("code1"));
		// 코드2
		cell = row.createCell(1);
		cell.setCellValue(emfMap.getString("code2"));
		// U+가입번호
		cell = row.createCell(2);
		cell.setCellValue(emfMap.getString("homePrdNum"));
		// 대명가입번호
		cell = row.createCell(3);
		cell.setCellValue(emfMap.getString("idNo"));
		// 상담신청일
		cell = row.createCell(4);
		cell.setCellValue(emfMap.getString("regDtm"));
		// 통화결과
		cell = row.createCell(5);
		cell.setCellValue(emfMap.getString("dpmsReslNm"));
		// 가입일
		cell = row.createCell(6);
		cell.setCellValue(emfMap.getString("joinDt"));
		// 납입회자
		cell = row.createCell(7);
		cell.setCellValue(emfMap.getString("trueCount"));
		// 납입수단
		cell = row.createCell(8);
		cell.setCellValue(emfMap.getString("payMthd"));
		// 해약일자
		cell = row.createCell(9);
		if( emfMap.getString("accStat").equals("해약") ) {
			cell.setCellValue(emfMap.getString("resnProcDay"));
		} else if( emfMap.getString("accStat").equals("행사") ) {
			cell.setCellValue(emfMap.getString("eventProcDay"));
		}
		// 주계약
		cell = row.createCell(10);
		cell.setCellValue(emfMap.getString("mainContType"));
		
		// 채널유형코드명
		cell = row.createCell(11);
		cell.setCellValue(emfMap.getString("uCmmnCdNm"));
		// 유치대리점명
		cell = row.createCell(12);
		cell.setCellValue(emfMap.getString("uDlrNm"));
		// 대리점/직영점 코드
		cell = row.createCell(13);
		cell.setCellValue(emfMap.getString("uDlrCd"));
		
		// 도매직영점 판매구분
		cell = row.createCell(14);
		cell.setCellValue(emfMap.getString("salesType"));
		// 도매직영점 POS코드
		cell = row.createCell(15);
		cell.setCellValue(emfMap.getString("whPosCd"));
		// 도매판매점명
		cell = row.createCell(16);
		cell.setCellValue(emfMap.getString("whStoreNm"));
		// 판매사명
		cell = row.createCell(17);
		cell.setCellValue(emfMap.getString("agentEmpNm"));
		// 판매자 사번
		cell = row.createCell(18);
		cell.setCellValue(emfMap.getString("uIndcEmpno"));
		
	}
}
