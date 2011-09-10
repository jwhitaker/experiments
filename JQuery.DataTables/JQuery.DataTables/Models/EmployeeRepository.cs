using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TheWhitakers.Experiments.JQuery.DataTables.Models
{
	public class EmployeeRepository
	{
		private IList<Employee> _employeeList;

		public EmployeeRepository()
		{
			_employeeList = new List<Employee>();
			_employeeList.Add(new Employee { FirstName = "Irene", LastName = "Craig", Salary = 86929 });
			_employeeList.Add(new Employee { FirstName = "Alexandra", LastName = "Soto", Salary = 73203 });
			_employeeList.Add(new Employee { FirstName = "Malachi", LastName = "Ramos", Salary = 43450 });
			_employeeList.Add(new Employee { FirstName = "Sage", LastName = "Ware", Salary = 51189 });
			_employeeList.Add(new Employee { FirstName = "Sade", LastName = "Ware", Salary = 50236 });
			_employeeList.Add(new Employee { FirstName = "Olivia", LastName = "Forbes", Salary = 68616 });
			_employeeList.Add(new Employee { FirstName = "Kai", LastName = "Horne", Salary = 55795 });
			_employeeList.Add(new Employee { FirstName = "Ezekiel", LastName = "Maynard", Salary = 70869 });
			_employeeList.Add(new Employee { FirstName = "Jameson", LastName = "Whitley", Salary = 42982 });
			_employeeList.Add(new Employee { FirstName = "Sylvester", LastName = "Ellison", Salary = 91194 });
			_employeeList.Add(new Employee { FirstName = "Jason", LastName = "Parsons", Salary = 43695 });
			_employeeList.Add(new Employee { FirstName = "Deacon", LastName = "Pope", Salary = 95367 });
		}

		public int GetTotalEmployees()
		{
			return _employeeList.Count;
		}

		public IList<Employee> GetEmployees(string sort, string direction, int start, int length)
		{
			var list = (from e in _employeeList
						select e).OrderBy(x => x.FirstName).Skip(start).Take(length);


			return list.ToList();
		}
	}
}