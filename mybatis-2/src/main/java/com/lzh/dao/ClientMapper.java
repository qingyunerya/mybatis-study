package com.lzh.dao;


import com.lzh.pojo.Client;

import java.util.List;

public interface ClientMapper {

    List<Client> getClientList();

    Client getClientById(int id);

    int insertClient(Client client);

    int updateClient(Client client);

    int deleteClient(int id);


}
