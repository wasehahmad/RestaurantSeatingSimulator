import java.util.*;

public class ExperimentController{
  
  //constants
  public static final int TOTAL_SECONDS=28800,S_EATING_TIME=2700,L_EATING_TIME=3600,S_ARRIVAL=20,L_ARRIVAL=30,S_EATING_STAN_DEV=600,L_EATING_STAN_DEV=900,
    S_ARRIVAL_STAN_DEV=10,L_ARRIVAL_STAN_DEV=15,ROUND_SIZE=30,BAR_SIZE=20,EIGHT_SIZE=5,FOUR_SIZE=5;
                          
//vaiables
  private Table round, bar, eight,four;
  private WaitingList queue;
  private Random fRandom = new Random();
  private int peopleSeated=0,queueCounter=0,groupCounter=0,count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0,eatingTime=-1,identityCounter=0;
  private int avgWaitTime1 = 0,avgWaitTime2 = 0,avgWaitTime3 = 0,avgWaitTime4 = 0,avgWaitTime5 = 0,avgWaitTime6 = 0,avgWaitTime7 = 0,avgWaitTime8 = 0;
  
  
  /**
   * Method to set a new estimate for the wait time
    * @param group the group which has its estimated wait time changed
   */
  public void setWaitTimeEstimate(Group group){
 
    if(group.getNum()==1)
      group.setEstimatedWaitTime((queue.size()/8)*S_EATING_TIME);
    if(group.getNum()==2)
      group.setEstimatedWaitTime((queue.size()/8)*S_EATING_TIME);
    if(group.getNum()==3)
      group.setEstimatedWaitTime((queue.size()/8)*S_EATING_TIME);
    if(group.getNum()==4)
      group.setEstimatedWaitTime((queue.size()/8)*S_EATING_TIME);
    if(group.getNum()==5)
      group.setEstimatedWaitTime((queue.size()/8)*L_EATING_TIME);
    if(group.getNum()==6)
      group.setEstimatedWaitTime((queue.size()/8)*L_EATING_TIME);
    if(group.getNum()==7)
      group.setEstimatedWaitTime((queue.size()/8)*L_EATING_TIME);
    if(group.getNum()==8)
      group.setEstimatedWaitTime((queue.size()/8-(eight.size()-eight.chairsFilled()))*L_EATING_TIME);
   
   
  }
  
  
  /**
   * Method to seat a group at a round table at the link of end and beginning
   * @param group to be added
   * @param i the current time 
   */
  public void roundTableSeating(Group group,int i){
    
    if(group.getNum()<5){
      
      eatingTime = normalDistributionGenerator(S_EATING_TIME,S_EATING_STAN_DEV);
      
    }else{
      eatingTime = normalDistributionGenerator(L_EATING_TIME,L_EATING_STAN_DEV);
    }
    
    int seated = 0;
    group.seatedTrue();
    group.setTimeToWait(i-group.getTimeToWait());
    group.setTimeToEat(eatingTime+i);
    int index=round.insert(group);
    
    //if the amount of people in group exceeds the amount of space at end
    if(index+group.getNum()>round.size()){
      //add to the end
      for(int j=index;j+1<round.size();j++){
        round.addMore(j+1,group);
        seated++;
      }
      //add to the front
      for(int k = 0;k<(group.getNum()-seated);k++){
        round.addMore(k,group);
      }
    }else{
      //else if its not at the link, add in the normal way
      for(int m =1;m<group.getNum();m++){
        round.addMore(index+m,group);
      }
    }
  }
  
  /**
   * Method to seat a group and set times for waiting and leaving
   * @param group the group under observation
   * @param i the current time
   */
  public void seat(Group group,int i){
    
  if(group.getNum()<5){
      eatingTime = normalDistributionGenerator(S_EATING_TIME,S_EATING_STAN_DEV);
      
    }else{
      eatingTime = normalDistributionGenerator(L_EATING_TIME,L_EATING_STAN_DEV);
    }
   
    
  //for a group of 1 person
    if(group.getNum()==1){
      if (round.canSit(group)){
        count1++;
        roundTableSeating(group,i);
      }
      
   else if(bar.canSit(group)){
        count1++;
        group.seatedTrue();
        group.setTimeToEat(eatingTime+i);
        group.setTimeToWait(i-group.getTimeToWait());
        bar.insert(group); 
        }
      
    }
    
    //for group of 2 people
    if(group.getNum()==2){
      
     if(bar.canSit(group)){
        count2++;
        group.seatedTrue();
        group.setTimeToEat(eatingTime+i);
        group.setTimeToWait(i-group.getTimeToWait());
        int index = bar.insert(group);
        bar.addMore(index+1,group);
        
        
      }
     /* else if (round.canSit(group)){
        count2++;
        roundTableSeating(group,i);
      }*/
      
    }
    
    //for a group of 3
    if(group.getNum()==3){
      if(round.canSit(group)){
        count3++;
        roundTableSeating(group,i);
      }
      else if(four.chairsFilled()<5){
        count3++;
        group.seatedTrue();
        group.setTimeToEat(eatingTime+i);
        group.setTimeToWait(i-group.getTimeToWait());
        four.addEntireGroup(group);
      } 
      
   }
    
    //for a group of 4
    if(group.getNum()==4){
      if(four.chairsFilled()<5){
        count4++;
        group.seatedTrue();
        group.setTimeToEat(eatingTime+i);
        group.setTimeToWait(i-group.getTimeToWait());
        four.addEntireGroup(group);
      }
      /* else if (round.canSit(group)){
        count4++;
        roundTableSeating(group,i);
      }*/
      
    }
    
    //for a group of 5
    if(group.getNum()==5){
      if (round.canSit(group)){
        count5++;
        roundTableSeating(group,i);
      }
   
   }
    
    //for a group of 6
    if(group.getNum()==6){
      
      if (round.canSit(group)){
        count6++;
        roundTableSeating(group,i);
      }
      
  }
    
    //for a group of 7
    if(group.getNum()==7){
      if(eight.chairsFilled()<5){
        count7++;
        group.seatedTrue();
        group.setTimeToEat(eatingTime+i);
        group.setTimeToWait(i-group.getTimeToWait());
        eight.addEntireGroup(group);
        
      }
      
    }
    //for a group of 8
    if(group.getNum()==8){
      if(eight.chairsFilled()<5){
        count8++;
        group.seatedTrue();
        group.setTimeToEat(eatingTime+i);
        group.setTimeToWait(i-group.getTimeToWait());
        eight.addEntireGroup(group);
        
      }
    }
    
    
  }
  
  
  /**
   * Method to generate a random group number
   * @param start the beginning of the range
   * @param end the end of the range
   * @return int a random number between start and end inclusive
   */
  public int groupNumber(int start,int end){
    Random random = new Random();
    
    //computes the range 
    long range = end-start + 1;
    
    // compute a fraction of the range, 0 <= frac < range
    long fraction = (long)(range * random.nextDouble());
    
    int randomNumber = (int) (fraction + start) ; 
    
    return randomNumber;
    
  }
  
  /**
   * Method to get a normal distribution of numbers
   * @param mean the mean of the range
   * @param stanDev the standard deviation of the range
   * @return a randomly generated int within the normal distribution
   */
  public int normalDistributionGenerator(int mean,int stanDev){
    
    int number = (int)(mean + fRandom.nextGaussian()*(stanDev));
    if(number<=0){
      return normalDistributionGenerator(mean,stanDev); 
    }
    else{
      return number;
    }
  }
  
  
  
  
  /**
   * Method to run the entire simulation
   */
  public void run(){
    
    //create the tables
    round = new Table(ROUND_SIZE,true);
    bar = new Table(BAR_SIZE,false);
    eight = new Table(EIGHT_SIZE,false);
    four = new Table(FOUR_SIZE,false);
    //creat the waiting list
    queue = new WaitingList();
    //the constants and variables to be used
    int i=0;
    int sStart=1,sEnd = 4,lStart = 5,lEnd = 8,sArrivalTemp = 0,lArrivalTemp = 0;
    
    //open the restaurant
    while(i<=TOTAL_SECONDS){
      
      
      int arrivalSmall=groupNumber(sStart,sEnd);
      int arrivalLarge=groupNumber(lStart,lEnd);
      
      int sArrivalTime = normalDistributionGenerator(S_ARRIVAL,S_ARRIVAL_STAN_DEV);
      int lArrivalTime = normalDistributionGenerator(L_ARRIVAL,L_ARRIVAL_STAN_DEV);
      
      
      //random number generators for arrival of next time 
      if(i==0){
        
        sArrivalTemp=sArrivalTime;
        lArrivalTemp=lArrivalTime;
      }
      
      //=============================================================================================
      //if time of arrival equals current time, add new group to the end of the waiting list
      
      if(i==sArrivalTemp ){
        
        Group group = new Group(identityCounter,arrivalSmall,-1,-1,-1,false);
        
        //sets the time to wait as current time so that when they are seated the time difference may be calculated and set as the actual time to wait
        group.setTimeToWait(i);
        setWaitTimeEstimate(group);
        if(group.getEstimatedWaitTime()<0){
          group.setEstimatedWaitTime(0);
        }
         if(i+group.getEstimatedWaitTime()<=TOTAL_SECONDS){
         identityCounter++;
         queue.insert(group);
         groupCounter++;
         queueCounter=queueCounter+arrivalSmall;
         }
        sArrivalTemp=i+sArrivalTime;
        
        
        
      }
      
      if(i==lArrivalTemp){
        
        Group group = new Group(identityCounter,arrivalLarge,-1,-1,-1,false);
        
        //sets the time to wait as current time so that when they are seated the time difference may be calculated and set as the actual time to wait
        group.setTimeToWait(i);
        setWaitTimeEstimate(group);
        if(group.getEstimatedWaitTime()<0){
          group.setEstimatedWaitTime(0);
        }
         if(i+group.getEstimatedWaitTime()<=TOTAL_SECONDS){
        identityCounter++;
        queue.insert(group);
        groupCounter++;
        queueCounter=queueCounter+arrivalLarge;
         }
        lArrivalTemp=i+lArrivalTime;
        
         
        
      }
      
      //=============================================================================================
      //check the tables to see if there are any groups who have to leave. remove them
      for(int j =0;j<four.size();j++){
        if(i==four.getGroup(j).getTimeToEat()){
          four.remove(four.getGroup(j));
        }
      }
      for(int j =0;j<eight.size();j++){
        if(i==eight.getGroup(j).getTimeToEat()){
          eight.remove(eight.getGroup(j));
        }
      }
      for(int j =0;j<bar.size();j++){
        if(i==bar.getGroup(j).getTimeToEat()){
          bar.remove(bar.getGroup(j));
        }
      }
      for(int j =0;j<round.size();j++){
        if(i==round.getGroup(j).getTimeToEat()){
          round.remove(round.getGroup(j));
        }
      }
      //================================================================================================
      
      //go throught the waiting list to see if there are seats available for the groups
      
      for(int k =0;k<queue.size();k++){
        
        //if seat is available, add group to the table and give them a departure time
        seat(queue.getGroup(k),i);
        
        if(queue.getGroup(k).getSeatedStatus()){
          System.out.println(queue.getGroup(k).getNum()+","+queue.getGroup(k).getTimeToWait()+","+queue.getGroup(k).getEstimatedWaitTime());
          peopleSeated=peopleSeated+ queue.getGroup(k).getNum();
          queue.removeGroup(k);
        }
        
      }
      //==================================================================================================
      
      i++;
      
    }
    
    //print out the statistics
    System.out.println("People who entered the queue= "+queueCounter);
    System.out.println("People who were seated= "+peopleSeated);
    System.out.println("1,2,3,4,5,6,7,8="+count1+"/"+count2+"/"+count3+"/"+count4+"/"+count5+"/"+count6+"/"+count7+"/"+count8);
    
  }
  
  
  public static void main(String[] args){
    
    ExperimentController lab = new ExperimentController(); 
    
    lab.run();
    
  }
  
  
}