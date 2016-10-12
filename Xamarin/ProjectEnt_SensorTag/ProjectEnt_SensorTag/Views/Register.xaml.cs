using System;

using Xamarin.Forms;

namespace ProjectEnt_SensorTag.Views
{
    public partial class Register : ContentPage
    {
        public Register()
        {
            InitializeComponent();
        }
        private void Register_Click(object sender, EventArgs e)
        {
            DisplayAlert("Alert", "Account created", "OK");
        }
    }
}
