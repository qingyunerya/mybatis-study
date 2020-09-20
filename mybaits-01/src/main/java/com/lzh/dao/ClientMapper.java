package com.lzh.dao;

import com.lzh.pojo.Client;

import java.util.List;
import java.util.Map;

public interface ClientMapper {

    List<Client> getClientList();

    List<Client> getLike(String value);
    Client getClientById(int id);

    int insertClient(Client client);

    int insertClient2(Map<String,Object> map);

    int updateClient(Client client);

    int deleteClient(int id);


}
