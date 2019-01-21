package com.silva.carrent.service.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.silva.carrent.db.RentEntity;
import com.silva.carrent.service.CarrentService.RentCarStatus;

public class RentMapper {
	
	public static RentCarStatus mapToStatus(List<RentEntity> rentEntityList, String startDate, String endDate){
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
			Date start = simpleDateFormat.parse(startDate);
			Date end = simpleDateFormat.parse(endDate);
			if(start.after(end)){
				return RentCarStatus.INVALID_INPUT;
			}
			if(rentEntityList == null || rentEntityList.isEmpty()){
				return RentCarStatus.OK;
			}
			for(RentEntity rentEntity : rentEntityList){
				Date bookedStart = simpleDateFormat.parse(rentEntity.getStartDate());
				Date bookedEnd = simpleDateFormat.parse(rentEntity.getEndDate());
				if(bookedStart.equals(start) || bookedEnd.equals(end) ||
						bookedStart.equals(end) || bookedEnd.equals(start)){
					return RentCarStatus.ALREADY_BOOKED;
				}
				if(start.after(bookedStart) && start.before(bookedEnd)){
					return RentCarStatus.ALREADY_BOOKED;
				}
				if(end.after(bookedStart) && end.before(bookedEnd)){
					return RentCarStatus.ALREADY_BOOKED;
				}
				if(start.before(bookedStart) && end.after(bookedEnd)){
					return RentCarStatus.ALREADY_BOOKED;
				}
			}
		} catch (ParseException e) {
			return RentCarStatus.INVALID_INPUT;
		}
		
		return RentCarStatus.OK;
	}

}
