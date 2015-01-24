/**
 * @author 	Bates Jernigan, Jacob Hassson
 * Date: 	1/22/2015
 * Purpose: 
 */

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Router_Function{
	public static void main(String[]args){
		int[] parsed_ip; //placeholder for initial parsed ip
		String[] input_ip = {""};
		String[] interface0_ip = {""};
		String[] interface1_ip = {""};
		String[] router1_ip = {""};
		String router2;
		
		input_ip = new String[4]; //set length to 4 octets to avoid index array out of bounds error
		interface0_ip = new String[5];
		interface1_ip = new String[5];
		router1_ip = new String[5];
		
//		parsed_ip = get_ip();
//		for (int i = 0; i< parsed_ip.length; i++)
//			 input_ip[i] = to_binary(parsed_ip[i]);
		
		parsed_ip = getInterface0();
		for (int i = 0; i< parsed_ip.length; i++)
			 interface0_ip[i] = to_binary(parsed_ip[i]);
		
		parsed_ip = getInterface1();
		for (int i = 0; i< parsed_ip.length; i++)
			 interface1_ip[i] = to_binary(parsed_ip[i]);
		
		parsed_ip = getRouter1();
		for (int i = 0; i< parsed_ip.length; i++)
			 router1_ip[i] = to_binary(parsed_ip[i]);
		
		router2 = getRouter2();
		
		new Router_Function();

		// show that it is correct binary
		// debugging statement
		JOptionPane.showMessageDialog(null, input_ip[0]+" "+input_ip[1]+" "+input_ip[2]+" "+input_ip[3]);
		JOptionPane.showMessageDialog(null, interface0_ip[0]+" "+interface0_ip[1]+" "+interface0_ip[2]+" "+interface0_ip[3]);
		JOptionPane.showMessageDialog(null, interface1_ip[0]+" "+interface1_ip[1]+" "+interface1_ip[2]+" "+interface1_ip[3]);
		JOptionPane.showMessageDialog(null, router1_ip[0]+" "+router1_ip[1]+" "+router1_ip[2]+" "+router1_ip[3]);
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
	
	public static int[] getInterface0(){
		int[] parsed_ip = {0};
		parsed_ip = new int[5];
		String initial_ip;
		String[] strTemp;
		String[] temp;
		initial_ip = JOptionPane.showInputDialog(
				"Interface 0:  ");

		strTemp = initial_ip.split("\\.");
		System.out.println();
		
		temp = strTemp[3].split("/");
		strTemp[3] = temp[0];
		strTemp[4] = temp[1];
		for(int i = 0; i< strTemp.length; i++){
			int tmp = Integer.parseInt(strTemp[i]);
			parsed_ip[i] = tmp;
		}

		return parsed_ip;
	}
	public static int[] getInterface1(){
		int[] parsed_ip = {0};
		parsed_ip = new int[5];
		String initial_ip;
		String[] strTemp;
		String[] temp;
		initial_ip = JOptionPane.showInputDialog(
				"Interface 0:  ");

		strTemp = initial_ip.split("\\.");
		System.out.println();
		
		temp = strTemp[3].split("\\/");
		strTemp[3] = temp[0];
		strTemp[4] = temp[1];
		for(int i = 0; i< strTemp.length; i++){
			int tmp = Integer.parseInt(strTemp[i]);
			parsed_ip[i] = tmp;
		}

		return parsed_ip;
	}

	public static int[] getRouter1(){
		int[] parsed_ip = {0};
		parsed_ip = new int[5];
		String initial_ip;
		String[] strTemp;
		String[] temp;
		initial_ip = JOptionPane.showInputDialog(
				"Interface 0:  ");

		strTemp = initial_ip.split("\\.");
		System.out.println();
		
		temp = strTemp[3].split("\\/");
		strTemp[3] = temp[0];
		strTemp[4] = temp[1];
		for(int i = 0; i< strTemp.length; i++){
			int tmp = Integer.parseInt(strTemp[i]);
			parsed_ip[i] = tmp;
		}

		return parsed_ip;
	}
	
	public static String getRouter2(){
		String router2;
		String[] strTemp;

		router2= JOptionPane.showInputDialog("Router 2:  ");

		if(router2 != "default"){
			JOptionPane.showMessageDialog(null, "Error, Router 2 is set to be default.");
			return "Default";
		}
		return router2;
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
