/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.tm.data.schedule;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.iemr.tm.utils.StringListConverter;
import com.iemr.tm.utils.mapper.OutputMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "t_SpecialistAvailabilityDetail")
public class SpecialistAvailabilityDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "SpecialistAvailabilityDetailID")
	private Long specialistAvailabilityDetailID;

	@Expose
	@Column(name = "UserID")
	private Long userID;

	@Temporal(TemporalType.DATE)
	@Expose
	@Column(name = "ConfiguredFromDate")
	private Date configuredFromDate;

	@Temporal(TemporalType.DATE)
	@Expose
	@Column(name = "ConfiguredToDate")
	private Date configuredToDate;

	@Expose
	@Column(name = "ConfiguredFromTime")
	private Timestamp configuredFromTime;

	@Expose
	@Column(name = "ConfiguredToTime")
	private Timestamp configuredToTime;

	@Expose
	@Column(name = "IsAvailability")
	private Boolean isAvailability;
	
	@Expose
//	@Transient
	@Column(name = "Excluded_Days")
	@Convert(converter = StringListConverter.class)
	private List<Integer> ExcludeDays;

	@Expose
	@Column(name = "Deleted",insertable=false,updatable=true)
	private Boolean deleted;

	@Expose
	@Column(name = "Processed",insertable=false,updatable=true)
	private String processed;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate",insertable=false,updatable=false)
	private Timestamp createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate",insertable=false,updatable=false)
	private Timestamp lastModDate;
	


	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
