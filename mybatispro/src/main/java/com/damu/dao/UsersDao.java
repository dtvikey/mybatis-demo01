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

    private SqlSession sqlSession;
    private List<Users> list;
    private Users user;

    private SqlSession getSession(){
        sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        return sqlSession;
    }


    /**
     * 查询全部用户
     * @return
     */
    public List<Users> findAll(){

        try{

            list = getSession().selectList("findUsers");

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

            user = getSession().selectOne("findUsers",new Users(id));

        }catch (Exception e){

            e.printStackTrace();

        }finally {

            sqlSession.close();

        }

        return user;

    }

    /**
     * 添加一个新用户数据到数据库
     * @return
     */
    public Users addUser(Users user){

        try{

            //返回值:insert执行过程中影响的行数
            getSession().insert("addUser",user);

            sqlSession.commit();

        }catch (Exception e){

            e.printStackTrace();

        }finally {

            sqlSession.close();

        }

        return user;

    }

    /**
     * 用于修改用户资料的方法
     * @return
     */
    public Users updateUsers(Users user){

        try{

            //返回值:insert执行过程中影响的行数
            getSession().update("updateUser",user);

            sqlSession.commit();

        }catch (Exception e){

            e.printStackTrace();

        }finally {

            sqlSession.close();

        }

        return user;

    }


    /**
     * 用于删除用户资料的方法
     * @return
     */
    public void delUsers(Integer id){

        try{

            getSession().delete("delUser",id);

            sqlSession.commit();

        }catch (Exception e){

            e.printStackTrace();

        }finally {

            sqlSession.close();

        }


    }


}
