package com.ossms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(AttId.class)
@Table(name = "attendance")
public class Attendance {
		@Id
		@Column(name="empid")
		int empId;
		
		@Id
		@Column(name="monthid")
		String monthId;
		
		@Column(name="attendance")
		int attendance;
		
		@Column(name="year")
		int year;

		
		@Override
		public String toString() {
			return "Attendance [empId=" + empId + ", monthId=" + monthId + ", attendance=" + attendance + ", year="
					+ year + "]";
		}


		public Attendance() {
			super();
		}


		public Attendance(int empId, String monthId, int attendance , int year) {
			super();
			this.empId = empId;
			this.monthId = monthId;
			this.attendance = attendance;
			this.year=year;
		}


		public int getEmpId() {
			return empId;
		}


		public String getMonthId() {
			return monthId;
		}


		public int getAttendance() {
			return attendance;
		}


		public int getYear() {
			return year;
		}


		public void setEmpId(int empId) {
			this.empId = empId;
		}


		public void setMonthId(String monthId) {
			this.monthId = monthId;
		}


		public void setAttendance(int attendance) {
			this.attendance = attendance;
		}


		public void setYear(int year) {
			this.year = year;
		}
		
		
		
		
}
