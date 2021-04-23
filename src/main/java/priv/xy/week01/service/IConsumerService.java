package priv.xy.week01.service;

import priv.xy.week01.domain.Consumer;
import priv.xy.week01.pojo.ConsumerDTO;
import priv.xy.week01.pojo.ConsumerVO;
import priv.xy.week01.pojo.PageResponseDTO;


public interface IConsumerService {
    /**
     * 根据数据插入
     *
     * @param consumerVo
     * @return
     */
    boolean insertConsumer(ConsumerVO consumerVo);

    /**
     * 用户登录
     *
     * @param consumerVo
     * @return
     */
    Consumer loginConsumer(ConsumerVO consumerVo);

    /**
     * 根据搜索条件，分页查询
     *
     * @param key
     * @param page
     * @param limit
     * @return
     */
    PageResponseDTO<ConsumerDTO> listConsumer(String key, Integer page, Integer limit);

    /**
     * 通过id 删除用户
     *
     * @param id
     * @return
     */
    boolean deleteConsumer(Long id);

    /**
     * 通过id 查找用户
     *
     * @param id
     * @return
     */
    Consumer getConsumerById(Long id);

    /**
     * 更新用户
     *
     * @param consumerVo
     * @return
     */
    boolean updateConsumer(ConsumerVO consumerVo);
}
