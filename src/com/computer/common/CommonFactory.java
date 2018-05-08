package com.computer.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.computer.constant.PermissionEnum;

/**
 * 公共资源
 *
 */
public class CommonFactory {
    /**
     * 白名单
     */
    public static final Map<String, List<String>> WHITE_MAP;
    /**
     * 黑名单
     */
    public static final Map<String, List<String>> BLACK_MAP;
    static {
        WHITE_MAP = Maps.newConcurrentMap();
        WHITE_MAP.put(PermissionEnum.WHITE_LIST.type, Arrays.asList(new String[] { "test", "alienware","testadd" })); //白名单可以删除
        BLACK_MAP = Maps.newConcurrentMap();
        BLACK_MAP.put(PermissionEnum.BLACK_LIST.type, Arrays.asList(new String[]  { "hp", "lenovo" } ));  //黑名单不可以更新
    }
}
