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
import java.text.DecimalFormat;

public class Song
{
   private String title;
   private int length;
   private static String cr = "\r\n";
   private static DecimalFormat fmt = new DecimalFormat("00");

   public Song(String title, String length)
   {
      this.title = title;

      String[] pieces = length.split(":");
      String minutes = pieces[0];
      String seconds = pieces[1];
      int min = Integer.parseInt(minutes);
      int sec = Integer.parseInt(seconds);
      this.length = 60*min + sec;
   }

   public String getTitle()
   {
      return title;
   }

   public int getLength()
   {
      return length;
   }
}
