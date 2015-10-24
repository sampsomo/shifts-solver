package com.mindforger.shiftsolver.client.ui.comparators;

import java.util.Comparator;

import com.mindforger.shiftsolver.client.solver.EmployeeAllocation;

public class ComparatorAllocationByRole implements Comparator<EmployeeAllocation> {

	private int descending; 
	
	public ComparatorAllocationByRole(boolean descending) {
		if(descending) {
			this.descending=1;						
		} else {
			this.descending=-1;			
		}
	}

	public int compare(EmployeeAllocation o1, EmployeeAllocation o2) {
		if(o1!=null && o2!=null) {
			int value;
			if(o1.employee.isEditor()) {
				value=1;
			} else {
				if(o1.employee.isSportak()) {
					value=2;
				} else {
					if(o1.employee.isMortak()) {
						value=3;
					} else {
						value=4;
					}					
				}
			}
			return value*descending;
		}
		return 0;
	}
}
