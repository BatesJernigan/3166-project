/**
 * @author 	Bates Jernigan, Jacob Hassson
 * Date: 	1/22/2015
 * Purpose: 
 */

import javax.swing.*;
import java.util.*; //only using this to debug, will remove when done

public class Router_Function {
	
	
	public static void main(String[]args){
		int[] parsed_ip; //placeholder for initial parsed ip
		String[] binary_ip; //array to hold the binary ip
		binary_ip = new String[4]; //set length to 4 octets to avoid index array out of bounds error

		parsed_ip = get_ip();

		for (int i = 0; i< parsed_ip.length; i++)
			 binary_ip[i] = to_binary(parsed_ip[i]);

		// show that it is correct binary
		// debugging statement
		JOptionPane.showMessageDialog(null, binary_ip[0]+" "+binary_ip[1]+" "+binary_ip[2]+" "+binary_ip[3]);		
	}

	/**
	 * gets the ip as an input and parses it with the '.' as the delimiter
	 * @return split ap address by the '.'s 
	 */
	public static int[] get_ip(){
		int[] parsed_ip = {0};
		parsed_ip = new int[4];
		String initial_ip;
		String[] strTemp;

		initial_ip = JOptionPane.showInputDialog(
				"Please Input the IP Address in the following format: \n '192.178.1.1'");
		
		strTemp = initial_ip.split("\\.");
		System.out.println();
		
		for(int i = 0; i< strTemp.length; i++){
			int temp = Integer.parseInt(strTemp[i]);
			parsed_ip[i] = temp;
		}

		return parsed_ip;
	}

	/**
	 * place to put the beginning menu of where you want to input the required numbers
	 * may delete later.
	 */
	public void main_menu(){
			
	}

	public static String to_binary(int ip){
		String binary = ""; //string to hold finished binary octet
		String[] binary_arr; //array to check the length and add 0s if needed
		
		if( ip == 0 )
			return "00000000";
		
		while( ip > 0 ){
			int rem = ip % 2;
			binary = rem + binary;
			ip = ip / 2;
		}

		//Put in the 0 padding
		binary_arr = binary.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
		if ( binary_arr.length < 8 ){
			int pad_size = 9-binary_arr.length;
			binary = String.format("%0"+pad_size+"d", Integer.parseInt(binary));
			System.out.println(binary);
		}

		//return concatenated binary digit string
		return binary;
	}
}
