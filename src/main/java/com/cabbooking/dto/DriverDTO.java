package com.cabbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class DriverDTO extends UserDTO {

	private String driverName;
	private String licenseNo;
	private Boolean driverAvailability;
	
	public DriverDTO() {
		
	}

	public DriverDTO(String driverName, String licenseNo, Boolean driverAvailability) {
		super();
		this.driverName = driverName;
		this.licenseNo = licenseNo;
		this.driverAvailability = driverAvailability;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Boolean getDriverAvailability() {
		return driverAvailability;
	}

	public void setDriverAvailability(Boolean driverAvailability) {
		this.driverAvailability = driverAvailability;
	}

	@Override
	public String toString() {
		return "DriverDTO [driverName=" + driverName + ", licenseNo=" + licenseNo + ", driverAvailability="
				+ driverAvailability + "]";
	}
	
}
