import java.util.Scanner;

/**
 * View class handles all interaction with user
 * 
 * @author Hayner
 * @version 1.0
 */
public class View
{
	Scanner scan;

	/**
	 * the collectUserInfo method asks the user if they have a saved program of study already
	 * 
	 * @return a string representing the user's concentration or saved file name
	 */
	public String collectUserInfo()
	{
		String fileName = "";
		char input = ' ';
		scan = new Scanner(System.in);
		
		while(input != 'Y' && input != 'N' && input != 'n' && input != 'y')
		{
			System.out.print("Is there an existing Program of Study (Y or N)? ");
			input = scan.nextLine().charAt(0);
		}
		if (input == 'Y' || input == 'y')
		{
			fileName = getFileName();
		}
		else
		{
			fileName = getConcentration();
		}
		
		return fileName;
	}
	
	/**
	 * the getFileName method asks the user for the name of their existing Program of Study
	 * 
	 * @return a string representing file name for saved program of study
	 */
	public String getFileName()
	{
		String fileName = "";
		
		System.out.print("Enter the filename for the existing file: ");
		fileName = scan.next();
		
		return fileName;
	}	
	
	/**
	 * the getConcentration method asks the user for their concentration
	 * 
	 * @return a string representing file name for default program of study
	 */
	public String getConcentration()
	{
		String concentration = "";
		
		boolean test = false;
		
		while(!(test))
		{
			printConcentrationOptions(); 
			
			concentration = scan.next();
			
			switch(concentration.toUpperCase())
			{
				case "INFORMATION SYSTEMS":
				case "IS":
					concentration = "InformationSystems";
					test = true;
					break;
				case "WEB DEVELOPMENT":
				case "WD":
					concentration = "WebDevelopment";
					test = true;
					break;
				case "COMPUTER SCIENCE":
				case "CS":
					concentration = "ComputerScience";
					test = true;
					break;
				case "DATABASE":
				case "DB":
					concentration = "Database";
					test = true;
					break;
				case "NETWORKS":
				case "NW":
					concentration = "Networks";
					test = true;
					break;
				case "SOFTWARE ENGINEERING":
				case "SE":
					concentration = "SoftwareEngineering";
					test = true;
					break;
				default:
					System.out.println("Invalid concentration");
					break;
			}
		}
		
		return concentration + ".dat";
	}
	
	/**
	 * the printConcentrationOptions method prints out the concentration options
	 */
	public void printConcentrationOptions()
	{
		System.out.println();
		System.out.println("Enter your concentration: ");
		System.out.println("Information Systems (IS)");
		System.out.println("Web Development (WD)");
		System.out.println("Computer Science (CS)");
		System.out.println("Database (DB)");
		System.out.println("Networks (NW)");
		System.out.println("Software Engineering (SE)");
	}
	
	/**
	 * the menuOptions method prints out the menu options and requests the user to select an option
	 * 
	 * @return a string representing the user's menu option choice
	 */
	public String menuOptions()
	{
		System.out.println();
		System.out.println("Menu: ");
		System.out.println("\tFind a course in the Program of Study (find)");
		System.out.println("\tAdd a course to the Program of Study (add)");
		System.out.println("\tRemove a course from the Program of Study (remove)");
		System.out.println("\tAdd a grade for a course in the Program of Study (grade)");
		System.out.println("\tOutput the courses in a particular semester (prints)");
		System.out.println("\tOutput the entire Program of Study (printPOS)");
		System.out.println("\tSave the Program of Study to a file (save)");
		System.out.println("\tExit the system (exit)");
		System.out.println();
		
		boolean test = false;
		String input = "";
		while(!(test))
		{
			System.out.print("Enter selection: ");
			input = scan.next();
			input = input.toLowerCase();
			switch(input)
			{
				case "find":
				case "add":
				case "remove":
				case "grade":
				case "prints":
				case "printpos":
				case "save":
				case "exit":
					test = true;
					break;
				default:
					System.out.println("Invalid selection.");
					break;
			}
		}
		return input;
	}
	
	/**
	 * the add method adds an addition course to the courses array
	 * 
	 * @param courses an array of course objects
	 */
	public void add(Course[][] courses)
	{
		System.out.println();
		System.out.println("Enter infomation for new course");
		System.out.print("Semester Number: ");
		int semester = scan.nextInt();
		System.out.print("Course: ");
		int course = scan.nextInt();
		System.out.print("Department: ");
		String dept = scan.next();
		System.out.print("Course Number: ");
		int courseNum = scan.nextInt();
		System.out.print("Credit Hours: ");
		int creditHours = scan.nextInt();
		System.out.print("Course Title: ");
		String courseTitle = scan.nextLine();
		courseTitle = scan.nextLine();
		char grade = ' ';

		courses[semester][course] = new Course(semester, course, dept, courseNum, creditHours, grade, courseTitle);
	}
	
	/**
	 * the find method requests a department and course number and then prints out that course's information
	 * 
	 * @param courses an array of course objects
	 */
	public void find(Course[][] courses)
	{
		System.out.print("Enter Department: ");
		String dept = scan.next();
		dept = dept.toUpperCase();
		System.out.print("Enter Course Number: ");
		int courseNum = scan.nextInt();
		boolean found = false;
		
		for(int x = 0; x < courses.length; x++)
		{
			for(int y = 0; y < courses[x].length; y++)
			{
				if (courses[x][y] != null)
				{
					if (courses[x][y].getDepartment().equals(dept) && courses[x][y].getCourseNumber() == courseNum)
					{
						System.out.println();
						System.out.println(courses[x][y]);
						found = true;
					}
				}
			}
		}
		
		if (!(found))
		{
			 System.out.println();
			 System.out.println("Course was not found");
		}
	}
	
	/**
	 * the printPOS method prints out the entire program of study
	 * 
	 * @param courses an array of course objects
	 */
	public void printPOS(Course[][] courses)
	{
		for(int x = 0; x < courses.length; x++)
		{
			if (courses[x][0] != null)
				System.out.println();
			
			for(int y = 0; y < courses[x].length; y++)
			{
				if (courses[x][y] != null)
					System.out.println(courses[x][y]);
			}
		}
	}
	
	/**
	 * the prints method requests a semester number and prints out all the courses in that semester
	 * 
	 * @param courses an array of course objects
	 */
	public void prints(Course[][] courses)
	{
		System.out.print("What semester would you like to print? ");
		int semester = scan.nextInt();
		for(int x = 0; x < courses[semester].length; x++)
		{
			if(courses[semester][x] != null)
				System.out.println(courses[semester][x]);
		}
	}

	/**
	 * the grade method requests a semester and course number and adds a grade to that location
	 * 
	 * @param courses an array of course objects
	 */
	public void grade(Course[][] courses)
	{
		System.out.print("Enter semester to enter grade: ");
		int semester = scan.nextInt();
		System.out.print("Enter course number to enter grade: ");
		int course = scan.nextInt();
		
		if( semester > courses.length || course > courses[semester].length || courses[semester][course] == null)
		{
			System.out.println("Invalid location.");
		}
		else
		{
			System.out.print("Enter grade: ");
			String temp = scan.next();
			courses[semester][course].setGrade(temp.charAt(0));
			temp = scan.nextLine();
		}
		
	}

	/**
	 * the remove method requests a semester and course number and removed the course object at that location in the array
	 * @param courses an array of course objects
	 */
	public void remove(Course[][] courses)
	{
		System.out.println();
		System.out.print("Enter semester to remove: ");
		int semester = scan.nextInt();
		System.out.print("Enter course to remove: ");
		int course = scan.nextInt();
		if( semester > courses.length || course > courses[semester].length || courses[semester][course] == null)
		{
			System.out.println("Invalid location");
		}
		else
		{
			courses[semester][course] = null;
		}
	}
	
	/**
	 * the getSaveName method requests the name to save the user's program of study as
	 * 
	 * @return a string representing the user's save name entry
	 */
	public String getSaveName()
	{
		System.out.print("Save name? ");
		String fileName = scan.next();
		return fileName;
	}

	/**
	 * the saveOnExit method asks the user if they want to save their program of study
	 * 
	 * @return a char representing the user's entry
	 */
	public char saveOnExit()
	{
		String input = "";
		System.out.println();
		System.out.print("Would you like to save (Y/N)? ");
		input = scan.next();
		input = input.toUpperCase();
		
		return input.charAt(0);
	}
	
	/**
	 * the outSave method prints a messaged stating the program of study has been saved
	 */
	public void outSave()
	{
		System.out.println();
		System.out.println("File saved.");
	}
}
