
// CSCI 211
// Brady Moore
// Student ID 010674564
// Program 2
// In keeping with the UM Honor Code, I have neither given nor received assistance from anyone other
// than the instructor.

import java.util.Stack;

public class Podcasts implements PodcastsADT {
    Stack<Episode> player;

    public Podcasts() {
        player = new Stack<>();
    }

    /**
     * method: play
     * @return Episode (what is currently playing)
     */

       // TODO: If player is not empty pop and return current episode that will now be "playing"
       // Throw exception if there is nothing to play

    public Episode play(){

            if(this.player.isEmpty()){
                throw new InvalidEpisodeException("There is nothing to play");
            }
            else{
                return player.pop();
            }
    }

    /*
    1. Checks if the player is empty and throws an exception if it is
    2. If player isn't empty, return player.pop()
     */


    /**
     * method: playNext
     * @param e (Episode)
	 * method body:  positions this Episode to play next
     */

        // TODO: Push Episode e on top of stack - this Episode will play next

    public void playNext(Episode e) {
        player.push(e);
    }
    /*
    1. Pushing episode (e) on the top of the stack
     */



    /**
     * method: playLast
     * @param e (Episode)
	 * method body:  positions Episode to play last
     */

        // TODO: Push Episode e on bottom of stack - this Episode will play last
    public void playLast(Episode e){
        player.insertElementAt(e, 0);

    }

    /*
    1. Inserting the element "e" at the 0-position which is the bottom
     */


    /**
     * method: playEpisode
     * @param pos (int)
     * @param e (Episode)
	 * method body:  plays the Episode at a given position in the stack
	 *               pos is first parameter, e is second parameter
     */

		// TODO: Push Episode e on the stack at position pos.
        // Assume that the top of the stack is position 1 (NOT 0)
        // Throw exception if position invalid

        public void playEpisode(int pos, Episode e){
            if(pos > player.size()+1){
                throw new InvalidEpisodeException("Position Invalid");
            }
            else if (pos == player.size()+1){
                playLast(e);
            }
            else{
                player.insertElementAt(e, pos-1);
            }
        }

        /*
        1. If the "pos" input from the user is greater than the size+1 of player throw exception
        2. Else if pos is equal to player.size()+1 then call the playLast method with "e" in the parameters
        3. Else insert the element "e" at "pos" - 1
         */




    /**
     * method: deleteNext
	 * method body: deletes the next Episode that would play
     */

        // TODO: Delete episode at the top of the stack
        // Throw exception if stack is empty


        public void deleteNext(){
            if (player.isEmpty())
                throw new InvalidEpisodeException("Stack is Empty");
            while(!player.isEmpty()){
                player.remove(player.pop());
            }
        }

        /*
        1. If the player is empty then an exception is thrown
        2. While the player isn't empty then remove element of player.pop()
         */


    /**
     * method: deleteLast
	 * method body:  deletes the last Episode in the stack
     */
    public void deleteLast() {
        // TODO: Delete episode at the bottom of the stack
        // Throw exception if stack is empty
        if(player.isEmpty())
            throw new InvalidEpisodeException("No episodes in the queue");
        Stack<Episode> temp = new Stack<>();
        while(!player.isEmpty()) {
            temp.push(player.pop());
        }
        temp.pop();
        while(!temp.isEmpty()) {
            player.push(temp.pop());
        }

    }

    /*
    Came finished
     */

    /**
     * method: deleteEpisode
     * @param title
	 * method body: finds and deletes the episode with this title
     */

        // TODO: Find the episode with this title and delete from stack
        // Throw exception if stack is empty of if the episode is not found
    public void deleteEpisode(String title) {
        if (player.isEmpty())
            throw new InvalidEpisodeException("Stack is Empty/Episode Not Found");

        for(int i = 0; i < player.size(); i++){
            if(player.get(i).getTitle().equals(title)){
                player.remove(i);
            }
        }
    }

    /*
    1. If player is empty then exception is thrown
    2. Iterating through player.size
    3. If the title located at location "i" equals the title input remove that title from player
     */


    /**
     * method: toString
     * @return output (titles of Episodes in stack - one title per line)
     */
    public String toString() {
        String output = "";
        Episode tempEpisode;
        Stack<Episode> temp = new Stack<>();
        while (!player.isEmpty()) {
            tempEpisode = player.pop();
            output += tempEpisode.getTitle() +"\n";
            temp.push(tempEpisode);
        }
        while(!temp.isEmpty()) {
            player.push(temp.pop());
        }
        return output;
    }

}
