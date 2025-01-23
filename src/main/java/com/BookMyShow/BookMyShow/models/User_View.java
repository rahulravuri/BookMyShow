package com.BookMyShow.BookMyShow.models;

import java.util.List;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Immutable
@Getter
@Setter
@Table(name = "user_details")
public class User_View {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid ;
	private String emailid;
	private int phone_number;

}
