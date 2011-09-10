using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using MVC3.DataTables.Models;

namespace TheWhitakers.MVC3.DataTables.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index(string sort, string sortdir, int page = 0, int rowsPerPage = 3)
        {
			EmployeeRepository repo = new EmployeeRepository();

			var employees = repo.GetEmployees(sort, sortdir, page, rowsPerPage);
			var totalEmployees = repo.GetTotalEmployees();

			ViewBag.Employees = employees;
			ViewBag.TotalEmployees = totalEmployees;
			ViewBag.RowsPerPage = rowsPerPage;

            return View();
        }
    }
}
