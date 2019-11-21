package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}


	@Test
	public void findWhiskiesByYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findByYear(2018);
		assertEquals(2, foundWhiskies.size());
	}

	@Test
	public void findDistilleriesByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findByRegion("Speyside");
		assertEquals(2, foundDistilleries.size());

	}

	@Test
	public void canGetAllWhiskiesFromADistilleryOfASpecificAge_TheCustomWay() {
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskiesFromADistilleryOfASpecificAge(1L, 12);
		assertEquals(1, foundWhiskies.size());
	}

	@Test
	public void canGetAllWhiskiesFromASpecificRegion__TheCustomWay(){
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskiesFromParticularRegion("Highland");
		assertEquals(2, foundWhiskies.size());
	}

	@Test
	public void findDistilleryByAge(){
		List<Distillery> foundDistillery = distilleryRepository.findByWhiskiesAge(12);
			assertEquals(2, foundDistillery.size());
	}




}
