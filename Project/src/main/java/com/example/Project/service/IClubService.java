package com.example.Project.service;

import java.util.List;

import com.example.Project.entity.ClubEntity;

public interface IClubService {

	
	public ClubEntity add(ClubEntity clubentity);
	public List<ClubEntity> clubLits();
	public void removeClubById(int club_id);
	public ClubEntity getClubById(int club_id);
}
