package com.covid19.cfc.user.registration.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.covid19.cfc.user.registration.model.DbSequence;

@Service
public class SequenceGeneratorService {

		@Autowired
		private MongoOperations mongoOperations;
		
		public int getSequenceNumber(String sequenceName)
		{
			Query query = new Query(Criteria.where("id").is(sequenceName));
			Update update = new Update().inc("seq", 1);
			DbSequence counter = mongoOperations
					.findAndModify(query, update, 
							FindAndModifyOptions.options().returnNew(true).upsert(true),
							DbSequence.class);
			return !Objects.isNull(counter) ? counter.getSeq() : 1;
			
		}
}
