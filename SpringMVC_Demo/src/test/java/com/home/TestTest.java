package com.home;

import com.home.entities.Goods;
import com.home.mapper.GoodsMapper;
import com.home.util.CtxUtil;
import com.home.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestTest {
    @Test
    public void getGoodsPagerTest() {
        int skip=4;
        int size=2;
        SqlSession session= MyBatisUtil.getSession();
        try {
            GoodsMapper bookdao=session.getMapper(GoodsMapper.class);
            List<Goods> goods=bookdao.getGoodsPager(skip, size);
            Assert.assertEquals(2, goods.size());
        } finally {
            session.close();
        }
    }

    @Test
    public void getGoodsByIdTest() {
        SqlSession session=MyBatisUtil.getSession();
        try {
            GoodsMapper bookdao=session.getMapper(GoodsMapper.class);
            Goods goods=bookdao.getGoodsById(1);
            Assert.assertEquals(1, goods.getId());
            System.out.println(goods);
        } finally {
            session.close();
        }
    }

    @Test
    public void getGoodsCountTest() {
        SqlSession session=MyBatisUtil.getSession();
        try {
            GoodsMapper bookdao=session.getMapper(GoodsMapper.class);
            Assert.assertEquals(9, bookdao.getGoodsCount());
        } finally {
            session.close();
        }
    }

    @Test
    public void insertTest() {
        SqlSession session=MyBatisUtil.getSession();
        try {
            Goods entity=new Goods();
            entity.setName("正宗无锡阳山水蜜桃新鲜水果水密桃12个6斤装江浙沪皖顺丰包邮");
            entity.setPrice(108);
            entity.setPicture("nopic.jpg");
            GoodsMapper bookdao=session.getMapper(GoodsMapper.class);
            Assert.assertEquals(1, bookdao.insert(entity));
        } finally {
            session.close();
        }
    }

    @Test
    public void deleteTest() {
        SqlSession session=MyBatisUtil.getSession();
        try {
            GoodsMapper bookdao=session.getMapper(GoodsMapper.class);
            Assert.assertEquals(1, bookdao.delete(12));
        } finally {
            session.close();
        }
    }

    @Test
    public void update() {
        SqlSession session=MyBatisUtil.getSession();
        try {
            GoodsMapper bookdao=session.getMapper(GoodsMapper.class);
            Goods entity=bookdao.getGoodsById(12);
            entity.setName("正宗无锡阳山水蜜桃新鲜水果水密桃12个6斤装");
            entity.setPrice(107);
            entity.setPicture("nopicture.jpg");

            Assert.assertEquals(1, bookdao.update(entity));
        } finally {
            session.close();
        }
    }



}
