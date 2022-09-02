package com.medoc.find.client.dao.repository;

import com.medoc.find.client.dao.entity.ClientEntity;
import com.medoc.find.client.dao.entity.QClientEntity;
import com.medoc.find.client.info.ClientInfoCriteriaRequest;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QueryDslClientRepository extends QuerydslRepositorySupport {

    public QueryDslClientRepository() {
        super(ClientEntity.class);
    }

    public List<ClientEntity> getByCriteria(final ClientInfoCriteriaRequest clientInfoCriteria) {

        QClientEntity qClientEntity = QClientEntity.clientEntity;
        JPQLQuery<ClientEntity> query = from(qClientEntity);

        if(clientInfoCriteria.getId()!=null){
            query=query.where(qClientEntity.id.eq(clientInfoCriteria.getId()));
        }
        if(clientInfoCriteria.getName()!=null){
            query=query.where(qClientEntity.name.likeIgnoreCase(clientInfoCriteria.getName()));
        }
        if(clientInfoCriteria.getLastName()!=null){
            query=query.where(qClientEntity.lastName.likeIgnoreCase(clientInfoCriteria.getLastName()));
        }
        if(clientInfoCriteria.getEmail()!=null){
            query=query.where(qClientEntity.email.likeIgnoreCase(clientInfoCriteria.getEmail()));
        }
        if(clientInfoCriteria.getAddress()!=null){
            query=query.where(qClientEntity.address.likeIgnoreCase(clientInfoCriteria.getAddress()));
        }
        if(clientInfoCriteria.getPhone()!=null){
            query=query.where(qClientEntity.phone.likeIgnoreCase(clientInfoCriteria.getPhone()));
        }
    return query.fetch();
    }

}
