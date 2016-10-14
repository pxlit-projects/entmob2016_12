using ProjectEnt_SensorTag.ViewModel;
using ProjectEnt_SensorTag.Views;
using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;

namespace ProjectEnt_SensorTag.View
{
    public partial class Home : ContentPage
    {
        public Home()
        {
            InitializeComponent();
            BindingContext = App.Locator.Main;
        }
    }
}
