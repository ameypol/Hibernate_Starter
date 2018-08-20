package org.firsthib.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
private String vehicleName;
@Id @GeneratedValue
private int vehicleId;
@ManyToOne
private UserDetails user;

public UserDetails getUser() {
	return user;
}
public void setUser(UserDetails user2) {
	this.user = user2;
}
public String getVehicleName() {
	return vehicleName;
}
public void setVehicleName(String vehicleName) {
	this.vehicleName = vehicleName;
}
public int getVehicleId() {
	return vehicleId;
}
public void setVehicleId(int vehicleId) {
	this.vehicleId = vehicleId;
}

}
