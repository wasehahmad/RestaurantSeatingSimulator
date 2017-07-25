import junit.framework.*;
import java.util.*;

public class TestTable extends TestCase{
  
  public void testInsert(){
    Table table = new Table(30,true);
    Table table2 = new Table(30,false);
    Group group = new Group(0,4,0,0,0,true);
    Group group2 = new Group(1,23,0,0,0,true);
    Group group3 = new Group(2,1,0,0,0,true);
    Group group4 = new Group(3,6,0,0,0,true);

    
    
    //insert group to the table
    int index = table.insert(group);
    
    //add more of the same groups to the same table in continuous chairs
    for(int i =1; i<group.getNum(); i++){
      table.addMore(index+i,group); 
    }
    
    //insert another group
    int testIndex= table.insert(group3);
    
    //test whether next group is added after the first group
    assertTrue(""+testIndex,testIndex==4);
    assertTrue(table.chairsFilled()==5);
    
    //remove the first group
    table.remove(group);
    
    //assert that the only group left is in the right place
    assertTrue(table.chairsFilled()==1);
    assertTrue(table.getGroup(4)==group3);
    
  
   //add another group
    int testIndexRoundTable = table.insert(group2);
    
   //assert that the added group is in the right place
   assertTrue(testIndexRoundTable==5);
    
    for(int i =1; i<group2.getNum(); i++){
      table.addMore(testIndexRoundTable+i,group2); 
    }
    
    assertTrue(table.chairsFilled()==24);
    
    //can a group of 6 sit if the table is round and only 4 spaces at the beginning and 2 at the end 
    assertTrue(table.insert(group4)==28);
   
    //test to see if the table isnt round, can you still insert at end and beginning together as a link
    
    table2.addMore(4,group3);
     for(int i =0; i<group2.getNum(); i++){
      table2.addMore(5+i,group2); 
    }
     
     //assert that a goup of 6 cannot be seated as there is no space left
     assertFalse(table2.canSit(group4));
     
    
     
    
  }
  
 public void testCanSit(){
    
    Table table = new Table(8,false);
    Group group = new Group(0,4,0,0,0,true);
    Group group2 = new Group(1,8,0,0,0,true);
    Group group3 = new Group(2,9,0,0,0,true);
    
    //test whether its possible to add groups to a table of size greater than the chairs
    assertFalse(table.canSit(group3));
    
    assertTrue(table.canSit(group));
    assertTrue(table.canSit(group2));
    
    //insert group to the table
    int index = table.insert(group);
    //add more of the same groups to the same table in continuous chairs
    for(int i =1; i<group.getNum(); i++){
      table.addMore(index+i,group); 
    }
    
    //test whether a group greater than remaining seats can sit
    assertFalse(table.canSit(group2));
    
    //test whether its possible to add more groups after removing
    table.remove(group);
    assertTrue(table.canSit(group2));
    
    
  }
  
  public void testAddMore(){
    
    Table table = new Table(20,false);
    Group group = new Group(0,1,0,0,0,true);
    Group group2 = new Group(1,1,0,0,0,true);
    Group group3 = new Group(2,1,0,0,0,true);
    
    assertTrue(table.chairsFilled()==0);
    
    table.addMore(0,group);
    table.addMore(1,group2);
    table.addMore(4,group3);
    
    assertTrue(table.chairsFilled()==3);
    
  }
  
  public void testRemove(){
    Table table = new Table(20,false);
    Group group = new Group(0,1,0,0,0,true);
    Group group2 = new Group(1,4,0,0,0,true);
    Group group3 = new Group(2,1,0,0,0,true);
    
    
    table.insert(group);
    
    //insert group to the table
    int index = table.insert(group2);
    //add more of the same groups to the same table in continuous chairs
    for(int i =1; i<group2.getNum(); i++){
      table.addMore(index+i,group2); 
    }
    
    table.insert(group3);
    //assert that all groups have been seated
    assertTrue(table.chairsFilled()==6);
    
    table.remove(group);
    //assert the removal of a group of 1
    assertTrue(table.chairsFilled()==5);
    
    table.remove(group2);
    //assert the removal of a group of 4
    assertTrue(table.chairsFilled()==1);
    
  }
  
  public void testAddEntireGroup(){
    Table table = new Table(2,false);
    Group group = new Group(0,6,0,0,0,true);
    Group group2 = new Group(1,8,0,0,0,true);
    Group group3 = new Group(2,9,0,0,0,true);
    
    //assert the size of the table as well as the amount of groups there
    assertTrue(table.size()==2);
    assertTrue(table.chairsFilled()==0);
    
    table.addEntireGroup(group);
    table.addEntireGroup(group2);
    
    //assert that all slots are filled
    assertTrue(table.chairsFilled()==table.size());
    
    //asset that another group cannot be added
    assertFalse(""+ table.addEntireGroup(group3),table.addEntireGroup(group3));
    
     
  }
  
  
  
}





