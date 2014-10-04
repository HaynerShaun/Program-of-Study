/**
	Course class represents a single course

	Author: Shaun Hayner
*/
public class Course
{
	private int semester;
	private int course;
	private String department;
	private int courseNumber;
	private String courseTitle;
	private int creditHours;
	private char grade;
	
	/**
	  Constructor for the Course class.  
	*/
	public Course(int semester, int course, String department, int courseNumber, int creditHours, char grade, String courseTitle)
	{
		this.semester = semester;
		this.course = course;
		this.department = department;
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
		this.creditHours = creditHours;
		this.grade = grade;
	}
	
	/**
	 * the getSmester method returns the semester number
	 * 
	 * @return a int representing the semester number
	 */
	public int getSemester()
	{
		return semester;
	}

	/**
	 * the getCourse method returns the course
	 * 
	 * @return a int representing the course
	 */
	public int getCourse()
	{
		return course;
	}

	/**
	 * the getDepartment method returns the department
	 * 
	 * @return a String representing the department
	 */
	public String getDepartment()
	{
		return department;
	}

	/**
	 * the getCourseNumber method returns the course number
	 * 
	 * @return a int representing the course number
	 */
	public int getCourseNumber()
	{
		return courseNumber;
	}

	/**
	 * the getCourseTitle method returns the course title
	 * 
	 * @return a String representing the course title
	 */
	public String getCourseTitle()
	{
		return courseTitle;
	}

	/**
	 * the getCreditHours method returns the credit hours
	 * 
	 * @return a int representing the credit hours
	 */
	public int getCreditHours()
	{
		return creditHours;
	}

	/**
	 * the getGrade method returns the grade
	 * 
	 * @return a char representing the grade
	 */
	public char getGrade()
	{
		return grade;
	}
	
	/**
	 * the setGrade method sets the grade variable
	 * 
	 * @param grade a char representing the grade being added to the course object
	 */
	public void setGrade(char grade)
	{
		this.grade = grade;
	}
	
	/**
	 * Returns a string representation of this Course
	 * 
	 * @return a string representation of the Course
	 */
	public String toString()
	{
		return semester + " " + course + " " + department + " " + courseNumber + " " + creditHours + " " + (grade == 'G'?' ':grade) + " " + courseTitle;	
	}
}