using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Newtonsoft.Json;
using TheWhitakers.Experiments.JQuery.Flexigrid.Models;

namespace TheWhitakers.Experiments.JQuery.Flexigrid.Components.Converters
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

			writer.WriteStartObject();

			writer.WritePropertyName("id");
			writer.WriteValue(e.Id.ToString());
			
			writer.WritePropertyName("cell");
			writer.WriteStartArray();
			writer.WriteValue(e.FirstName);
			writer.WriteValue(e.LastName);
			writer.WriteValue(e.Salary);
			writer.WriteEndArray();

			writer.WriteEndObject();
		}
	}
}