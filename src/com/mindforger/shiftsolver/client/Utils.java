package com.mindforger.shiftsolver.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mindforger.shiftsolver.shared.model.DayPreference;
import com.mindforger.shiftsolver.shared.model.Employee;
import com.mindforger.shiftsolver.shared.model.EmployeePreferences;
import com.mindforger.shiftsolver.shared.model.PeriodPreferences;
import com.mindforger.shiftsolver.shared.model.Team;

public class Utils {

	public static boolean isWeekend(int day, int startWeekDay) {
		int sundayBeginningDayNumber=(day-1+startWeekDay-1)%7;
		if(sundayBeginningDayNumber==0 || sundayBeginningDayNumber==6) {
			return true;
		} else {
			return false;
		}
	}
			
	public static int getWeekdayNumber(int day, int startWeekDay) {
		return (day-1+startWeekDay-1)%7;
	}
	
	public static String getDayLetter(int day, int startWeekDay, RiaMessages i18n) {
		switch(getWeekdayNumber(day, startWeekDay)) {
		case 0:
			return i18n.sundayLetter();
		case 1:
			return i18n.mondayLetter();
		case 2:
			return i18n.tuesdayLetter();
		case 3:
			return i18n.wednesdayLetter();
		case 4:
			return i18n.thursdayLetter();
		case 5:
			return i18n.fridayLetter();
		case 6:
			return i18n.saturdayLetter();
		}
		return "";
	}
	
	public static void shuffleArray(Employee[] array) {
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			Employee a = array[index];
			array[index] = array[i];
			array[i] = a;
		}
	}
	
	public static boolean isWorkday(int day, int dayOfWeek, int numberOfDaysInMonth) {
		int dow=dayOfWeek-1;
		for(int i=0; i<numberOfDaysInMonth; i++) {
			if(dow!=0 && dow!=6) {
				if(day==i) {
					return true;
				} else {
					return false;
				}
			}
			dow++;
			dow=dow%7;
		}
		return false;
	}
	
	public static RiaState createBigFooState() {
		RiaState state = new RiaState();

		Team team=new Team();
		int key=0;

		Employee e, igor;

		/*
		 * editors
		 */
		
		igor=e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Igor");
		e.setFamilyname("M");
		e.setEditor(true);
		e.setFulltime(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Mirko");
		e.setFamilyname("K");
		e.setEditor(true);
		e.setFulltime(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Alice");
		e.setFamilyname("K");
		e.setEditor(true);
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Martin");
		e.setFamilyname("B");
		e.setEditor(true);
		e.setFulltime(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Lenka");
		e.setFamilyname("K");
		e.setEditor(true);
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);
		
		/*
		 * sportaci
		 */

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Simona");
		e.setFamilyname("B");
		e.setMortak(true);
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Katarina");
		e.setFamilyname("B");
		e.setMortak(true);
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("David");
		e.setFamilyname("B");
		e.setMortak(true);
		e.setFulltime(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Vojta");
		e.setFamilyname("M");
		e.setSportak(true);
		e.setFulltime(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Vojta");
		e.setFamilyname("B");
		e.setSportak(true);
		e.setFulltime(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Standa");
		e.setFamilyname("Z");
		e.setSportak(true);
		e.setFulltime(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Marek");
		e.setFamilyname("A");
		e.setSportak(true);
		e.setFulltime(true);
		team.addEmployee(e);
		
		/*
		 * fulltime
		 */

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Martin");
		e.setFamilyname("H");
		e.setFulltime(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Milan");
		e.setFamilyname("K");
		e.setFulltime(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Jan");
		e.setFamilyname("P");
		e.setFulltime(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Marika");
		e.setFamilyname("T");
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Michaela");
		e.setFamilyname("V");
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Kristina");
		e.setFamilyname("W");
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Vojtech");
		e.setFamilyname("K");
		e.setFulltime(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Anna");
		e.setFamilyname("K");
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);
		
		/*
		 * part time
		 */
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("David");
		e.setFamilyname("B");
		e.setFulltime(false);
		e.setFemale(false);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Matej");
		e.setFamilyname("S");
		e.setFulltime(false);
		e.setFemale(false);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Marie");
		e.setFamilyname("H");
		e.setFulltime(false);
		e.setFemale(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Dominika");
		e.setFamilyname("P");
		e.setFulltime(false);
		e.setFemale(true);
		team.addEmployee(e);
		
		// ...
		
		state.setEmployees(team.getStableEmployeeList().toArray(new Employee[team.getStableEmployeeList().size()]));
		
		int year=2015;
		int month=10;
		PeriodPreferences periodPreferences = new PeriodPreferences(year, month);
		periodPreferences.setKey("2");
		periodPreferences.setMonthDays(31);
		periodPreferences.setMonthWorkDays(22);
		periodPreferences.setStartWeekDay(5);
		
		EmployeePreferences employeePreferences;
		for(Employee ee:state.getEmployees()) {
			ArrayList<DayPreference> dayPreferencesList = new ArrayList<DayPreference>();
			if(ee.getKey().equals(igor.getKey())) {
				DayPreference dayPreference = new DayPreference();
				dayPreference.setYear(year);
				dayPreference.setMonth(month);
				dayPreference.setDay(1);
				dayPreference.setNoDay(true);
				dayPreferencesList.add(dayPreference);

				dayPreference = new DayPreference();
				dayPreference.setYear(year);
				dayPreference.setMonth(month);
				dayPreference.setDay(2);
				dayPreference.setNoMorning6(true);
				dayPreferencesList.add(dayPreference);
				
				dayPreference = new DayPreference();
				dayPreference.setYear(year);
				dayPreference.setMonth(month);
				dayPreference.setDay(3);
				dayPreference.setNoAfternoon(true);
				dayPreferencesList.add(dayPreference);
				
				dayPreference = new DayPreference();
				dayPreference.setYear(year);
				dayPreference.setMonth(month);
				dayPreference.setDay(4);
				dayPreference.setNoNight(true);
				dayPreferencesList.add(dayPreference);
			}
			employeePreferences = new EmployeePreferences();
			employeePreferences.setPreferences(dayPreferencesList);
			periodPreferences.addEmployeePreferences(ee.getKey(), employeePreferences);			
		}
		
		PeriodPreferences[] periodPreferencesArray=new PeriodPreferences[1];
		periodPreferencesArray[0]=periodPreferences;
		state.setPeriodPreferencesList(periodPreferencesArray);
		
		return state;		
	}

	public static RiaState createNovemberFooState() {
		RiaState state = new RiaState();

		Team team=new Team();
		int key=0;

		Employee e, igor, mirko;

		/*
		 * editors
		 */
		
		igor=e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Igor");
		e.setFamilyname("M");
		e.setEditor(true);
		e.setFulltime(true);
		team.addEmployee(e);
		
		mirko=e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Mirko");
		e.setFamilyname("K");
		e.setEditor(true);
		e.setFulltime(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Alice");
		e.setFamilyname("K");
		e.setEditor(true);
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Martin");
		e.setFamilyname("B");
		e.setEditor(true);
		e.setFulltime(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Lenka");
		e.setFamilyname("K");
		e.setEditor(true);
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);
		
		/*
		 * sportaci
		 */

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Simona");
		e.setFamilyname("B");
		e.setMortak(true);
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Katarina");
		e.setFamilyname("B");
		e.setMortak(true);
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("David");
		e.setFamilyname("B");
		e.setMortak(true);
		e.setFulltime(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Vojta");
		e.setFamilyname("M");
		e.setSportak(true);
		e.setFulltime(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Standa");
		e.setFamilyname("Z");
		e.setSportak(true);
		e.setFulltime(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Marek");
		e.setFamilyname("A");
		e.setSportak(true);
		e.setFulltime(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Mr.");
		e.setFamilyname("X");
		e.setSportak(true);
		e.setFulltime(true);
		team.addEmployee(e);
		
		/*
		 * fulltime
		 */

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Martin");
		e.setFamilyname("H");
		e.setFulltime(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Milan");
		e.setFamilyname("K");
		e.setFulltime(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Jan");
		e.setFamilyname("P");
		e.setFulltime(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Marika");
		e.setFamilyname("T");
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Michaela");
		e.setFamilyname("V");
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Kristina");
		e.setFamilyname("W");
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Vojtech");
		e.setFamilyname("K");
		e.setFulltime(true);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Anna");
		e.setFamilyname("K");
		e.setFulltime(true);
		e.setFemale(true);
		team.addEmployee(e);
		
		/*
		 * part time
		 */
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("David");
		e.setFamilyname("B");
		e.setFulltime(false);
		e.setFemale(false);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Matej");
		e.setFamilyname("S");
		e.setFulltime(false);
		e.setFemale(false);
		team.addEmployee(e);
		
		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Marie");
		e.setFamilyname("H");
		e.setFulltime(false);
		e.setFemale(true);
		team.addEmployee(e);

		e=new Employee();
		e.setKey(""+key++);
		e.setFirstname("Dominika");
		e.setFamilyname("P");
		e.setFulltime(false);
		e.setFemale(true);
		team.addEmployee(e);
		
		// ...
		
		state.setEmployees(team.getStableEmployeeList().toArray(new Employee[team.getStableEmployeeList().size()]));
		
		int year=2015;
		int month=11;
		PeriodPreferences periodPreferences = new PeriodPreferences(year, month);
		periodPreferences.setKey("2");
		periodPreferences.setMonthDays(30);
		periodPreferences.setMonthWorkDays(21);
		periodPreferences.setStartWeekDay(1);
		periodPreferences.setLastMonthEditor(mirko.getKey());
		
		EmployeePreferences employeePreferences;
		for(Employee ee:state.getEmployees()) {
			ArrayList<DayPreference> dayPreferencesList = new ArrayList<DayPreference>();
			if(ee.getKey().equals(igor.getKey())) {
				DayPreference dayPreference = new DayPreference();
				dayPreference.setYear(year);
				dayPreference.setMonth(month);
				dayPreference.setDay(1);
				dayPreference.setNoDay(true);
				dayPreferencesList.add(dayPreference);

				dayPreference = new DayPreference();
				dayPreference.setYear(year);
				dayPreference.setMonth(month);
				dayPreference.setDay(2);
				dayPreference.setNoMorning6(true);
				dayPreferencesList.add(dayPreference);
				
				dayPreference = new DayPreference();
				dayPreference.setYear(year);
				dayPreference.setMonth(month);
				dayPreference.setDay(3);
				dayPreference.setNoAfternoon(true);
				dayPreferencesList.add(dayPreference);
				
				dayPreference = new DayPreference();
				dayPreference.setYear(year);
				dayPreference.setMonth(month);
				dayPreference.setDay(4);
				dayPreference.setNoNight(true);
				dayPreferencesList.add(dayPreference);
			}
			employeePreferences = new EmployeePreferences();
			employeePreferences.setPreferences(dayPreferencesList);
			periodPreferences.addEmployeePreferences(ee.getKey(), employeePreferences);			
		}
		
		PeriodPreferences[] periodPreferencesArray=new PeriodPreferences[1];
		periodPreferencesArray[0]=periodPreferences;
		state.setPeriodPreferencesList(periodPreferencesArray);
		
		return state;		
	}
	
	public static RiaState createSmallFooState() {
		RiaState state = new RiaState();
		
		List<Employee> employeesList=new ArrayList<Employee>();
		
		Employee lenka=new Employee();
		lenka.setKey("1");
		lenka.setFirstname("Lenka");
		lenka.setFamilyname("Strelenka");
		lenka.setEditor(true);
		lenka.setFulltime(false);
		lenka.setFemale(true);
		employeesList.add(lenka);
		
		Employee misa=new Employee();
		misa.setKey("2");
		misa.setFirstname("Misa");
		misa.setFamilyname("Plysak");
		misa.setEditor(true);
		misa.setFulltime(true);
		misa.setFemale(true);
		employeesList.add(misa);
		
		Employee mirek=new Employee();
		mirek.setKey("3");
		mirek.setFirstname("Mirek");
		mirek.setFamilyname("Drson");
		mirek.setEditor(true);
		mirek.setFulltime(true);
		mirek.setFemale(false);
		employeesList.add(mirek);
		
		state.setEmployees(employeesList.toArray(new Employee[employeesList.size()]));
		
		PeriodPreferences periodPreferences = new PeriodPreferences(2015, 10);
		periodPreferences.setKey("1");
		periodPreferences.setMonthDays(31);
		periodPreferences.setMonthWorkDays(22);
		periodPreferences.setStartWeekDay(5);
		EmployeePreferences employeePreferences = new EmployeePreferences();
		employeePreferences.setPreferences(new ArrayList<DayPreference>());
		periodPreferences.addEmployeePreferences(lenka.getKey(), employeePreferences);
		periodPreferences.addEmployeePreferences(misa.getKey(), employeePreferences);
		periodPreferences.addEmployeePreferences(mirek.getKey(), employeePreferences);
		PeriodPreferences[] periodPreferencesArray=new PeriodPreferences[1];
		periodPreferencesArray[0]=periodPreferences;
		state.setPeriodPreferencesList(periodPreferencesArray);
		
		return state;
	}
}
