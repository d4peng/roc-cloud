package icu.d4peng.cloud.common.auth.dao;

import cn.dev33.satoken.dao.SaTokenDao;
import cn.dev33.satoken.util.SaFoxUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-30 10:38
 * @description SaTokenRedisDao: 缓存Dao
 */
public class SaTokenRedisDao implements SaTokenDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaTokenRedisDao.class);
    /**
     * String专用
     */
    public StringRedisTemplate stringRedisTemplate;
    /**
     * Object专用
     */
    public RedisTemplate<String, Object> objectRedisTemplate;

    public SaTokenRedisDao(StringRedisTemplate stringRedisTemplate, RedisTemplate<String, Object> objectRedisTemplate) {
        // 开始初始化相关组件
        this.stringRedisTemplate = stringRedisTemplate;
        this.objectRedisTemplate = objectRedisTemplate;
        Assert.notNull(this.stringRedisTemplate, "string redis template can't be null");
        Assert.notNull(this.objectRedisTemplate, "object redis template can't be null");
    }

    /**
     * 获取Value，如无返空
     */
    @Override
    public String get(String key) {
        return this.stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 写入Value，并设定存活时间 (单位: 秒)
     */
    @Override
    public void set(String key, String value, long timeout) {
        if (timeout == 0 || timeout <= SaTokenDao.NOT_VALUE_EXPIRE) {
            return;
        }
        // 判断是否为永不过期
        if (timeout == SaTokenDao.NEVER_EXPIRE) {
            this.stringRedisTemplate.opsForValue().set(key, value);
        } else {
            this.stringRedisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
        }
    }

    /**
     * 修修改指定key-value键值对 (过期时间不变)
     */
    @Override
    public void update(String key, String value) {
        long expire = getTimeout(key);
        // -2 = 无此键
        if (expire == SaTokenDao.NOT_VALUE_EXPIRE) {
            return;
        }
        this.set(key, value, expire);
    }

    /**
     * 删除Value
     */
    @Override
    public void delete(String key) {
        this.stringRedisTemplate.delete(key);
    }

    /**
     * 获取Value的剩余存活时间 (单位: 秒)
     */
    @Override
    public long getTimeout(String key) {
        Long expire = this.stringRedisTemplate.getExpire(key);
        return expire == null ? -2L : expire;
    }

    /**
     * 修改Value的剩余存活时间 (单位: 秒)
     */
    @Override
    public void updateTimeout(String key, long timeout) {
        // 判断是否想要设置为永久
        if (timeout == SaTokenDao.NEVER_EXPIRE) {
            long expire = getTimeout(key);
            if (expire == SaTokenDao.NEVER_EXPIRE) {
                // 如果其已经被设置为永久，则不作任何处理
                LOGGER.info("forever");
            } else {
                // 如果尚未被设置为永久，那么再次set一次
                this.set(key, this.get(key), timeout);
            }
            return;
        }
        this.stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }


    /**
     * 获取Object,如无返空
     */
    @Override
    public Object getObject(String key) {
        return this.objectRedisTemplate.opsForValue().get(key);
    }

    /**
     * 写入Object，并设定存活时间 (单位: 秒)
     */
    @Override
    public void setObject(String key, Object object, long timeout) {
        if (timeout == 0 || timeout <= SaTokenDao.NOT_VALUE_EXPIRE) {
            return;
        }
        // 判断是否为永不过期
        if (timeout == SaTokenDao.NEVER_EXPIRE) {
            this.objectRedisTemplate.opsForValue().set(key, object);
        } else {
            this.objectRedisTemplate.opsForValue().set(key, object, timeout, TimeUnit.SECONDS);
        }
    }

    /**
     * 更新Object (过期时间不变)
     */
    @Override
    public void updateObject(String key, Object object) {
        long expire = getObjectTimeout(key);
        // -2 = 无此键
        if (expire == SaTokenDao.NOT_VALUE_EXPIRE) {
            return;
        }
        this.setObject(key, object, expire);
    }

    /**
     * 删除Object
     */
    @Override
    public void deleteObject(String key) {
        this.objectRedisTemplate.delete(key);
    }

    /**
     * 获取Object的剩余存活时间 (单位: 秒)
     */
    @Override
    public long getObjectTimeout(String key) {
        Long expire = this.objectRedisTemplate.getExpire(key);
        return expire == null ? 0 : expire;
    }

    /**
     * 修改Object的剩余存活时间 (单位: 秒)
     */
    @Override
    public void updateObjectTimeout(String key, long timeout) {
        // 判断是否想要设置为永久
        if (timeout == SaTokenDao.NEVER_EXPIRE) {
            long expire = getObjectTimeout(key);
            if (expire == SaTokenDao.NEVER_EXPIRE) {
                // 如果其已经被设置为永久，则不作任何处理
                LOGGER.info("forever");
            } else {
                // 如果尚未被设置为永久，那么再次set一次
                this.setObject(key, this.getObject(key), timeout);
            }
            return;
        }
        this.objectRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }


    /**
     * 搜索数据
     */
    @Override
    public List<String> searchData(String prefix, String keyword, int start, int size) {
        Set<String> keys = this.stringRedisTemplate.keys(prefix + "*" + keyword + "*");
        if (keys == null) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>(keys);
        return SaFoxUtil.searchList(list, start, size);
    }
}
