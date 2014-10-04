import java.io.*;
import java.util.Scanner;

/**
 * the plan class controls the input from and output to a file
 * 
 * @author Hayner
 * @version 1.0
 */
public class Plan
{	
	File file;
	/**
	 * the pullDataFile method opens a file and creates course objects for each line of information
	 * 
	 * @param fileName a string representing the file name that is being opened
	 * @param courses an array of course objects
	 */
	public void pullDataFile(String fileName, Course[][] courses)
	{
		int courseNumber = 0, creditHours = 0;
		String department = "", courseTitle = "";
		int semester = 0, course = 0;
		char grade = 'G';
		
		file = new File(fileName);
		try 
		{
			Scanner scan = new Scanner(file);  
			
			while (scan.hasNext()) 
			{
				semester = scan.nextInt();
				course = scan.nextInt();
				department = scan.next();
				courseNumber = scan.nextInt();
				creditHours = scan.nextInt();
				
				if(fileName.equals("InformationSystems.dat") || fileName.equals("WebDevelopment.dat") || fileName.equals("ComputerScience.dat") || 
						fileName.equals("Database.dat") || fileName.equals("Networks.dat") || fileName.equals("SoftwareEngineering.dat"))
				{
					courseTitle = scan.nextLine();
				}
				else
				{
					String temp = scan.next();
					grade = temp.charAt(0);
					courseTitle = scan.nextLine();
				} 
				courses[semester][course] = new Course(semester, course, department, courseNumber, creditHours, grade, courseTitle.substring(1, courseTitle.length()));
			}
			
			scan.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * the save method writes the contents of the courses array to a file. 
	 * 
	 * @param courses an array of course objects
	 * @param fileName a string representing the file name that is being opened
	 */
	public void save(Course[][] courses, String fileName)
	{
		try
		{
			FileWriter output  = new FileWriter(fileName);

	        BufferedWriter out = new BufferedWriter(output);

	        for (int x = 0; x < courses.length; x++)
	        {
		        for (int y = 0; y < courses[x].length; y++)
		        {
		        	if (courses[x][y] != null)
		        	{
		        		String temp = courses[x][y].getSemester() + " " + courses[x][y].getCourse() + " " + courses[x][y].getDepartment() + " " + 
	        					courses[x][y].getCourseNumber() + " " + courses[x][y].getCreditHours() + " " + courses[x][y].getGrade() + " " + 
	        					courses[x][y].getCourseTitle();
	        	
		        		out.write(temp + "\n");
		        	}
		        }
	        }
	        
	        out.close();
		}
	    catch (Exception e)
		{
	    	System.err.println("Error: " + e.getMessage());
	    }
	}
}