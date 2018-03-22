/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs2420;

/**
 *
 * @author OWNER
 */
public abstract class KeyedItem
{
  private String search_key;
  
  public KeyedItem(String key) 
  {
    search_key = key;
  }  

  public String getKey() 
  {
    return search_key;
  }
}
