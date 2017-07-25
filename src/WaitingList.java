import java.util.*;

public class WaitingList{
  
  private LinkedList<Group> list;
  
  /**
   * Constructor method for the waiting line for customers
   */
  public WaitingList(){
    
    list = new LinkedList<Group>(); 
    
  }
  
  /**
   * Method to insert a group to the end of the waiting list
   * @param group the group to be added
   * @return boolean true i.e. added
   */
  public boolean insert(Group group){
    
   list.add(group);
   
   return true;
    
  }
  
  /**
   * Method to get a group at a point in the waiting list
   * @param index the index of the place where the specific group
   * @return the group
   */
  public Group getGroup(int index){
    
   return  list.get(index);
  }
  
  /**
   * Method to remove a group from the waiting list
   * @param index the index where the group lies which needs to be removed
   */
  public void removeGroup(int index){
    
   list.remove(index); 
  }
  
  /**
   * Method to get the size of the list
   * @return int the size of the list
   */
  public int size(){
   return list.size(); 
  }
  
  
  
  
  
}