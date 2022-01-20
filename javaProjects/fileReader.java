import java.io.*;


public class IOTester
{
	public static void main(String[] args)
	{
		char input1;
		String deptName, numOfFacultyStr, nameOfUniversity;
		String firstName, lastName, academicLevel;
		String university;
		int numOfFaculty;
		String line;
		String filename;

		DeptManagement deptManage1 = new DeptManagement();

		File file;

		try {
			printMenu();
			InputStreamReader isr = new InputStreamReader(System.in );
			BufferedReader stdin = new BufferedReader(isr);

			do {
				System.out.print("\nWhat action would you like to perform?\n");
				line = stdin.readLine().trim(); //read a line
				input1 = line.charAt(0);
				input1 = Character.toUpperCase(input1);

				if (line.length() == 1) //check if a user entered only one character
				{
					switch (input1) {
					case 'A':
						//Add Department
						System.out.print("Please enter the department information:\n");
						System.out.print("Enter department name:\n");
						deptName = stdin.readLine().trim();
						System.out.print("Enter number of faculty:\n");
						numOfFacultyStr = stdin.readLine().trim();
						numOfFaculty = Integer.parseInt(numOfFacultyStr);
						System.out.print("Enter university name:\n");
						nameOfUniversity = stdin.readLine().trim();
						System.out.print("Enter faculty first name:\n");
						firstName = stdin.readLine().trim();
						System.out.print("Enter faculty last name:\n");
						lastName = stdin.readLine().trim();
						System.out.print("Enter faculty academic level:\n");
						academicLevel = stdin.readLine().trim();
						if (deptManage1.addDepartment(deptName, nameOfUniversity, numOfFaculty, firstName, lastName, academicLevel)) {
							System.out.print("Department added\n");
						}
						else {
							System.out.print("Department NOT added\n");
						}
						break;
					case 'C':
						deptManage1 = new DeptManagement();
						break;
						//*****
					case 'D':
						System.out.print("Please enter the department name to search:\n");
						deptName = stdin.readLine().trim();
						System.out.print("Please enter the university name to search:\n");
						university = stdin.readLine().trim();
						if (deptManage1.deptExists(deptName, university)>= 0) {
							System.out.print(deptName + " at " + university + " is found\n");
						}
						else {
							System.out.print(deptName + " at " + university + " is NOT found\n");
						}
						break;
					case 'E':
						//Search faculty
						System.out.print("Please enter the faculty first name to search:\n");
						firstName = stdin.readLine().trim();
						System.out.print("Please enter the faculty last name to search:\n");
						lastName = stdin.readLine().trim();
						System.out.print("Please enter the faculty academic level to search:\n");
						academicLevel = stdin.readLine().trim();

						if (deptManage1.facultyExists(firstName, lastName, academicLevel)>= 0) {
							System.out.print("Faculty: " +firstName+ " "+ lastName + ", " + academicLevel + " is found\n" );
						}
						else {
							System.out.print("Faculty: " +firstName+ " "+ lastName + ", " + academicLevel + " is NOT found\n" );
						}
						
						break;
					case 'L':
						//List departments
						System.out.print(deptManage1.listDepartments());
						break;

					case 'N':

						deptManage1.sortByDepartmentName();
						System.out.print("sorted by department names\n");
						break;

					case 'O':
						deptManage1.sortByFacultyNumbers();
						System.out.print("sorted by faculty numbers\n");
						break;
					case 'P':

						deptManage1.sortByDeptFaculty();
						System.out.print("sorted by current faculty name\n");
						break;
					case 'Q':
						//Quit
						break;
					case 'R':
						//Remove a department
						System.out.print("Please enter the department name to remove:\n");
						deptName = stdin.readLine().trim();
						System.out.print("Please enter the university name to remove:\n");
						university = stdin.readLine().trim();
						 deptManage1.removeDepartment(deptName, university);
						if (deptManage1.removeDepartment(deptName, university) == true)
							System.out.print(deptName + " at " + university + " is removed\n");
						else
							System.out.print(deptName + " at " + university + " is NOT removed\n");
						break;
					case 'T':
						//Close DeptManagement
						deptManage1.closeDeptManagement();
						System.out.print("Department management system closed\n");
						break;
					case 'U':
						//Write Text to a File
						System.out.print("Please enter a file name that we will write to:\n");
						filename = stdin.readLine().trim();
						try {
							FileWriter write = new FileWriter(filename);
								System.out.print("Please enter a string to write inside the file:\n");
								String writeString = stdin.readLine().trim();
								write.write(writeString);
								write.close();
								System.out.print(filename+ " is written\n");
						}
						catch(IOException e) {
							System.out.print("Write string inside the file error\n");
							//e.printStackTrace();
						}
						break;
					case 'V':
						//Read Text from a File
						System.out.print("Please enter a file name which we will read from:\n");
						filename = stdin.readLine().trim();
						try {

							file = new File (filename);
							BufferedReader inFile = new BufferedReader(new FileReader (file));
							line = inFile.readLine();
							System.out.print(filename + " was read\n");
							System.out.print("The first line of the file is:\n");
							System.out.print(line + "\n");
							inFile.close();	
						}
						catch(FileNotFoundException FILENF) {
							System.out.print(filename + " not found error\n");
						}
						catch(IOException ReadS) {
							System.out.print("Read string from the file error\n");
						}
						break;
					case 'W':
						//Serialize DeptManagement to a File
						System.out.print("Please enter a file name which we will write to:\n");
						filename = stdin.readLine().trim();
						try {
				       ObjectOutputStream object = new ObjectOutputStream( new FileOutputStream( filename ) );
					   object.writeObject(deptManage1);
					   object.close();
						}
						catch(NotSerializableException NOTSeR) {
							System.out.print("Not serializable exception\n");
						}
						catch(IOException IOe) {
							System.out.print("Data file written exception\n");
						}
						break;
					case 'X':
						//Deserialize DeptManagement from a File
						System.out.print("Please enter a file name which we will read from:\n");
						filename = stdin.readLine().trim();
						try {
						ObjectInputStream object = new ObjectInputStream( new FileInputStream (filename) );
						deptManage1 = (DeptManagement)object.readObject( );
			

						    
						    System.out.print(filename + " was read\n");
						    object.close();
						}
						catch(ClassNotFoundException notF) {
							System.out.print("Class not found exception\n");
						}

						catch(NotSerializableException notS) {
							System.out.print("Not serializable exception\n");
						}
						catch(IOException DataR) {
							System.out.print("Data file read exception\n");
						}
						break;
					case '?':
						//Display Menu
						printMenu();
						break;
					default:
						System.out.print("Unknown action\n");
						break;
					}
				}
				else {
					System.out.print("Unknown action\n");
				}
			} while ( input1 != 'Q' || line . length () != 1);
		}
		catch(IOException exception) {
			System.out.print("IO Exception\n");
		}
	}

	/** The method printMenu displays the menu to a user **/
	public static void printMenu() {
		System.out.print("Choice\t\tAction\n" +
						 "------\t\t------\n" +
						 "A\t\tAdd a department\n" +
						 "C\t\tCreate a DeptManagement\n" +
						 "D\t\tSearch a department\n" +
						 "E\t\tSearch a faculty\n" +
						 "L\t\tList departments\n" +
						 "N\t\tSort by department names\n" +
						 "O\t\tSort by department faculty numbers\n" +
						 "P\t\tSort by current faculty name\n" +
						 "Q\t\tQuit\n" +
						 "R\t\tRemove a department\n" +
						 "T\t\tClose DeptManagement\n" +
						 "U\t\tWrite strings to a text file\n" +
						 "V\t\tRead strings from a text file\n" +
						 "W\t\tSerialize DeptManagement to a data file\n" +
						 "X\t\tDeserialize DeptManagement from a data file\n" +
						 "?\t\tDisplay Help\n");
	}
}
