package com.mindforger.shiftsolver.client;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.mindforger.shiftsolver.client.solver.ShiftSolver;
import com.mindforger.shiftsolver.client.ui.EmployeeEditPanel;
import com.mindforger.shiftsolver.client.ui.EmployeesTable;
import com.mindforger.shiftsolver.client.ui.HomePanel;
import com.mindforger.shiftsolver.client.ui.PageTitlePanel;
import com.mindforger.shiftsolver.client.ui.PeriodPreferencesTable;
import com.mindforger.shiftsolver.client.ui.PreferencesPanel;
import com.mindforger.shiftsolver.client.ui.PrintButtonPanel;
import com.mindforger.shiftsolver.client.ui.SettingsPanel;
import com.mindforger.shiftsolver.client.ui.SolutionPanel;
import com.mindforger.shiftsolver.client.ui.SolutionsTable;
import com.mindforger.shiftsolver.client.ui.SolverEmployeesSummaryPanel;
import com.mindforger.shiftsolver.client.ui.SolverProgressPanel;
import com.mindforger.shiftsolver.client.ui.StatusLine;
import com.mindforger.shiftsolver.client.ui.menu.LeftMenubar;
import com.mindforger.shiftsolver.shared.FieldVerifier;
import com.mindforger.shiftsolver.shared.ShiftSolverConstants;

/**
 * This is an analogy of Spring Application Context. It gives overview of the most
 * important beans, simplifies beans and avoid singletons across the source code:
 * <ul>
 *   <li>get*() methods are used to get SINGLETON objects</li>
 *   <li>create*() methods are used to get a new instance of the initialized object - FACTORY</li>
 *   <li>All beans are instantiated in the ctx's constructor using
 *       either default constructor or the constructor that takes ctx as parameter</li>
 *   <li>Ctx does LAZY initialization of beans in ctx.get*() methods.</li>
 * </ul>
 */
public class RiaContext implements ShiftSolverConstants {

	// RIA
	private Ria ria;
	
	// i18n and l10n
	private RiaMessages i18n;
	
	// server
	private ShiftSolverServiceAsync service;
	
	// solver
	private ShiftSolver solver;
	
	// validation
	private FieldVerifier fieldVerifier;

	// UI components
	private StatusLine statusLine;
	private PageTitlePanel pageTitlePanel;
	private LeftMenubar menu;
	private HomePanel homePanel;
	private SettingsPanel settingsPanel;
	private EmployeesTable employeesTable;
	private EmployeeEditPanel employeeEditPanel;
	private PeriodPreferencesTable periodPreferencesTable;
	private PreferencesPanel periodPreferencesEditPanel;
	private SolutionsTable periodSolutionsTable;
	private SolutionPanel periodSolutionViewPanel;
	private SolverProgressPanel solverProgressPanel;
	private SolverEmployeesSummaryPanel solverNoSolutionPanel;
	private PrintButtonPanel printButtonPanel;
	
	// data
	private RiaState state;
	
	private Set<Object> initialized;
	
	public RiaContext(Ria ria) {
		this.ria=ria;

		initialized=new HashSet<Object>();
		
		i18n=GWT.create(RiaMessages.class);		
		service=GWT.create(ShiftSolverService.class);		
		fieldVerifier=new FieldVerifier();
		state=new RiaState();
		solver=new ShiftSolver(this);
		
		// UI
		statusLine=new StatusLine(this);
		pageTitlePanel=new PageTitlePanel();
		menu=new LeftMenubar(this);
		homePanel=new HomePanel(this);
		settingsPanel=new SettingsPanel(this);
		employeesTable=new EmployeesTable(this);
		employeeEditPanel=new EmployeeEditPanel(this);
		periodPreferencesTable=new PeriodPreferencesTable(this);		
		periodPreferencesEditPanel=new PreferencesPanel(this);
		periodSolutionsTable=new SolutionsTable(this);
		periodSolutionViewPanel=new SolutionPanel(this);
		solverProgressPanel=new SolverProgressPanel(this);
		solverNoSolutionPanel=new SolverEmployeesSummaryPanel(this, true);
		printButtonPanel=new PrintButtonPanel(this);
	}

	public RiaMessages getI18n() {
		return i18n;
	}

	public ShiftSolverServiceAsync getService() {
		return service;
	}

	public FieldVerifier getFieldVerifier() {
		return fieldVerifier;
	}

	public StatusLine getStatusLine() {
		return statusLine;
	}

	public LeftMenubar getMenu() {
		if(!initialized.contains(menu)) {
			initialized.add(menu);
			menu.init();
		}
		return menu;
	}
	
	public EmployeesTable getEmployeesTable() {
		if(!initialized.contains(employeesTable)) {
			initialized.add(employeesTable);
			employeesTable.init();
		}
		return employeesTable;
	}

	public EmployeeEditPanel getEmployeesEditPanel() {
		return employeeEditPanel;
	}
	
	public PeriodPreferencesTable getPeriodPreferencesTable() {
		if(!initialized.contains(periodPreferencesTable)) {
			initialized.add(periodPreferencesTable);
			periodPreferencesTable.init();
		}
		return periodPreferencesTable;
	}
	
	public PreferencesPanel getPreferencesPanel() {
		return periodPreferencesEditPanel;
	}
	
	public RiaState getState() {
		return state;
	}	
	
	public void setState(RiaState state) {
		this.state = state;
	}

	public Ria getRia() {
		return ria;
	}

	public SolutionsTable getSolutionsTable() {
		if(!initialized.contains(periodSolutionsTable)) {
			initialized.add(periodSolutionsTable);
			periodSolutionsTable.init();
		}
		return periodSolutionsTable;
	}

	public SolutionPanel getSolutionPanel() {
		return periodSolutionViewPanel;
	}

	public PageTitlePanel getPageTitlePanel() {
		return pageTitlePanel;
	}
	
	public SolverProgressPanel getSolverProgressPanel() {
		return solverProgressPanel;
	}

	public HomePanel getHomePanel() {
		if(!initialized.contains(homePanel)) {
			initialized.add(homePanel);
			homePanel.init();
		}
		return homePanel;
	}

	public ShiftSolver getSolver() {
		return solver;
	}

	public SolverEmployeesSummaryPanel getSolverNoSolutionPanel() {
		return solverNoSolutionPanel;
	}

	public void setSolverNoSolutionPanel(SolverEmployeesSummaryPanel solverNoSolutionPanel) {
		this.solverNoSolutionPanel = solverNoSolutionPanel;
	}

	public SettingsPanel getSettingsPanel() {
		if(!initialized.contains(settingsPanel)) {
			initialized.add(settingsPanel);
			settingsPanel.init();
		}
		return settingsPanel;
	}

	public Button getPrintButtonPanel() {
		return printButtonPanel;
	}
}
