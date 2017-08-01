package top.doutzen.dao;

import org.apache.ibatis.annotations.Param;
import top.doutzen.entity.SuccessKilled;

/**
 * Created by DoutzenShum on 2017/7/30.
 */
public interface SuccessKilledDao {
    /**
     * 插入购买明细，可以过滤重复
     * @param seckillId
     * @param userPhone
     * @return插入的行数
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);

    /**
     * 根据秒杀的商品的id查询SuccessKilled对象（该对象携带了Seckill秒杀产品对象）
     * @param seckillId
     * @param userPhone
     * @return SuccessKilled对象
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}
