using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace TheWhitakers.Experiments.JQuery.Flexigrid.Models
{
	public class Employee
	{
		public Guid Id { get; set; }
		public string FirstName { get; set; }
		public string LastName { get; set; }
		public decimal Salary { get; set; }
	}
}