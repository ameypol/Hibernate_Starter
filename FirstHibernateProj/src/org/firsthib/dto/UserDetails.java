package org.firsthib.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name = "User_details")
public class UserDetails {
  @Id @GeneratedValue(strategy= GenerationType.AUTO) 
  @Column(name="User_Id")
  private int userId;
  @Column(name="User_Name")
  private String userName;
  @Temporal(TemporalType.DATE)
  private Date joinedDate;
  private String description;
  @ElementCollection(fetch=FetchType.EAGER) //to let know hibernate we are suing collecton
  @JoinTable(name="user_address", joinColumns= @JoinColumn(name="UserId"))
  @GenericGenerator(name="increment", strategy="increment")
  @CollectionId(columns = { @Column(name="Address_id") }, generator = "increment", type = @Type(type="long"))
  private Collection<Address> listofAddress = new ArrayList<Address>() ;
  
public Collection<Address> getListofAddress() {
	return listofAddress;
}
public void setListofAddress(Collection<Address> listofAddress) {
	this.listofAddress = listofAddress;
}
@Embedded
  @AttributeOverrides({
	  @AttributeOverride (name="street", column= @Column(name="home_street")),
	  @AttributeOverride (name="state", column= @Column(name="home_state")),
	  @AttributeOverride (name="city", column= @Column(name="home_city")),
	  @AttributeOverride (name="pincode", column= @Column(name="home_picode"))})
      private Address homeaddress; 
  
  @Embedded
  private Address officeaddress;
  @OneToOne
 private Vehicle vehicle;
 
  @OneToMany
  private Collection<Vehicle> vehicl2 = new ArrayList<Vehicle>();
  
 
public Collection<Vehicle> getVehicl2() {
	return vehicl2;
}
public void setVehicl2(Collection<Vehicle> vehicl2) {
	this.vehicl2 = vehicl2;
}
public Vehicle getVehicle() {
	return vehicle;
}
public void setVehicle(Vehicle vehicle) {
	this.vehicle = vehicle;
}
public Address getHomeaddress() {
	return homeaddress;
}
public void setHomeaddress(Address homeaddress) {
	this.homeaddress = homeaddress;
}
public Address getOfficeaddress() {
	return officeaddress;
}
public void setOfficeaddress(Address officeaddress) {
	this.officeaddress = officeaddress;
}

public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public Date getJoinedDate() {
	return joinedDate;
}
public void setJoinedDate(Date joinedDate) {
	this.joinedDate = joinedDate;
}

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
}
