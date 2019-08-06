package com.slzr.system.vo;

import java.util.List;


public class StatisticsVO {
	private AmountNumVO TotalStatistics;
	private AmountNumVO TodayStatistics;
	private List<WeekDayVO> WeekDay;
	private List<DayRegisterVO> WeekDayRegister;
	private int totalRegister;
	private int todayRegister;
	public AmountNumVO getTotalStatistics() {
		return TotalStatistics;
	}
	public void setTotalStatistics(AmountNumVO totalStatistics) {
		TotalStatistics = totalStatistics;
	}
	public AmountNumVO getTodayStatistics() {
		return TodayStatistics;
	}
	public void setTodayStatistics(AmountNumVO todayStatistics) {
		TodayStatistics = todayStatistics;
	}
	public List<WeekDayVO> getWeekDay() {
		return WeekDay;
	}
	public void setWeekDay(List<WeekDayVO> weekDay) {
		WeekDay = weekDay;
	}
	public List<DayRegisterVO> getWeekDayRegister() {
		return WeekDayRegister;
	}
	public void setWeekDayRegister(List<DayRegisterVO> weekDayRegister) {
		WeekDayRegister = weekDayRegister;
	}
	public int getTotalRegister() {
		return totalRegister;
	}
	public void setTotalRegister(int totalRegister) {
		this.totalRegister = totalRegister;
	}
	public int getTodayRegister() {
		return todayRegister;
	}
	public void setTodayRegister(int todayRegister) {
		this.todayRegister = todayRegister;
	}
}
