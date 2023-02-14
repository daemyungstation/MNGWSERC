package emf.core.util;

import emf.core.vo.EmfMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.regex.Pattern;


public class EMFSecurityUtil {
    protected static Log log = LogFactory.getLog(EMFSecurityUtil.class);
    public static void maskEmfMap(EmfMap data, String nameColumn, String hpColumn, String emailColumn) {
        try {
            if( data == null ) {
                return;
            }
            if (StringUtils.isNotEmpty(nameColumn)) {
                data.put(nameColumn, maskName(data.getString(nameColumn)));
            }
            if (StringUtils.isNotEmpty(hpColumn)) {
                data.put(hpColumn, maskPhone(data.getString(hpColumn)));
            }
            if (StringUtils.isNotEmpty(emailColumn)) {
                data.put(emailColumn, maskEmail(data.getString(emailColumn)));
            }
        } catch (Exception e) {
            log.warn(String.format("EMFSecurityUtil :%s, %s, %s, %s", data, nameColumn, hpColumn, emailColumn), e);
        }
    }
    public static String maskName(String name) {
        if( StringUtils.isNotEmpty(name) ) {
            int len = name.length();
            if( len >= 3)  {
                return name.substring(0,1) + name.substring(2).replaceAll(".", "*") +     StringUtils .right(name,1);
            } else if( len == 2 ) {
                return name.substring(0,1) + "*";
            } else {
                return name;
            }
        }
        return "";
    }
    public static String maskEmail(String email) {
        if ( StringUtils.isNotEmpty(email) ) {
            if (email.indexOf("@") >= 0) {
                String mailId = email.split("@")[0];
                int len = mailId.length();
                if( len >= 3)  {
                    return mailId.substring(0, 2) +  mailId.substring(2).replaceAll(".", "*") + "@" +  email.split("@")[1];
                } else if( len == 2 ) {
                    return mailId.substring(0,1) + "*@" +  email.split("@")[1];
                } else {
                    return mailId + "@" +  email.split("@")[1];
                }
            } else {
                int len = email.length();
                if( len >= 3)  {
                    return email.substring(0,2) + email.substring(2).replaceAll(".", "*");
                } else if( len == 2 ) {
                    return email.substring(0,1) + "*";
                } else {
                    return email;
                }
            }
        }
        return null;
    }
    public static String maskPhone(String phone) {
        if( StringUtils.isNotEmpty(phone) ) {
            if( phone.indexOf("-") >= 0 && phone.length() > 9 ) {
                return StringUtils.left(phone, 4) + "****" + StringUtils.right(phone, 5);
            } else if(  phone.length() > 7 ) {
                return StringUtils.left(phone, 3) + "-****-" + StringUtils.right(phone, 4);
            }
        }
        return "";
    }
}
