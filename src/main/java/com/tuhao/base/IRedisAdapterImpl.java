package com.tuhao.base;

import org.asyou.redis.dao.IRedisAdapter;
import org.asyou.redis.dao.RedisHost;
import redis.clients.jedis.Jedis;

public class IRedisAdapterImpl implements IRedisAdapter {
    @Override
    public RedisHost getHost() {
        return null;
    }

    @Override
    public Jedis getRedis() {
        return null;
    }

    @Override
    public void release(Jedis jedis) {

    }

    @Override
    public void releaseHost() {

    }

    @Override
    public boolean exists(String s) {
        return false;
    }

    @Override
    public boolean exists(byte[] bytes) {
        return false;
    }

    @Override
    public String get(String s) {
        return null;
    }

    @Override
    public void set(String s, String s1) {


    }

    @Override
    public void set(String s, String s1, int i) {

    }

    @Override
    public byte[] get(byte[] bytes) {
        return new byte[0];
    }

    @Override
    public void set(byte[] bytes, byte[] bytes1) {

    }

    @Override
    public void set(byte[] bytes, byte[] bytes1, int i) {

    }

    @Override
    public String getSet(String s, String s1) {
        return null;
    }

    @Override
    public void lpush(byte[] bytes, byte[] bytes1) {

    }

    @Override
    public void lpush(String s, String s1) {

    }

    @Override
    public byte[] rpop(byte[] bytes) {
        return new byte[0];
    }

    @Override
    public String rpop(String s) {
        return null;
    }

    @Override
    public void del(byte[] bytes) {

    }

    @Override
    public void del(String s) {

    }
}
