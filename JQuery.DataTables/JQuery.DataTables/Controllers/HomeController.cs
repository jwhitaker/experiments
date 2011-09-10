using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using TheWhitakers.Experiments.JQuery.DataTables.Models;
using TheWhitakers.Experiments.JQuery.DataTables.Components;
using TheWhitakers.Experiments.JQuery.DataTables.Components.Converters;

namespace TheWhitakers.Experiments.JQuery.DataTables.Controllers
{
	public class HomeController : Controller
	{
		public ActionResult Index()
		{
			ViewBag.Message = "Welcome to ASP.NET MVC!";
			
			return View();
		}

		public ActionResult About()
		{
			return View();
		}

		public ActionResult LoadData()
		{
			var repo = new EmployeeRepository();

			var displayLength = int.Parse(Request["iDisplayLength"]);
			var displayStart = int.Parse(Request["iDisplayStart"]);
			var iSortCol = Request["iSortCol_0"].ToString();
			var iSortDir = Request["sSortDir_0"].ToString();

			var result = new JsonNetResult();
			result.SerializerSettings.Converters.Add(new EmployeeResultToArrayConverter());
			result.Data = new
			{
				iTotalRecords = repo.GetTotalEmployees(),
				iTotalDisplayRecords = repo.GetTotalEmployees(),
				aaData = repo.GetEmployees(iSortCol, iSortDir, displayStart, displayLength)
			};

			return result;
		}
	}
}
