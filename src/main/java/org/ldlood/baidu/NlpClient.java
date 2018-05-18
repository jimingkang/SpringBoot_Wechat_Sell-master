package org.ldlood.baidu;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

public class NlpClient extends AipNlp {
    //设置APPID/AK/SK
    public static final String APP_ID = "11220383";
    public static final String API_KEY = "vk8hZ2psbYYnQ892anoS8w74";
    public static final String SECRET_KEY = "HAwgchqXZ4N53prYlZpHwYB3mhiFDSox";





    protected NlpClient(String appId, String apiKey, String secretKey) {
        super(appId, apiKey, secretKey);
    }

    public static void main(String[] args) {
        // 初始化一个AipImageClassifyClient
        NlpClient client = new NlpClient(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
    //    client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
    //    client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "log4j.properties");

        // 调用接口
        //String path = "/home/jka07@int.hrs.com/hrs_doc/SpringBoot_Wechat_Sell-master/src/main/java/org/ldlood/baidu/0105_2-1.jpg";
        JSONObject res = client.sentimentClassify("商务标间: 欧式电脑大床房, 大床1.8米、2，3楼、10-15平米、免费宽带、可入住2人", null);
        System.out.println(res.toString(2));
        
    }
}
