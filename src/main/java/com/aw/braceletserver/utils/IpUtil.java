package com.aw.braceletserver.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IP工具类
 */
public class IpUtil {
    private static final Logger logger = LoggerFactory.getLogger(IpUtil.class);

    /** 查询IP地址 */
    private static final String ipLookUp = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=";

    /** 省 */
    public static final String PROVINCE = "ip_province";

    /** 市 */
    public static final String CITY = "ip_city";

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        if (ip != null && ip.length() > 15 && ip.indexOf(",") > 0) {
            ip = ip.substring(0, ip.indexOf(","));
        }
        return ip;
    }

    /**
     * 获得请求的真实IP地址
     *
     * @param request
     * @return
     */
    public static String getRealIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }

        if (StringUtils.isNotBlank(ip)) {
            int dotIndex = ip.indexOf(",");
            if (-1 != dotIndex) {
                ip = ip.substring(0, dotIndex);
            }
        }
        return ip;
    }

    /**
     * 集群环境下获取服务器IP地址生成主键
     * @return
     */
    public static String getServerIp(){
        String serverIP = "";
        try {
            boolean bFindIP = false;
            InetAddress ip = null;
            Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                if(bFindIP){
                    break;
                }
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                // 遍历所有IP
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    ip = (InetAddress) ips.nextElement();
                    logger.debug("获取到的服务器IP地址：" + ip.getHostAddress());
                    if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1
                            && (ip.getHostAddress().indexOf("192.168.8") != -1 || ip.getHostAddress().indexOf("10.10") != -1) ) {
                        bFindIP = true;
                        logger.info("IF获取到的集群节点服务器IP地址：" + ip.getHostAddress());
                        serverIP = ip.getHostAddress();
                        break;
                    }else{
                        logger.debug("ELSE获取到的服务器IP地址");
                        serverIP = null;
                    }
                }
            }
        } catch (Exception e) {
            try {
                serverIP = getWinLocalIp();
            } catch (Exception e1) {

            }
        }
        logger.info("返回的集群节点服务器IP地址："+serverIP);
        return serverIP;
    }

    private static String getWinLocalIp() throws UnknownHostException{
        InetAddress inet = InetAddress.getLocalHost();
        return inet.getHostAddress();
    }
    public static String getPublicIp() {
        try {
            String path = "http://iframe.ip138.com/ic.asp";// 要获得html页面内容的地址

            URL url = new URL(path);// 创建url对象

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();// 打开连接

            conn.setRequestProperty("contentType", "GBK"); // 设置url中文参数编码

            conn.setConnectTimeout(5 * 1000);// 请求的时间

            conn.setRequestMethod("GET");// 请求方式

            InputStream inStream = conn.getInputStream();
            // readLesoSysXML(inStream);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    inStream, "GBK"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            // 读取获取到内容的最后一行,写入
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
            String str = buffer.toString();
            String ipString1 = str.substring(str.indexOf("["));
            // 获取你的IP是中间的[182.149.82.50]内容
            String ipsString2 = ipString1.substring(ipString1.indexOf("[") + 1,
                    ipString1.lastIndexOf("]"));
            //获取当前IP地址所在地址
		/*	String ipsString3=ipString1.substring(ipString1.indexOf(": "),ipString1.lastIndexOf("</center>"));
			System.err.println(ipsString3);*/

            // 返回公网IP值
            return ipsString2;

        } catch (Exception e) {
            return "获取公网IP连接超时";
        }
    }
    /**
     * 获取本机的外网ip地址
     * @return
     */
    public static String getV4IP(){
        String ip = "";
        String chinaz = "http://www.net.cn/static/customercare/yourip.asp";

        StringBuilder inputLine = new StringBuilder();
        String read = "";
        URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedReader in = null;
        logger.info("请求："+chinaz);
        try {
            url = new URL(chinaz);
            urlConnection = (HttpURLConnection) url.openConnection();
            in = new BufferedReader( new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            while((read=in.readLine())!=null){
                inputLine.append(read+"\r\n");
            }
            //System.out.println(inputLine.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
        Matcher m = p.matcher(inputLine.toString());
        if(m.find()){
            String ipstr = m.group(1);
            ip = ipstr;
        }
        return ip;
    }
    /**
     * 根据IP查询具体省市 没有“省”“市” 如221.7.130.243 返回为广西 南宁
     *
     * @param ip IP地址
     * @return KEY PROVINCE、CITY
     */
    public static Map<String, String> parseIp(String ip) {
        Map<String, String> parMap = new HashMap<String, String>(2);
        if (StringUtils.isBlank(ip) || "127.0.0.1".equals(ip) || ip.startsWith("10.")) {
            return parMap;
        }
        try {
            String s = HttpClientUtil.invokeGet(ipLookUp + StringUtils.trimToEmpty(ip), new HashMap<String, String>(), "GBK", 1000, 1000);
            Map<String, Object> map = JSONUtil.getInstance().parseJSON2Map(s);
            String province = (String) map.get("province");
            String city = (String) map.get("city");
            /**
             * 省市最多不会超过20个字符，但考虑到IP获取到外部地区时，会获取到较长字符。 为了保证当此处字符较长时，超过数据库字段长度，导致业务失败，此处截取
             */
            province = StringUtils.substring(province, 0, 20);
            city = StringUtils.substring(city, 0, 50);
            parMap.put(PROVINCE, province);
            parMap.put(CITY, city);
        } catch (Exception e) {
            logger.error("通过IP获取省市异常：" + e);
        }
        return parMap;
    }
    /**判断Http请求是来自手机端还是电脑端*/
    public static boolean isWeb(String requestHeader) {
        /**
         *
         * android : 所有android设备
         * mac os : iphone ipad
         * windows phone:Nokia等windows系统的手机
         */
        String[] deviceArray = new String[]{"android","mac os","windows phone"};
        if(requestHeader == null)
            return false;
        requestHeader = requestHeader.toLowerCase();
        for(int i=0;i<deviceArray.length;i++){
            if(requestHeader.indexOf(deviceArray[i])>0){
                return false;
            }
        }
        return true;
    }

    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     *
     * @param request HttpServletRequest
     * @return String
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (logger.isInfoEnabled()) {
            logger.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
        }

        String unknown = "unknown";
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
                }
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (String ip1 : ips) {
                if (!(unknown.equalsIgnoreCase(ip1))) {
                    ip = ip1;
                    break;
                }
            }
        }
        return ip;
    }


    public static String getIpAddress() {
        return "IpUtil.getIpAddress()";
    }
}

