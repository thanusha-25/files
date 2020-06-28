package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("dataBaseFortuneService")
	private FortuneService fortuneService;
	
  /*
	TennisCoach(FortuneService theFortuneService)
	{
		fortuneService=theFortuneService;
	}
	*/
	/*
	 public void setFortuneService(FortuneService theFortuneService)
	 {
		 fortuneService=theFortuneService;
	 }
	 */
	@Override
	public String getDailyWorkOut() {
		
		return "Practise ypur daily daily backend volley----tennis coach";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
