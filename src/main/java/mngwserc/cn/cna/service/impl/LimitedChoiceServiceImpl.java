package mngwserc.cn.cna.service.impl;

import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import emf.core.vo.EmfMap;
import mngwserc.cn.cna.GetAllMapValue;
import mngwserc.cn.cna.service.dao.LimitedChoiceDAO;
import mngwserc.co.util.COPaginationUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class LimitedChoiceServiceImpl {

    @Autowired
    private LimitedChoiceDAO limitedChoiceDAO;

    private final static String img_path = EgovProperties.getProperty("Globals.limitedImageStorePath");


    public List<EmfMap> getLimitedChoiceCategoryList() throws Exception {
        return limitedChoiceDAO.getLimitedChoiceCategoryList();
    }

    public EmfMap getLimitedChoiceProductList(EmfMap emfMap) throws Exception {

        PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);

        //페이징 처리
        emfMap.put("paginationInfo", paginationInfo);

        List<EmfMap> list = limitedChoiceDAO.getLimitedChoiceProductList(emfMap);
        emfMap.put("list", list);


        if (list.size() > 0) paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
        else paginationInfo.setTotalRecordCount(0);

        return emfMap;
    }

    public EmfMap getLimitedChoiceProductInfo(EmfMap emfMap) throws Exception {

        EmfMap productInfo = limitedChoiceDAO.getLimitedChoiceProductInfo(emfMap);

        if (productInfo != null) {
            emfMap.put("prdMgrInfo", productInfo);
            emfMap.put("prdSpecImgList", limitedChoiceDAO.getLimitedChoiceFileInfo("spec", "prdmgr", emfMap));
            emfMap.put("prdImgList", limitedChoiceDAO.getLimitedChoiceFileInfo("prd", "prdmgr", emfMap));
            emfMap.put("prdImgCnt", limitedChoiceDAO.getZeroChoiseImgContainerCnt("prd", "prdmgr", emfMap));
        }

        return emfMap;
    }

    public void setLimitedChoiceProduct(EmfMap emfMap, HttpServletRequest request) throws Exception {

        EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();

        emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
        emfMap.put("regId", lgnMap.getString("id"));
        emfMap.put("regIp", lgnMap.getString("loginIp"));
        emfMap.put("modId", lgnMap.getString("id"));
        emfMap.put("modIp", lgnMap.getString("loginIp"));
        emfMap.put("priceYn", "on".equals(emfMap.getString("priceYn")) ? "Y" : "N");
        emfMap.put("priceBenefitUnitYn", "on".equals(emfMap.getString("priceBenefitUnitYn")) ? "Y" : "N");

        int limitedChoiceProductSeq = limitedChoiceDAO.setLimitedChoiceProduct(emfMap);
        emfMap.put("limitedChoiceProductSeq", limitedChoiceProductSeq);

        // 이미지 파일 저장
        List<EmfMap> list = new ArrayList<EmfMap>();

        MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) request;
        Iterator<String> iter = mReq.getFileNames();
        MultipartFile mf;

        while (iter.hasNext()) {

            mf = mReq.getFile(iter.next());

            if (mf.isEmpty() == false) {

                String ori_filenm = mf.getOriginalFilename();
                String filenm = ori_filenm.substring(0, ori_filenm.lastIndexOf("."));
                String ext = ori_filenm.substring(ori_filenm.lastIndexOf(".") + 1, ori_filenm.length());
                String size = "";
                String local_file_nm = System.currentTimeMillis() + "_" + filenm + "." + ext;

                if (mf.getSize() / 1024 / 1024 > 1) { //MB
                    size = Math.round(Math.ceil(mf.getSize() / 1024 / 1024)) + " MB";
                } else { //KB
                    size = Math.round(Math.ceil(mf.getSize() / 1024)) + " KB";
                }

                String name = mf.getName();
                String classification = name.contains("pc") == true ? "pc" : "mobile";
                String using = name.contains("prd_spec") == true ? "spec" : "prd";
                String regOrder = name.substring(name.lastIndexOf("_") + 1, name.length());

                EmfMap map = new EmfMap();

                map.put("classification", classification);
                map.put("fileNm", filenm);
                map.put("fileSize", size);
                map.put("fileType", ext);
                map.put("regOrder", regOrder);
                map.put("using", using);
                map.put("localFileName", local_file_nm);
                map.put("path", img_path);

                list.add(map);

                // 서버폴더에 이미지 저장
                try {
                    EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        emfMap.put("imgFile", list);
        emfMap.put("zeroChoiGb", "prdmgr");
        limitedChoiceDAO.setLimitedChoiceFile(emfMap);
    }

    public EmfMap selectFileInfoByFileSeq(EmfMap emfMap) throws Exception {
        return limitedChoiceDAO.selectFileInfoByFileSeq(emfMap);
    }

    public void delLimitedChoiceProduct(EmfMap emfMap) throws Exception {

        Object obj = emfMap.get("delSeq");

        if (!obj.getClass().isArray()) {
            emfMap.put("delSeq", Arrays.asList(obj));
        }

        limitedChoiceDAO.delLimitedChoiceProduct(emfMap);
        limitedChoiceDAO.delLimitedChoiceFile(emfMap);
    }

    public void modifyLimitedChoiceProduct(EmfMap emfMap, HttpServletRequest request) throws Exception {
        EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();

        List<String> space_del_orders_list = new ArrayList<String>();
        String[] spaceDelOrders_arr = emfMap.getString("spaceDelOrders").split(",");
        for(int i=0; i<spaceDelOrders_arr.length; i++) {
            space_del_orders_list.add(spaceDelOrders_arr[i]);
        }

        emfMap.put("space_del_orders_list", space_del_orders_list);
        emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
        emfMap.put("modId", lgnMap.getString("id"));
        emfMap.put("modIp", lgnMap.getString("loginIp"));
        emfMap.put("seq", emfMap.getString("prdctSeq"));
        emfMap.put("priceYn", "on".equals(emfMap.getString("priceYn")) ? "Y" : "N");
        emfMap.put("priceBenefitUnitYn", "on".equals(emfMap.getString("priceBenefitUnitYn")) ? "Y" : "N");

        GetAllMapValue.getMapValue(emfMap);
        limitedChoiceDAO.modifyLimitedChoiceProduct(emfMap);

        // 이미지 파일 저장
        MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) request;
        Iterator<String> iter = mReq.getFileNames();
        MultipartFile mf;

        while(iter.hasNext()) {
            mf = mReq.getFile(iter.next());
            if(mf.isEmpty() == false) {
                String ori_filenm = mf.getOriginalFilename();
                String filenm = ori_filenm.substring(0, ori_filenm.lastIndexOf("."));
                String ext = ori_filenm.substring(ori_filenm.lastIndexOf(".")+1, ori_filenm.length());
                String size = "";
                String local_file_nm = System.currentTimeMillis() + "_" + filenm + "." + ext;

                if(mf.getSize()/1024/1024 > 1) { //MB
                    size = Math.round(Math.ceil(mf.getSize()/1024/1024)) + " MB";
                } else { //KB
                    size = Math.round(Math.ceil(mf.getSize()/1024)) + " KB";
                }

                String name = mf.getName();
                String classification = name.contains("pc") == true ? "pc" : "mobile";
                String using = name.contains("prd_spec") == true ? "spec" : "prd";
                String regOrder = name.substring(name.lastIndexOf("_")+1, name.length());

                EmfMap map = new EmfMap();

                map.put("classification", classification);
                map.put("fileNm", filenm);
                map.put("fileSize", size);
                map.put("fileType", ext);
                map.put("regOrder", regOrder);
                map.put("chfGb", "prdmgr");
                map.put("using", using);
                map.put("localFileName", local_file_nm);
                map.put("path", img_path);

                // 서버폴더에 이미지 저장
                try {
                    EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                emfMap.put("fileInfo", map);

                GetAllMapValue.getMapValue(emfMap);

                limitedChoiceDAO.mergeLimitedChoiceFile(emfMap);
            }
        }

        if (space_del_orders_list.size() > 0) {
            emfMap.put("using", "prd");
            emfMap.put("zeroChoiGb", "prdmgr");
            limitedChoiceDAO.deleteLimitedChoiceFileByUpdate(emfMap);
        }
    }

    public JSONArray getCategoryList() throws Exception {

        List<EmfMap> cateList = limitedChoiceDAO.getLimitedChoiceCategoryList();

        JSONArray jSONArray = new JSONArray();

        if (cateList.size() > 0) {
            for (int i = 0; i < cateList.size(); i++) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jsonAttr = new JSONObject();

                jsonAttr.put("id", "node_" + cateList.get(i).getString("cateSeq"));
                jsonAttr.put("rel", "cms");

                jSONObject.put("attr", jsonAttr);
                jSONObject.put("data", cateList.get(i).getString("cateNm"));

                jSONArray.put(jSONObject);
            }
        }

        return jSONArray;
    }

    public int setCategory(EmfMap emfMap) throws Exception {
        GetAllMapValue.getMapValue(emfMap);

        EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();

        emfMap.put("regId", lgnMap.getString("id"));
        emfMap.put("regIp", lgnMap.getString("loginIp"));
        emfMap.put("modId", lgnMap.getString("id"));
        emfMap.put("modIp", lgnMap.getString("loginIp"));

        return limitedChoiceDAO.setCategory(emfMap);
    }

    public int modCategoryName(EmfMap emfMap) throws Exception {
        EmfMap lgnMap = (EmfMap) EgovUserDetailsHelper.getAuthenticatedUser();

        emfMap.put("modId", lgnMap.getString("id"));
        emfMap.put("modIp", lgnMap.getString("loginIp"));

        GetAllMapValue.getMapValue(emfMap);

        return limitedChoiceDAO.modCategoryName(emfMap);
    }

    public int modCategoryOrder(EmfMap emfMap) throws Exception {
        emfMap.put("cateSeq", Integer.parseInt((String) emfMap.get("cateSeq")));
        emfMap.put("pstn", Integer.parseInt((String) emfMap.get("pstn")));
        return limitedChoiceDAO.modCategoryOrder(emfMap);
    }

    public int removeCategory(EmfMap emfMap) throws Exception {
        int delCnt = limitedChoiceDAO.removeCategory(emfMap);
        limitedChoiceDAO.sortCategory();
        return delCnt;
    }

    public EmfMap getLimitedChoiceImageList(EmfMap emfMap) throws Exception {
        PaginationInfo paginationInfo = new COPaginationUtil().getPage(emfMap);
        //페이징 처리
        emfMap.put("paginationInfo", paginationInfo);

        List<EmfMap> list = limitedChoiceDAO.getLimitedChoiceImageList(emfMap);
        emfMap.put("list", list);


        if (list.size() > 0) paginationInfo.setTotalRecordCount(Integer.parseInt(list.get(0).getString("totCnt")));
        else paginationInfo.setTotalRecordCount(0);

        return emfMap;
    }

    public EmfMap getLimitedChoiceImageInfo(EmfMap emfMap) throws Exception {
        EmfMap imgMgrInfo = limitedChoiceDAO.getLimitedChoiceImageInfo(emfMap);
        List<EmfMap> imageList = limitedChoiceDAO.getLimitedChoiceFileInfo(null, "imgmgr", emfMap);
        List<EmfMap> topFileList = new ArrayList<EmfMap>();
        List<EmfMap> bottomFileList = new ArrayList<EmfMap>();
        List<EmfMap> topPopFileList = new ArrayList<EmfMap>();
        List<EmfMap> bottomPopFileList = new ArrayList<EmfMap>();

        int topContCnt = 0;
        int bottomContCnt = 0;
        int topPopContCnt = 0;
        int bottomPopContCnt = 0;

        for (EmfMap image : imageList) {

            String using = (String) image.get("using");
            int regOrder = Integer.parseInt(image.getString("regOrder"));

            if ("top".equals(using)) {
                if ( topContCnt != regOrder) topContCnt =  regOrder;
                topFileList.add(image);
            } else if ("bottom".equals(using)) {
                if ( bottomContCnt != regOrder) bottomContCnt =  regOrder;
                bottomFileList.add(image);
            } else if ("top_pop".equals(using)) {
                if ( topPopContCnt != regOrder) topPopContCnt =  regOrder;
                topPopFileList.add(image);
            } else if ("bottom_pop".equals(using)) {
                if ( bottomPopContCnt != regOrder) bottomPopContCnt =  regOrder;
                bottomPopFileList.add(image);
            }
        }

        emfMap.put("imgMgrInfo", imgMgrInfo);
        emfMap.put("topFileList", topFileList);
        emfMap.put("bottomFileList", bottomFileList);
        emfMap.put("topPopFileList", topPopFileList);
        emfMap.put("bottomPopFileList", bottomPopFileList);
        emfMap.put("topContCnt", topContCnt);
        emfMap.put("bottomContCnt", bottomContCnt);
        emfMap.put("topPopContCnt", topPopContCnt);
        emfMap.put("bottomPopContCnt", bottomPopContCnt);

        return emfMap;
    }

    public void modifyLimitedChoiceImage(EmfMap emfMap, HttpServletRequest request) throws Exception {

        EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();

        emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
        emfMap.put("modId", lgnMap.getString("id"));
        emfMap.put("modIp", lgnMap.getString("loginIp"));
        emfMap.put("seq", emfMap.getString("imgSeq"));

        limitedChoiceDAO.modifyLimitedChoiceImage(emfMap);

        // 이미지 파일 저장
        MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) request;
        Iterator<String> iter = mReq.getFileNames();
        MultipartFile mf;

        // 이미지 파일 저장
        List<EmfMap> list = new ArrayList<EmfMap>();
        List<EmfMap> db_file =  new ArrayList<EmfMap>();

        while (iter.hasNext()) {

            mf = mReq.getFile(iter.next());

            if (!mf.isEmpty()) {

                String ori_filenm = mf.getOriginalFilename();
                String filenm = ori_filenm.substring(0, ori_filenm.lastIndexOf("."));
                String ext = ori_filenm.substring(ori_filenm.lastIndexOf(".")+1, ori_filenm.length());
                String size = "";
                String local_file_nm = System.currentTimeMillis() + "_" + filenm + "." + ext;

                if (mf.getSize()/1024/1024 > 1) { //MB
                    size = Math.round(Math.ceil(mf.getSize()/1024/1024)) + " MB";
                } else { //KB
                    size = Math.round(Math.ceil(mf.getSize()/1024)) + " KB";
                }

                String name = mf.getName();

                String classification = name.contains("pc") == true ? "pc" : "mobile";
                String using = "";

                if (name.contains("top")) {
                    if (name.contains("pop")) using = "top_pop";
                    else using = "top";
                } else {
                    if (name.contains("pop")) using = "bottom_pop";
                    else using = "bottom";
                }

                String regOrder = name.substring(name.lastIndexOf("_")+1, name.length());

                EmfMap map = new EmfMap();

                map.put("classification", classification);
                map.put("fileNm", filenm);
                map.put("fileSize", size);
                map.put("fileType", ext);
                map.put("regOrder", regOrder);
                map.put("using", using);
                map.put("localFileName", local_file_nm);
                map.put("path", img_path);
                map.put("chfGb", "imgmgr");

                // 서버폴더에 이미지 저장
                try {
                    EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                emfMap.put("fileInfo", map);

                limitedChoiceDAO.mergeLimitedChoiceFile(emfMap);
            }
        }

        // 영역 삭제한 항목 삭제
        String[] spaceDelOrders_arr = emfMap.getString("spaceDelOrders").split(",");

        if(!"".equals(spaceDelOrders_arr[0])) {
            List<EmfMap> space_del_orders_list = new ArrayList<EmfMap>();

            for(int i=0; i<spaceDelOrders_arr.length; i++) {
                String gubun = spaceDelOrders_arr[i].split("_")[0];
                String regOrder = spaceDelOrders_arr[i].split("_")[1];

                EmfMap delMap = new EmfMap();
                delMap.put("gubun", gubun);
                delMap.put("regOrder", regOrder);

                space_del_orders_list.add(delMap);
            }
            emfMap.put("space_del_orders_list", space_del_orders_list);
            emfMap.put("zeroChoiGb", "imgmgr");

            limitedChoiceDAO.deleteLimitedChoiceFileByUpdate(emfMap);
        }
    }

    public void setLimitedChoiceImage(EmfMap emfMap, HttpServletRequest request) throws Exception {

        EmfMap lgnMap = (EmfMap)EgovUserDetailsHelper.getAuthenticatedUser();

        emfMap.put("ptupDt", emfMap.getString("ptupDt").replaceAll("-", ""));
        emfMap.put("regId", lgnMap.getString("id"));
        emfMap.put("regIp", lgnMap.getString("loginIp"));
        emfMap.put("modId", lgnMap.getString("id"));
        emfMap.put("modIp", lgnMap.getString("loginIp"));
        emfMap.put("zeroChoiGb", "imgmgr");

        if ("Y".equals(emfMap.getString("useYn"))) {
            // 모든 useYn을 N으로 변경
            emfMap.put("imgSeq", -1);
            limitedChoiceDAO.modifyLimitedChoiceImage(emfMap);
        }

        emfMap.put("limitedChoiceProductSeq", limitedChoiceDAO.setLimitedChoiceImage(emfMap));

        // 이미지 파일 저장
        List<EmfMap> list = new ArrayList<EmfMap>();

        MultipartHttpServletRequest mReq = (MultipartHttpServletRequest) request;
        Iterator<String> iter = mReq.getFileNames();
        MultipartFile mf;

        while (iter.hasNext()) {

            mf = mReq.getFile(iter.next());

            if (mf.isEmpty() == false) {
                String ori_filenm = mf.getOriginalFilename();
                String filenm = ori_filenm.substring(0, ori_filenm.lastIndexOf("."));
                String ext = ori_filenm.substring(ori_filenm.lastIndexOf(".")+1, ori_filenm.length());
                String size = "";
                String local_file_nm = System.currentTimeMillis() + "_" + filenm + "." + ext;

                if (mf.getSize()/1024/1024 > 1) { //MB
                    size = Math.round(Math.ceil(mf.getSize()/1024/1024)) + " MB";
                } else { //KB
                    size = Math.round(Math.ceil(mf.getSize()/1024)) + " KB";
                }

                String name = mf.getName();
                String classification = name.contains("pc") == true ? "pc" : "mobile";
                String using = "";

                if (name.contains("top")) {
                    if (name.contains("pop")) using = "top_pop";
                    else using = "top";
                }

                if(name.contains("bottom")) {
                    if (name.contains("pop")) using = "bottom_pop";
                    else using = "bottom";
                }

                String regOrder = name.substring(name.lastIndexOf("_")+1, name.length());

                EmfMap map = new EmfMap();

                map.put("classification", classification);
                map.put("fileNm", filenm);
                map.put("fileSize", size);
                map.put("fileType", ext);
                map.put("regOrder", regOrder);
                map.put("using", using);
                map.put("localFileName", local_file_nm);
                map.put("path", img_path);

                list.add(map);

                try {
                    EgovFileMngUtil.uploadFileImg(mf, img_path, local_file_nm);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        emfMap.put("imgFile", list);

        limitedChoiceDAO.setLimitedChoiceFile(emfMap);
    }

    public void delLimitedChoiceImage(EmfMap emfMap) throws Exception {
        Object obj = emfMap.get("delSeq");

        if (!obj.getClass().isArray()) {
            emfMap.put("delSeq", Arrays.asList(obj));
        }

        limitedChoiceDAO.delLimitedChoiceImage(emfMap);
        limitedChoiceDAO.delLimitedChoiceFile(emfMap);
    }

}
