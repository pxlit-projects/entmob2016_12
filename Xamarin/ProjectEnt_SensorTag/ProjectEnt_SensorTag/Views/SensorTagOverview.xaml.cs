using ProjectEnt_SensorTag.ViewModel;

using Xamarin.Forms;

namespace ProjectEnt_SensorTag.Views
{
    public partial class SensorTagOverview : ContentPage
    {
        public SensorTagOverview()
        {
            InitializeComponent();
            SensorTagViewModel vm = App.Locator.SensorTagViewModel;
            BindingContext = vm;
        }
    }
}