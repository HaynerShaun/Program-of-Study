
/**
 * Controller class manages Program of Study
 * 
 * @author Hayner
 * @version 1.0
 */

public class Controller
{
	Plan plan = new Plan();
	View view = new View();
	
	int totalSem = 10, totalCoursePerSem = 8;
	Course[][] courses = new Course[totalSem][totalCoursePerSem];
	
	String fileName;
	
	/**
	 * Loads file based on user input
	 * Calls menu loop
	 */
	public void start()
	{
		fileName = view.collectUserInfo();
		plan.pullDataFile(fileName, courses);
		
		menuLoop(fileName);
	}
	
	/**
	 * handles menu loop
	 * @param fileName
	 */
	public void menuLoop(String fileName)
	{	
		boolean test = false;
		while(!(test))
		{
			String input = view.menuOptions();
			switch(input)
			{
				case "find":
					view.find(courses);
					break;
				case "add":
					view.add(courses);
					break;
				case "remove":
					view.remove(courses);
					break;
				case "grade":
					view.grade(courses);
					break;
				case "prints":
					view.prints(courses);
					break;
				case "printpos":
					view.printPOS(courses);
					break;
				case "save":
					fileName = view.getSaveName() + ".dat";
					plan.save(courses, fileName);
					view.outSave();
					break;
				case "exit":
					exitSelect();
			}
		}
	}
	
	/**
	 * handles exit menu selection
	 */
	public void exitSelect()
	{
		char temp = view.saveOnExit();
		if (temp == 'Y')
		{
			fileName = view.getSaveName() + ".dat";
			plan.save(courses, fileName);
			view.outSave();
		}
		System.exit(1);
	}
}