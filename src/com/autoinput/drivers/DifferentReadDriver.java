package com.autoinput.drivers;

import com.autoinput.filereader.ReadData;

public class DifferentReadDriver {
	public static void main(String[] args) {
		ReadData rd = new ReadData("C:\\Users\\Chris\\Dropbox\\World v15.2 - Copy.xlsm");
		rd.doStuff();
	}
}
