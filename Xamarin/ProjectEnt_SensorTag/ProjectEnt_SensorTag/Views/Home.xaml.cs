using ProjectEnt_SensorTag.ViewModel;
using ProjectEnt_SensorTag.Views;
using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;

namespace ProjectEnt_SensorTag
{
    public partial class Home : ContentPage
    {
        public Home()
        {
            InitializeComponent();      
        }

        private void Login_Click(object sender, EventArgs e)
        {
            Navigation.PushModalAsync(new LogIn());
        }
        private void Register_Click(object sender, EventArgs e)
        {
            Navigation.PushModalAsync(new Register());
        }
        private void ConnectSensorTag_Click(object sender, EventArgs e)
        {
            Navigation.PushAsync(new SensorTagOverview());
        }
    }
}
