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
import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Comparator;

public class CDSort {
    
    
    public static void main(String[] args) {
        
        String file_name = "cds.txt";
        
        CD[] cds = readMusic(file_name);
        MaxPQ<CD> myCD = new MaxPQ<CD>(cds.length, Sorty);
        for(CD el: cds)
        {
            myCD.insert(el);
        }
        
        for(CD x: cds){
            StdOut.println(myCD.delMax());
            StdOut.println();
        }

        //DO THIS
        //use pq sort on the array of cds
        //print out the cds showing sorted order by title
       
        
    }

    private static CD[] readMusic(String file_name) {
        ArrayList<CD> cds = new ArrayList<CD>();
        
        
        ReadTextFile file = new ReadTextFile(file_name);
      String str = file.readLine();
      while (!file.EOF()){
            String title = file.readLine();
            int year = Integer.parseInt(file.readLine());
            int rating = Integer.parseInt(file.readLine());
            int numTracks = Integer.parseInt(file.readLine());
            CD cd = new CD(title, str, year, rating, numTracks);

            cds.add(cd);
            int tracks = 1;

            while (tracks <= numTracks) {
                String temp = file.readLine();
                String[] line = temp.split(",");
                String len = line[0];
                String songTitle = line[1];
                Song song = new Song(songTitle, len);
                cd.addSong(song);
                tracks++;
            }

            str = file.readLine();
        }

        int num_cds = cds.size();
        CD[] cd_array = new CD[num_cds];

        int count = 0;
        for (CD cd : cds) {
            cd_array[count] = cd;
            count++;
        }

        return cd_array;
    }


	public static Comparator<CD> Sorty = new Comparator<CD>() {
		@Override
		public int compare(CD title1, CD title2) {
			if (title1.getTitle().compareTo(title2.getTitle()) < 0)
				return -1;
			else if (title1.getTitle().compareTo(title2.getTitle()) > 0)
				return 1;
			else
				return 0;
		}

	};
}