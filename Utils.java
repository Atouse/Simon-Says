package SimonSays;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Utils {
	
	//reset vars for different levels with increasing iterations
	final static int[] RESET_4 = {5,5}; // reset default user input sequence arr

	//
	
	public static boolean areEqual(int[] arr1, int[] arr2) {
		for(int i = 0; i < arr1.length; ++i) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void delay(int ms) {
		try {
			Thread.sleep(ms);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static int[] increase(int[] arr1) {
		int[] arr=new int[arr1.length+1];
		for(int i=0;i<arr.length;i++) {
			arr[i]=5;
		}
		return arr;
	}
	
	public static int[] increased(int[] arr) {
		int[]arr1=new int[arr.length+1];
		for(int i=0;i<arr.length;i++) {
			arr1[i]=arr[i];
		}
		return arr1;
	}
	
	public static void play(String clip) {
        //This gets the path to the project, but not into /src for eclipse
        String path = new File("").getAbsolutePath() + "/" + clip + ".wav";
        //Make a File object with a path to the audio file.
        File sound = new File(path);

        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
            Clip c = AudioSystem.getClip();
            c.open(ais); //Clip opens AudioInputStream
            c.start(); //Start playing audio

            //sleep thread for length of the song
            Thread.sleep((int)(c.getMicrosecondLength() * 0.001));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
	
	
}
