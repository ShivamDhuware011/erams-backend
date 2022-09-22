package com.example.Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.entity.ClubEntity;
import com.example.Project.service.ClubServiceImpl;

@RestController
public class ClubController {
	
	@Autowired
	private ClubServiceImpl clubservice;
	
	@PostMapping("/addclub")
	public ClubEntity addclub(@RequestBody ClubEntity clubentity)
	{
		return clubservice.add(clubentity);
	}
	
	@GetMapping("/clublist")
	public List<ClubEntity> allclubs()
	{
		return clubservice.clubLits();
	}
	
	@DeleteMapping("/deleteclub")
	public String deleteclub(@PathVariable("club_id") int club_id)
	{
		clubservice.removeClubById(club_id);
		return "club deleted successfully";
	}
	
	@GetMapping("/{club_id}")
	public ClubEntity getclubbyid(@PathVariable("club_id") int club_id)
	{
	  return clubservice.getClubById(club_id);
	}
	

}
