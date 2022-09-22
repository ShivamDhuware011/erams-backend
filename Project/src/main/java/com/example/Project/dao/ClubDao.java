package com.example.Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project.entity.ClubEntity;

public interface ClubDao extends JpaRepository<ClubEntity, Integer> {

}
