import java.util.*;

public class Table{
  
  private ArrayList <Group> container; 
  private int chairs,availableCounter;
  private Group groupZero;
  private boolean round;
  
  /**
   * Constructor method of a table
   * @param chairs the number of chairs in the table
   * @param round the boolean whether a table is open end or not
   */
  public Table(int chairs, boolean round){
    container = new ArrayList<Group> (chairs);
    
    groupZero = new Group(-1,-1,-1,-1,-1,true);
    this.chairs = chairs;
    this.round = round;
    for(int i =0;i<chairs;i++){
      container.add(groupZero); 
    }
    
  }
  
  /**
   * Method to insert a group into a table
   * @param group the group to be inserted
   * @return int the index where the first part of the group is placed
   */
  public int insert(Group group){
    
    int index =-1;
    int counter=0;
    int available = 0;
    int availAtStart = 0;
    int availAtEnd=0;
    boolean firstTimeAvailable=true;
    
    if(canSit(group)){
      
      //calculate the index at which the first person from the group will be placed
      for(int i = 0; i< chairs && available<group.getNum(); i++){
        
        if(container.get(i) == groupZero){
          counter++;
          if(firstTimeAvailable||counter>available){
            available++; 
            
          } 
          
        }if(i+1<chairs && container.get(i+1) !=groupZero){
          if(available<=counter){
            available = counter;
            if(available>0){
              firstTimeAvailable=false;
            }
          }
          
          counter = 0;
        }
        
        if(available == group.getNum()){
          
          index = i-available+1; 
        }
        
      }
      
      
      
      //if there arent seats available on the round table as a straight line then check both ends as well.
      if(available<group.getNum() && round){
        //count available at start
        for(int j =0;j<chairs && container.get(j)==groupZero;j++){
          availAtStart++; 
        }
        //count available at end
        for(int k=chairs-1; k>=0 && container.get(k)==groupZero; k--){
          availAtEnd++; 
        }
        if(available<(availAtStart+availAtEnd)){
          available = (availAtStart+availAtEnd);
          index = chairs-availAtEnd;
        }
      }
      
      //add the first perosn of the group to the calculated index
      container.set(index,group); 
    }
    
    return index;
    
    
  }
  
  /**
   * Method to add a group to a specific index on a table
   * @param index the index where the group is to be added
   * @param group the group to be inserted
   */
  public void addMore(int index,Group group){
    container.set(index,group);
  }
  
  /**
   * Method to add an entire group(for use with tables where size represents number of tables of that type not the number of chairs
   * @param group the group to be added
   * @return boolean true if space is available for group else false
   */
  public boolean addEntireGroup(Group group){
    
    boolean spaceAvail=false;
    int i;
    for(i = 0 ; i<container.size() && !spaceAvail ; i++){
      if(container.get(i) == groupZero){
        spaceAvail=true;
      }
    }if(spaceAvail){
      container.set(i-1,group);
      return true; 
    }else{
      return false; 
    }
    
  }
  
  /**
   * Method to remove a group from the table
   * @param group the group to be removed
   */
  public void remove(Group group){
    for(int i =0;i<chairs;i++){
      if(container.get(i)==group){
        container.set(i,groupZero);
      }
    }
  }
  
  /**
   * Method to check whether there is space available for a group to sit
   * @param group the group to be added
   * @return boolean true if space is available , false if not
   */
  public boolean canSit(Group group){
    
    int counter=0;
    int available = 0;
    int availAtStart = 0;
    int availAtEnd=0;
    boolean firstTimeAvailable = true;
    int i;
    
    //check whetehr there are enough seats for the the group at a table
    for(i = 0; i< chairs && available< group.getNum(); i++){
      
      if(container.get(i) == groupZero){
        counter++;
        if(firstTimeAvailable||counter>available){
          available++; 
          
        } 
        
      }if(i+1<chairs && container.get(i+1) !=groupZero){
        if(available<=counter){
          available = counter;
          if(available>0){
            firstTimeAvailable=false;
          }
        }
        
        counter = 0;
      }
      
    }
    
    
    //if there arent seats available on the round table as a straight line then check both ends as well.
    if(available<group.getNum() && round){
      //count available at start
      for(int j =0;j<chairs && container.get(j)==groupZero;j++){
        availAtStart++; 
      }
      //count available at end
      for(int k=chairs-1; k>=0 && container.get(k)==groupZero; k--){
        availAtEnd++; 
      }
      
      
      if(available<(availAtStart+availAtEnd)){
        available = (availAtStart+availAtEnd); 
      }
    }
    
    
    
    availableCounter = available;
    
    if(available == group.getNum()){
      
      return true; 
    }
    else{
      
      return false; 
    }
  }
  
  /**
   * Method to get the size of the table
   * @return the size of the table
   */
  public int size(){
    return chairs; 
  }
  
  /**
   * Method to get the number of chairs/slots available 
   * @return int the number of chairs/slots filled
   */
  public int chairsFilled(){
    int chairsFilled=0;
    for(int i =0;i<chairs;i++){
      if(container.get(i) != groupZero){
        chairsFilled++;
      }
    }
    return chairsFilled;
    
  }
  
  /**
   * Method to get the group at a particular index
   * @param index where the group lies
   * @return the group
   */
  public Group getGroup(int index){
    return container.get(index);
  }
  
  /**
   * Method to get the type of the table
   * @return boolean true if circular, false if open end
   */
  public boolean getRound(){
    return round;
  }
  
  
  
  
}