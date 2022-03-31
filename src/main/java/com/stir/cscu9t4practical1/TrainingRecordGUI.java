 // GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField repetitions = new JTextField(30);
    private JTextField recovery = new JTextField(2);
    private JTextField tempo = new JTextField(2);
    private JTextField terrain = new JTextField(4);
    private JTextField where = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labrepetitions = new JLabel(" repetitions:");
    private JLabel labrecovery = new JLabel(" recovery:");
    private JLabel labtempo = new JLabel(" tempo:");
    private JLabel labterrain = new JLabel(" terrain:");
    private JLabel labwhere = new JLabel(" where:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private TrainingRecord myAthletes = new TrainingRecord();
    private JButton showAll = new JButton("show all");
    private JButton remove = new JButton("Remove record");
    //checkbox
    private JRadioButton  rad1 = new JRadioButton ("swim"); 
    private JRadioButton  rad2 = new JRadioButton ("run"); 
    private JRadioButton  rad3 = new JRadioButton ("cycle"); 
    
     
    


    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        
        add(labrepetitions);
        add(repetitions);
        repetitions.setEditable(true);
        
        add(labrecovery);
        add(recovery);
        recovery.setEditable(true);
        
        add(labtempo);
        add(tempo);
        tempo.setEditable(true);
        
        add(labterrain);
        add(terrain);
        terrain.setEditable(true);
        
        add(labwhere);
        add(where);
        where.setEditable(true);
        //rad box
        ButtonGroup group = new ButtonGroup();
        rad1.setBounds(150,150, 50,50);    
        group.add(rad1);
        add(rad1);
        rad1.addActionListener(e -> {
            System.out.println("man: " + ((JRadioButton) e.getSource()).isSelected()); });

        
        rad2.setBounds(150,150, 50,50);    
        group.add(rad2);
        add(rad2);
        rad2.addActionListener(e -> {
            System.out.println("kug: " + ((JRadioButton) e.getSource()).isSelected()); });

        
        rad3.setBounds(150,150, 50,50);    
        group.add(rad3);
        add(rad3);
        rad3.addActionListener(e -> {
            System.out.println("pih: " + ((JRadioButton) e.getSource()).isSelected()); });

        //rad box
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(showAll);
        showAll.addActionListener(this);
        add(remove);
        remove .addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == showAll) {
        	message = findAllByDate();
        }
        if(event.getSource() == remove ) {
        	removeEntry();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        // add me
        int rep = Integer.parseInt(repetitions.getText());
        int rec = Integer.parseInt(recovery.getText());
        String tem = tempo.getText();
        String ter = terrain.getText();
        String whr = where.getText();
        
        
        if(rad1.isSelected() == true){
        	Entry e = new SwimEntry(n, d, m, y, h, mm, s, km,whr);
        	 myAthletes.addEntry(e);
             return message;
        }
        else if(rad2.isSelected() == true){
        	Entry e = new SprintEntry(n, d, m, y, h, mm, s, km,rep,rec);
        	 myAthletes.addEntry(e);
             return message;
        }
        else if(rad3.isSelected() == true){
        	Entry e = new CycleEntry(n, d, m, y, h, mm, s, km,ter,tem);
        	 myAthletes.addEntry(e);
             return message;
        }
        else {
        	Entry e = new Entry(n, d, m, y, h, mm, s, km);
       	 	myAthletes.addEntry(e);
            return message;
        }
        
        
        //add me
       
    }
    public String findAllByDate() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.findAllByDate(d, m, y);
        return message;
    }
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
    public void removeEntry() {
    	 String n = name.getText();
    	 int m = Integer.parseInt(month.getText());
         int d = Integer.parseInt(day.getText());
         int y = Integer.parseInt(year.getText());
         outputArea.setText("looking up record ...");
         myAthletes.removeEntry(n, d, m, y);

    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        //add me
        repetitions.setText("");
        recovery.setText("");
        tempo.setText("");
        terrain.setText("");
        where.setText("");
        //add me

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

