package mngwserc.fair.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import emf.core.extend.service.EmfAbstractService;
import emf.core.vo.EmfMap;
import mngwserc.fair.service.FairDistributeService;
import mngwserc.fair.service.dao.FairDistributeDao;

/**
 * <pre> 
 * 박람회 배포 관리 Implement
 * </pre>
 * 
 * @ClassName		: FairUserServiceImpl.java
 * @Description		: 박람회 배포 관리 Implement
 * @author inuscommunity
 * @since 2019. 10. 23.
 * @version 1.0
 * @see
 * @Modification Information
 * <pre>
 * 	    since			author	               description
 *  ============    ==============    =============================
 *  2019. 10. 23.	   inuscomm                 최초생성
 * </pre>
 */

@Service("fairDistributeService")
public class FairDistributeServiceImpl extends EmfAbstractService implements FairDistributeService {
	
	/** 서비스 **/
	@Resource(name="fairDistributeDao")
	private FairDistributeDao fairDistributeDAO;
	
	
	/**
     * 메인 HTML 생성
     * 
     * @param 
	 * @return String
	 * @throws Exception
     */
	public EmfMap makeMain() throws Exception {
		EmfMap rstMap = new EmfMap();
		String html = "";
		
		//전체설정
		List<EmfMap> configList = fairDistributeDAO.configList();
		EmfMap config = new EmfMap();
		if(configList.size() > 0)
		{
			config = configList.get(0);
		}
		
		//배너
		int bannerHeight = 0;
		List<EmfMap> bannerList = fairDistributeDAO.selectBanner();
		for(EmfMap bl : bannerList)
		{
			BufferedImage imgBanner = ImageIO.read(new File(bl.getString("fbtImageBgPath")+"/"+bl.getString("fbtImageWSaveNm")));
			if(imgBanner.getHeight() > bannerHeight) {
				bannerHeight = imgBanner.getHeight();
			}
		}
		
		//소구포인트
		int pointHeight = 0;
		List<EmfMap> points = fairDistributeDAO.selectPoint();
		EmfMap point = new EmfMap();
		List<EmfMap> pointSubList = new ArrayList<EmfMap>(); 
		if(points.size() > 0)
		{
			point = points.get(0);
			BufferedImage imgPoint = ImageIO.read(new File(point.getString("fmImageBgPath")+"/"+point.getString("fmImageBgSaveNm")));
			pointHeight = imgPoint.getHeight();

			pointSubList = fairDistributeDAO.selectPointList();
			for(EmfMap psl : pointSubList)
			{
				psl.put("fmsDesc", psl.getString("fmsDesc").replaceAll("\r\n", "<br>"));
			}
		}
		
		//카테고리 & 상품
		List<EmfMap> cateList = fairDistributeDAO.selectCategory();
		for(EmfMap cl : cateList)
		{
			cl.put("fcSubtitle", cl.getString("fcSubtitle").replaceAll("\r\n", "<br>"));

			//상품
			EmfMap param = new EmfMap();
			param.put("fcMainMaxCount", cl.getString("fcMainMaxCount"));
			param.put("fcSeq", cl.getString("fcSeq"));
			List<EmfMap> product = fairDistributeDAO.selectProduct(param);
			for(EmfMap pl : product)
			{
				BufferedImage imgProduct = ImageIO.read(new File(pl.getString("fpMainImageBgPath")+"/"+pl.getString("fpMainImageBgSaveNm")));
				pl.put("fpMainHeight", imgProduct.getHeight());
				
				pl.put("fpMainSubtitle", pl.getString("fpMainSubtitle").replaceAll("\r\n", "<br>"));
				pl.put("fpMainDesc", pl.getString("fpMainDesc").replaceAll("\r\n", "<br>"));
			}
			
			cl.put("productList", product);
		}
		
		//이벤트
		List<EmfMap> eventList = fairDistributeDAO.selectEvent();
		
		
		//PC HTML
		html += "<%@ page pageEncoding=\"UTF-8\" contentType=\"text/html; charset=UTF-8\"%>\n";
		html += "<%@include file=\"/WEB-INF/jsp/include/el.jspf\" %>\n";
		html += "<!doctype html>\n";
		html += "<html lang=\"ko\">\n";
		html += "<head>\n";
		html += "<meta charset=\"utf-8\" />\n";
		html += "<title>"+ config.getString("fcfgTitle") +"</title>\n";
		html += "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n";
		html += "<meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,user-scalable=no,maximum-scale=1.0,minimum-scale=1.0,target-densitydpi=medium-dpi\" />\n";
		html += "<meta name=\"author\" content=\"http://www.daemyungimready.com\" />\n";
		html += "<meta name=\"keywords\" content=\"대명아임레디, 라이프케어, 상조/웨딩/여행, 업계 최초 멤버십/결합혜택, 회원가입, 고객센터\" />\n";
		html += "<meta name=\"description\" content=\"대명아임레디, 라이프케어, 상조/웨딩/여행, 업계 최초 멤버십/결합혜택, 회원가입, 고객센터\" />\n";
		html += "<meta name=\"format-detection\" content =\"telephone=no\"/>\n";
		html += "<meta name=\"naver-site-verification\" content=\"6b34a18682ba6578cac42877a7c865a026aabaa8\"/>\n";
		html += "<meta property=\"og:type\" content=\"article\" />\n";
		html += "<meta property=\"og:site_name\" content=\"대명아임레디\" />\n";
		html += "<meta property=\"og:title\" content=\"대명아임레디\" />\n";
		html += "<meta property=\"og:description\" content=\"대명아임레디, 라이프케어, 상조/웨딩/여행, 업계 최초 멤버십/결합혜택, 회원가입, 고객센터\" />\n";
		html += "<meta property=\"og:image\" content=\"http://www.daemyunglifeway.com/common/images/logo.gif\" />\n";
		html += "<link rel=\"shortcut icon\" href=\"/common/images/favicon_16.ico\" type=\"image/x-icon\" />\n";
		html += "<link rel=\"icon\" href=\"/common/images/favicon_16.ico\" type=\"image/x-icon\" />\n";
		html += "\n";
		html += "<script type=\"text/javascript\" src=\"/common/js/jquery-1.8.2.min.js\"></script>\n";
		html += "<script type='text/javascript' src='/common/js/swiper.min.js'></script>\n";
		html += "<link rel='stylesheet' type='text/css' href='/common/css/swiper.min.css' />\n";
		html += "</head>\n";
		html += "\n";
		html += "<style>\n";
		html += "@font-face {\n";
		html += "font-family: 'NotoKrL';\n";
		html += "font-style: normal;\n";
		html += "font-weight: 100;\n";
		html += "src: local('Noto Sans Light'), local('NotoSans-Light'), url(/common/css/fonts/NotoSans-Light.eot);\n";
		html += "src: url(/common/css/fonts/NotoSans-Light.eot?#iefix) format('embedded-opentype'),\n";
		html += "url(/common/css/fonts/NotoSans-Light.woff2) format('woff2'),\n";
		html += "url(/common/css/fonts/NotoSans-Light.woff) format('woff');;\n";
		html += "}\n";
		html += "@font-face {\n";
		html += "font-family: 'NotoKrR';\n";
		html += "font-style: normal;\n";
		html += "font-weight: 300;\n";
		html += "src: local('Noto Sans Regular'), local('NotoSans-Regular'), url(/common/css/fonts/NotoSans-Regular.eot);\n";
		html += "src: url(/common/css/fonts/NotoSans-Regular.eot?#iefix) format('embedded-opentype'),\n";
		html += "url(/common/css/fonts/NotoSans-Regular.woff2) format('woff2'),\n";
		html += "url(/common/css/fonts/NotoSans-Regular.woff) format('woff');\n";
		html += "}\n";
		html += "@font-face {\n";
		html += "font-family: 'NotoKrM';\n";
		html += "font-style: normal;\n";
		html += "font-weight: 500;\n";
		html += "src: local('Noto Sans Medium'), local('NotoSans-Medium'), url(/common/css/fonts/NotoSans-Medium.eot);\n";
		html += "src: url(/common/css/fonts/NotoSans-Medium.eot?#iefix) format('embedded-opentype'),\n";
		html += "url(/common/css/fonts/NotoSans-Medium.woff2) format('woff2'),\n";
		html += "url(/common/css/fonts/NotoSans-Medium.woff) format('woff');\n";
		html += "}\n";
		html += "@font-face {\n";
		html += "font-family: 'NotoKrB';\n";
		html += "font-style: normal;\n";
		html += "font-weight: 700;\n";
		html += "src: local('Noto Sans Bold'), local('NotoSans-Bold'), url(/common/css/fonts/NotoSans-Bold.eot);\n";
		html += "src: url(/common/css/fonts/NotoSans-Bold.eot?#iefix) format('embedded-opentype'),\n";
		html += "url(/common/css/fonts/NotoSans-Bold.woff2) format('woff2'),\n";
		html += "url(/common/css/fonts/NotoSans-Bold.woff) format('woff');\n";
		html += "}\n";
		html += "\n";
		html += "body,ul,li { margin:0; padding:0; font-family:\"NotoKrR\", sans-serif;  }\n";
		html += "li { list-style:none; }\n";
		html += ".container { position:relative; width:1080px; margin:0 auto; line-height:0; text-align:center; }\n";
		html += "\n";
		html += ".header { position:relative; width:100%; height:150px; background-image:url('/common/images/fairimage/main_top.jpg'); background-size: cover; background-position: top center; }\n";
		html += ".header .header_logo { position:relative; margin: 0 auto; text-align:center; }\n";
		html += "\n";
		html += ".bannerList { position:relative; width:100%; height:"+ bannerHeight +"px; }\n";
		html += ".bannerList .banner { width:100%; height:"+ bannerHeight +"px; background-size:cover; text-align:center; }\n";
		html += ".bannerList .btn_prev { position:absolute; top:50%; left:50%; margin-left:-500px; z-index:1; }\n";
		html += ".bannerList .btn_next { position:absolute; top:50%; right:50%; margin-right:-500px; z-index:1; }\n";
		html += "\n";
		html += ".dday { position:absolute; width:100%; bottom:40px; left:0; z-index:1; text-align:center; line-height:0; }\n";
		html += ".dday .dday_container { width:auto; display: inline-block; font-family:\"NotoKrM\", sans-serif; }\n";
		html += ".dday .dday_container .day { float:left; display:block; padding:0px 50px; height:95px; line-height:95px; text-align:center; background:#000000; color:#ffffff;  font-size:55px;  border-radius:5px; box-sizing:border-box; }\n";
		html += ".dday .dday_container .time { float:left; margin-left:5px; display:block; width:80px; height:95px; line-height:95px; text-align:center; background:#ffffff; color:#000000;  font-size:55px;  border-radius:5px; box-sizing:border-box; }\n";
		html += ".dday .dday_container .comma { float:left; margin-left:5px; display:block; height:95px; line-height:0; }\n";
		html += ".dday .dday_container .comma .box { display:block; width:7px; height:7px; background:#ffffff; line-height:0; margin-top:30px; }\n";
		html += ".dday .dday_container .comma .box.bottom { margin-top:20px; }\n";
		html += ".dday .dday_container .ddat_title { display:block; line-height:normal; text-align:center; color:#ffffff;  font-size:22px;  margin-top: 10px; font-family:\"NotoKrL\", sans-serif; }\n";
		html += "\n";
		html += ".point { position:relative; width:100%; background-size:cover; }\n";
		html += ".point .pointTitle { padding-top:80px; text-align:center; box-sizing:border-box; }\n";
		html += ".point .pointSub { position:relative; display:inline-block; margin-top:70px; margin-left:5px; margin-right:5px; box-shadow: 6px 6px 6px 0 rgba(0,0,0,.2); box-sizing:border-box; }\n";
		html += ".point .pointSub .pointOver { position:absolute; top:0; left:0; width:100%; height:100%; opacity:0.95; text-align:center; display:none; }\n";
		html += ".point .pointSub .pointOver .pointOverContainer { position:relative; width:100%; display:inline-block; transform:translateY(50%); }\n";
		html += ".point .pointSub .pointOver .pointLine { width:20%; height:3px; background:#ffffff; margin:0 auto; }\n";
		html += ".point .pointSub .pointOver .pointDesc { display:inline-block; margin-top:40px; line-height:140%;  color:#ffffff; font-size:24px; }\n";
		html += "\n";
		html += ".category { position:relative; width:100%; padding:30px 0; }\n";
		html += ".category .categorySub { position:relative; display:inline-block; cursor:pointer; }\n";
		html += ".category .categorySub .categoryTitle { position:absolute; top:15px; left:25px; line-height:140%;  color:#000000; font-size:26px;  }\n";
		html += ".category .categorySub .categorySubTitle { position:relative; line-height:120%;  color:#000000; font-size:17px; padding:15px 0; font-family: \"NotoKrM\", sans-serif;}\n";
		html += "\n";
		html += ".productCategory { position:relative; }\n";
		html += ".productCategory .productCategoryTitle { position: absolute; top:45px; left:0; width:100%; text-align:center; line-height:140%; color:#ffffff; font-size:22px; z-index:1; }\n";
		html += ".productCategory .product { position:relative; width:100%; background-size:cover; background-position: center; text-align:center; }\n";
		html += ".productCategory .product .productContainer { position:relative; display:inline-block; transform:translateY(50%); box-shadow: 6px 6px 6px 0 rgba(0,0,0,.2); }\n";
		html += ".productCategory .product .productContainer .productTitle { position:absolute; top:-110px; width:100%; text-align:center; line-height:140%;  color:#ffffff; font-size:36px; }\n";
		html += ".productCategory .product .productContainer .productDetail { position:absolute; top:120px; left:65px; width:340px; height:300px; padding:20px 25px; box-sizing:border-box; background-color:rgba(255,255,255,0.8); }\n";
		html += ".productCategory .product .productContainer .productDetail .productLabel { position:relative; text-align:left; display:none; }\n";
		html += ".productCategory .product .productContainer .productDetail .productLabel .productLabelDetail { display:inline-block; line-height:120%;  color:#ffffff; font-size:15px; margin-left:5px; padding:5px; box-sizing:border-box; min-width:70px; text-align:center; }\n";
		html += ".productCategory .product .productContainer .productDetail .productLabel .productLabelDetail:first-child { margin-left:0; }\n";
		html += ".productCategory .product .productContainer .productDetail .productSubTitle { position:relative; text-align:left; line-height:120%;  color:#000000; font-size:23px; margin-top:5px; font-family: \"NotoKrM\", sans-serif; }\n";
		html += ".productCategory .product .productContainer .productDetail .productDesc { position:relative; text-align:left; line-height:160%;  color:#5f5f5f; font-size:15px; margin-top:10px; font-family: \"NotoKrM\", sans-serif; }\n";
		html += ".productCategory .product .productContainer .productDetail .productPrice { display:none; position:relative; text-align:right; margin-top:20px; }\n";
		html += ".productCategory .product .productContainer .productDetail .productPrice .prefix { line-height:120%;  color:#000000; font-size:30px; font-family: \"NotoKrM\", sans-serif; letter-spacing:-1px; }\n";
		html += ".productCategory .product .productContainer .productDetail .productPrice .price { line-height:120%;  color:#ff3b85; font-size:33px; font-family: \"NotoKrM\", sans-serif; letter-spacing:-1px; }\n";
		html += ".productCategory .product .productContainer .productDetail .productPrice .won { line-height:120%;  color:#000000; font-size:20px; font-family: \"NotoKrM\", sans-serif; letter-spacing:-1px; }\n";
		html += ".productCategory .product .productContainer .productDetail .productBtn { position:absolute; bottom:0; left:0; width:100%; height:50px; background-color:#282b5d; line-height:50px;  color:#ffffff; font-size:20px; text-decoration:none; }\n";
		html += ".productCategory .btn_prev { position:absolute; top:50%; left:50%; margin-left:-540px; z-index:1; }\n";
		html += ".productCategory .btn_next { position:absolute; top:50%; right:50%; margin-right:-540px; z-index:1; }\n";
		html += ".productCategory .swiper-pagination { position: absolute; width:auto; padding:5px 15px; left: 50%; bottom:45px; box-sizing:border-box; -webkit-transform: translateX(-50%);-ms-transform: translateX(-50%);transform: translateX(-50%); z-index: 1;}\n";
		html += ".productCategory .swiper-pagination .swiper-pagination-bullet {position: relative;display: inline-block; width:12px; height:12px; background:#fff; border-radius: 50%; margin-left:45px; opacity:.3;}\n";
		html += ".productCategory .swiper-pagination .swiper-pagination-bullet:first-child {margin-left: 0;}\n";
		html += ".productCategory .swiper-pagination .swiper-pagination-bullet-active { opacity:1; }\n";
		html += ".productCategory .productList { position:absolute; bottom:50px; left:50%; transform:translateX(-50%); margin-left:440px; display:block; width:150px; height:34px; line-height:33px; background-color:rgba(40,43,93,1); border-radius:17px;  color:#ffffff; font-size:17px; z-index:1; text-align:center; cursor:pointer; }\n";
		html += "\n";
		html += ".productListModal { position:absolute; top:0; left:0; width:100%; height:100%; background-color:rgba(0,0,0,.65); z-index:2; display:none; }\n";
		html += ".productListModal .productListContainer { position:absolute; top:50px; left:50%; width:1080px; transform:translateX(-50%); }\n";
		html += ".productListModal .productListContainer .productListTitle { color:#ffffff;  font-size:30px; letter-spacing: -2px; text-align:center; line-height:56px; }\n";
		html += ".productListModal .productListContainer .productListClose { position: absolute; top:0px; right: 30px; display: inline-block; padding: 0; width: 2px; height: 56px; background: #ffffff; transform: rotate(45deg); cursor:pointer; }\n";
		html += ".productListModal .productListContainer .productListClose:before { display: block; content: \"\"; position: absolute; top: 50%; left: -26px; width: 56px; height: 2px; margin-top: -1px; background: #ffffff; }\n";
		html += ".productListModal .productListContainer .productListClose a { display:block; width:56px; height: 56px; top: 0px; left: -26px; position: absolute; transform: rotate(45deg); }\n";
		html += "\n";
		html += ".event { position:relative; margin-bottom:30px; }\n";
		html += ".event .eventTitle { position:relative; margin-top:45px; width:100%; text-align:center; line-height:140%;  color:#000000; font-size: 22px; font-family: \"NotoKrM\", sans-serif; letter-spacing: -1px; }\n";
		html += ".event .eventSubTitle { position:relative; margin-top:10px; width:100%; text-align:center; line-height:120%;  color:#000000; font-size: 34px; letter-spacing: -1px; }\n";
		html += ".event .eventList { display:inline-block; }\n";
		html += ".event .eventList .eventRow { float:left; margin-top:25px; margin-left:25px; }\n";
		html += ".event .eventList .eventRow:first-child { margin-left:0; }\n";
		html += "\n";
		html += ".footer { position:relative; width:100%; }\n";
		html += ".footer .links { height:45px; background:#282b5d; color:#ffffff; }\n";
		html += ".footer .links a { line-height:45px;  color:#ffffff; font-size:14px; text-decoration:none; font-family: \"NotoKrL\", sans-serif; }\n";
		html += ".footer .links span { line-height:25px; font-size:10px; padding:0 20px; box-sizing:border-box; }\n";
		html += "\n";
		html += ".footer .logo { float:left; padding:25px; box-sizing:border-box; }\n";
		html += ".footer .info { float:left; padding-top:30px; width:calc(100% - 280px); text-align:left; }\n";
		html += ".footer .info span { line-height:140%; padding:0 5px; box-sizing:border-box;  color:#888888; font-size:12px;  }\n";
		html += ".footer .info span.txt { padding:0; }\n";
		html += ".footer .info .copyright { line-height:140%; padding:5px 0 0 0; box-sizing:border-box;  color:#888888; font-size:12px;  text-align:left; }\n";
		html += "\n";
		html += ".end { width:956px; margin:0 auto; }\n";
		html += "</style>\n";
		html += "\n";
		html += "<script>\n";
		html += "Number.prototype.format = function(){\n";
		html += "if(this==0) return 0;\n";
		html += "var reg = /(^[+-]?\\d+)(\\d{3})/;\n";
		html += "var n = (this + '');\n";
		html += "while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');\n";
		html += "return n;\n";
		html += "};\n";
		html += "function ddayTime() {\n";
		html += "var dday = new Date(\""+ config.getString("fcfgEtimeDate") +"\").getTime();\n";
		html += "var nday = new Date().getTime();\n";
		html += "\n";
		html += "if(dday > nday) {\n";
		html += "var distance  = dday - nday;\n";
		html += "var dd = Math.floor(distance / (1000 * 60 * 60 * 24));\n";
		html += "var hh = \"\"+ Math.floor((distance / (1000*60*60)) % 24);\n";
		html += "var mm = \"\"+ Math.floor((distance / (1000*60)) % 60);\n";
		html += "var ss = \"\"+ Math.floor((distance / 1000) % 60);\n";
		html += "\n";
		html += "if(hh.length < 2) hh = \"0\"+ hh;\n";
		html += "if(mm.length < 2) mm = \"0\"+ mm;\n";
		html += "if(ss.length < 2) ss = \"0\"+ ss;\n";
		html += "\n";
		html += "jQuery(\"#dd\").html(\"마감 D-\"+ dd);\n";
		html += "if(dd == 0) jQuery(\"#dd\").html(\"마감 D-DAY\");\n";
		html += "jQuery(\"#hh0\").html(hh.substring(0,1));\n";
		html += "jQuery(\"#hh1\").html(hh.substring(1,2));\n";
		html += "jQuery(\"#mm0\").html(mm.substring(0,1));\n";
		html += "jQuery(\"#mm1\").html(mm.substring(1,2));\n";
		html += "jQuery(\"#ss0\").html(ss.substring(0,1));\n";
		html += "jQuery(\"#ss1\").html(ss.substring(1,2));\n";
		html += "\n";
		html += "setTimeout(ddayTime, 1000);\n";
		html += "}else {\n";
		html += "jQuery(\"body\")\n";
		html += ".html('<div class=\"end\"><img src=\"/common/images/fairimage/parking_pc.png\"></div>')\n";
		html += ".css({\"width\":\"100%\", \"height\":\"100px\", \"background-image\":\"url('/common/images/fairimage/parking_pc_bg.jpg')\", \"background-size\":\"cover\"});\n";
		html += "}\n";
		html += "}\n";
		html += "jQuery(document).ready(function(){\n";
		//if(!config.getString("fcfgEtimeDate").isEmpty())
		if(config.getString("fcfgStatus").equals("Y"))
		{
			html += "var dday = new Date(\""+ config.getString("fcfgEtimeDate") +"\").getTime();\n";
			html += "var nday = new Date().getTime();\n";
			html += "\n";
			//html += "if(dday > nday) {\n";
			html += "ddayTime();\n";
			//html += "}\n";
		}
		
		//if((config.getString("fcfgEtimeDate").isEmpty() && !config.getString("fcfgStatus").equals("A")) || config.getString("fcfgStatus").equals("N"))
		if(config.getString("fcfgStatus").equals("N"))
		{
			html += "jQuery(\"body\")\n";
			html += ".html('<div class=\"end\"><img src=\"/common/images/fairimage/parking_pc.png\"></div>')\n";
			html += ".css({\"width\":\"100%\", \"height\":\"100px\", \"background-image\":\"url('/common/images/fairimage/parking_pc_bg.jpg')\", \"background-size\":\"cover\"});\n";
			html += "return;\n";
		}
		html += "swiper = new Swiper('.swiper', {\n";
		html += "autoplay: {\n";
		html += "delay: 3000\n";
		html += "},\n";
		html += "loop: true,\n";
		html += "delay: 2000,\n";
		html += "disableOnInteraction: false,\n";
		html += "navigation: {\n";
		html += "nextEl: '.btn_next',\n";
		html += "prevEl: '.btn_prev'\n";
		html += "},\n";
		html += "on: {\n";
		html += "autoplayStop: function () {\n";
		html += "this.autoplay.start();\n";
		html += "}\n";
		html += "}\n";
		html += "});\n";
		html += "\n";
		html += "swiperProduct = new Swiper('.swiperProduct', {\n";
		html += "loop: true,\n";
		html += "delay: 2000,\n";
		html += "disableOnInteraction: false,\n";
		html += "navigation: {\n";
		html += "nextEl: '.btn_next',\n";
		html += "prevEl: '.btn_prev'\n";
		html += "},\n";
		html += "pagination: {\n";
		html += "el: '.swiper-pagination',\n";
		html += "clickable: true,\n";
		html += "renderBullet: function (index, className) {\n";
		html += "return '<span class=\"' + className + '\"></span>';\n";
		html += "}\n";
		html += "}\n";
		html += "});\n";
		html += "\n";
		html += "jQuery(\".pointSub\").mouseenter(function(){\n";
		html += "jQuery(this).find(\".pointOver\").slideDown('fast');\n";
		html += "});\n";
		html += "\n";
		html += "jQuery(\".pointSub\").mouseleave(function(){\n";
		html += "jQuery(this).find(\".pointOver\").slideUp('fast');\n";
		html += "});\n";
		html += "\n";
		html += "jQuery(\".productLabel\").each(function(){\n";
		html += "var label = JSON.parse(jQuery(this).text());\n";
		html += "if(label.length > 0) {\n";
		html += "var html = '';\n";
		html += "for(var i = 0; i < label.length; i++) {\n";
		html += "html += '<span class=\"productLabelDetail\" style=\"background-color:'+ label[i].BGCOLOR +';\">'+ label[i].TITLE +'</span>';\n";
		html += "}\n";
		html += "jQuery(this).html(html).show();\n";
		html += "}\n";
		html += "});\n";
		html += "\n";
		html += "jQuery(\".productPrice\").each(function(){\n";
		html += "var input = JSON.parse(jQuery(this).text());\n";
		html += "var key = input.PRICE[0].KEY;\n";
		html += "var html = \"<span class='price'>\"+ parseInt(input.PRICE[0].PRICE).format() +\"</span><span class='won'>원~</span>\";\n";
		html += "if(key != \"-1\" && input.INPUT[key].TITLE == \"인원\") {\n";
		html += "html = \"<span class='prefix'>&nbsp;\"+ input.INPUT[key].VALUE[0].replace(\"명\", \"인\") +\"&nbsp;</span>\"+ html;\n";
		html += "}\n";
		html += "jQuery(this).html(html).show();\n";
		html += "});\n";
		html += "\n";
		html += "jQuery(\"#productListClose\").click(function(){\n";
		html += "jQuery(\".productListModal\").hide();\n";
		html += "});\n";
		html += "});\n";
		html += "\n";
		html += "jQuery.fn.extend({\n";
		html += "categoryMove: function() {\n";
		html += "var index = jQuery(this).index();\n";
		html += "var top = jQuery(\".productCategory\").eq(index).offset().top;\n";
		html += "jQuery('html, body').animate({scrollTop: top}, 500);\n";
		html += "},\n";
		html += "\n";
		html += "productListShow: function(FC_SEQ, pageIndex) {\n";
		html += "if(jQuery(this).attr(\"class\") == 'productList') {\n";
		html += "//jQuery(\"#productListTitle\").text(jQuery(this).prev().text());	\n";
		html += "}				\n";
		html += "jQuery.ajax({\n";
		html += "url: \"./productList.do\",\n";
		html += "type: \"GET\",\n";
		html += "dataType: \"html\",\n";
		html += "data: {\n";
		html += "\"fcseq\": FC_SEQ,\n";
		html += "\"pageIndex\": pageIndex\n";
		html += "},\n";
		html += "success: function(data) {\n";
		html += "jQuery(\"#productListHtml\").html(data);\n";
		html += "jQuery(\".productListModal\").height(jQuery(document).height()).show();\n";
		html += "jQuery(\".productListContainer\").css(\"top\", jQuery(document).scrollTop() + 50);\n";
		html += "\n";
		html += "}\n";
		html += "});\n";
		html += "}\n";
		html += "});\n";
		html += "if (/bz_tracking_id/.test(location.search)) { localStorage.BuzzAd = location.search }";
		html += "</script>\n";
		html += "<body>\n";
		html += "\n";
		html += "\n";
		html += "<!--  PC 화면  -->\n";
		html += "<div id=\"pc\">\n";
		html += "<div class=\"header\">\n";
		html += "<div class=\"container\">\n";
		html += "<div class=\"header_logo\"><img src=\"/common/images/fairimage/main_top_title.png\"></div>\n";
		html += "</div>\n";
		html += "</div>\n";
		html += "\n";
		
		if(bannerList.size() > 0)
		{
			html += "<div class=\"bannerList\">\n";
			html += "<div class=\"swiper swiper-container\">\n";
			html += "<ul class=\"swiper-wrapper\">\n";
			
			for(EmfMap blist : bannerList) {
				html += "<li class=\"swiper-slide\">\n";
				if(!blist.getString("fbtLink").isEmpty()) {
					html += "<a href=\""+ blist.getString("fbtLink") +"\"\n";
					
					if(!blist.getString("fbtLinkType").isEmpty()) {
						html += "target = \""+ blist.getString("fbtLinkType") +"\"\n";
					}else{
						html += "target = \"_blank\"\n";
					}
				html += ">\n";
				}
				html += "<div class=\"banner\" style=\"background-image:url(/common/images/fairimage/"+ blist.getString("fbtImageBgSaveNm") +");\">\n";
				html += "<img src=\"/common/images/fairimage/"+ blist.getString("fbtImageWSaveNm") +"\" title=\""+ blist.getString("fbtImageWRealNm") +"\">\n";
				html += "</div>\n";
				if(!blist.getString("fbtLink").isEmpty()) {
					html += "</a>\n";
				}
				html += "</li>\n";
			}
			html += "</ul>\n";
			html += "<a href=\"#\" class=\"btn_prev\"><img src=\"/common/images/fairimage/main_banner_arrow_left.png\"></a>\n";
			html += "<a href=\"#\" class=\"btn_next\"><img src=\"/common/images/fairimage/main_banner_arrow_right.png\"></a>\n";
			html += "</div>\n";
			if(config.getString("fcfgStatus").equals("Y")) {
				html += "<div class=\"dday\">\n";
				html += "<div class=\"dday_container\">\n";
				html += "<div class=\"day\" id=\"dd\">마감 D-DAY</div>\n";
				html += "<div class=\"time\" id=\"hh0\">0</div>\n";
				html += "<div class=\"time\" id=\"hh1\">0</div>\n";
				html += "<div class=\"comma\"><span class=\"box\"></span><span class=\"box bottom\"></span></div>\n";
				html += "<div class=\"time\" id=\"mm0\">0</div>\n";
				html += "<div class=\"time\" id=\"mm1\">0</div>\n";
				html += "<div class=\"comma\"><span class=\"box\"></span><span class=\"box bottom\"></span></div>\n";
				html += "<div class=\"time\" id=\"ss0\">0</div>\n";
				html += "<div class=\"time\" id=\"ss1\">0</div>\n";
				html += "<div style=\"clear:both;\"></div>\n";
				html += "\n";
				html += "<div class=\"ddat_title\">"+ config.getString("fcfgDdayTitle") +"</div>\n";
				html += "</div>\n";
				html += "</div>\n";
			}
			html += "</div>\n";
		}
		html += "\n";
		
		if(points.size() > 0 && pointSubList.size() > 0) {
			html += "<div class=\"point\" style=\"height:"+ pointHeight +"px; background-image:url('/common/images/fairimage/"+ point.getString("fmImageBgSaveNm") +"');\">\n";
			html += "<div class=\"container\">\n";
			html += "<div class=\"pointTitle\"><img src=\"/common/images/fairimage/"+ point.getString("fmImageTitleSaveNm") +"\"></div>\n";
			for(EmfMap pointSub : pointSubList) {
				html += "<div class=\"pointSub\">\n";
				html += "<div><img src=\"/common/images/fairimage/"+ pointSub.getString("fmsImageWSaveNm") +"\" title=\""+ pointSub.getString("fmsImageWRealNm") +"\"></div>\n";
				html += "<div class=\"pointOver\" style=\"background-color:"+ pointSub.getString("fmsBgcolor") +";\">\n";
				html += "<div class=\"pointOverContainer\">\n";
				html += "<div class=\"pointLine\"></div>\n";
				html += "<div class=\"pointDesc\">"+ pointSub.getString("fmsDesc") +"</div>\n";
				html += "</div>\n";
				html += "</div>\n";
				html += "</div>\n";
			}
			html += "</div>\n";
			html += "</div>\n";
		}
		html += "\n";
		
		if(cateList.size() > 0) {
			html += "<div class=\"category\">\n";
			html += "<div class=\"container\">\n";
			for(EmfMap cate : cateList) {
				html += "<div class=\"categorySub\" onclick=\"javascript:jQuery(this).categoryMove();\">\n";
				html += "<div><img src=\"/common/images/fairimage/"+ cate.getString("fcImageWSaveNm") +"\" title=\""+ cate.getString("fcImageWRealNm") +"\"></div>\n";
				html += "<div class=\"categoryTitle\">"+ cate.getString("fcTitle") +"</div>\n";
				html += "<div class=\"categorySubTitle\" style=\"border-bottom:5px solid "+ cate.getString("fcBgcolor") +";\">"+ cate.getString("fcSubtitle") +"</div>\n";
				html += "</div>\n";
			}
			html += "</div>\n";
			html += "</div>\n";
			html += "\n";
			for(EmfMap cate : cateList) {
				List<EmfMap> productList  = (List<EmfMap>) cate.get("productList");
				if(productList.size() > 0) {
					html += "<div class=\"productCategory\">\n";
					html += "<div class=\"swiperProduct swiper-container\">\n";
					html += "<ul class=\"swiper-wrapper\">\n";
					for(EmfMap product : productList) {
						html += "<li class=\"swiper-slide\">\n";
						html += "<div class=\"product\" style=\"height:"+ product.getString("fpMainHeight") +"px; background-image:url('/common/images/fairimage/"+ product.getString("fpMainImageBgSaveNm") +"');\">\n";
						html += "<div class=\"container\">\n";
						html += "<div class=\"productContainer\">\n";
						html += "<div><img src=\"/common/images/fairimage/"+ product.getString("fpMainImageWSaveNm") +"\" title=\""+ product.getString("fpMainImageWRealNm") +"\"></div>\n";
						html += "<div class=\"productTitle\"";
						if(!cate.getString("fcCategoryTitleColor").isEmpty()) {
							html += "style=\"color:"+ cate.getString("fcCategoryTitleColor") +";\"";
						}
						html += ">"+ product.getString("fpMainTitle") +"</div>\n";
						html += "<div class=\"productDetail\">\n";
						html += "<div class=\"productLabel\">"+ product.getString("fpLabel") +"</div>\n";
						html += "<div class=\"productSubTitle\">"+ product.getString("fpMainSubtitle") +"</div>\n";
						html += "<div class=\"productDesc\">"+ product.getString("fpMainDesc") +"</div>\n";
						html += "<div class=\"productPrice\">"+ product.getString("fpInput") +"</div>\n";
						html += "<a class=\"productBtn\" href=\"/fair/"+ product.getString("fpSeq") +"/index.do\">자세히보기</a>\n";
						html += "</div>\n";
						html += "</div>\n";
						html += "</div>\n";
						html += "</div>\n";
						html += "</li>\n";
					}
					html += "</ul>\n";
					html += "<a href=\"#\" class=\"btn_prev\"><img src=\"/common/images/fairimage/product_arrow_left.png\"></a>\n";
					html += "<a href=\"#\" class=\"btn_next\"><img src=\"/common/images/fairimage/product_arrow_right.png\"></a>\n";
					html += "<div class=\"swiper-pagination\"></div>\n";
					html += "</div>\n";
					html += "<div class=\"productCategoryTitle\"";
					if(!cate.getString("fcCategoryTitleColor").isEmpty()) {
						html += "style=\"color:"+ cate.getString("fcCategoryTitleColor") +";\"";
					}
					html += ">"+ cate.getString("fcCategoryTitle") +"</div>\n";
					html += "<a class=\"productList\" onclick=\"javascript:jQuery(this).productListShow('"+ cate.getString("fcSeq") +"', '1');\">+ 전체상품보기</a>\n";
					html += "</div>\n";
				}
			}
		}
		html += "\n";
		if(eventList.size() > 0) {
			html += "<div class=\"event\">\n";
			html += "<div class=\"container\">\n";
			html += "<div class=\"eventTitle\">항공, 호텔, 패스, 입장권 이벤트</div>\n";
			html += "<div class=\"eventSubTitle\">대박나라 이벤트 모아보기</div>\n";
			for(EmfMap event : eventList) {
				html += "<ul class=\"eventList\">\n";
				if(event.getString("feType").equals("3")) {
					html += "<li class=\"eventRow\"><a href=\""+ event.getString("feLink1") +"\" target=\""+ event.getString("feLink1Type") +"\"><img src=\"/common/images/fairimage/"+ event.getString("feImage1WSaveNm") +"\"></a></li>\n";
					html += "<li class=\"eventRow\"><a href=\""+ event.getString("feLink2") +"\" target=\""+ event.getString("feLink2Type") +"\"><img src=\"/common/images/fairimage/"+ event.getString("feImage2WSaveNm") +"\"></a></li>\n";
					html += "<li class=\"eventRow\"><a href=\""+ event.getString("feLink3") +"\" target=\""+ event.getString("feLink3Type") +"\"><img src=\"/common/images/fairimage/"+ event.getString("feImage3WSaveNm") +"\"></a></li>\n";
				}
				if(event.getString("feType").equals("2")) {
					html += "<li class=\"eventRow\"><a href=\""+ event.getString("feLink1") +"\" target=\""+ event.getString("feLink1Type") +"\"><img src=\"/common/images/fairimage/"+ event.getString("feImage1WSaveNm") +"\"></a></li>\n";
					html += "<li class=\"eventRow\"><a href=\""+ event.getString("feLink2") +"\" target=\""+ event.getString("feLink2Type") +"\"><img src=\"/common/images/fairimage/"+ event.getString("feImage2WSaveNm") +"\"></a></li>\n";
				}
				if(event.getString("feType").equals("1")) {
					html += "<li class=\"eventRow\"><a href=\""+ event.getString("feLink1") +"\" target=\""+ event.getString("feLink1Type") +"\"><img src=\"/common/images/fairimage/"+ event.getString("feImage1WSaveNm") +"\"></a></li>\n";
				}
				html += "<li style=\"clear:both;\"></li>\n";
				html += "</ul>\n";
			}
			html += "</div>\n";
			html += "</div>\n";
		}
		
		html += "\n";
		html += "<div class=\"footer\">\n";
		html += "<div class=\"links\">\n";
		html += "<div class=\"container\">\n";
		html += "<a href=\"https://www.daemyungimready.com/operation-guide/privacy/index.do\" target=\"_blank\">개인정보취급방침</a>\n";
		html += "<span>|</span>\n";
		html += "<a href=\"https://www.daemyungimready.com/daemyung-lifeway/introduction/contentsid/212/index.do\" target=\"_blank\">회사소개</a>\n";
		html += "<span>|</span>\n";
		html += "<a href=\"https://www.daemyungimready.com/main/index.do\" target=\"_blank\">공식홈페이지</a>\n";
		html += "<span>|</span>\n";
		html += "<a href=\"https://www.imreadymall.com\" target=\"_blank\">회원몰</a>\n";
		html += "</div>\n";
		html += "</div>\n";
		html += "<div class=\"container\">\n";
		html += "<img class=\"logo\" src=\"/common/images/fairimage/footer_logo.png\">\n";
		html += "<div class=\"info\">\n";
		html += "<span class=\"txt\">서울시 송파구 법원로 135 대명타워</span>\n";
		html += "<span>|</span>\n";
		html += "<span class=\"txt\">사업자등록번호 220-88-09321</span>\n";
		html += "<span>|</span>\n";
		html += "<span class=\"txt\">대표자 (주)대명스테이션 대표이사 서준혁, 최성훈</span>\n";
		html += "<br>\n";
		html += "<span class=\"txt\">통신판매신고번호 제2016-서울송파-0669호</span>\n";
		html += "<div class=\"copyright\">\n";
		html += "COPYRIGHT DAEMYUNGSTATION.CO,.LTD. ALL RIGHTS RESERVED.\n";
		html += "</div>\n";
		html += "</div>\n";
		html += "<div style=\"clear:both;\"></div>\n";
		html += "</div>\n";
		html += "</div>\n";
		html += "\n";
		html += "<div class=\"productListModal\">\n";
		html += "<div class=\"productListContainer\">\n";
		html += "<div class=\"productListTitle\" id=\"productListTitle\">상품 전체보기</div>\n";
		html += "<div class=\"productListClose\"><a id=\"productListClose\"></a></div>\n";
		html += "<div id=\"productListHtml\"></div>\n";
		html += "</div>	\n";
		html += "</div>\n";
		html += "</div>\n";
		html += "\n";
		
		html += "<!-- Global site tag (gtag.js) - Google Analytics -->\n";
		html += "<script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-154355799-1\"></script>\n";
		html += "<script>\n";
		html += "window.dataLayer = window.dataLayer || [];\n";
		html += "function gtag(){dataLayer.push(arguments);}\n";
		html += "gtag(\"js\", new Date());\n";
		html += "gtag(\"config\", \"UA-154355799-1\");\n";
		html += "</script>\n";
		
		html += "</body>\n";
		html += "</html>\n";
		
		rstMap.put("pc", html);
		
		//MO HTML
		html = "";
		
		html += "<%@ page pageEncoding=\"UTF-8\" contentType=\"text/html; charset=UTF-8\"%>\n";
		html += "<%@include file=\"/WEB-INF/jsp/include/el.jspf\" %>\n";
		html += "<!doctype html>\n";
		html += "<html lang=\"ko\">\n";
		html += "<head>\n";
		html += "<meta charset=\"utf-8\" />\n";
		html += "<title>"+ config.getString("fcfgTitle") +"</title>\n";
		html += "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n";
		html += "<meta name=\"viewport\" content=\"width=640, target-densitydpi=device-dpi, user-scalable=no\">\n";
		html += "<meta name=\"author\" content=\"http://www.daemyungimready.com\" />\n";
		html += "<meta name=\"keywords\" content=\"대명아임레디, 라이프케어, 상조/웨딩/여행, 업계 최초 멤버십/결합혜택, 회원가입, 고객센터\" />\n";
		html += "<meta name=\"description\" content=\"대명아임레디, 라이프케어, 상조/웨딩/여행, 업계 최초 멤버십/결합혜택, 회원가입, 고객센터\" />\n";
		html += "<meta name=\"format-detection\" content =\"telephone=no\"/>\n";
		html += "<meta name=\"naver-site-verification\" content=\"6b34a18682ba6578cac42877a7c865a026aabaa8\"/>\n";
		html += "<meta property=\"og:type\" content=\"article\" />\n";
		html += "<meta property=\"og:site_name\" content=\"대명아임레디\" />\n";
		html += "<meta property=\"og:title\" content=\"대명아임레디\" />\n";
		html += "<meta property=\"og:description\" content=\"대명아임레디, 라이프케어, 상조/웨딩/여행, 업계 최초 멤버십/결합혜택, 회원가입, 고객센터\" />\n";
		html += "<meta property=\"og:image\" content=\"http://www.daemyunglifeway.com/common/images/logo.gif\" />\n";
		html += "<link rel=\"shortcut icon\" href=\"/common/images/favicon_16.ico\" type=\"image/x-icon\" />\n";
		html += "<link rel=\"icon\" href=\"/common/images/favicon_16.ico\" type=\"image/x-icon\" />\n";
		html += "\n";
		html += "<script type=\"text/javascript\" src=\"/common/js/jquery-1.8.2.min.js\"></script>\n";
		html += "<script type='text/javascript' src='/common/js/swiper.min.js'></script>\n";
		html += "<link rel='stylesheet' type='text/css' href='/common/css/swiper.min.css' />\n";
		html += "</head>\n";
		html += "\n";
		html += "<style>\n";
		html += "@font-face {\n";
		html += "font-family: 'NotoKrL';\n";
		html += "font-style: normal;\n";
		html += "font-weight: 100;\n";
		html += "src: local('Noto Sans Light'), local('NotoSans-Light'), url(/common/css/fonts/NotoSans-Light.eot);\n";
		html += "src: url(/common/css/fonts/NotoSans-Light.eot?#iefix) format('embedded-opentype'),\n";
		html += "url(/common/css/fonts/NotoSans-Light.woff2) format('woff2'),\n";
		html += "url(/common/css/fonts/NotoSans-Light.woff) format('woff');;\n";
		html += "}\n";
		html += "@font-face {\n";
		html += "font-family: 'NotoKrR';\n";
		html += "font-style: normal;\n";
		html += "font-weight: 300;\n";
		html += "src: local('Noto Sans Regular'), local('NotoSans-Regular'), url(/common/css/fonts/NotoSans-Regular.eot);\n";
		html += "src: url(/common/css/fonts/NotoSans-Regular.eot?#iefix) format('embedded-opentype'),\n";
		html += "url(/common/css/fonts/NotoSans-Regular.woff2) format('woff2'),\n";
		html += "url(/common/css/fonts/NotoSans-Regular.woff) format('woff');\n";
		html += "}\n";
		html += "@font-face {\n";
		html += "font-family: 'NotoKrM';\n";
		html += "font-style: normal;\n";
		html += "font-weight: 500;\n";
		html += "src: local('Noto Sans Medium'), local('NotoSans-Medium'), url(/common/css/fonts/NotoSans-Medium.eot);\n";
		html += "src: url(/common/css/fonts/NotoSans-Medium.eot?#iefix) format('embedded-opentype'),\n";
		html += "url(/common/css/fonts/NotoSans-Medium.woff2) format('woff2'),\n";
		html += "url(/common/css/fonts/NotoSans-Medium.woff) format('woff');\n";
		html += "}\n";
		html += "@font-face {\n";
		html += "font-family: 'NotoKrB';\n";
		html += "font-style: normal;\n";
		html += "font-weight: 700;\n";
		html += "src: local('Noto Sans Bold'), local('NotoSans-Bold'), url(/common/css/fonts/NotoSans-Bold.eot);\n";
		html += "src: url(/common/css/fonts/NotoSans-Bold.eot?#iefix) format('embedded-opentype'),\n";
		html += "url(/common/css/fonts/NotoSans-Bold.woff2) format('woff2'),\n";
		html += "url(/common/css/fonts/NotoSans-Bold.woff) format('woff');\n";
		html += "}\n";
		html += "\n";
		html += "body,ul,li { margin:0; padding:0; font-family:\"NotoKrR\", sans-serif; line-height: 0; word-break:keep-all; }\n";
		html += "li { list-style:none; }\n";
		html += ".container { position:relative; width:640px; margin:0 auto; line-height:0; text-align:center; }\n";
		html += "\n";
		html += ".header { position:relative; }\n";
		html += "\n";
		html += ".bannerList { position:relative; width:100%; }\n";
		html += ".bannerList .banner { width:100%; height:"+ bannerHeight +"px; background-size:cover; text-align:center; }\n";
		html += ".bannerList .btn_prev { position:absolute; top:50%; left:50%; margin-left:-300px; z-index:1; }\n";
		html += ".bannerList .btn_next { position:absolute; top:50%; right:50%; margin-right:-300px; z-index:1; }\n";
		html += "\n";
		html += ".dday { position:absolute; width:510px; bottom:65px; left:50%; transform:translateX(-50%); z-index:1; text-align:center; line-height:0; }\n";
		html += ".dday .dday_container { width:auto; display: inline-block; }\n";
		html += ".dday .dday_container .day { display:block; background:#000000; border-radius:5px; box-sizing:border-box; }\n";
		html += ".dday .dday_container .day #dd { text-align:center; color:#ffffff;  font-size:42px;  line-height:normal; padding-top: 10px;}\n";
		html += ".dday .dday_container .day .time_container { display:inline-block; margin:10px 20px 20px; }\n";
		html += ".dday .dday_container .day .time_container .time { float:left; margin-left:5px; display:block; width:65px; height:80px; line-height:80px; text-align:center; background:#ffffff; color:#000000;  font-size:50px;  border-radius:5px; box-sizing:border-box; }\n";
		html += ".dday .dday_container .day .time_container .time:first-child { margin-left:0; }\n";
		html += ".dday .dday_container .day .time_container .comma { float:left; margin-left:5px; display:block; height:65px; line-height:0; }\n";
		html += ".dday .dday_container .day .time_container .comma .box { display:block; width:7px; height:7px; background:#ffffff; line-height:0; margin-top:15px; }\n";
		html += ".dday .dday_container .day .time_container .comma .box.bottom { margin-top:20px; }\n";
		html += ".dday .dday_container .ddat_title { display:block; line-height:normal; text-align:center; color:#ffffff;  font-size:20px;  margin-top: 10px; letter-spacing: -2px;  }\n";
		html += "\n";
		html += ".point { position:relative; width:100%; background-size:100%; padding-bottom:50px; box-sizing:border-box; }\n";
		html += ".point .pointTitle { padding-top:80px; text-align:center; box-sizing:border-box; }\n";
		html += ".point .pointSub { position:relative; margin-top:50px; }\n";
		html += ".point .pointDesc { position: absolute; top: 155px; left: 285px; width:320px; display: inline-block; margin-top: 0; line-height: 120%; font-weight: 500; color: #000000; font-size: 25px; text-align: left; letter-spacing: -2px; }\n";
		html += "\n";
		html += ".category { position:relative; width:100%; padding:30px 0; }\n";
		html += ".category .categorySub { position:relative; display:inline-block; cursor:pointer; margin-left:50px; }\n";
		html += ".category .categorySub:first-child { margin-left:0; }\n";
		html += ".category .categorySub .categoryTitle { position:relative; line-height:140%;  color:#000000; font-size:20px; }\n";
		html += "\n";
		html += ".productCategory { position:relative; }\n";
		html += ".productCategory .productCategoryTitle { position: absolute; top:45px; left:0; width:100%; text-align:center; line-height:140%;  color:#ffffff; font-size:25px; z-index:1; }\n";
		html += ".productCategory .product { position:relative; width:100%; background-size:cover; background-position: center; text-align:center; padding-bottom:365px; box-sizing:border-box; }\n";
		html += ".productCategory .product .productContainer { position:relative; display:inline-block; margin-top:70px; box-shadow: 6px 6px 6px 0 rgba(0,0,0,.2);}\n";
		html += ".productCategory .product .productContainer .productTitle { position:relative; margin-top:20px; width:100%; text-align:center; line-height:140%;  color:#ffffff; font-size:38px;  }\n";
		html += ".productCategory .product .productContainer .productImage { position:relative; margin-top:40px; width:100%; text-align:center; }\n";
		html += ".productCategory .product .productContainer .productImage .productLabel { position:absolute; top:20px; left:20px; display:none; }\n";
		html += ".productCategory .product .productContainer .productImage .productLabel .productLabelDetail { display:inline-block; line-height:120%;  color:#ffffff; font-size:20px; margin-left:5px; padding:5px; box-sizing:border-box; min-width:70px; text-align:center; }\n";
		html += ".productCategory .product .productContainer .productImage .productLabel .productLabelDetail:first-child { margin-left:0; }\n";
		html += "\n";
		html += ".productCategory .product .productContainer .productDetail { position:absolute; bottom: -195px; left: 30px; width:500px; padding:0; box-sizing:border-box; background-color:rgba(255,255,255,0.9); }\n";
		html += ".productCategory .product .productContainer .productDetail .productSubTitle { position: relative; text-align: center; line-height: 120%; color: #000000; font-size: 26px; margin-top: 20px; }\n";
		html += ".productCategory .product .productContainer .productDetail .productDesc { position:relative; text-align:center; line-height:120%;  color:#5f5f5f; font-size:23px; margin-top:10px; }\n";
		html += ".productCategory .product .productContainer .productDetail .productPrice { display:none; position:relative; text-align:center; margin-top:20px; font-family:\"NotoKrB\", sans-serif; letter-spacing: -1px; }\n";
		html += ".productCategory .product .productContainer .productDetail .productPrice .prefix { line-height:120%;  color:#000000; font-size:30px; }\n";
		html += ".productCategory .product .productContainer .productDetail .productPrice .price { line-height:120%;  color:#ff3b85; font-size:33px; }\n";
		html += ".productCategory .product .productContainer .productDetail .productPrice .won { line-height:120%;  color:#000000; font-size:20px;  font-family:\"NotoKrM\", sans-serif; }\n";
		html += ".productCategory .product .productContainer .productBtn { position:relative; display:block; text-align:center; margin-top:20px; width:100%; height:50px; background-color:#282b5d; line-height:50px;  color:#ffffff; font-size:20px; text-decoration:none; }\n";
		html += ".productCategory .btn_prev { position:absolute; top:40%; left:50%; margin-left:-300px; z-index:1; }\n";
		html += ".productCategory .btn_next { position:absolute; top:40%; right:50%; margin-right:-300px; z-index:1; }\n";
		html += ".productCategory .swiper-pagination { position: absolute; width:auto; padding:5px 15px; left: 50%; bottom:110px; box-sizing:border-box; -webkit-transform: translateX(-50%);-ms-transform: translateX(-50%);transform: translateX(-50%); z-index: 1;}\n";
		html += ".productCategory .swiper-pagination .swiper-pagination-bullet {position: relative;display: inline-block; width:12px; height:12px; background:#fff; border-radius: 50%; margin-left:45px; opacity:.3;}\n";
		html += ".productCategory .swiper-pagination .swiper-pagination-bullet:first-child {margin-left: 0;}\n";
		html += ".productCategory .swiper-pagination .swiper-pagination-bullet-active { opacity:1; }\n";
		html += ".productCategory .productList { position:absolute; bottom:30px; left:50%; transform:translateX(-50%); display:block; width:230px; height:50px; line-height:50px; background-color:rgba(40,43,93,1); border-radius:25px;  color:#ffffff; font-size:20px; z-index:1; text-align:center; cursor:pointer; }\n";
		html += "\n";
		html += ".productListModal { position:absolute; top:0; left:0; width:100%; height:100%; background-color:rgba(0,0,0,.65); z-index:2; display:none; }\n";
		html += ".productListModal .productListContainer { position:absolute; top:50px; left:95px; width:450px; }\n";
		html += ".productListModal .productListContainer .productListTitle { color:#ffffff;  font-size:30px; letter-spacing: -2px; text-align:center; line-height:56px; }\n";
		html += ".productListModal .productListContainer .productListClose { position: absolute; top:0px; right: 30px; display: inline-block; padding: 0; width: 2px; height: 56px; background: #ffffff; transform: rotate(45deg); cursor:pointer; }\n";
		html += ".productListModal .productListContainer .productListClose:before { display: block; content: \"\"; position: absolute; top: 50%; left: -26px; width: 56px; height: 2px; margin-top: -1px; background: #ffffff; }\n";
		html += ".productListModal .productListContainer .productListClose a { display:block; width:56px; height: 56px; top: 0px; left: -26px; position: absolute; transform: rotate(45deg); }\n";
		html += "\n";
		html += ".event { position:relative; margin-bottom:30px; }\n";
		html += ".event .eventTitle { position:relative; margin-top:45px; width:100%; text-align:center; line-height:140%;  color:#000000; font-size:25px; letter-spacing: -1px;}\n";
		html += ".event .eventSubTitle { position:relative; margin-top:10px; width:100%; text-align:center; line-height:120%;  color:#000000; font-size:36px; letter-spacing: -1px;}\n";
		html += ".event .eventList { display:inline-block; }\n";
		html += ".event .eventList .eventRow { float:left; margin-top:25px; margin-left:25px; }\n";
		html += ".event .eventList .eventRow:first-child { margin-left:0; }\n";
		html += "\n";
		html += ".footer { position:relative; width:100%; }\n";
		html += ".footer .logo {  }\n";
		html += ".footer .links { background:#ffffff; padding:30px 30px 0 30px; box-sizing:border-box; }\n";
		html += ".footer .links a { line-height:normal;  color:#545454; font-size:20px; text-decoration:none; }\n";
		html += ".footer .links span { line-height:normal; font-size:18px; padding:0 10px; box-sizing:border-box; }\n";
		html += "\n";
		html += ".footer .info { line-height:normal; padding:20px 30px 30px 30px; text-align:left; }\n";
		html += ".footer .info span { height:normal; padding:0 5px; box-sizing:border-box;  color:#888888; font-size:14px;  }\n";
		html += ".footer .info span.txt { padding:0; }\n";
		html += ".footer .info .copyright { line-height:normal; padding:10px 0 0 0; box-sizing:border-box;  color:#888888; font-size:14px;  text-align:left; }\n";
		html += "\n";
		html += ".end { width:100%; margin:0 auto; }\n";
		html += "</style>\n";
		html += "\n";
		html += "<script>\n";
		html += "Number.prototype.format = function(){\n";
		html += "if(this==0) return 0;\n";
		html += "var reg = /(^[+-]?\\d+)(\\d{3})/;\n";
		html += "var n = (this + '');\n";
		html += "while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');\n";
		html += "return n;\n";
		html += "};\n";
		html += "function ddayTime() {\n";
		html += "var dday = new Date(\""+ config.getString("fcfgEtimeDate") +"\").getTime();\n";
		html += "var nday = new Date().getTime();\n";
		html += "if(dday > nday) {\n";
		html += "var distance  = dday - nday;\n";
		html += "var dd = Math.floor(distance / (1000 * 60 * 60 * 24));\n";
		html += "var hh = \"\"+ Math.floor((distance / (1000*60*60)) % 24);\n";
		html += "var mm = \"\"+ Math.floor((distance / (1000*60)) % 60);\n";
		html += "var ss = \"\"+ Math.floor((distance / 1000) % 60);\n";
		html += "\n";
		html += "if(hh.length < 2) hh = \"0\"+ hh;\n";
		html += "if(mm.length < 2) mm = \"0\"+ mm;\n";
		html += "if(ss.length < 2) ss = \"0\"+ ss;\n";
		html += "\n";
		html += "jQuery(\"#dd\").html(\"마감 D-\"+ dd);\n";
		html += "if(dd == 0) jQuery(\"#dd\").html(\"마감 D-DAY\");\n";
		html += "jQuery(\"#hh0\").html(hh.substring(0,1));\n";
		html += "jQuery(\"#hh1\").html(hh.substring(1,2));\n";
		html += "jQuery(\"#mm0\").html(mm.substring(0,1));\n";
		html += "jQuery(\"#mm1\").html(mm.substring(1,2));\n";
		html += "jQuery(\"#ss0\").html(ss.substring(0,1));\n";
		html += "jQuery(\"#ss1\").html(ss.substring(1,2));\n";
		html += "\n";
		html += "setTimeout(ddayTime, 1000);\n";
		html += "}else {\n";
		html += "jQuery(\"body\").html('<div class=\"end\"><img src=\"/common/images/fairimage/parking_mo.png\"></div>')\n";
		html += "}\n";
		html += "}\n";
		html += "jQuery(document).ready(function(){\n";
		if(config.getString("fcfgStatus").equals("Y"))
		{
			html += "var dday = new Date(\""+ config.getString("fcfgEtimeDate") +"\").getTime();\n";
			html += "var nday = new Date().getTime();\n";
			html += "\n";
			//html += "if(dday > nday) {\n";
			html += "ddayTime();\n";
			//html += "}\n";
		}

		if(config.getString("fcfgStatus").equals("N"))
		{
			html += "jQuery(\"body\")\n";
			html += ".html('<div class=\"end\"><img src=\"/common/images/fairimage/parking_pc.png\"></div>')\n";
			html += ".css({\"width\":\"100%\", \"height\":\"100px\", \"background-image\":\"url('/common/images/fairimage/parking_pc_bg.jpg')\", \"background-size\":\"cover\"});\n";
			html += "return;\n";
		}
		html += "swiper = new Swiper('.swiper', {\n";
		html += "autoplay: {\n";
		html += "delay: 3000\n";
		html += "},\n";
		html += "loop: true,\n";
		html += "delay: 2000,\n";
		html += "disableOnInteraction: false,\n";
		html += "navigation: {\n";
		html += "nextEl: '.btn_next',\n";
		html += "prevEl: '.btn_prev'\n";
		html += "},\n";
		html += "on: {\n";
		html += "autoplayStop: function () {\n";
		html += "this.autoplay.start();\n";
		html += "}\n";
		html += "}\n";
		html += "});\n";
		html += "\n";
		html += "swiperProduct = new Swiper('.swiperProduct', {\n";
		html += "loop: true,\n";
		html += "delay: 2000,\n";
		html += "disableOnInteraction: false,\n";
		html += "navigation: {\n";
		html += "nextEl: '.btn_next',\n";
		html += "prevEl: '.btn_prev'\n";
		html += "},\n";
		html += "pagination: {\n";
		html += "el: '.swiper-pagination',\n";
		html += "clickable: true,\n";
		html += "renderBullet: function (index, className) {\n";
		html += "return '<span class=\"' + className + '\"></span>';\n";
		html += "}\n";
		html += "}\n";
		html += "});\n";
		html += "\n";
		html += "jQuery(\".pointSub\").mouseenter(function(){\n";
		html += "jQuery(this).find(\".pointOver\").slideDown('fast');\n";
		html += "});\n";
		html += "\n";
		html += "jQuery(\".pointOver\").mouseleave(function(){\n";
		html += "jQuery(this).slideUp('fast');\n";
		html += "});\n";
		html += "\n";
		html += "jQuery(\".productLabel\").each(function(){\n";
		html += "var label = JSON.parse(jQuery(this).text());\n";
		html += "if(label.length > 0) {\n";
		html += "var html = '';\n";
		html += "for(var i = 0; i < label.length; i++) {\n";
		html += "html += '<span class=\"productLabelDetail\" style=\"background-color:'+ label[i].BGCOLOR +';\">'+ label[i].TITLE +'</span>';\n";
		html += "}\n";
		html += "jQuery(this).html(html).show();\n";
		html += "}\n";
		html += "});\n";
		html += "\n";
		html += "jQuery(\".productPrice\").each(function(){\n";
		html += "var input = JSON.parse(jQuery(this).text());\n";
		html += "var key = input.PRICE[0].KEY;\n";
		html += "var html = \"<span class='price'>\"+ parseInt(input.PRICE[0].PRICE).format() +\"</span><span class='won'>원~</span>\";\n";
		html += "if(key != \"-1\" && input.INPUT[key].TITLE == \"인원\") {\n";
		html += "html = \"<span class='prefix'>&nbsp;\"+ input.INPUT[key].VALUE[0].replace(\"명\", \"인\") +\"</span>\"+ html;\n";
		html += "}\n";
		html += "jQuery(this).html(html).show();\n";
		html += "});\n";
		html += "\n";
		html += "jQuery(\"#productListClose\").click(function(){\n";
		html += "jQuery(\".productListModal\").hide();\n";
		html += "});\n";
		html += "});\n";
		html += "\n";
		html += "jQuery.fn.extend({\n";
		html += "categoryMove: function() {\n";
		html += "var index = jQuery(this).index();\n";
		html += "var top = jQuery(\".productCategory\").eq(index).offset().top;\n";
		html += "jQuery('html, body').animate({scrollTop: top}, 500);\n";
		html += "},\n";
		html += "\n";
		html += "productListShow: function(FC_SEQ, pageIndex) {\n";
		html += "if(jQuery(this).attr(\"class\") == 'productList') {\n";
		html += "//jQuery(\"#productListTitle\").text(jQuery(this).prev().text());	\n";
		html += "}				\n";
		html += "jQuery.ajax({\n";
		html += "url: \"./productList.do\",\n";
		html += "type: \"GET\",\n";
		html += "dataType: \"html\",\n";
		html += "data: {\n";
		html += "\"fcseq\": FC_SEQ,\n";
		html += "\"pageIndex\": pageIndex\n";
		html += "},\n";
		html += "success: function(data) {\n";
		html += "jQuery(\"#productListHtml\").html(data);\n";
		html += "jQuery(\".productListModal\").height(jQuery(document).height()).show();\n";
		html += "jQuery(\".productListContainer\").css(\"top\", jQuery(document).scrollTop() + 50);\n";
		html += "\n";
		html += "}\n";
		html += "});\n";
		html += "}\n";
		html += "});\n";
		html += "if (/bz_tracking_id/.test(location.search)) { localStorage.BuzzAd = location.search }";
		html += "</script>\n";
		html += "<body>\n";
		html += "\n";
		html += "\n";
		html += "<!--  PC 화면  -->\n";
		html += "<div id=\"pc\">\n";
		html += "<div class=\"header\">\n";
		html += "<img src=\"/common/images/fairimage/main_top_title_m.png\">\n";
		html += "</div>\n";
		html += "\n";
		if(bannerList.size() > 0) {
			html += "<div class=\"bannerList\">\n";
			html += "<div class=\"swiper swiper-container\">\n";
			html += "<ul class=\"swiper-wrapper\">\n";
				for(EmfMap blist : bannerList) {
					html += "<li class=\"swiper-slide\">\n";
					if(!blist.getString("fbtLink").isEmpty()) {
						html += "<a href=\""+ blist.getString("fbtLink") +"\"\n";
						
						if(!blist.getString("fbtLinkType").isEmpty()) {
							html += "target = \""+ blist.getString("fbtLinkType") +"\"\n";
						}else{
							html += "target = \"_blank\"\n";
						}
						html += ">\n";
					}
					html += "<img src=\"/common/images/fairimage/"+ blist.getString("fbtImageMSaveNm") +"\" title=\""+ blist.getString("fbtImageMRealNm") +"\">\n";
					if(!blist.getString("fbtLink").isEmpty()) {
						html += "</a>\n";
					}
					html += "</li>\n";
				}
			html += "</ul>\n";
			html += "<a href=\"#\" class=\"btn_prev\"><img src=\"/common/images/fairimage/main_banner_arrow_left.png\"></a>\n";
			html += "<a href=\"#\" class=\"btn_next\"><img src=\"/common/images/fairimage/main_banner_arrow_right.png\"></a>\n";
			html += "</div>\n";
			if(config.getString("fcfgStatus").equals("Y")) {
				html += "<div class=\"dday\">\n";
				html += "<div class=\"dday_container\">\n";
				html += "<div class=\"day\">\n";
				html += "<div id=\"dd\">마감 D-DAY</div>\n";
				html += "<div class=\"time_container\">\n";
				html += "<div class=\"time\" id=\"hh0\">0</div>\n";
				html += "<div class=\"time\" id=\"hh1\">0</div>\n";
				html += "<div class=\"comma\"><span class=\"box\"></span><span class=\"box bottom\"></span></div>\n";
				html += "<div class=\"time\" id=\"mm0\">0</div>\n";
				html += "<div class=\"time\" id=\"mm1\">0</div>\n";
				html += "<div class=\"comma\"><span class=\"box\"></span><span class=\"box bottom\"></span></div>\n";
				html += "<div class=\"time\" id=\"ss0\">0</div>\n";
				html += "<div class=\"time\" id=\"ss1\">0</div>\n";
				html += "<div style=\"clear:both;\"></div>\n";
				html += "</div>\n";
				html += "</div>\n";
				html += "<div class=\"ddat_title\">"+ config.getString("fcfgDdayTitle") +"</div>\n";
				html += "</div>\n";
				html += "</div>\n";
			}
			html += "</div>\n";
		}
		html += "\n";
		
		if(points.size() > 0 && pointSubList.size() > 0) {
			html += "<div class=\"point\" style=\"background-image:url('/common/images/fairimage/"+ point.getString("fmImageBgSaveNm") +"');\">\n";
			html += "<div class=\"container\">\n";
			html += "<div class=\"pointTitle\"><img src=\"/common/images/fairimage/"+ point.getString("fmImageTitleSaveNm") +"\"></div>\n";
			
			for(EmfMap pointSub : pointSubList) {
				html += "<div class=\"pointSub\">\n";
				html += "<div><img src=\"/common/images/fairimage/"+ pointSub.getString("fmsImageMSaveNm") +"\" title=\""+ pointSub.getString("fmsImageMRealNm") +"\"></div>\n";
				html += "<div class=\"pointDesc\">"+ pointSub.getString("fmsDesc") +"</div>\n";
				html += "</div>\n";
			}
			html += "</div>\n";
			html += "</div>\n";
		}
		html += "\n";
		
		if(cateList.size() > 0) {
			html += "<div class=\"category\">\n";
			html += "<div class=\"container\">\n";
				for(EmfMap cate : cateList) {
					html += "<div class=\"categorySub\" onclick=\"javascript:jQuery(this).categoryMove();\">\n";
					html += "<div><img src=\"/common/images/fairimage/"+ cate.getString("fcImageMSaveNm") +"\" title=\""+ cate.getString("fcImageMRealNm") +"\"></div>\n";
					html += "<div class=\"categoryTitle\">"+ cate.getString("fcTitle") +"</div>\n";
					html += "</div>\n";
				}
				html += "</div>\n";
				html += "</div>\n";
				html += "\n";
				for(EmfMap cate : cateList) {
					List<EmfMap> productList  = (List<EmfMap>) cate.get("productList");
					if(productList.size() > 0) {
						html += "<div class=\"productCategory\">\n";
						html += "<div class=\"swiperProduct swiper-container\">\n";
						html += "<ul class=\"swiper-wrapper\">\n";
						for(EmfMap product : productList) {
							html += "<li class=\"swiper-slide\">\n";
							html += "<div class=\"product\" style=\"background-image:url('/common/images/fairimage/"+ product.getString("fpMainImageBgSaveNm") +"');\">\n";
							html += "<div class=\"container\">\n";
							html += "<div class=\"productContainer\">\n";
							html += "<div class=\"productTitle\"";
							if(!cate.getString("fcCategoryTitleColor").isEmpty()) {
								html += "style=\"color:"+ cate.getString("fcCategoryTitleColor") +";\"";
							}
							html += ">"+ product.getString("fpMainTitle") +"</div>\n";
							html += "<div class=\"productImage\">\n";
							html += "<img src=\"/common/images/fairimage/"+ product.getString("fpMainImageMSaveNm") +"\" title=\""+ product.getString("fpMainImageMRealNm") +"\">\n";
							html += "<div class=\"productLabel\">"+ product.getString("fpLabel") +"</div>\n";
							html += "</div>\n";
							html += "\n";
							html += "<div class=\"productDetail\">\n";
							html += "<div class=\"productSubTitle\">"+ product.getString("fpMainSubtitle") +"</div>\n";
							html += "<div class=\"productDesc\">"+ product.getString("fpMainDesc") +"</div>\n";
							html += "<div class=\"productPrice\">"+ product.getString("fpInput") +"</div>\n";
							html += "<a class=\"productBtn\" href=\"/fair/"+ product.getString("fpSeq") +"/index.do\">자세히보기</a>\n";
							html += "</div>\n";
							html += "</div>\n";
							html += "</div>\n";
							html += "</div>\n";
							html += "</li>\n";
						}
						html += "</ul>\n";
						html += "<a href=\"#\" class=\"btn_prev\"><img src=\"/common/images/fairimage/product_arrow_left.png\"></a>\n";
						html += "<a href=\"#\" class=\"btn_next\"><img src=\"/common/images/fairimage/product_arrow_right.png\"></a>\n";
						html += "<div class=\"swiper-pagination\"></div>\n";
						html += "</div>\n";
						html += "<div class=\"productCategoryTitle\"";
						if(!cate.getString("fcCategoryTitleColor").isEmpty()) {
							html += "style=\"color:"+ cate.getString("fcCategoryTitleColor") +";\"";
						}
						html += ">"+ cate.getString("fcCategoryTitle") +"</div>\n";
						html += "<a class=\"productList\" onclick=\"javascript:jQuery(this).productListShow('"+ cate.getString("fcSeq") +"', '1');\">+전체상품보기</a>\n";
						html += "</div>\n";
					}
				}
		}
		html += "\n";
		
		if(eventList.size() > 0) {
			html += "<div class=\"event\">\n";
			html += "<div class=\"container\">\n";
			html += "<div class=\"eventTitle\">항공, 호텔, 패스, 입장권 이벤트</div>\n";
			html += "<div class=\"eventSubTitle\">대박나라 이벤트 모아보기</div>\n";
			for(EmfMap event : eventList) {
				html += "<ul class=\"eventList\">\n";
				if(event.getString("feType").equals("3")) {
					html += "<li class=\"eventRow\"><a href=\""+ event.getString("feLink1") +"\" target=\""+ event.getString("feLink1Type") +"\"><img src=\"/common/images/fairimage/"+ event.getString("feImage1MSaveNm") +"\"></a></li>\n";
					html += "<li class=\"eventRow\"><a href=\""+ event.getString("feLink2") +"\" target=\""+ event.getString("feLink2Type") +"\"><img src=\"/common/images/fairimage/"+ event.getString("feImage2MSaveNm") +"\"></a></li>\n";
				}
				if(event.getString("feType").equals("2")) {
					html += "<li class=\"eventRow\"><a href=\""+ event.getString("feLink1") +"\" target=\""+ event.getString("feLink1Type") +"\"><img src=\"/common/images/fairimage/"+ event.getString("feImage1MSaveNm") +"\"></a></li>\n";
				}
				if(event.getString("feType").equals("1")) {
					html += "<li class=\"eventRow\"><a href=\""+ event.getString("feLink1") +"\" target=\""+ event.getString("feLink1Type") +"\"><img src=\"/common/images/fairimage/"+ event.getString("feImage1MSaveNm") +"\"></a></li>\n";
				}
				html += "<li style=\"clear:both;\"></li>\n";
				html += "</ul>\n";
			}
			html += "</div>\n";
			html += "</div>\n";
		}
		html += "\n";
		html += "<div class=\"footer\">\n";
		html += "<div class=\"logo\"><img class=\"logo\" src=\"/common/images/fairimage/footer_logom.png\"></div>\n";
		html += "<div class=\"links\">\n";
		html += "<a href=\"https://www.daemyungimready.com/operation-guide/privacy/index.do\" target=\"_blank\">개인정보취급방침</a>\n";
		html += "<span>|</span>\n";
		html += "<a href=\"https://www.daemyungimready.com/daemyung-lifeway/introduction/contentsid/212/index.do\" target=\"_blank\">회사소개</a>\n";
		html += "<span>|</span>\n";
		html += "<a href=\"https://www.daemyungimready.com/main/index.do\" target=\"_blank\">공식홈페이지</a>\n";
		html += "<span>|</span>\n";
		html += "<a href=\"https://www.imreadymall.com\" target=\"_blank\">회원몰</a>\n";
		html += "</div>\n";
		html += "<div class=\"info\">\n";
		html += "<span class=\"txt\">서울시 송파구 법원로 135 대명타워</span>\n";
		html += "<span>|</span>\n";
		html += "<span class=\"txt\">사업자등록번호 220-88-09321</span>\n";
		html += "<span>|</span>\n";
		html += "<span class=\"txt\">대표자 (주)대명스테이션 대표이사 서준혁, 최성훈</span>\n";
		html += "<span>|</span>\n";
		html += "<span class=\"txt\">통신판매신고번호 제2016-서울송파-0669호</span>\n";
		html += "<div class=\"copyright\">\n";
		html += "COPYRIGHT DAEMYUNGSTATION.CO,.LTD. ALL RIGHTS RESERVED.\n";
		html += "</div>\n";
		html += "</div>\n";
		html += "</div>\n";
		html += "\n";
		html += "<div class=\"productListModal\">\n";
		html += "<div class=\"productListContainer\">\n";
		html += "<div class=\"productListTitle\" id=\"productListTitle\">상품 전체보기</div>\n";
		html += "<div class=\"productListClose\"><a id=\"productListClose\"></a></div>\n";
		html += "<div id=\"productListHtml\"></div>\n";
		html += "</div>	\n";
		html += "</div>\n";
		html += "</div>\n";
		html += "\n";
		html += "<!-- Global site tag (gtag.js) - Google Analytics -->\n";
		html += "<script async src=\"https://www.googletagmanager.com/gtag/js?id=UA-154355799-1\"></script>\n";
		html += "<script>\n";
		html += "window.dataLayer = window.dataLayer || [];\n";
		html += "function gtag(){dataLayer.push(arguments);}\n";
		html += "gtag(\"js\", new Date());\n";
		html += "gtag(\"config\", \"UA-154355799-1\");\n";
		html += "</script>\n";
		html += "</body>\n";
		html += "</html>\n";
		
		rstMap.put("mo", html);
		
		return rstMap;
	}
}