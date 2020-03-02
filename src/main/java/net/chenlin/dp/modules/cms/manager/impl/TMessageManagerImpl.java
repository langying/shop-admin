package net.chenlin.dp.modules.cms.manager.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.jpush.JiGuangClient;
import net.chenlin.dp.common.jpush.JiGuangUtil;
import net.chenlin.dp.modules.cms.dao.TMessageMapper;
import net.chenlin.dp.modules.cms.entity.TMessageEntity;
import net.chenlin.dp.modules.cms.manager.TMessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 消息推送表
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2018年8月18日 下午3:09:21
 */
@Component("tMessageManager")
public class TMessageManagerImpl implements TMessageManager {

    @Autowired
    private TMessageMapper tMessageMapper;


    @Override
    public List<TMessageEntity> listTMessage(Page<TMessageEntity> page, Query search) {
        return tMessageMapper.listForPage(page, search);
    }

    @Override
    public int saveTMessage(TMessageEntity tMessage) {
        if(tMessage.getType()==1){
            tMessage.setLinkUrl("");
        }else{
            tMessage.setProductId(0);
        }
        int result = tMessageMapper.save(tMessage);
        if (result > 0) {//发送推送
            if (!"".equals(tMessage.getChannel()) && tMessage.getChannel() != null) {
                Map<String,String> map = new HashMap();

                map.put("type", tMessage.getType()+"");
                map.put("messageId", tMessage.getId()+"");
                map.put("productId", tMessage.getProductId()+"");
                map.put("linkUrl", tMessage.getLinkUrl());
                JiGuangClient jc = new JiGuangUtil();
                jc.pushChannel(tMessage.getContent(), tMessage.getChannel(), map);

            }

        }


        return result;
    }

    @Override
    public TMessageEntity getTMessageById(Long id) {
        TMessageEntity tMessage = tMessageMapper.getObjectById(id);
        return tMessage;
    }

    @Override
    public int updateTMessage(TMessageEntity tMessage) {
        if(tMessage.getType()==1){
            tMessage.setLinkUrl("");
        }else{
            tMessage.setProductId(0);
        }
        return tMessageMapper.update(tMessage);
    }

    @Override
    public int batchRemove(Long[] id) {
        int count = tMessageMapper.batchRemove(id);
        return count;
    }

}
