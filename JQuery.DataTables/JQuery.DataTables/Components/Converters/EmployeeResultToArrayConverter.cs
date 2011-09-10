using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Newtonsoft.Json;
using TheWhitakers.Experiments.JQuery.DataTables.Models;

namespace TheWhitakers.Experiments.JQuery.DataTables.Components.Converters
{
	public class EmployeeResultToArrayConverter : JsonConverter
	{
		public override bool CanConvert(Type objectType)
		{
			return objectType == typeof(Employee);
		}

		public override object ReadJson(JsonReader reader, Type objectType, object existingValue, JsonSerializer serializer)
		{
			throw new NotImplementedException();
		}

		public override void WriteJson(JsonWriter writer, object value, JsonSerializer serializer)
		{
			if (value == null)
			{
				writer.WriteNull();
			}

			Employee e = (Employee)value;

			writer.WriteStartArray();
			writer.WriteValue(e.FirstName);
			writer.WriteValue(e.LastName);
			writer.WriteValue(e.Salary);
			writer.WriteEndArray();
		}
	}
}