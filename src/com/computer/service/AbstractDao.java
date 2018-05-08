package com.computer.service;
import java.util.List;

import com.computer.common.CommonFactory;
import com.computer.constant.PermissionEnum;
import com.computer.mapper.ComputerMapper;
import com.computer.model.ComputerModel;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author: Mr.Wang
 * @description: 检查名单
 **/
public abstract class AbstractDao {
    protected final Logger logger = Logger.getLogger(this.getClass());
    /**
     * computerMapper接口
     *自动装配注解
     */
    @Autowired
    protected ComputerMapper computerMapper;

    //检查白名单权限
    Boolean checkWhitePermission(Integer id) {
        // 切记:
        // 先检查边界数据和异常数据,最后再执行正常流程
        // 边界数据和异常数据包括:
        // 1.返回值为null
        // 2.返回值不为null,内容为空
        // 3.返回值不识别怎么办
        // 4.接口是否会阻塞,应不应该加超时限时,如果阻塞了,是否会影响正常业务流程
        // 5.接口是否会抛出异常,如果抛出异常应该怎么处理,是否有补救措施,是否应该进行告警,是否应该请求运营人员手工介入

        // 针对该记录提取品牌信息并判空
        ComputerModel computerModel = computerMapper.selectComputerById(id);
        // 此处设计的业务逻辑是判断 品牌 信息,只有 品牌 信息符合白名单逻辑的才可以删除
        // 1.返回值为null
        if (null == computerModel || StringUtils.isBlank(computerModel.getBrand())) {
            return Boolean.FALSE;
        }
        // 获取白名单并判空
        // 2.返回值不为null,内容为空
        List<String> whiteList = CommonFactory.WHITE_MAP.get(PermissionEnum.WHITE_LIST.type);
        if (CollectionUtils.isEmpty(whiteList)) {
            return Boolean.FALSE;
        }
        // 进行白名单校验,如果在白名单中的数据才可以删除
        if (whiteList.contains(computerModel.getBrand())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    // 检查黑名单权限
    Boolean checkBlackPermission(Integer id) {
        // 针对该记录提取品牌信息并判空
        ComputerModel computerModel = computerMapper.selectComputerById(id);
        // 此处设计的业务逻辑是判断 品牌 信息,只有 品牌 信息符合黑名单逻辑的 不可以删除
        // 1.返回值为null
        if (null == computerModel || StringUtils.isBlank(computerModel.getBrand())) {
            return Boolean.FALSE;
        }
        // 获取黑名单并判空
        // 2.返回值不为null,内容为空
        List<String> blacklist = CommonFactory.BLACK_MAP.get(PermissionEnum.BLACK_LIST.type);
        if (CollectionUtils.isEmpty(blacklist)) {
            return Boolean.FALSE;
        }
        // 进行黑名单校验,如果在白名单中的数据才可以删除
        if (blacklist.contains(computerModel.getBrand())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
