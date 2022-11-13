package com.bt_akademi.team1.utility;

import javax.swing.*;

public final class Util
{
	private Util() {}

	public static void showGeneralException(Exception e)
	{
		showWarningMessage( e.getMessage(), e.getClass().getSimpleName() );
	}

	public static void showAddressInfo(Object varlik)
	{
		System.out.println("object hashcode: " + varlik.hashCode());
		System.out.println("object memory address: " + Integer.toHexString(varlik.hashCode()) + "\n");
	}

	public static void showErrorMessage(Object message) {
		
		JOptionPane.showMessageDialog(null, message, "Error Screen", JOptionPane.ERROR_MESSAGE);
		
	}

	public static void showWarningMessage(Object message, String title)
	{
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
	}

	public static void showWarningMessage(Object message)
	{
		
		JOptionPane.showMessageDialog(null, message, "Warning Screen", JOptionPane.WARNING_MESSAGE);
		
	}
	
	public static void showQuestionMessage(Object message) {
		
		JOptionPane.showMessageDialog(null, message, "Question Screen", JOptionPane.QUESTION_MESSAGE);
		
	}
	
	public static void showInformationMessage(Object message) {
		
		JOptionPane.showMessageDialog(null, message, "Info Screen", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
