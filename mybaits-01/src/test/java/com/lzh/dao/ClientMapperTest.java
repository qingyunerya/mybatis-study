package com.lzh.dao;

import com.lzh.pojo.Client;
import com.lzh.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class ClientMapperTest {

    @Test
    public void testClientDao(){
        SqlSession session = null;
        try {
            session = MybatisUtils.getSqlSession();
            ClientMapper mapper = session.getMapper(ClientMapper.class);
            List<Client> clientList = mapper.getClientList();
            for (Client c : clientList) {
                System.out.println(c.getId() + "username:" + c.getUsername() + "password:" + c.getPassword());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }


    }

    @Test
    public void testClientMapper(){

        SqlSession session=null;
        try {
            session=MybatisUtils.getSqlSession();
            ClientMapper mapper = session.getMapper(ClientMapper.class);
            Client c = mapper.getClientById(4);
            System.out.println(c.getId() + "username:" + c.getUsername() + "password:" + c.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }

    }
    @Test
    public void testClientInsert(){

        SqlSession session=null;
        try {
            session=MybatisUtils.getSqlSession();
            ClientMapper mapper = session.getMapper(ClientMapper.class);
            Client client=new Client();
//            client.setId(1234L);
            client.setPassword("fsadf");
            client.setUsername("张三");
            int num=mapper.insertClient(client);
            if (num>0) System.out.println("插入成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.commit();
            session.close();
        }

    }
    @Test
    public void testClientUpdate(){

        SqlSession session=null;
        try {
            session=MybatisUtils.getSqlSession();
            ClientMapper mapper = session.getMapper(ClientMapper.class);
            Client client=new Client();
            client.setId(1234L);
            client.setPassword("fsadf");
            client.setUsername("李四");
           int num= mapper.updateClient(client);
            if (num>0) System.out.println("更新成功");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.commit();
            session.close();
        }


    }
    @Test
    public void testClientDelete(){

        SqlSession session=null;
        try {
            session=MybatisUtils.getSqlSession();
            ClientMapper mapper = session.getMapper(ClientMapper.class);
            int num= mapper.deleteClient(1234);
            if (num>0) System.out.println("删除成功");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.commit();
            session.close();
        }


    }
    @Test
    public void testClientInsertMap(){

        SqlSession session=null;
        try {
            session=MybatisUtils.getSqlSession();
            ClientMapper mapper = session.getMapper(ClientMapper.class);

            HashMap<String, Object> map = new HashMap<String, Object>();
//            map.put("id",1234);
            map.put("pwd","nihaoa");
            int num=mapper.insertClient2(map);
            if (num>0) System.out.println("插入成功");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.commit();
            session.close();
        }

    }
    @Test
    public void testClientInsertLike(){

        SqlSession session=null;
        try {
            session=MybatisUtils.getSqlSession();
            ClientMapper mapper = session.getMapper(ClientMapper.class);
            List<Client> clients = mapper.getLike("%%");
            for (Client c : clients) {
                System.out.println(c.getId() + "username:" + c.getUsername() + "password:" + c.getPassword());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.commit();
            session.close();
        }

    }


}
