package com.project.apa.api.search.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.apa.mapper.ReservationMapper;

@Repository
public class ReservationDAOImpl implements ReservationDAO {
	@Autowired
	private ReservationMapper mapper;
}
