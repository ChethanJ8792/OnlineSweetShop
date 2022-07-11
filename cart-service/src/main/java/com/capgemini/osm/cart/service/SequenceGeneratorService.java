package com.capgemini.osm.cart.service;
import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.capgemini.osm.cart.model.DbSequenceCart;

import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {


    @Autowired
    private MongoOperations mongoOperations;


   
    
    public int getSequenceNumberForCart(String sequenceName) {
        //get sequence no
        Query query = new Query(Criteria.where("id").is(sequenceName));
        //update the sequence no
        Update update = new Update().inc("seq",50);
        //modify in document
        //login id will start from 50
        DbSequenceCart pro = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DbSequenceCart.class);
        return !Objects.isNull(pro) ? pro.getSeq() :1;
    }
}