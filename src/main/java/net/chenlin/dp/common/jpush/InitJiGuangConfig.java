package net.chenlin.dp.common.jpush;

import net.chenlin.dp.common.utils.PropertiesUtil;

/**
 * 初始化读取配置
 *
 * @author luck
 */
public class InitJiGuangConfig {

    /**
     * 配置文件地址
     */
    private static PropertiesUtil props;
    static {
        props = new PropertiesUtil("velocity/jpush.properties");
    }

    /**
     * 读取极光配置加载到内存中
     */
    protected static final String JPUSH_MASTERSECRET = props.getProperty("jpush.masterSecret");
    protected static final String JPUSH_APPKEY = props.getProperty("jpush.appKey");
    protected static final String JPUSH__APNS_PRODUCTION = props.getProperty("jpush.options.apns_production");
    public static final String JPUSH__TAG = props.getProperty("jpush.tagName");
    public static final String THIRD_URL = props.getProperty("thirdUrl");
    public static final String H5_PATH = props.getProperty("h5Path");
    public static final String IMAGE_PATH = props.getProperty("imagePath");
    public static final String AGENT_PATH = props.getProperty("agentUrl");
}
