package com.slzr.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.slzr.system.vo.AmountNumVO;
import com.slzr.system.vo.DayRegisterVO;
import com.slzr.system.vo.WeekDayVO;
import com.slzr.system.vo.ZSTodayVO;
import com.slzr.system.vo.ZSTotalVO;

@Mapper
public interface StatisticsDao {
	AmountNumVO GetTotalStatistics(@Param("code") String code);
	AmountNumVO GetTodayStatistics(@Param("code") String code);

	List<DayRegisterVO> GetWeekRegister(@Param("code") String code);
	
	List<WeekDayVO> GetWeekDay(@Param("code") String code);
	
	int GetTodayRegister(@Param("code") String code);
	int GetTotalRegister(@Param("code") String code);
	
	Boolean IsEnableDiscountSetting(@Param("code") String code);
	ZSTodayVO GetZSToday(@Param("code") String code);
	ZSTotalVO GetZSTotal(@Param("code") String code);
}
