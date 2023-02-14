package mngwserc.cn.cna.web;

import emf.core.exception.EmfException;
import emf.core.extend.web.EmfController;
import emf.core.vo.EmfMap;
import mngwserc.cn.cna.CNAFileUtil;
import mngwserc.cn.cna.service.impl.LimitedChoiceServiceImpl;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@RequestMapping(value="/mngwserc/cna/limited")
public class LimitedChoiceController extends EmfController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LimitedChoiceServiceImpl limitedChoiceService;

    @RequestMapping(value = "/product/list.do", method = RequestMethod.GET)
    public String getLimitedChoiceProductList(EmfMap emfMap, ModelMap modelMap) throws Exception {

        logger.info("GET LIMITED CHOICE PRODUCT LIST :: {}", emfMap);

        EmfMap rtnMap;

        try {
            rtnMap = limitedChoiceService.getLimitedChoiceProductList(emfMap);
            rtnMap.put("cateList", limitedChoiceService.getLimitedChoiceCategoryList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmfException(e.getMessage());
        }

        modelMap.addAttribute("rtnMap", rtnMap);

        logger.info("RESULT :: {}", modelMap);

        return "mngwserc/cn/cna/limited/ProductList.admin";
    }

    @RequestMapping(value = "/product/detail.ajax", method = RequestMethod.GET)
    public ModelAndView getLimitedChoiceProductInfo(EmfMap emfMap) throws Exception {

        logger.info("GET PRODUCT DETAIL :: {}", emfMap);

        EmfMap rtnMap;

        try {
            rtnMap = limitedChoiceService.getLimitedChoiceProductInfo(emfMap);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmfException(e.getMessage());
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("data", rtnMap);
        mav.setViewName("jsonView");

        return mav;
    }

    @RequestMapping(value = "/product/insert.do", method = RequestMethod.POST)
    public String setLimitedChoiceProduct(EmfMap emfMap, HttpServletRequest request) throws Exception {

        try {
            limitedChoiceService.setLimitedChoiceProduct(emfMap, request);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmfException(e.getMessage());
        }

        return "redirect:./list.do";
    }

    @RequestMapping(value = "/product/previewImg.do", method = RequestMethod.GET)
    public void previewImgFile(EmfMap emfMap, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
        CNAFileUtil.getImageInf(limitedChoiceService.selectFileInfoByFileSeq(emfMap), response);
    }

    @RequestMapping(value = "/product/delete.do", method = RequestMethod.POST)
    public String delLimitedChoice(EmfMap emfMap, ModelMap modelMap) throws Exception {

        try {
            limitedChoiceService.delLimitedChoiceProduct(emfMap);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmfException(e.getMessage());
        }

        return "redirect:./list.do";
    }

    @RequestMapping(value = "/product/update.do", method = RequestMethod.POST)
    public String modifyLimitedChoiceProduct(EmfMap emfMap, HttpServletRequest request) throws Exception {

        try {
            limitedChoiceService.modifyLimitedChoiceProduct(emfMap, request);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmfException(e.getMessage());
        }

        return "redirect:./list.do";
    }

    @RequestMapping(value = "/category/list.do", method = RequestMethod.GET)
    public String getLimitedChoiceCategoryList() throws Exception {
        return "mngwserc/cn/cna/limited/category.admin";
    }

    @RequestMapping(value = "/category/getCateJson.ajax", method = RequestMethod.GET)
    public void getCategoryList(HttpServletResponse response) throws Exception {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            JSONArray jSONArray = limitedChoiceService.getCategoryList();
            out.print(jSONArray);
        } catch (Exception he) {
            he.printStackTrace();
            throw new EmfException(he.getMessage());
        } finally {
            out.close();
        }
    }

    @RequestMapping(value = "/category/insertCateMenu.ajax", method = RequestMethod.POST)
    public ModelAndView setCategory(EmfMap emfMap) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("jsonView");

        try {
            mav.addObject("insMenuSeq", limitedChoiceService.setCategory(emfMap));
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmfException(e.getMessage());
        }

        return mav;
    }

    @RequestMapping(value = "/category/updateCateMenuNm.ajax", method = RequestMethod.POST)
    public ModelAndView modCategoryName(EmfMap emfMap) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("jsonView");

        try {
            mav.addObject("updCnt", limitedChoiceService.modCategoryName(emfMap));
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmfException(e.getMessage());
        }
        return mav;
    }

    @RequestMapping(value = "/category/updateCateMenuPstn.ajax", method = RequestMethod.POST)
    public ModelAndView modCategoryOrder(EmfMap emfMap) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("jsonView");

        try {
            limitedChoiceService.modCategoryOrder(emfMap);
            mav.addObject("moveYn", "Y");
            mav.setViewName("jsonView");
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmfException(e.getMessage());
        }
        return mav;
    }

    @RequestMapping(value = "/category/deleteCateMenu.ajax", method = RequestMethod.POST)
    public ModelAndView removeCategory(EmfMap emfMap) throws Exception {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("jsonView");

        try {
            int delCnt = limitedChoiceService.removeCategory(emfMap);

            mav.addObject("delCnt", delCnt);
            mav.setViewName("jsonView");

        } catch (Exception e) {
            e.printStackTrace();
            throw new EmfException(e.getMessage());
        }
        return mav;
    }

    @RequestMapping(value = "/image/list.do", method = RequestMethod.GET)
    public String getLimitedChoiceImageList(EmfMap emfMap, ModelMap modelMap) throws Exception {

        try {
            modelMap.addAttribute("rtnMap", limitedChoiceService.getLimitedChoiceImageList(emfMap));
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmfException(e.getMessage());
        }

        return "mngwserc/cn/cna/limited/imageList.admin";
    }

    @RequestMapping(value = "/image/detail.ajax", method = RequestMethod.GET)
    public ModelAndView getLimitedChoiceImageInfo(EmfMap emfMap) throws Exception {

        EmfMap rtnMap;

        try {
            rtnMap = limitedChoiceService.getLimitedChoiceImageInfo(emfMap);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmfException(e.getMessage());
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("data", rtnMap);
        mav.setViewName("jsonView");

        return mav;
    }

    @RequestMapping(value = "/image/update.do", method = RequestMethod.POST)
    public String modifyLimitedChoiceImage(EmfMap emfMap, HttpServletRequest request) throws Exception {

        try {
            limitedChoiceService.modifyLimitedChoiceImage(emfMap, request);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmfException(e.getMessage());
        }

        return "redirect:./list.do";
    }

    @RequestMapping(value = "/image/insert.do", method = RequestMethod.POST)
    public String setLimitedChoiceImage(EmfMap emfMap, HttpServletRequest request) throws Exception {

        try {
            limitedChoiceService.setLimitedChoiceImage(emfMap, request);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmfException(e.getMessage());
        }

        return "redirect:./list.do";
    }

    @RequestMapping(value = "/image/delete.do", method = RequestMethod.POST)
    public String delLimitedChoiceImage(EmfMap emfMap) throws Exception {

        try {
            limitedChoiceService.delLimitedChoiceImage(emfMap);
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmfException(e.getMessage());
        }

        return "redirect:./list.do";
    }

}
