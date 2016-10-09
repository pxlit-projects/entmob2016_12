using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ProjectEnt_SensorTag.ViewModel;
using Xamarin.Forms;

namespace ProjectEnt_SensorTag.Views
{
    public partial class SensorTagDetail : ContentPage
    {
        public SensorTagDetail(IDevice device)
        {
            InitializeComponent();
            SensorTagDetailViewModel.Device = device;
            BindingContext = App.Locator.SensorTagDetailViewModel;
        }
    }
}
