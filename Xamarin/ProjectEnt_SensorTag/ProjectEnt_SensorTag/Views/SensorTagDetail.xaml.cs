using Xamarin.Forms;

namespace ProjectEnt_SensorTag.Views
{
    public partial class SensorTagDetail : ContentPage
    {
        public SensorTagDetail()
        {
            InitializeComponent();
            BindingContext = App.Locator.SensorTagDetailViewModel;
        }
    }
}
