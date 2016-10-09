using ProjectEnt_SensorTag.ViewModel;
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
        }

        //private void ListView_OnItemSelected(object sender, SelectedItemChangedEventArgs e)
        //{
        //    if (e.SelectedItem == null) return;

        //    Navigation.PushAsync(new SensorTagDetail());
        //}
    }
}
