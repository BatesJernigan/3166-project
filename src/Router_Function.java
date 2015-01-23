/**
 * @author 	Bates Jernigan, Jacob Hassson
 * Date: 	1/22/2015
 * Purpose: 
 */

import javax.swing.*; 
import java.util.*;

public class Router_Function {
	
	
	public static void main(String[]args){
		int[] parsed_ip;
		String[] binary_ip;
		binary_ip = new String[4];
		parsed_ip = get_ip();

		for (int i = 0; i< parsed_ip.length; i++)
			 binary_ip[i] = to_binary(parsed_ip[i]);
		JOptionPane.showMessageDialog(null, binary_ip[0]+" "+binary_ip[1]+" "+binary_ip[2]+" "+binary_ip[3]);
		
	}
	
	public static int[] get_ip(){
		int[] parsed_ip = {0};
		parsed_ip = new int[4];
		String initial_ip;
		String delimeter = "\\.";
		String[] strTemp;

		initial_ip = JOptionPane.showInputDialog(
				"Please Input the IP Address in the following format: \n '192.178.1.1'");
		
		strTemp = initial_ip.split(delimeter);
		System.out.println();
		
		for(int i = 0; i< strTemp.length; i++){
			int temp = Integer.parseInt(strTemp[i]);
			parsed_ip[i] = temp;
		}

		return parsed_ip;
	}

	public void main_menu(){
		
		
	}

	public static String to_binary(int ip){
		if( ip == 0 )
			return "0";
		String binary = "";
		String[] binary_arr;
		while( ip > 0 ){
			int rem = ip % 2;
			binary = rem + binary;
			ip = ip / 2;
		}
		binary_arr = binary.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
		if ( binary_arr.length < 8 ){
			int pad_size = 9-binary_arr.length;
			binary = String.format("%0"+pad_size+"d", Integer.parseInt(binary));
			System.out.println(binary);
		}
		return binary;
	}
}
