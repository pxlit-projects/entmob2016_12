using ProjectEnt_SensorTag.ViewModel;
using Robotics.Mobile.Core.Bluetooth.LE;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;

namespace ProjectEnt_SensorTag.Views
{
    public partial class SensorTagOverview : ContentPage
    {
        public SensorTagOverview()
        {
            InitializeComponent();
            BindingContext = App.Locator.SensorTagViewModel;
            sensorTagList.IsPullToRefreshEnabled = true;
        }

        private void ListView_OnItemSelected(object sender, SelectedItemChangedEventArgs e)
        {
            SensorTagViewModel vm = (SensorTagViewModel)BindingContext;
            vm.RefreshList.Execute(null);
            if (e.SelectedItem == null) return;

            Navigation.PushAsync(new SensorTagDetail((IDevice)e.SelectedItem));
        }

        protected override void OnAppearing()
        {
            base.OnAppearing();
            SensorTagViewModel vm = (SensorTagViewModel)BindingContext;
            vm.RefreshList.Execute(null);
        }
    }
}
