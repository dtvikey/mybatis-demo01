package com.damu.dao;

import com.damu.entity.Users;
import com.damu.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author: dtvikey
 * @Date: 18-11-16 下午4:46
 * @Version 1.0
 */
public class UsersDao {

    private SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
    private List<Users> list;
    private Users user;

    /**
     * 查询全部用户
     * @return
     */
    public List<Users> findAll(){

        try{

            list = sqlSession.selectList("findAll");

        }catch (Exception e){

            e.printStackTrace();

        }finally {

            sqlSession.close();

        }

        return list;
    }


    /**
     * 根据编号查询单个用户
     * @return
     */
    public Users findById(Integer id){

        try{

            user = sqlSession.selectOne("findById",id);

        }catch (Exception e){

            e.printStackTrace();

        }finally {

            sqlSession.close();

        }

        return user;
    }
}
