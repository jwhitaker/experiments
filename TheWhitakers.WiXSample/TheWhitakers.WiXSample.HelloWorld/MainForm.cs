using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace TheWhitakers.WiXSample.HelloWorld
{
	public partial class MainForm : Form
	{
		public MainForm()
		{
			InitializeComponent();
		}

		private void exitButton_Click(object sender, EventArgs e)
		{
			Application.Exit();
		}

		private void label1_Click(object sender, EventArgs e)
		{

		}
	}
}
