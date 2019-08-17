package com.imooc.service.impl;

import com.imooc.config.WeChatAccountConfig;
import com.imooc.constant.WeChatPushConstant;
import com.imooc.service.IPushMessageService;
import com.imooc.service.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by TongHaiJun
 * 2019/8/18 2:00
 */
@Service
@Slf4j
public class PushMessageServiceImpl implements IPushMessageService {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WeChatAccountConfig weChatAccountConfig;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId(weChatAccountConfig.getTemplateId().get(WeChatPushConstant.ORDER_TEMPLATE));
        templateMessage.setToUser(orderDTO.getBuyerOpenid());
        List<WxMpTemplateData> data = Arrays.asList(
                new WxMpTemplateData(WeChatPushConstant.FIRST, WeChatPushConstant.ORDER_FIRST_VALUE),
                new WxMpTemplateData(WeChatPushConstant.KEY_WORD_ONE, WeChatPushConstant.MERCHANT_NAME),
                new WxMpTemplateData(WeChatPushConstant.KEY_WORD_TWO, WeChatPushConstant.MERCHANT_PHONE),
                new WxMpTemplateData(WeChatPushConstant.KEY_WORD_THREE, orderDTO.getOrderId()),
                new WxMpTemplateData(WeChatPushConstant.KEY_WORD_FOUR, orderDTO.getOrderStatusEnum().getMessage()),
                new WxMpTemplateData(WeChatPushConstant.KEY_WORD_FIVES, "￥" + orderDTO.getOrderAmount()),
                new WxMpTemplateData(WeChatPushConstant.REMARK, WeChatPushConstant.ORDER_REMARK_VALUE)
        );
        templateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送失败，{}", e);
        }
    }
}
