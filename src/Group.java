import java.util.*;

public class Group{
  
  private int numberOfPeople,timeToEat,timeToWait,identity,estimatedWaitTime;
  private boolean seated;
  
  /**
   * Constructor method of a Group object
   * @param identity the identity of the group
   * @param numberOfPeople the number of people in the group
   * @param timeToEat the time on the global clock at which the customer will leave
   * @param timeToWait the time the group waited
   * @param estimatedWaitTime the time that the group is estimated to wait
   * @param seated the status of whether or not the group has been seated
   */
  public  Group(int identity,int numberOfPeople, int timeToEat,int timeToWait,int estimatedWaitTime, boolean seated){
    
    this.numberOfPeople=numberOfPeople;
    this.timeToEat=timeToEat;
    this.timeToWait=timeToWait;
    this.seated = seated;
    this.estimatedWaitTime=estimatedWaitTime;
    
  }
  
  /**
   * Method to get the number of people in the group
   * @return the number of people in the group
   */
  public int getNum(){
    
    return numberOfPeople; 
  }
  
  /**
   * Method to get the identity of the group
   * @return the identity of the group
   */
  public int getIdentity(){
    return identity;
    
  }
  
  /**
   * Method to get the time the geopu will take to eat and leave
   * @return the time at which the group will leave
   */
  public int getTimeToEat(){
    return timeToEat;
    
  }
  
  /**
   * Method to get tthe time waited by the group
   * @return the time the group had to wait
   */
  public int getTimeToWait(){
    return timeToWait; 
  }
  
  /**
   * Method to change the identity of the group
   * @param newIdentity the new Identity of the group
   */
  public void setIdentity(int newIdentity){
   identity = newIdentity;
  }
  
  /**
   * Method to change the time when the customers will take to eat and leave
   * @param newTimeToEat the new time at which the group will eat and leave
   */
  public void setTimeToEat(int newTimeToEat){
   timeToEat = newTimeToEat;
  }
  
  /**
   * Method to change the time the customers waited
   * @param newTimeToWait the new time the customers had to wait to be seated
   */
  public void setTimeToWait(int newTimeToWait){
   timeToWait = newTimeToWait;
  }
  
  /**
   * Method to set the seated status of the group to true
   */
  public void seatedTrue(){
   seated=true; 
  }
  
  /**
   * Method to check whether a group has been seated or not
   * @return true if seated else return false
   */
  public boolean getSeatedStatus(){
   return seated; 
  }
  
  /**
   * mehtod to get the estimated wait time for that group
   * @return the estimated wait time
   */
   public int getEstimatedWaitTime(){
    return estimatedWaitTime; 
  }
   
   /**
    * Method to set a new estimated wait time for the group
    * @param newEstimatedWaitTime the new estimated wait time
    */
   public void setEstimatedWaitTime(int newEstimatedWaitTime){
     
     estimatedWaitTime=newEstimatedWaitTime;
   }
  
  
  
}