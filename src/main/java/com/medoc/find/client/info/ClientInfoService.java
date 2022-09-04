package com.medoc.find.client.info;


import com.medoc.find.client.dao.entity.ClientEntity;
import com.medoc.find.client.dao.entity.QClientEntity;
import com.medoc.find.client.dao.repository.ClientRepository;
import com.medoc.find.client.dao.repository.QueryDslClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientInfoService {

    private final ClientRepository clientRepository;
    private final QueryDslClientRepository queryDslClientRepository;

    private final ClientInfoMapper clientInfoMapper;

    public ClientInfoService(final ClientRepository clientRepository,
                             final QueryDslClientRepository queryDslClientRepository,
                             final ClientInfoMapper clientInfoMapper) {
        this.clientRepository = clientRepository;
        this.queryDslClientRepository = queryDslClientRepository;
        this.clientInfoMapper = clientInfoMapper;
    }


    public ClientEntity save(final ClientInfoDTO clientInfoDTO) {
        final ClientEntity clientEntity = new ClientEntity();
        clientEntity.setAddress(clientInfoDTO.getAddress());
        clientEntity.setEmail(clientInfoDTO.getEmail());
        clientEntity.setName(clientInfoDTO.getName());
        clientEntity.setLastName(clientInfoDTO.getLastName());
        clientEntity.setPhone(clientInfoDTO.getPhone());

        return clientRepository.save(clientEntity);

    }

    public boolean update(Long id, final ClientInfoDTO clientInfoDTO) {

        ClientEntity clientEntity = clientInfoMapper.mapfromobjectEntity(clientInfoDTO);
        clientRepository.save(clientEntity);
        return true;


    }

    public void deleteAll() {
        clientRepository.deleteAll();
    }

    public int deleteClient(Long id) {
        clientRepository.deleteById(id);
        return 0;
    }

    public List<ClientEntity> getAllClient() {
        return clientRepository.getAllClient();
    }

    public List<ClientEntity> getfromQuery(ClientInfoCriteriaRequest clientInfoCriteriaRequest) {
        return queryDslClientRepository.getByCriteria(clientInfoCriteriaRequest);
    }


    public ClientInfoDTO getByID(Long id) {
        ClientEntity entity = clientRepository.getById(id);
        ClientInfoDTO dto = clientInfoMapper.mapFromClientEntity(entity);
        return dto;
    }


    public List<ClientInfoDTO> getAll() {
        List<ClientEntity> entities = clientRepository.getAllClient();
        List<ClientInfoDTO> dto = clientInfoMapper.mapFromClientEntities(entities);
        return dto;
    }
}
