package top.doutzen.dao;

import org.apache.ibatis.annotations.Param;
import top.doutzen.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by DoutzenShum on 2017/7/30.
 */
public interface SeckillDao {
    /**
     * 减库存
     *
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1，表示更新库存的记录行数
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀的商品信息
     *
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**使用存储过程
     *@Author DoutzenShum
     *@Date 2017/8/16 10:04
     *@Param
     *@Return
     */
    void killByProcedure(Map<String, Object> map);
}
