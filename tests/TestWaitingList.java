import junit.framework.*;
import java.util.*;

public class TestWaitingList extends TestCase{
  
  public void testInsert(){
   WaitingList list = new WaitingList();
   Group group = new Group(0,2,0,0,0,true);
   Group group2 = new Group(0,3,0,0,0,true);
   Group group3 = new Group(0,4,0,0,0,true);
   Group group4 = new Group(0,5,0,0,0,true);
   
   assertTrue(list.size()==0);
   assertTrue(list.insert(group));
   assertTrue(list.insert(group2));
   assertTrue(list.insert(group3));
   assertTrue(list.insert(group4));
   
   assertTrue(list.size()==4);
    
  }
  
  public void testGetGroup(){
   WaitingList list = new WaitingList();
   Group group = new Group(0,2,0,0,0,true);
   Group group2 = new Group(0,3,0,0,0,true);
   Group group3 = new Group(0,4,0,0,0,true);
   Group group4 = new Group(0,5,0,0,0,true);
   
   list.insert(group4);
   list.insert(group2);
   list.insert(group);
   list.insert(group3);
   
   assertTrue(list.getGroup(0)==group4);
   assertTrue(list.getGroup(3)==group3);
   
   list.removeGroup(0);
   assertTrue(list.getGroup(0)==group2);
   
   list.removeGroup(1);
   assertTrue(list.getGroup(1)==group3);
  }
  
  public void testRemoveGroup(){
    WaitingList list = new WaitingList();
   Group group = new Group(0,2,0,0,0,true);
   Group group2 = new Group(0,3,0,0,0,true);
   Group group3 = new Group(0,4,0,0,0,true);
   Group group4 = new Group(0,5,0,0,0,true);
    
   list.insert(group4);
   list.insert(group2);
   list.insert(group);
   list.insert(group3);
   
   assertTrue(list.size()==4);
   int i=3;
   while(i>=0){
    list.removeGroup(i);
    assertTrue(list.size()==i);
    i--;
   }
    
  }
  
  
  
  
  
  
  
}