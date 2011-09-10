using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using TheWhitakers.Experiments.JQuery.Flexigrid.Models;
using TheWhitakers.Experiments.JQuery.Flexigrid.Components;
using TheWhitakers.Experiments.JQuery.Flexigrid.Components.Converters;

namespace TheWhitakers.Experiments.JQuery.Flexigrid.Controllers
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

		public ActionResult LoadEmployees(int? page, int? rp, string sortname, string sortorder)
		{
			sortname = string.IsNullOrEmpty(sortname) ? "FirstName" : sortname;
			sortorder = string.IsNullOrEmpty(sortorder) ? "desc" : sortorder;

			page = page.HasValue ? page : 1;
			rp = rp.HasValue ? rp : 10;

			var repo = new EmployeeRepository();

			var result = new JsonNetResult();
			result.SerializerSettings.Converters.Add(new EmployeeResultToArrayConverter());
			result.Data = new
			{
				page = page,
				total = repo.GetTotalEmployees(),
				rows = repo.GetEmployees(sortname, sortorder, page.Value, rp.Value)
			};

			return result;
		}
	}
}
