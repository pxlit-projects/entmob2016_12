using ProjectEnt_SensorTag.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;

namespace ProjectEnt_SensorTag
{
    public partial class LogIn : ContentPage
    {
        public LogIn()
        {
            InitializeComponent();

        }

        private void Aanmelden_Click(object sender, EventArgs e)
        {
            bool isValid = true;
            User user = new User();

            if (String.IsNullOrWhiteSpace(user.Password) && String.IsNullOrWhiteSpace(user.Username) && isValid)
            {
                Navigation.PopModalAsync();
            }
            else
            {
                DisplayAlert("Fout", "Uw wachwoord of username klopt niet", "OK");
            }
        } 
    }
}
