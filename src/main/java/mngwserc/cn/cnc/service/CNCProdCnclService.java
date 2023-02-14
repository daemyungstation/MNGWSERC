package mngwserc.cn.cnc.service;

import javax.servlet.http.HttpServletRequest;

import emf.core.vo.EmfMap;
import jxl.Workbook;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface CNCProdCnclService {

	public EmfMap selectProdCnclList(EmfMap emfMap) throws Exception;

	public EmfMap selectProdCncl(EmfMap emfMap) throws Exception;

	public void updateProdCncl(HttpServletRequest request, EmfMap emfMap) throws Exception;

	public void deleteProdCnclList(int[] delSeq) throws Exception;

	public EmfMap selectProdCnclMngExcelList(EmfMap emfMap) throws Exception;

	EmfMap setExcelData(MultipartHttpServletRequest multiRequest) throws Exception;

}
