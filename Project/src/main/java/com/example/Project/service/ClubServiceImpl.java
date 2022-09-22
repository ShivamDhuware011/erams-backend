package com.example.Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Project.dao.ClubDao;
import com.example.Project.entity.ClubEntity;

@Service
@Transactional
public class ClubServiceImpl implements IClubService {
	
	@Autowired
	private ClubDao clubDao;

	@Override
	public ClubEntity add(ClubEntity clubentity) {
		
		return clubDao.save(clubentity) ;
	}

	@Override
	public List<ClubEntity> clubLits() {
		List<ClubEntity> clubentity = (List<ClubEntity>) clubDao.findAll();
		return clubentity;
	}

	@Override
	public void removeClubById(int club_id) {
	
		clubDao.deleteById(club_id);
		}

	@Override
	public ClubEntity getClubById(int club_id) {
		
		return clubDao.findById(club_id).get();
		}

}
