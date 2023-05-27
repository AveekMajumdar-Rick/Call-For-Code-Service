package com.covid19.ces.covid.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_sequence_ces")
public class DbSequence {
	
	@Id
	private String id;

	private int seq;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}


	@Override
	public String toString() {
		return "DbSequence [id=" + id + ", seq=" + seq + "]";
	}
	
	
}
