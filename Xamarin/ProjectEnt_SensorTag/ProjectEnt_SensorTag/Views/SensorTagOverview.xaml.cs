using ProjectEnt_SensorTag.ViewModel;

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

        protected override void OnAppearing()
        {
            base.OnAppearing();
            SensorTagViewModel vm = (SensorTagViewModel)BindingContext;
            vm.RefreshList.Execute(null);
        }
    }
}