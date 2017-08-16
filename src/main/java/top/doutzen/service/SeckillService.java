package top.doutzen.service;

import top.doutzen.dto.Exposer;
import top.doutzen.dto.SeckillExecution;
import top.doutzen.entity.Seckill;
import top.doutzen.exception.RepeatKillException;
import top.doutzen.exception.SeckillCloseException;
import top.doutzen.exception.SeckillException;

import java.util.List;

/**
 * Created by DoutzenShum on 2017/8/3.
 */

/**
 * 业务接口三个方面:
 * 1.方法定义粒度，方法定义的要非常清楚
 * 2.参数，要越简练越好
 * 3.返回类型(return 类型一定要友好/或者return异常，我们允许的异常)
 */
public interface SeckillService {
    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    //以下是行为的接口（重要）

    /**
     * 在秒杀开启时输出秒杀的地址，否则输出系统时间和秒杀时间
     *
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    //spring的事务只能识别抛出的运行期异常
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;

    /**
     * 执行秒杀操作by存储过程
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     * @throws RepeatKillException
     * @throws SeckillCloseException
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;
}
